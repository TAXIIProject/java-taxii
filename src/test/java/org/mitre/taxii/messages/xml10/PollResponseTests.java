package org.mitre.taxii.messages.xml10;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.junit.Test;
import org.mitre.taxii.query.DefaultQuery;
import org.xml.sax.SAXException;

/**
 *
 * @author jasenj1
 */
public class PollResponseTests {
    private final ObjectFactory factory = new ObjectFactory();
    private final TaxiiXmlFactory txf = new TaxiiXmlFactory();
    private final TaxiiXml taxiiXml;
    
    public PollResponseTests() {
       txf.addJaxbContextPackage(DefaultQuery.class.getPackage().getName());
       taxiiXml = txf.getTaxiiXml();
    }
    
    @Test
    public void pollResp1() throws JAXBException, SAXException, IOException, DatatypeConfigurationException {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(new Date()); // Now.
        XMLGregorianCalendar beginTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        
        gc.setTime(new Date()); // Now.
        XMLGregorianCalendar endTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);

        
        PollResponse pr1 = factory.createPollResponse()
                                .withMessageId("1")
                                .withFeedName("Feed1")
                                .withInResponseTo("1")
                                .withSubscriptionId("24")
                                .withInclusiveBeginTimestamp(beginTime)
                                .withInclusiveEndTimestamp(endTime)
                                .withMessage("Woooooooo");
        TestUtil.roundTripMessage(taxiiXml, pr1);                                
    }    
}
