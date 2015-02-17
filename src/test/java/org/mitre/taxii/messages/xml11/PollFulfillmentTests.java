package org.mitre.taxii.messages.xml11;

import java.io.IOException;
import java.math.BigInteger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.xml.sax.SAXException;

/**
 *
 * @author jasenj1
 */
public class PollFulfillmentTests {
    private final ObjectFactory factory = new ObjectFactory();
    private final TaxiiXmlFactory txf = new TaxiiXmlFactory();
    private final TaxiiXml taxiiXml;
    
    public PollFulfillmentTests() {
        // Use MOXy so we get JSON support
        System.setProperty(JAXBContext.JAXB_CONTEXT_FACTORY, "org.eclipse.persistence.jaxb.JAXBContextFactory");
        
       taxiiXml = txf.createTaxiiXml();
    }

    private PollFulfillment getPollFulfillment1() {
        PollFulfillment pf = factory.createPollFulfillment()
                                .withMessageId("pf1")
                                .withCollectionName("1-800-collection")
                                .withResultId("123")
                                .withResultPartNumber(BigInteger.ONE);
        return pf;        
    }
    
    @Test
    public void pollFullfillment1XML() throws JAXBException, SAXException, IOException {
        TestUtil.roundTripMessage(taxiiXml, getPollFulfillment1());                                                
    }

    @Test
    public void pollFullfillment1JSON() throws JAXBException, SAXException, IOException {
        TestUtilJSON.roundTripMessage(taxiiXml, getPollFulfillment1());                                                
    }
}
