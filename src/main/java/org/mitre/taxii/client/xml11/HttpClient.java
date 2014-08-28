package org.mitre.taxii.client.xml11;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.mitre.taxii.Versions;
import org.mitre.taxii.messages.xml11.MessageType;
import org.mitre.taxii.messages.xml11.ObjectFactory;
import org.mitre.taxii.messages.xml11.RequestMessageType;
import org.mitre.taxii.messages.xml11.StatusMessage;
import org.mitre.taxii.messages.xml11.StatusTypeEnum;
import org.mitre.taxii.messages.xml11.TaxiiXml;

/**
 *
 * @author jasenj1
 */
public class HttpClient {

    public final static String SCHEME_HTTP = "http";
    public final static String SCHEME_HTTPS = "https";

    // Header Constants
    public final static String HEADER_ACCEPT = "accept";
    public final static String HEADER_CONTENT_TYPE = "content-type";
    public final static String HEADER_X_TAXII_ACCEPT = "x-taxii-accept";
    public final static String HEADER_X_TAXII_CONTENT_TYPE = "x-taxii-content-type";
    public final static String HEADER_X_TAXII_PROTOCOL = "x-taxii-protocol";
    public final static String HEADER_X_TAXII_SERVICES = "x-taxii-services";

    private CloseableHttpClient httpClient;

    private final TaxiiXml taxiiXml;

    public HttpClient(TaxiiXml taxiiXml, CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
        this.taxiiXml = taxiiXml;
    }

    public HttpClient(TaxiiXml taxiiXml) {
        this(taxiiXml, HttpClientBuilder.create().useSystemProperties().build());
    }

    public Object callTaxiiService(final URI uri, final MessageType message) throws JAXBException, UnsupportedEncodingException, IOException {
        String resultStr = null;
        Object resultObj = null;
        
        try {
            // The TAXII messages must be sent as POST.
            HttpPost postRequest = new HttpPost(uri);

            // Set the required HTTP Headers.
            postRequest.addHeader("User-Agent", "java-taxii.httpclient");
            postRequest.addHeader(HEADER_CONTENT_TYPE, "application/xml");
            postRequest.addHeader(HEADER_ACCEPT, "application/xml");
            if (message instanceof RequestMessageType) { 
                // Should be present for requests. Should NOT be present for responses.
                postRequest.addHeader(HEADER_X_TAXII_ACCEPT, Versions.VID_TAXII_XML_11); 
            }
            postRequest.addHeader(HEADER_X_TAXII_CONTENT_TYPE, Versions.VID_TAXII_XML_11);
            postRequest.addHeader(HEADER_X_TAXII_SERVICES, Versions.VID_TAXII_SERVICES_11);

            if (postRequest.getURI().getScheme().equals(SCHEME_HTTPS)) {
                postRequest.addHeader(HEADER_X_TAXII_PROTOCOL, Versions.VID_TAXII_HTTPS_10);
            } else {
                postRequest.addHeader(HEADER_X_TAXII_PROTOCOL, Versions.VID_TAXII_HTTP_10);
            }

            // Serialize the message.
            final Marshaller m = taxiiXml.createMarshaller(false); // Don't pretty print.
            m.setProperty(Marshaller.JAXB_FRAGMENT, true); // Don't generate xml declaration.

            // Render the JAXB object to a string.
            final StringWriter sw = new StringWriter();
            m.marshal(message, sw);
            String requestStr = sw.toString();

            // Put the XML string in an entiny for the Request.
            StringEntity reqEntity = new StringEntity(requestStr);
            postRequest.setEntity(reqEntity);
            
            // Do the request
            try (CloseableHttpResponse response = httpClient.execute(postRequest)) {
                
                    // Check that we got the TAXII Content Type we're expecting.
                    Header[] headers = response.getHeaders(HEADER_X_TAXII_CONTENT_TYPE);
                    List<Header> headerList = Arrays.asList(headers);
                    
                    boolean contentFound = false;
                    for (Header header : headerList) {
                        if (Versions.VID_TAXII_XML_11.equals(header.getValue())) {
                            contentFound = true;
                            break;
                        }
                    }
                    
                    if (!contentFound) { // Response is not a TAXII Message we understand.
                        // go create a TAXII status message base on what we got.
                        resultObj = buildStatusCodeStatusMessage(response, message.getMessageId());
                    } else {
                    
                        HttpEntity respEntity = response.getEntity();
                        resultStr = EntityUtils.toString(respEntity);

                        // Attempt to parse the response into a JAXB object regardless of the 
                        // HTTP status code.
                        Unmarshaller um = taxiiXml.getJaxbContext().createUnmarshaller();
                        try {
                            resultObj = um.unmarshal(new StringReader(resultStr));
                        } catch (Exception ex) {
                            // We were told the response would be a TAXII Message, but 
                            // it couldn't be parsed.

                        }
                    }
            } catch (SSLException ex) {
                resultObj = buildSSLErrorStatusMessage(ex, message.getMessageId());
            }
        } finally {
            httpClient.close();
        }        
        return resultObj;
    }
    
    /**
     *   Section 5.2 of the TAXII HTTP Protocol Binding Specification states:
     * 
     * "If TLS is used, problems with the TLS handshake or connection are indicated
     * using a TLS Alert Protocol Record. This section defines rules for interpreting
     * a TLS Alert Protocol Record as a TAXII Status Message. Treat a TLS Alert
     * Protocol Record as being equivalent to a TAXII Status Message with the 
     * following properties:
     * Status = Use the appropriate TAXII Status Type as identified in Table 3.
     * Message = The TLS Alert, represented as a hexadecimal string."
     * 
     * Unfortunately, Java does not give us access to the TLS Alert, so we'll 
     * just make all the Statuses UNAUTHORIZED and return the exception's message.
     * 
     */ 
    private StatusMessage buildSSLErrorStatusMessage(SSLException ex, String msgId) {
        ObjectFactory factory = new ObjectFactory();
        StatusMessage msg = factory.createStatusMessage()
                                .withInResponseTo(msgId)
                                .withMessageId("0");
        
        msg.setStatusType(StatusTypeEnum.UNAUTHORIZED.name());
        msg.setMessage(ex.getMessage());

        return msg;
    }
    
    /**
     * We received a response that did not contain the proper HEADER_X_TAXII_CONTENT_TYPE
     * value. Make up an appropriate Status Message.
     * 
     * @param response
     * @return 
     */
    private StatusMessage buildStatusCodeStatusMessage(CloseableHttpResponse response, String msgId) {
        ObjectFactory factory = new ObjectFactory();
        StatusMessage msg = factory.createStatusMessage()
                                .withInResponseTo(msgId)
                                .withMessageId("0");
        
        switch (response.getStatusLine().getStatusCode()) {
            case 400: // Bad Request
            case 413: // Request Entity Too Large
                    msg.setStatusType(StatusTypeEnum.BAD_MESSAGE.name());
                    break;

            case 401: // Unauthorized
            case 403: // Forbidden
            case 407: // Proxy Authentication Required
                    msg.setStatusType(StatusTypeEnum.UNAUTHORIZED.name());
                    break;

            case 406: // Not Acceptable
            case 415: // Unsupported Media Type
                    msg.setStatusType(StatusTypeEnum.UNSUPPORTED_MESSAGE.name());
                    break;
                
            default:
                    msg.setStatusType(StatusTypeEnum.FAILURE.name());
        }
        
        String msgStr = buildResponseStr(response);
        
        msg.setMessage(msgStr);
        
        return msg;
    }
    
    /**
     * Render the headers and the response content as a string.
     * This could include more things such as the status code.
     * 
     * @param response
     * @return 
     */
    private String buildResponseStr(CloseableHttpResponse response) {
        StringBuilder sb = new StringBuilder();
        
        HeaderIterator hi = response.headerIterator();
        while (hi.hasNext()) {
            Header header = hi.nextHeader();
            sb.append(header.getName()).append(": ").append(header.getValue()).append("\r\n");                        
        }
        sb.append("\r\n");
        try {
            sb.append(EntityUtils.toString(response.getEntity()));            
        } catch (IOException | IllegalStateException ex) {
            // Don't care
        }
        
        return sb.toString();
    }

    // ========= Getters and Setters. ==============
    public CloseableHttpClient getHttpclient() {
        return httpClient;
    }

    public void setHttpclient(CloseableHttpClient httpclient) {
        this.httpClient = httpclient;
    }

}
