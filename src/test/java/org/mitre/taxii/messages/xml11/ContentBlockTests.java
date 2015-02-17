package org.mitre.taxii.messages.xml11;

import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
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
public class ContentBlockTests {
    private final ObjectFactory factory = new ObjectFactory();
    private final TaxiiXmlFactory txf = new TaxiiXmlFactory();
    private final TaxiiXml taxiiXml;    
    private final boolean debug = true; // Boolean.getBoolean("debug");

    public ContentBlockTests() {
        // Use MOXy so we get JSON support
        System.setProperty(JAXBContext.JAXB_CONTEXT_FACTORY, "org.eclipse.persistence.jaxb.JAXBContextFactory");
        
        taxiiXml = txf.createTaxiiXml();
    }
    
    
    private ContentBlock gecContentBlock1() throws SAXException, ParserConfigurationException, IOException {
        
        // Create a DOM Node from an XML string.
        // JAXB can handle a generic DOM NODE, but a String it will escape and treat as a String - not XML.
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();        
        Document doc = db.parse(new InputSource(new StringReader("<stix:STIX_Package xmlns:stix=\"http://stix.mitre.org/stix-1\"/>")));
        Node stix = doc.getDocumentElement();
        
        ContentBlock cb = factory.createContentBlock()                                    
                                    .withContentBinding(
                                        factory.createContentInstanceType().withBindingId(ContentBindings.CB_STIX_XML_10)
                                    )
                                    .withContent(
                                        factory.createAnyMixedContentType()
                                                .withContent(stix)
                                    );
        return cb;
    }
    
    @Test
    public void contentBlock1XML() throws JAXBException, SAXException, IOException, ParserConfigurationException {
        ContentBlock cb = gecContentBlock1();
        TestUtil.roundTripObject(taxiiXml, cb, false); // Don't compare the original & reparsed object because the DOM above & whatever gets reparsed do not match.               
    }
    
    @Test
    public void contentBlock1JSON() throws JAXBException, SAXException, IOException, ParserConfigurationException {
        ContentBlock cb = gecContentBlock1();
        TestUtilJSON.roundTripObject(taxiiXml, cb, false); // Don't compare the original & reparsed object because the DOM above & whatever gets reparsed do not match.       
    }    
    
    
    private ContentBlock getContentBlock2() throws JAXBException, SAXException, IOException {
        ContentBlock cb = factory.createContentBlock()                                    
                                    .withContentBinding(
                                            factory.createContentInstanceType().withBindingId(ContentBindings.CB_STIX_XML_10)
                                    )
                                    .withContent(
                                            factory.createAnyMixedContentType()
                                                    .withContent("<Something that's not XML")
                                    );
        return cb;
    }

    @Test
    public void contentBlock2XML() throws JAXBException, SAXException, IOException, ParserConfigurationException {
        ContentBlock cb = getContentBlock2();
        TestUtil.roundTripObject(taxiiXml, cb, true);        
    }
    
    @Test
    public void contentBlock2JSON() throws JAXBException, SAXException, IOException, ParserConfigurationException {
        ContentBlock cb = getContentBlock2();
        TestUtilJSON.roundTripObject(taxiiXml, cb, true);        
    }
    
    private ContentBlock getContentBlock3() throws JAXBException, SAXException, IOException {
        ContentBlock cb = factory.createContentBlock()                                    
                                    .withContentBinding(
                                            factory.createContentInstanceType().withBindingId(ContentBindings.CB_STIX_XML_10)
                                    )
                                    .withContent(
                                            factory.createAnyMixedContentType()
                                                    .withContent("Something that's not XML <xml/>")
                                    );
        
        return cb;
    }

    @Test
    public void contentBlock3XML() throws JAXBException, SAXException, IOException, ParserConfigurationException {
        ContentBlock cb = getContentBlock3();
        TestUtil.roundTripObject(taxiiXml, cb, true);        
    }
    
    @Test
    public void contentBlock3JSON() throws JAXBException, SAXException, IOException, ParserConfigurationException {
        ContentBlock cb = getContentBlock3();
        TestUtilJSON.roundTripObject(taxiiXml, cb, true);        
    }
    
    private ContentBlock getContentBlock4() throws JAXBException, SAXException, IOException {
        ContentBlock cb = factory.createContentBlock()                                    
                                    .withContentBinding(
                                            factory.createContentInstanceType().withBindingId("RandomUnicodeString")
                                    )
                                    .withContent(
                                            factory.createAnyMixedContentType()
                                                    .withContent("abcdef")
                                    );
        return cb;
    }

    @Test
    public void contentBlock4XML() throws JAXBException, SAXException, IOException, ParserConfigurationException {
        ContentBlock cb = getContentBlock4();
        TestUtil.roundTripObject(taxiiXml, cb, true);        
    }
    
    @Test
    public void contentBlock4JSON() throws JAXBException, SAXException, IOException, ParserConfigurationException {
        ContentBlock cb = getContentBlock4();
        TestUtilJSON.roundTripObject(taxiiXml, cb, true);        
    }
    
}
