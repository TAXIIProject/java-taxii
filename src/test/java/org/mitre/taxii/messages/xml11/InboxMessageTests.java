package org.mitre.taxii.messages.xml11;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.Test;
import org.mitre.taxii.ContentBindings;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author jasenj1
 */
public class InboxMessageTests {
    private final ObjectFactory factory = new ObjectFactory();
    private final TaxiiXmlFactory txf = new TaxiiXmlFactory();
    private final TaxiiXml taxiiXml;
    
    private ContentBlock cb001, cb002;

    public InboxMessageTests() {
        // Use MOXy so we get JSON support
        System.setProperty(JAXBContext.JAXB_CONTEXT_FACTORY, "org.eclipse.persistence.jaxb.JAXBContextFactory");

        taxiiXml = txf.createTaxiiXml();
        try {
            setup();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(InboxMessageTests.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(InboxMessageTests.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InboxMessageTests.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(InboxMessageTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setup() throws ParserConfigurationException, SAXException, IOException, DatatypeConfigurationException {
        
        // Create a DOM Node from an XML string.
        // JAXB can handle a generic DOM NODE, but a String it will escape and treat as a String - not XML.
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new InputSource(new StringReader("<STIX_Package/>")));
        Node stix = doc.getDocumentElement();
        
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(new Date()); // Now.
        XMLGregorianCalendar timeStamp = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);

        
        cb001 = factory.createContentBlock()
                    .withContentBinding(
                        factory.createContentInstanceType()
                            .withBindingId(ContentBindings.CB_STIX_XML_11)
                            .withSubtype(
                                    factory.createSubtypeType()
                                        .withSubtypeId("test1")
                            )
                    )
                    .withContent(
                            factory.createAnyMixedContentType()
                                .withContent(stix)
                    )
                    .withTimestampLabel(timeStamp.normalize())
                    .withMessage("Hullo!")
                    .withPadding("The quick brown fox jumped over the lazy dogs.");                
        
        cb002 = factory.createContentBlock()
                    .withContentBinding(
                        factory.createContentInstanceType()
                            .withBindingId(ContentBindings.CB_STIX_XML_11)
                    )
                    .withContent(
                            factory.createAnyMixedContentType()
                                .withContent(stix)                            
                    );
    }
        
    private InboxMessage getInbox1() throws DatatypeConfigurationException {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(new Date()); // Now.
        XMLGregorianCalendar beginTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        
        gc.setTime(new Date()); // Now.
        XMLGregorianCalendar endTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);

        SourceSubscriptionType si = factory.createSourceSubscriptionType()
                                        .withCollectionName("SomeCollectionName")
                                        .withSubscriptionID("SubsId021")
                                        .withExclusiveBeginTimestamp(beginTime)
                                        .withInclusiveEndTimestamp(endTime);
                
        InboxMessage inbox = factory.createInboxMessage()
                                .withMessageId("Inbox1")
                                .withResultId("123")
                                .withDestinationCollectionNames("collection1", "collection2")
                                .withMessage("Hello!")                                
                                .withSourceSubscription(si)
                                .withRecordCount(
                                    factory.createRecordCountType()
                                        .withPartialCount(Boolean.TRUE)
                                        .withValue(BigInteger.valueOf(22)                                        
                                ))
                                .withContentBlocks(cb001, cb002);                                                       
        return inbox;
    }
    
    @Test
    public void inbox1XML() throws JAXBException, SAXException, IOException, DatatypeConfigurationException {
        TestUtil.roundTripMessage(taxiiXml, getInbox1(), false, false); // Do not pretty print, and do not compare the object - only the string representation.
        
    }
    
    @Test
    public void inbox1JSON() throws JAXBException, SAXException, IOException, DatatypeConfigurationException {
        TestUtilJSON.roundTripMessage(taxiiXml, getInbox1(), false, false); // Do not pretty print, and do not compare the object - only the string representation.
        
    }

    
    private InboxMessage getInbox2() {
        InboxMessage inbox = factory.createInboxMessage()
                                .withMessageId("Inbox2");
        return inbox;
    }
    
    @Test
    public void inbox2XML() throws JAXBException, SAXException, IOException, DatatypeConfigurationException {
        TestUtil.roundTripMessage(taxiiXml, getInbox2());                                                               
    }    

    @Test
    public void inbox2JSON() throws JAXBException, SAXException, IOException, DatatypeConfigurationException {
        TestUtilJSON.roundTripMessage(taxiiXml, getInbox2());                                                               
    }    

    private InboxMessage getInbox3() {
        SourceSubscriptionType si = factory.createSourceSubscriptionType()
                                        .withCollectionName("SomeCollectionName")
                                        .withSubscriptionID("SubsId021");
        
        InboxMessage inbox = factory.createInboxMessage()
                                .withMessageId("Inbox3")
                                .withResultId("123")
                                .withDestinationCollectionNames("collection1", "collection2")
                                .withSourceSubscription(si)
                                .withRecordCount(factory.createRecordCountType().withValue(BigInteger.ONE)) //NOTE: Python test does not add the record count and generates an invalid message.
                                .withContentBlocks(cb002);

        return inbox;
    }

    @Test
    public void inbox3XML() throws JAXBException, SAXException, IOException, DatatypeConfigurationException {
        TestUtil.roundTripMessage(taxiiXml, getInbox3(), false, false); // Do not pretty print, and do not compare the object - only the string representation.        
    }    

    @Test
    public void inbox3JSON() throws JAXBException, SAXException, IOException, DatatypeConfigurationException {
        TestUtilJSON.roundTripMessage(taxiiXml, getInbox3(), false, false); // Do not pretty print, and do not compare the object - only the string representation.        
    }    
}
