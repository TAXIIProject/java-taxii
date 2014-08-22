package org.mitre.taxii.client;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.mitre.taxii.Versions;
import org.mitre.taxii.messages.xml11.MessageType;
import org.mitre.taxii.messages.xml11.TaxiiXml;

/**
 *
 * @author jasenj1
 */
public class HttpClient {

    public static enum AuthTypeEnum {
        NONE,
        BASIC,
        CERT,
        CERT_BASIC
    }

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

    public Object callTaxiiService(final String uri, final String messageBinding, final MessageType message) throws JAXBException, UnsupportedEncodingException, IOException {
        String resultStr = null;
        Object resultObj = null;
        
        try {
            // The TAXII messages must be sent as POST.
            HttpPost postRequest = new HttpPost(uri);

            // Set the required HTTP Headers.
            postRequest.addHeader("User-Agent", "java-taxii.httpclient");
            postRequest.addHeader(HEADER_CONTENT_TYPE, "application/xml");
            postRequest.addHeader(HEADER_ACCEPT, "application/xml");
            postRequest.addHeader(HEADER_X_TAXII_ACCEPT, messageBinding);
            postRequest.addHeader(HEADER_X_TAXII_CONTENT_TYPE, messageBinding);
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
                
                if (200 == response.getStatusLine().getStatusCode()) {
                    HttpEntity respEntity = response.getEntity();
                    resultStr = EntityUtils.toString(respEntity);

                    // Parse the response into a JAXB object.
                    Unmarshaller um = taxiiXml.getJaxbContext().createUnmarshaller();
                    resultObj = um.unmarshal(new StringReader(resultStr));
                }
            }
        } finally {
            httpClient.close();
        }        
        return resultObj;
    }

    // ========= Getters and Setters. ==============
    public CloseableHttpClient getHttpclient() {
        return httpClient;
    }

    public void setHttpclient(CloseableHttpClient httpclient) {
        this.httpClient = httpclient;
    }

}
