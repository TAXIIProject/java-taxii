package org.mitre.taxii.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.xml.bind.JAXBException;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.mitre.taxii.Messages;
import org.mitre.taxii.messages.xml11.ObjectFactory;
import org.mitre.taxii.messages.xml11.PollRequest;
import org.mitre.taxii.messages.xml11.PollResponse;
import org.mitre.taxii.messages.xml11.TaxiiXmlImpl;
import org.mitre.taxii.messages.xml11.TaxiiXmlFactory;

/**
 *
 * @author jasenj1
 */
public class PollRequestTest {
    private final ObjectFactory factory = new ObjectFactory();
    private final TaxiiXmlFactory txf = new TaxiiXmlFactory();
    private final TaxiiXmlImpl taxiiXml;
    private final boolean debug = true; // Boolean.getBoolean("debug");

    public PollRequestTest() {
        taxiiXml = txf.getTaxiiXml();
    }
    
    @Test
    public void pollRequest() throws URISyntaxException, JAXBException, IOException {
        HttpClient taxiiClient = new HttpClient();
        final URI serviceUri = new URI("http://127.0.0.1:8000/services/poll/");
        
        PollRequest pr = factory.createPollRequest()
                        .withMessageId(Messages.generateMessageId())
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
