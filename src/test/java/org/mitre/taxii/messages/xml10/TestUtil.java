package org.mitre.taxii.messages.xml10;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.ListIterator;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.mitre.taxii.util.Validation;
import org.xml.sax.SAXException;

/**
 *
 * @author jasenj1
 */
public class TestUtil {
    private static final boolean debug = true; // Boolean.getBoolean("debug"); 

    /**
     * Render a JAXB object to an XML string and back to a JAXB Object.
     * This does NOT validate the object because it may be schema invalid.
     * e.g. The element may represent an item that only exists in the schema as
     * a child of another element, but we need to create one on its own, like a
     * Content_Block element.
     * 
     * @param taxiiXml
     * @param obj
     * @throws JAXBException
     * @throws SAXException
     * @throws IOException 
     */
    public static void roundTripObject(TaxiiXml taxiiXml, Object obj, boolean compareObject) throws JAXBException, SAXException, IOException {
        final Marshaller m = taxiiXml.createMarshaller(false); // Whether to pretty print. // Using pretty print causes problems with some extra carriage returns being put in during the round trip.
        final Unmarshaller u = taxiiXml.getJaxbContext().createUnmarshaller();
        
        m.setProperty(Marshaller.JAXB_FRAGMENT, true); // Don't generate xml declaration.
        
        // Render the JAXB object to a string.
        final StringWriter sw = new StringWriter();
        m.marshal(obj, sw);        
        String xmlString = sw.toString();

        // Parse the rendered string back into a JAXB object.
        final Object objFromXml = u.unmarshal(new StringReader(xmlString));

        // Render the reconstructed JAXB object to a string.
        sw.getBuffer().setLength(0);
        m.marshal(objFromXml, sw);
        final String xmlString2 = sw.toString();

        if (debug) {            
            System.out.println("Original Object:\n");
            System.out.println(xmlString);
            System.out.println("\n");
            System.out.println("Unmarshaled Object:\n");
            System.out.println(xmlString2);
        }
        
        // do the XML-object-XML round trip comparison first because it's
        // easier to debug
        assertEquals("round tripping from XML to object back to XML failed",
                xmlString, xmlString2);
        if (compareObject) {
            assertEquals("round tripping from object to XML back to object failed! ",
                    obj, objFromXml);
        }
    }
    
    public static void roundTripMessage(TaxiiXml taxiiXml, MessageType msg) throws JAXBException, SAXException, IOException {
        roundTripMessage(taxiiXml, msg, true, true);
    }
    
    /**
     * Confirm that a JAXB MessageType Object matches itself when marshaled to
     * a String and back.
     * 
     * @param taxiiXml
     * @param msg
     * @param prettyPrint
     * @throws javax.xml.bind.JAXBException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public static void roundTripMessage(TaxiiXml taxiiXml, MessageType msg, boolean prettyPrint, boolean compareObject) throws JAXBException, SAXException, IOException {

        final Marshaller m = taxiiXml.createMarshaller(prettyPrint); // Whether to pretty print. // Using pretty print causes problems with some extra carriage returns being put in during the round trip.
        final Unmarshaller u = taxiiXml.getJaxbContext().createUnmarshaller();
        
        m.setProperty(Marshaller.JAXB_FRAGMENT, true); // Don't generate xml declaration.

        if (debug) {
            final String rawString = taxiiXml.marshalToString(m, msg);
            System.out.println("raw marshalled XML:\n");
            System.out.println(rawString);
            System.out.println("\n");
        }
        
        assertValid(taxiiXml, msg);
        // Render the JAXB object to a string.
        final String xmlString = taxiiXml.marshalToString(m, msg);
        
        // Parse the rendered string back into a JAXB object.
        final MessageType msgFromXml = (MessageType) u.unmarshal(new StringReader(xmlString));
        assertValid(taxiiXml, msgFromXml);
        
        // Render the reconstructed JAXB object to a string.
        final String xmlString2 = taxiiXml.marshalToString(m, msgFromXml);
        
        if (debug) {
            System.out.println("validated XML:\n");
            System.out.println(xmlString);
            System.out.println("\n");
            
            System.out.println("Parsed & re-marshalled XML:\n");
            System.out.println(xmlString2);
            System.out.println("\n");
        }
        
        // do the XML-object-XML round trip comparison first because it's
        // easier to debug
        assertEquals("round tripping from XML to object back to XML failed",
                xmlString, xmlString2);
        
        if (compareObject) {
            assertEquals("round tripping from object to XML back to object failed! ",
                    msg, msgFromXml);
        }
    }    
    
    public static void assertValid(TaxiiXml taxiiXml, MessageType msg) 
            throws JAXBException, SAXException, IOException {
        final Validation results = taxiiXml.validateAll(msg, true);
        if (results.isFailure()) {
            fail(results.getAllErrorsAndWarnings());
        }
        if (results.hasWarnings()) {
            System.out.print("Validation warnings: ");
            System.out.println(results.getAllWarnings());
        }
    }
    
}
