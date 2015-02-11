package org.mitre.taxii.messages.xml11;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.oxm.MediaType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.mitre.taxii.util.Validation;
import org.xml.sax.SAXException;

/**
 * Utilities for marshalling/serializing and unmarshalling/parsing 
 * TAXII items as JSON. This assumes the TaxiiXml implementation supports
 * JSON.
 * This was written using the EclipseLink MOXy JAXB provider.
 * http://eclipse.org/eclipselink/moxy.php
 * 
 * @author jasenj1
 */
public class TestUtilJSON {
    private static final boolean debug = true; // Boolean.getBoolean("debug"); 

    /**
     * Render a JAXB object to a JSON string and back to a JAXB Object.
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
        
        // Tell the marshaller to output JSON.
        m.setProperty(MarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);
        // Tell the unmarshaller to parse JSON.
        u.setProperty(MarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);

        // Render the JAXB object to a string.
        final StringWriter sw = new StringWriter();
        m.marshal(obj, sw);        
        String jsonString = sw.toString();
        
        if (debug) {            
            System.out.println("Original Object:\n");
            System.out.println(jsonString);
            System.out.println("\n");
        }

        // Parse the rendered string back into a JAXB object.
        final Object objFromJSON = u.unmarshal(new StringReader(jsonString));

        // Render the reconstructed JAXB object to a string.
        sw.getBuffer().setLength(0);
        m.marshal(objFromJSON, sw);
        final String jsonString2 = sw.toString();

        if (debug) {            
            System.out.println("Unmarshaled Object:\n");
            System.out.println(jsonString2);
        }
        
        // do the JSON-object-JSON round trip comparison first because it's
        // easier to debug
        assertEquals("round tripping from JSON to object back to JSON failed",
                jsonString, jsonString2);
        
        if(compareObject) {
            assertEquals("round tripping from object to JSON back to object failed! ",
                    obj, objFromJSON);
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

        // Tell the marshaller to output JSON.
        m.setProperty(MarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);
        // Tell the unmarshaller to parse JSON.
        u.setProperty(MarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);
        
        if (debug) {
            final String rawString = taxiiXml.marshalToString(m, msg);
            System.out.println("raw marshalled JSON:\n");
            System.out.println(rawString);
            System.out.println("\n");
        }
        
        assertValid(taxiiXml, msg);
        // Render the JAXB object to a string.
        final String jsonString = taxiiXml.marshalToString(m, msg);
        
        // Parse the rendered string back into a JAXB object.
        final MessageType msgFromJSON = (MessageType) u.unmarshal(new StringReader(jsonString));
        assertValid(taxiiXml, msgFromJSON);
        
        // Render the reconstructed JAXB object to a string.
        final String jsonString2 = taxiiXml.marshalToString(m, msgFromJSON);
        
        if (debug) {
            System.out.println("validated JSON:\n");
            System.out.println(jsonString);
            System.out.println("\n");
            
            System.out.println("Parsed & re-marshalled JSON:\n");
            System.out.println(jsonString2);
            System.out.println("\n");
        }
        
        // do the XML-object-XML round trip comparison first because it's
        // easier to debug
        assertEquals("round tripping from JSON to object back to JSON failed",
                jsonString, jsonString2);
        
        if (compareObject) {
        assertEquals("round tripping from object to JSON back to object failed! ",
                msg, msgFromJSON);
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
