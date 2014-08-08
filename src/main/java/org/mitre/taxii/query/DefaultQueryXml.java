package org.mitre.taxii.query;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.dom.DOMResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.mitre.taxii.messages.xmldsig.Signature;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author jasenj1
 */
public final class DefaultQueryXml {
    // Format ID for this version of TAXII Default Query
    public static final String FID_TAXII_DEFAULT_QUERY_10 = "urn:taxii.mitre.org:query:default:1.0";

    // XML Schema document location.
    private static final String TAXII_DEFAULT_QUERY_SCHEMA = "/TAXII_DefaultQuery_schema.xsd";

    // Capability Module IDs
    // Capability Module ID for Core
    public static final String CM_CORE = "urn:taxii.mitre.org:query:capability:core-1";
    // Capability Module ID for Regex
    public static final String CM_REGEX = "urn:taxii.mitre.org:query:capability:regex-1";
    // Capability Module ID for Timestamp
    public static final String CM_TIMESTAMP = "urn:taxii.mitre.org:query:capability:timestamp-1";

    // Tuple of all capability modules defined in TAXII Default Query 1.0
    public static final List<String> CM_IDS = Arrays.asList(CM_CORE, CM_REGEX, CM_TIMESTAMP);

    // Operators
    // Operator OR
    public static final String OP_OR = "OR";
    // Operator AND
    public static final String OP_AND = "AND";

    // Tuple of all operators
    public static final List<String> OP_TYPES = Arrays.asList(OP_OR, OP_AND);

    // Status Type indicating an unsupported capability module
    public static final String ST_UNSUPPORTED_CAPABILITY_MODULE = "UNSUPPORTED_CAPABILITY_MODULE";
    // Status Type indicating an unsupported targeting expression
    public static final String ST_UNSUPPORTED_TARGETING_EXPRESSION = "UNSUPPORTED_TARGETING_EXPRESSION";
    // Status Type indicating an unsupported targeting expression id
    public static final String ST_UNSUPPORTED_TARGETING_EXPRESSION_ID = "UNSUPPORTED_TARGETING_EXPRESSION_ID";
    
//    private final JAXBContext jaxbContext;
//    private final Schema defaultQuerySchema;
    
    DefaultQueryInfo dqi;

/*    
    private DefaultQueryXml(JAXBContext context, Schema schema) {
        this.jaxbContext = context;
        this.defaultQuerySchema = schema;
    }
    
    public static DefaultQueryXml newInstance() {
        return new DefaultQueryXml(newJAXBContext(), newSchema());
    }
  */
    
    public void setDefaultQueryInfo(DefaultQueryInfo dqi) {
        this.dqi = dqi;
    }
    
    public DefaultQueryInfo getDefaultQueryInfo() {
        return this.dqi;
    }

    /**
     * Returns a JAXBContext for the TAXII XML Message Binding 1.1 classes.
     * 
     * @throws RuntimeException 
     *              if a deployment error prevents 
     *              the JAXBContext from being created
     */
/*    
    private static JAXBContext newJAXBContext() {
        try {
            return JAXBContext.newInstance(DefaultQueryXml.class.getPackage().getName() + ":"
                            + Signature.class.getPackage().getName());
        } catch (JAXBException e) {
            throw new RuntimeException("Deployment error", e);
        }
    }
*/    
    /**
     * Returns a JAXP Schema that can be used to validate against the TAXII
     * XML Message Binding 1.1 schema.
     * 
     * @throws RuntimeException 
     *              if a deployment error prevents the TAXII Schema from 
     *              being parsed
     */
/*    
    private static Schema newSchema() {
        final SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            return sf.newSchema(org.mitre.taxii.messages.xml10.ObjectFactory.class.getResource(TAXII_DEFAULT_QUERY_SCHEMA));
        } catch (SAXException e) {
            throw new RuntimeException("Deployment error: can't parse TAXII schema", e);
        }
    }
*/    
    /**
     * Returns a marshaller for the TAXII Default Query binding.
     * classes.
     * 
     * @param prettyPrint
     *              Returns a marshaller that indents the output if true.
     * @return 
     * @throws JAXBException 
     *              if an error was encountered while creating the Marshaller
     */
/*    
    public Marshaller createMarshaller(
            boolean prettyPrint)
            throws JAXBException {
        final Marshaller m = jaxbContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, prettyPrint);
        return m;
    }
*/    
    /**
     * Marshals the DefaultQueryInfo to an XML String. 
     * 
     * @return 
     */
/*    
    @Override
    public String toString() {
        final StringWriter sw = new StringWriter();
        try {
            Marshaller m = createMarshaller(true);
            m.marshal(dqi, sw);
        } catch (JAXBException ex) {
            Logger.getLogger(DefaultQueryXml.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sw.toString();
    }
*/    
    /**
     * Marshals the DefaultQueryInfo to a DOM Element.
     * 
     * @return 
     */
/*    
    public  Element toElement() {
            DOMResult res = new DOMResult();
        try {
            Marshaller m = createMarshaller(false);
            m.marshal(dqi, res);
        } catch (JAXBException ex) {
            Logger.getLogger(DefaultQueryXml.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        Element el = (Element)res.getNode().getFirstChild();
       
        return el;
    }
*/    
}
