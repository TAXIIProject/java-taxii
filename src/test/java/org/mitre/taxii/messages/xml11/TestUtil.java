package org.mitre.taxii.messages.xml11;

import java.io.IOException;
import java.io.StringReader;
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
     * Confirm that a JAXB MessageType Object matches itself when marshaled to
     * a String and back.
     * 
     * @param taxiiXml
     * @param msg
     * @throws javax.xml.bind.JAXBException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public static void roundTripMessage(TaxiiXml taxiiXml, MessageType msg) throws JAXBException, SAXException, IOException {

        final Marshaller m = taxiiXml.createMarshaller(true);
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
        assertEquals("round tripping from object to XML back to object failed! ",
                msg, msgFromXml);
    }    
    
    public static void assertValid(TaxiiXml taxiiXml, MessageType msg) 
            throws JAXBException, SAXException, IOException {
        final Validation results = taxiiXml.validateAll(msg);
        if (results.isFailure()) {
            fail(results.getAllErrorsAndWarnings());
        }
        if (results.hasWarnings()) {
            System.out.print("Validation warnings: ");
            System.out.println(results.getAllWarnings());
        }
    }
    
}
