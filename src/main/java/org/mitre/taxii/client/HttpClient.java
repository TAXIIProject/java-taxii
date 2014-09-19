package org.mitre.taxii.client;
/*
Copyright (c) 2014, The MITRE Corporation
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
    * Neither the name of The MITRE Corporation nor the 
      names of its contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 */

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
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
 * <p>
 * This class does its best to comply with the "TAXII HTTP Protocol Binding
 * Specification". It handles interaction with a TAXII HTTP server. This
 * includes serializing TAXII Messages, managing the connection to the remote
 * end point, parsing and unmarshaling the responses, and returning a TAXII
 * Message back to the user.
 * </p><p>
 * There are two important components of this class.
 * </p>
 * <ol>
 * <li> An Apache Components CloseableHttpClient, {@link HttpClient#getHttpClient} This manages the HTTP protocol interaction.
 * The default constructor will create a simple, pre-configured HttpClient based
 * on the system properties. If you wish to use an HttpClient configured to use
 * an explicit proxy, or a security certificate, you will need to construct and 
 * configure it, then apply it to the TAXII HttpClient.
 * </li>
 * 
 * <li>One or more {@link TaxiiXml} objects, stored in {@link HttpClient#taxiiXmlMap}. These objects understand the TAXII JAXB environment.
 * They are configured to handle parsing and generating a certain version of TAXII
 * messages. There can be only one {@link TaxiiXml} object per TAXII version.
 * The default constructor will create {@link TaxiiXml} objects for TAXII 1.0 and 1.1.
 * You may, for example, want to provide a {@link TaxiiXml} object configured to handle 
 * STIX content blocks as well as TAXII 1.1 messages.
 * </li>
 *
 * <h3>Usage example</h3>
 <pre>
    HttpClient taxiiClient = new HttpClient();
        
    final String serverUrl = "http://127.0.0.1:8080/services/discovery/";

    // Prepare the message to send.
    DiscoveryRequest dr = factory.createDiscoveryRequest()
            .withMessageId(MessageHelper.generateMessageId());

    // Call the service
    Object responseObj = taxiiClient.callTaxiiService(new URI(serverUrl), dr);
 </pre>
 
 * @author jasenj1
 */
public class HttpClient {

    public final static String SCHEME_HTTP = "http";
    public final static String SCHEME_HTTPS = "https";

    // Header Constants
    /** HTTP Accept header name */
    public final static String HEADER_ACCEPT = "accept";
    /** HTTP Content-Type header name */
    public final static String HEADER_CONTENT_TYPE = "content-type";
    /** X-TAXII-Accept header name */
    public final static String HEADER_X_TAXII_ACCEPT = "x-taxii-accept";
    /** X-TAXII-Content-Type header name */
    public final static String HEADER_X_TAXII_CONTENT_TYPE = "x-taxii-content-type";
    /** The X-TAXII-Protocol header name */
    public final static String HEADER_X_TAXII_PROTOCOL = "x-taxii-protocol";
    /** The X-TAXII-Services header name */
    public final static String HEADER_X_TAXII_SERVICES = "x-taxii-services";

    /** <a href="http://hc.apache.org">Apache Commons HTTP Client</a> that handles connection management */
    private CloseableHttpClient httpClient;

    // Structures to handle multiple versions of TAXII
    
    /**
     * The map of TAXII versions to TaxiiXml objects that process that version.
     * Each TAXII version may have one and only one TaxiiXml to handle TAXII
     * messages of that version.
     */
    private final HashMap<String, TaxiiXml> taxiiXmlMap = new HashMap<>();
    /** 
     * Provides a link from package names to TAXII versions.
     * The TaxiiXml object that handles a version of TAXII must be in its own
     * package. e.g. com.example.xml10 and com.example.xml11.
     * So you could not have a com.example.TaxiiXml10 and com.example.TaxiiXml11.
     * The package names would collide.
     */
    private final HashMap<String, String> packageToVersionMap = new HashMap<>();

    /**
     * Create a client that uses a specific TaxiiXml object and a pre-configured
     * Apache HttpClient.
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
     * Create a client with a pre-configured Apache HttpClient.
     * For example, one configured to use a proxy or SSL.
     * TaxiiXml objects that handle TAXII 1.0 and 1.1 will be created.
     *
     * @param httpClient
     */
    public HttpClient(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;

        // By default, create a taxiiXmlMap that understands basic TAXII 1.0 and 1.1        
        org.mitre.taxii.messages.xml10.TaxiiXmlFactory txf10 = new org.mitre.taxii.messages.xml10.TaxiiXmlFactory();
        org.mitre.taxii.messages.xml11.TaxiiXmlFactory txf11 = new org.mitre.taxii.messages.xml11.TaxiiXmlFactory();

        TaxiiXml tx10 = txf10.createTaxiiXml();
        TaxiiXml tx11 = txf11.createTaxiiXml();

        taxiiXmlMap.put(tx10.getTaxiiVersion(), tx10);
        taxiiXmlMap.put(tx11.getTaxiiVersion(), tx11);

        populatePackageToVersionMap();
    }

    /**
     * Default constructor. Create a basic default <a href="http://hc.apache.org/httpcomponents-client-4.3.x/httpclient/apidocs/org/apache/http/client/CloseableHttpClient.html">CloseableHttpClient</a>, handle TAXII 1.0
     * and 1.1 versions.
     *
     */
    public HttpClient() {
        this(HttpClientBuilder.create().useSystemProperties().build());
    }

    /**
     * Send a TAXII message to an endpoint. The version of the message will be
     * determined by its package name, which must match the package name of a {@link org.mitre.taxii.messages.TaxiiXml}
     * object in the taxiiXmlMap. If an appropriate message handler cannot be found,
     * an exception is thrown.
     *
     * NOTE: It is expected that the response received will match the version of
     * the message sent. The TAXII specification allows setting multiple values
     * in the "x-taxii-accept" header. This library only sets and sends the
     * version of the message being sent.
     *
     * @param uri The address of the endpoint to send the message to
     * @param message The message to send.
     * @return resultObj
     *              Either a TAXII response object of the same version as was passed in
     *              or "null" if parsing fails in a way that does not throw an exception.
     * @throws JAXBException
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    public Object callTaxiiService(final URI uri, final Object message) throws JAXBException, UnsupportedEncodingException, IOException {

        // Figure out the version of the message.
        String msgPackage = message.getClass().getPackage().getName();

        // Get the appropriate TAXII message environment.
        String msgVersion = packageToVersionMap.get(msgPackage);
        TaxiiXml taxiiXml = taxiiXmlMap.get(msgVersion);

        /*
         System.out.println("Message package = " + msgPackage);
         System.out.println("Message version = " + msgVersion);
         System.out.println("taxiiXml = " + taxiiXml.toString());
         System.out.println("TaxiiXmlInterface version = " + taxiiXml.getTaxiiVersion());
        */

        // Couldn't find a handler for the message.
         if (null == taxiiXml) {
            throw new JAXBException("Message is unknown TAXII version.");
        }

        // we now have a TaxiiXml that knows how to handle the message we receieved.
        String resultStr = null;
        Object resultObj = null;

        // Make the call to the server.
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
            
            // validate the scheme (HTTP or HTTPS)
            if (null == postRequest.getURI().getScheme()) {
                throw new IOException("Invalid service URI.");
            } else if (!(postRequest.getURI().getScheme().toLowerCase().equals(SCHEME_HTTP) || 
                    postRequest.getURI().getScheme().toLowerCase().equals(SCHEME_HTTPS))) {
                throw new IOException("Invalid service URI. Only 'http' or 'https' are supported");                
            }

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
                    // go create a TAXII status message based on what we got.
                    resultObj = taxiiXml.getResponseHandler().buildStatusCodeStatusMessage(response, message);
                } else { // We should know how to handle the response.

                    // Extract the response body.
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

    /**
     * Populate the map that maps package names to TAXII versions.
     * The package of the TaxiiXml classes is used to determine which version of 
     * TAXII they understand.
     */
    private void populatePackageToVersionMap() {
        // Populate the package to version map so we can figure out what version message objects are.
        Set<Entry<String, TaxiiXml>> entries = taxiiXmlMap.entrySet();

        for (Entry<String, TaxiiXml> entry : entries) {
            String version = entry.getKey();
            String packageName = entry.getValue().getClass().getPackage().getName();
            packageToVersionMap.put(packageName, version);
        }
    }
            
    // ========= Getters and Setters. ==============
    
    /**
     * Get the Apache Components HTTP Client in use by this object.
     *
     * @return the Apache Components HTTP Client used by this TAXII HTTP Client.
     */
    public CloseableHttpClient getHttpclient() {
        return httpClient;
    }

    /**
     * Set the Apache Components HTTP Client.
     * This method is very useful when needing an HttpClient configured to use a
     * proxy or SSL certificates or other authorization technique.
     * 
     * @param httpclient 
     */
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
