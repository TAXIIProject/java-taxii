package org.mitre.taxii.messages.xml11;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBContext;
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
        // Use MOXy so we get JSON support
        System.setProperty(JAXBContext.JAXB_CONTEXT_FACTORY, "org.eclipse.persistence.jaxb.JAXBContextFactory");
        
       txf.addJaxbContextPackage(DefaultQuery.class.getPackage().getName());
       taxiiXml = txf.createTaxiiXml();
    }
    
    private PollResponse getPollResp1() throws JAXBException, SAXException, IOException, DatatypeConfigurationException {
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
        
        return pr1;
    }
    
    @Test
    public void pollResp1XML() throws JAXBException, SAXException, IOException, DatatypeConfigurationException {
        TestUtil.roundTripMessage(taxiiXml, getPollResp1());                                        
    }
    
    @Test
    public void pollResp1JSON() throws JAXBException, SAXException, IOException, DatatypeConfigurationException {
        TestUtilJSON.roundTripMessage(taxiiXml, getPollResp1());                                        
    }

    
    private PollResponse getPollResp2(){        
        PollResponse pr = factory.createPollResponse()
                                .withMessageId("PollResp2")
                                .withInResponseTo("tmp")
                                .withCollectionName("blah");
        return pr;
    }

    @Test
    public void pollResp2XML() throws JAXBException, SAXException, IOException {
        TestUtil.roundTripMessage(taxiiXml, getPollResp2());                                        
    }
    
    @Test
    public void pollResp2JSON() throws JAXBException, SAXException, IOException {
        TestUtilJSON.roundTripMessage(taxiiXml, getPollResp2());                                        
    }

    
    private PollResponse getPollResp3() throws JAXBException, SAXException, IOException {
        
        PollResponse pr = factory.createPollResponse()
                                .withMessageId("PollResp3")
                                .withInResponseTo("tmp")
                                .withCollectionName("blah")
                                .withResultId("123")
                                .withSubscriptionID("24")
                                .withRecordCount(factory.createRecordCountType()
                                                    .withValue(BigInteger.valueOf(22))                                
                                );
        return pr;
    }

    @Test
    public void pollResp3XML() throws JAXBException, SAXException, IOException {
        TestUtil.roundTripMessage(taxiiXml, getPollResp3());                                        
    }
    
    @Test
    public void pollResp3JSON() throws JAXBException, SAXException, IOException {
        TestUtilJSON.roundTripMessage(taxiiXml, getPollResp3());                                        
    }
    
    private PollResponse getPollResp4() {
        
        PollResponse pr = factory.createPollResponse()
                                .withMessageId("PollResp4")
                                .withInResponseTo("tmp")
                                .withCollectionName("blah");
        return pr;
    }
    
    @Test
    public void pollResp4XML() throws JAXBException, SAXException, IOException {
        TestUtil.roundTripMessage(taxiiXml, getPollResp4());                                        
    }
    
    @Test
    public void pollResp4JSON() throws JAXBException, SAXException, IOException {
        TestUtilJSON.roundTripMessage(taxiiXml, getPollResp4());                                        
    }
    
}
