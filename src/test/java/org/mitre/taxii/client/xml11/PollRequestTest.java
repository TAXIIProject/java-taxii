package org.mitre.taxii.client.xml11;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.xml.bind.JAXBException;
import org.apache.http.client.fluent.Request;
import static org.junit.Assert.assertTrue;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.mitre.taxii.client.HttpClient;
import org.mitre.taxii.messages.xml11.MessageHelper;
import org.mitre.taxii.messages.xml11.ObjectFactory;
import org.mitre.taxii.messages.xml11.PollRequest;
import org.mitre.taxii.messages.xml11.PollResponse;
import org.mitre.taxii.messages.xml11.TaxiiXml;
import org.mitre.taxii.messages.xml11.TaxiiXmlFactory;

/**
 *
 * @author jasenj1
 */
public class PollRequestTest {
    private final ObjectFactory factory = new ObjectFactory();
    private final TaxiiXmlFactory txf = new TaxiiXmlFactory();
    private final TaxiiXml taxiiXml;
    private final boolean debug = true; // Boolean.getBoolean("debug");
    
    private static final String serverURL = "http://127.0.0.1:8080/";

    public PollRequestTest() {
        taxiiXml = txf.createTaxiiXml();
    }
    

    /*
        Confirm that the local TAXII server is running.
        If not, skip these tests. That is what the Assume is supposed to do.
        If the Assume is false, the tests will be ignored.
        In NetBeans, the Assume causes an ERROR rather than ignoring the tests.
    */
    @Before
    public void confirmConnection() {
        try {
            Request.Get(serverURL).execute();
        } catch (Exception ex) {
            Assume.assumeNoException(ex);
        }
    }
    
    @Test
    public void pollRequest() throws URISyntaxException, JAXBException, IOException {
        HttpClient taxiiClient = new HttpClient();
        final URI serviceUri = new URI(serverURL + "services/poll/");
        
        PollRequest pr = factory.createPollRequest()
                        .withMessageId(MessageHelper.generateMessageId())
                        .withCollectionName("default")
                        .withPollParameters(
                                factory.createPollParametersType()
                        );
        
        Object responseObj = taxiiClient.callTaxiiService(serviceUri, pr);

        if (debug) {
            System.out.println(taxiiXml.marshalToString(pr, true));
            System.out.println(taxiiXml.marshalToString(responseObj, true));
        }
        assertTrue("Received Poll Response", (responseObj instanceof PollResponse));        
    }    
}
