package org.mitre.taxii.messages.xml10;

import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
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
        taxiiXml = txf.getTaxiiXml();
    }
    
    @Test
    public void contentBlock1() throws URISyntaxException, JAXBException, SAXException, IOException, ParserConfigurationException {
        
        // Create a DOM Node from an XML string.
        // JAXB can handle a generic DOM NODE, but a String it will escape and treat as a String - not XML.
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new InputSource(new StringReader("<stix:STIX_Package xmlns:stix=\"http://stix.mitre.org/stix-1\"/>")));
        Node stix = doc.getDocumentElement();
        
        ContentBlock cb = factory.createContentBlock()                                    
                                    .withContentBinding(
                                        ContentBindings.CB_STIX_XML_10
                                    )
                                    .withContent(
                                        factory.createAnyMixedContentType()
                                                .withContent(stix)
                                    );
                        
        TestUtil.roundTripObject(taxiiXml, cb, false);
    }
    
    @Test
    public void contentBlock2() throws JAXBException, SAXException, IOException {
        ContentBlock cb = factory.createContentBlock()                                    
                                    .withContentBinding(
                                            ContentBindings.CB_STIX_XML_10
                                    )
                                    .withContent(
                                            factory.createAnyMixedContentType()
                                                    .withContent("<Something thats not XML")
                                    );
                        
        TestUtil.roundTripObject(taxiiXml, cb, true);        
    }
    
    @Test
    public void contentBlock3() throws JAXBException, SAXException, IOException {
        ContentBlock cb = factory.createContentBlock()                                    
                                    .withContentBinding(
                                            ContentBindings.CB_STIX_XML_10
                                    )
                                    .withContent(
                                            factory.createAnyMixedContentType()
                                                    .withContent("Something thats not XML <xml/>")
                                    );
        
        TestUtil.roundTripObject(taxiiXml, cb, true);        
    }

    @Test
    public void contentBlock4() throws JAXBException, SAXException, IOException {
        ContentBlock cb = factory.createContentBlock()                                    
                                    .withContentBinding(
                                            "RandomUnicodeString"
                                    )
                                    .withContent(
                                            factory.createAnyMixedContentType()
                                                    .withContent("abcdef")
                                    );
        
        TestUtil.roundTripObject(taxiiXml, cb, true);        
    }
    
}
