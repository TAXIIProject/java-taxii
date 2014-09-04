package org.mitre.taxii.messages.xml10;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private ContentBlockType cb001, cb002;

    public InboxMessageTests() {
       taxiiXml = txf.getTaxiiXml();
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

        
        cb001 = factory.createContentBlockType()
                    .withContentBinding(
                        ContentBindings.CB_STIX_XML_11
                    )
                    .withContent(
                            factory.createAnyMixedContentType()
                                .withContent(stix)
                    )
                    .withTimestampLabel(timeStamp.normalize())
                    .withPadding("The quick brown fox jumped over the lazy dogs.");                
        
        cb002 = factory.createContentBlockType()
                    .withContentBinding(
                            ContentBindings.CB_STIX_XML_11
                    )
                    .withContent(
                            factory.createAnyMixedContentType()
                                .withContent(stix)                            
                    );
    }
    
    
    @Test
    public void inbox1() throws JAXBException, SAXException, IOException, DatatypeConfigurationException {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(new Date()); // Now.
        XMLGregorianCalendar beginTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        
        gc.setTime(new Date()); // Now.
        XMLGregorianCalendar endTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);

        SourceSubscriptionType si = factory.createSourceSubscriptionType()
                                        .withSubscriptionId("SubsId021")
                                        .withInclusiveBeginTimestamp(beginTime)
                                        .withInclusiveEndTimestamp(endTime);
                
        InboxMessage inbox = factory.createInboxMessage()
                                .withMessageId("Inbox1")
                                .withMessage("Hello!")                                
                                .withSourceSubscription(si)
                                .withContentBlocks(cb001, cb002);                                               
        
        TestUtil.roundTripMessage(taxiiXml, inbox, false);                                       
    }
    
    @Test
    public void inbox2() throws JAXBException, SAXException, IOException {
        InboxMessage inbox = factory.createInboxMessage()
                                .withMessageId("Inbox2");

        TestUtil.roundTripMessage(taxiiXml, inbox);                                                       
    }

    @Test
    public void inbox3() throws JAXBException, SAXException, IOException {
        SourceSubscriptionType si = factory.createSourceSubscriptionType()
                                        .withSubscriptionId("SubsId021");
        
        InboxMessage inbox = factory.createInboxMessage()
                                .withMessageId("Inbox3")
                                .withSourceSubscription(si)
                                .withContentBlocks(cb002);

        TestUtil.roundTripMessage(taxiiXml, inbox, false);                                                       
    }
    
}
