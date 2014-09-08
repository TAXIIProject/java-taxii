package org.mitre.taxii.client;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.SSLException;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.mitre.taxii.Versions;
import org.mitre.taxii.messages.TaxiiXml;

/**
 * This class does its best to comply with the "TAXII HTTP Protocol Binding
 * Specification". It handles interaction with a TAXII HTTP server. This
 * includes serializing TAXII Messages, managing the connection to the remote
 * end point, parsing and unmarshaling the responses and returning a TAXII
 * Message back to the user.
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

    // Structures to handle multiple versions of TAXII
    private final HashMap<String, TaxiiXml> taxiiXmlMap = new HashMap<>();
    private final HashMap<String, String> packageToVersionMap = new HashMap<>();

    /**
     * Create an HttpClient that uses a specific TaxiiXmlInterface object. NOTE: This
     * will prevent the HttpClient from handling other TAXII versions.
     *
     * @param taxiiXml
     * @param httpClient
     */
    public HttpClient(TaxiiXml taxiiXml, CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
        taxiiXmlMap.put(taxiiXml.getTaxiiVersion(), taxiiXml);
        populatePackageToVersionMap();
    }

    /**
     * Create an HttpClient with a configured Apache HttpClient. For example,
 one configured to use a proxy or SSL. This will also create TaxiiXmlInterface
 objects that handle 1.0 and 1.1.
     *
     * @param httpClient
     */
    public HttpClient(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;

        // By default, create a taxiiXmlMap that understands basic TAXII 1.0 and 1.1        
        org.mitre.taxii.messages.xml10.TaxiiXmlFactory txf10 = new org.mitre.taxii.messages.xml10.TaxiiXmlFactory();
        org.mitre.taxii.messages.xml11.TaxiiXmlFactory txf11 = new org.mitre.taxii.messages.xml11.TaxiiXmlFactory();

        TaxiiXml tx10 = txf10.getTaxiiXml();
        TaxiiXml tx11 = txf11.getTaxiiXml();

        taxiiXmlMap.put(tx10.getTaxiiVersion(), tx10);
        taxiiXmlMap.put(tx11.getTaxiiVersion(), tx11);

        populatePackageToVersionMap();
    }

    /**
     * Default constructor. Create a basic default HttpClient, handle TAXII 1.0
     * and 1.1 versions.
     *
     */
    public HttpClient() {
        this(HttpClientBuilder.create().useSystemProperties().build());
    }

    /**
     * Send a TAXII message to an endpoint. The version of the message will be
     * determined by its package name. A TAXII message handler will be used
     * based on this version. If an appropriate message handler cannot be found,
     * an exception is thrown.
     *
     * NOTE: It is expected that the response received will match the version of
     * the message sent. The TAXII specification allows setting multiple values
     * in the "x-taxii-accept" header. This library only sets and sends the
     * version of the message being sent.
     *
     * @param uri
     * @param message
     * @return
     * @throws JAXBException
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    public Object callTaxiiService(final URI uri, final Object message) throws JAXBException, UnsupportedEncodingException, IOException {

        // Figure out the version of the message.
        String msgPackage = message.getClass().getPackage().getName();

        String msgVersion = packageToVersionMap.get(msgPackage);
        TaxiiXml taxiiXml = taxiiXmlMap.get(msgVersion);

        /*
         System.out.println("Message package = " + msgPackage);
         System.out.println("Message version = " + msgVersion);
         System.out.println("taxiiXml = " + taxiiXml.toString());
         System.out.println("TaxiiXmlInterface version = " + taxiiXml.getTaxiiVersion());
        */

         if (null == taxiiXml) {
            throw new JAXBException("Message is unknown TAXII version.");
        }

        // we now have a TaxiiXmlInterface that knows how to handle the message we receieved.
        String resultStr = null;
        Object resultObj = null;

        try {
            // The TAXII messages must be sent as POST.
            HttpPost postRequest = new HttpPost(uri);

            // Set the required HTTP Headers.
            postRequest.addHeader("User-Agent", "java-taxii.httpclient");
            postRequest.addHeader(HEADER_CONTENT_TYPE, "application/xml");
            postRequest.addHeader(HEADER_ACCEPT, "application/xml");
            if (taxiiXml.isRequestMessage(message)) {
                // Should be present for requests. Should NOT be present for responses.
                postRequest.addHeader(HEADER_X_TAXII_ACCEPT, msgVersion);
            }
            postRequest.addHeader(HEADER_X_TAXII_CONTENT_TYPE, msgVersion);
            postRequest.addHeader(HEADER_X_TAXII_SERVICES, taxiiXml.getServiceVersion());

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
                    if (msgVersion.equals(header.getValue())) {
                        contentFound = true;
                        break;
                    }
                }

                if (!contentFound) { // Response is not a TAXII Message we understand.
                    // go create a TAXII status message base on what we got.
                    resultObj = taxiiXml.getResponseHandler().buildStatusCodeStatusMessage(response, message);
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
                        throw new JAXBException("Unable to unmarshal response.");                        
                    }
                }
            } catch (SSLException ex) {
                resultObj = taxiiXml.getResponseHandler().buildSSLErrorStatusMessage(ex, message);
            }
        } finally {
            httpClient.close();
        }
        return resultObj;
    }

    private void populatePackageToVersionMap() {
        // Populate the package to version map so we can figure out what version message objects are.
        Set<Entry<String, TaxiiXml>> entries = taxiiXmlMap.entrySet();

        for (Entry<String, TaxiiXml> entry : entries) {
            String version = entry.getKey();
            String packageName = entry.getValue().getClass().getPackage().getName();
            packageToVersionMap.put(packageName, version);
        }
    }
    
    private void populateResponseHandlerMap(String taxiiPackage) {
        try {
            // Use reflection to instantiate the proper HttpResponseHandler.
            Class rhClass = Class.forName(taxiiPackage + ".ResponseHandler");
            Constructor rhConstructor = rhClass.getConstructor();
            HttpResponseHandler responseHandler = (HttpResponseHandler)rhConstructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            // TODO: This is bad!
        }

    }
        
    // ========= Getters and Setters. ==============
    public CloseableHttpClient getHttpclient() {
        return httpClient;
    }

    public void setHttpclient(CloseableHttpClient httpclient) {
        this.httpClient = httpclient;
    }

    /**
     * Assign a TAXII message handler. The version of TAXII the handler
     * understands is extracted from the provided object. If another handler for
     * the same version already exists, it will be replaced. There can be only
     * one handler per TAXII version.
     *
     * @param taxiiXml
     */
    public void setVersionHandler(TaxiiXml taxiiXml) {
        taxiiXmlMap.put(taxiiXml.getTaxiiVersion(), taxiiXml);
    }

    public TaxiiXml getVersionHandler(String key) {
        return taxiiXmlMap.get(key);
    }
    
}
