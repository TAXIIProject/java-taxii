package org.mitre.taxii.client.xml11;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import javax.xml.bind.JAXBException;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.mitre.taxii.Messages;
import org.mitre.taxii.client.HttpClient;
import org.mitre.taxii.messages.TaxiiXml;
import org.mitre.taxii.messages.xml11.DiscoveryRequest;
import org.mitre.taxii.messages.xml11.DiscoveryResponse;
import org.mitre.taxii.messages.xml11.ObjectFactory;
import org.mitre.taxii.messages.xml11.TaxiiXmlFactory;

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
        taxiiXml = txf.getTaxiiXml();
    }
   
    @Test
    public void simpleDiscoveryTest() throws IOException, JAXBException, URISyntaxException {
        
        HttpClient taxiiClient = new HttpClient();
        
        final String serverUrl = "http://127.0.0.1:8080/services/discovery/";

        // Prepare the message to send.
        DiscoveryRequest dr = factory.createDiscoveryRequest()
                .withMessageId(Messages.generateMessageId());

        // Call the services
        Object responseObj = taxiiClient.callTaxiiService(new URI(serverUrl), dr);

        if (debug) {
            System.out.println(taxiiXml.marshalToString(dr, true));
            System.out.println(taxiiXml.marshalToString(responseObj, true));
        }

        assertTrue("Received Discovery Response", (responseObj instanceof DiscoveryResponse));
    }

    /*
    @Test
    public void basicAuthDiscoveryTest() throws IOException, JAXBException, URISyntaxException {
        
        // Create a client that uses basic authentication (user & password).
        HttpClientBuilder cb = HttpClientBuilder.create();
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                AuthScope.ANY,
                new UsernamePasswordCredentials("taxii", "taxii"));        
        cb.setDefaultCredentialsProvider(credsProvider);        
        CloseableHttpClient httpClient = cb.build();

        // Create a Taxii Client with the HttpClient object.
        HttpClient taxiiClient = new HttpClient(httpClient);

        // Prepare the message to send.
        DiscoveryRequest dr = factory.createDiscoveryRequest()
                .withMessageId(Messages.generateMessageId());

        // Call the service
        final String serverUrl = "http://127.0.0.1:8100/services/discovery/";
        Object responseObj = taxiiClient.callTaxiiService(new URI(serverUrl), dr);

        if (debug) {
            System.out.println(taxiiXml.marshalToString(dr, true));
            System.out.println(taxiiXml.marshalToString(responseObj, true));
        }

        assertTrue("Received Discovery Response", (responseObj instanceof DiscoveryResponse));
    }
    
    @Test
    public void sslDiscoveryTest() throws IOException, JAXBException, KeyStoreException, NoSuchAlgorithmException, CertificateException, KeyManagementException, URISyntaxException {
        final String serverUrl = "https://127.0.0.1:8443/services/discovery/";

        // Prepare the TLS objects necessary for SSL connection.
        KeyStore trustStore  = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(null);

        // Trust own CA and all self-signed certs
        SSLContext sslcontext = SSLContexts.custom()
                .loadTrustMaterial(trustStore, new TrustSelfSignedStrategy())
                .build();
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext,
                new String[] { "TLSv1" },
                null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .build();        
        
        // Create a Taxii Client with the HttpClient and TaxiiXml objects.
        HttpClient taxiiClient = new HttpClient(httpClient);

        // Prepare the message to send.
        DiscoveryRequest dr = factory.createDiscoveryRequest()
                .withMessageId(Messages.generateMessageId());

        // Call the service
        Object responseObj = taxiiClient.callTaxiiService(new URI(serverUrl), dr);

        if (debug) {
            System.out.println(taxiiXml.marshalToString(dr, true));
            System.out.println(taxiiXml.marshalToString(responseObj, true));
        }

        assertTrue("Received Discovery Response", (responseObj instanceof DiscoveryResponse));
    }
    */
        
    @Test
    public void proxyDiscoveryTest() throws IOException, JAXBException, URISyntaxException {
        
        // Create a client that connects via a proxy.
        HttpHost proxy = new HttpHost("gatekeeper-w.mitre.org", 80, "http");        
        HttpClientBuilder cb = HttpClientBuilder.create();        
        cb.setProxy(proxy);        
        CloseableHttpClient httpClient = cb.build();

        // Create a Taxii Client with the HttpClient object.
        HttpClient taxiiClient = new HttpClient(httpClient);
        
        // Prepare the message to send.
        DiscoveryRequest dr = factory.createDiscoveryRequest()
                .withMessageId(Messages.generateMessageId());

        // Call the service
        final String serverUrl = "http://taxiitest.mitre.org/services/discovery/";
        Object responseObj = taxiiClient.callTaxiiService(new URI(serverUrl), dr);

        if (debug) {
            System.out.println(taxiiXml.marshalToString(dr, true));
            System.out.println(taxiiXml.marshalToString(responseObj, true));
        }

        assertTrue("Received Discovery Response", (responseObj instanceof DiscoveryResponse));
    }       
}
