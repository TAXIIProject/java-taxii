/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mitre.taxii.client;

import java.io.IOException;
import javax.xml.bind.JAXBException;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.mitre.taxii.Messages;
import org.mitre.taxii.Versions;
import org.mitre.taxii.messages.xml11.DiscoveryRequest;
import org.mitre.taxii.messages.xml11.DiscoveryResponse;
import org.mitre.taxii.messages.xml11.ObjectFactory;
import org.mitre.taxii.messages.xml11.TaxiiXml;
import org.mitre.taxii.messages.xml11.TaxiiXmlFactory;
import org.mitre.taxii.query.DefaultQuery;

/**
 *
 * @author jasenj1
 */
public class DiscoveryTests {

    private final ObjectFactory factory = new ObjectFactory();
    private final TaxiiXmlFactory txf = new TaxiiXmlFactory();
    private final TaxiiXml taxiiXml;
    private final boolean debug = true; // Boolean.getBoolean("debug");

    public DiscoveryTests() {
        txf.addJaxbContextPackage(DefaultQuery.class.getPackage().getName());
        taxiiXml = txf.getTaxiiXml();
    }

    
    @Test
    public void simpleDiscoveryTest() throws IOException, JAXBException {
        org.mitre.taxii.client.HttpClient taxiiClient = new org.mitre.taxii.client.HttpClient(taxiiXml);
        final String serverUrl = "http://127.0.0.1:8000/services/discovery/";

        // Prepare the message to send.
        DiscoveryRequest dr = factory.createDiscoveryRequest()
                .withMessageId(Messages.generateMessageId());

        Object responseObj = taxiiClient.callTaxiiService(serverUrl, Versions.VID_TAXII_XML_11, dr);

        if (debug) {
            System.out.println(taxiiXml.marshalToString(dr, true));
            System.out.println(taxiiXml.marshalToString(responseObj, true));
        }

        assertTrue("Received Discovery Response", (responseObj instanceof DiscoveryResponse));
    }

    @Test
    public void basicAuthDiscoveryTest() throws IOException, JAXBException {
        HttpClientBuilder cb = HttpClientBuilder.create();
        
        // Create a client that uses basic (user & password) authentication.
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                AuthScope.ANY,
                new UsernamePasswordCredentials("taxii", "taxii"));        
        cb.setDefaultCredentialsProvider(credsProvider);        
        CloseableHttpClient httpClient = cb.build();

        org.mitre.taxii.client.HttpClient taxiiClient = new org.mitre.taxii.client.HttpClient(taxiiXml, httpClient);

        final String serverUrl = "http://127.0.0.1:8100/services/discovery/";

        // Prepare the message to send.
        DiscoveryRequest dr = factory.createDiscoveryRequest()
                .withMessageId(Messages.generateMessageId());

        Object responseObj = taxiiClient.callTaxiiService(serverUrl, Versions.VID_TAXII_XML_11, dr);

        if (debug) {
            System.out.println(taxiiXml.marshalToString(dr, true));
            System.out.println(taxiiXml.marshalToString(responseObj, true));
        }

        assertTrue("Received Discovery Response", (responseObj instanceof DiscoveryResponse));
    }
    
    @Test
    public void proxyDiscoveryTest() throws IOException, JAXBException {
        HttpHost proxy = new HttpHost("gatekeeper-w.mitre.org", 80, "http");
        
        HttpClientBuilder cb = HttpClientBuilder.create();        
        cb.setProxy(proxy);
        
        CloseableHttpClient httpClient = cb.build();

        org.mitre.taxii.client.HttpClient taxiiClient = new org.mitre.taxii.client.HttpClient(taxiiXml, httpClient);
        
        // Prepare the message to send.
        DiscoveryRequest dr = factory.createDiscoveryRequest()
                .withMessageId(Messages.generateMessageId());

        final String serverUrl = "http://taxiitest.mitre.org/services/discovery/";
        Object responseObj = taxiiClient.callTaxiiService(serverUrl, Versions.VID_TAXII_XML_11, dr);

        if (debug) {
            System.out.println(taxiiXml.marshalToString(dr, true));
            System.out.println(taxiiXml.marshalToString(responseObj, true));
        }

        assertTrue("Received Discovery Response", (responseObj instanceof DiscoveryResponse));
    }
}
