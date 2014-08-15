package org.mitre.taxii.messages.xml11;

import java.io.IOException;
import java.math.BigInteger;
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
                                .withMessageId("PollResp1")
                                .withInResponseTo("tmp")
                                .withCollectionName("blah")
                                .withMore(Boolean.FALSE)
                                .withResultId("123")
                                .withResultPartNumber(BigInteger.ONE)
                                .withSubscriptionID("24")
                                .withExclusiveBeginTimestamp(beginTime)
                                .withInclusiveEndTimestamp(endTime)
                                .withRecordCount(factory.createRecordCountType()
                                                    .withPartialCount(Boolean.FALSE)
                                                    .withValue(BigInteger.valueOf(22))                                
                                )
                                .withMessage("Woooooooo");
        TestUtil.roundTripMessage(taxiiXml, pr1);                                
    }
    
    @Test
    public void pollResp2() throws JAXBException, SAXException, IOException {
        
        PollResponse pr = factory.createPollResponse()
                                .withMessageId("PollResp2")
                                .withInResponseTo("tmp")
                                .withCollectionName("blah");
        TestUtil.roundTripMessage(taxiiXml, pr);                                
    }

    @Test
    public void pollResp3() throws JAXBException, SAXException, IOException {
        
        PollResponse pr = factory.createPollResponse()
                                .withMessageId("PollResp3")
                                .withInResponseTo("tmp")
                                .withCollectionName("blah")
                                .withResultId("123")
                                .withSubscriptionID("24")
                                .withRecordCount(factory.createRecordCountType()
                                                    .withValue(BigInteger.valueOf(22))                                
                                );
        TestUtil.roundTripMessage(taxiiXml, pr);                                
    }
    
    @Test
    public void pollResp4() throws JAXBException, SAXException, IOException {
        
        PollResponse pr = factory.createPollResponse()
                                .withMessageId("PollResp4")
                                .withInResponseTo("tmp")
                                .withCollectionName("blah");
        TestUtil.roundTripMessage(taxiiXml, pr);                                
    }
}
