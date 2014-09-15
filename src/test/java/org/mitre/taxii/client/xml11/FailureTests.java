package org.mitre.taxii.client.xml11;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.xml.bind.JAXBException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.mitre.taxii.Messages;
import org.mitre.taxii.client.HttpClient;
import org.mitre.taxii.messages.xml11.DiscoveryRequest;
import org.mitre.taxii.messages.xml11.ObjectFactory;
import org.mitre.taxii.messages.xml11.StatusMessage;
import org.mitre.taxii.messages.TaxiiXml;
import org.mitre.taxii.messages.xml11.TaxiiXmlFactory;

/**
 *
 * @author jasenj1
 */
public class FailureTests {
    
    private final ObjectFactory factory = new ObjectFactory();
    private final TaxiiXmlFactory txf = new TaxiiXmlFactory();
    private final TaxiiXml taxiiXml;
    private final boolean debug = true; // Boolean.getBoolean("debug");

    public FailureTests() {
        taxiiXml = txf.getTaxiiXml();
    }
    
    @Test
    public void missingEndpointDiscoveryTest() throws IOException, JAXBException, URISyntaxException {
        org.mitre.taxii.client.HttpClient taxiiClient = new HttpClient();
        final String serverUrl = "http://127.0.0.1:8080/services/discover/"; // URL does not exist.

        // Prepare the message to send.
        DiscoveryRequest dr = factory.createDiscoveryRequest()
                .withMessageId(Messages.generateMessageId());

        Object responseObj = taxiiClient.callTaxiiService(new URI(serverUrl), dr);

        if (debug) {
            System.out.println(taxiiXml.marshalToString(dr, true));
            System.out.println(taxiiXml.marshalToString(responseObj, true));
        }

        assertTrue("Received Status Message", (responseObj instanceof StatusMessage));
    }

/*    
    @Test
    public void failBasicAuthDiscoveryTest() throws IOException, JAXBException, URISyntaxException {
        
        // Create a client that uses basic (user & password) authentication.
        HttpClientBuilder cb = HttpClientBuilder.create();
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                AuthScope.ANY,
                new UsernamePasswordCredentials("taxii", "taxi")); // Bad password
        cb.setDefaultCredentialsProvider(credsProvider);        
        CloseableHttpClient httpClient = cb.build();

        HttpClient taxiiClient = new HttpClient(taxiiXml, httpClient);

        // Prepare the message to send.
        DiscoveryRequest dr = factory.createDiscoveryRequest()
                .withMessageId(Messages.generateMessageId());

        final String serverUrl = "http://127.0.0.1:8100/services/discovery/";
        Object responseObj = taxiiClient.callTaxiiService(new URI(serverUrl), dr);

        if (debug) {
            System.out.println(taxiiXml.marshalToString(dr, true));
            System.out.println(taxiiXml.marshalToString(responseObj, true));
        }

        assertTrue("Received Status Message", (responseObj instanceof StatusMessage));
    }

    @Test
    public void failedSslDiscoveryTest() throws IOException, JAXBException, KeyStoreException, NoSuchAlgorithmException, CertificateException, KeyManagementException, URISyntaxException {
        final String serverUrl = "https://127.0.0.1:8443/services/discovery/";

        /* The below configures the client to accept self-signed certificates.
        KeyStore trustStore  = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(null, "nopassword".toCharArray());

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
        */
/*        
        HttpClient taxiiClient = new HttpClient();

        // Prepare the message to send.
        DiscoveryRequest dr = factory.createDiscoveryRequest()
                .withMessageId(Messages.generateMessageId());

        Object responseObj = null;
        responseObj = taxiiClient.callTaxiiService(new URI(serverUrl), dr);

        if (debug) {
            System.out.println(taxiiXml.marshalToString(dr, true));
            if (null != responseObj) {
                System.out.println(taxiiXml.marshalToString(responseObj, true));
            }
        }

        assertTrue("Received Status Message", (responseObj instanceof StatusMessage));
    }
*/    
}
