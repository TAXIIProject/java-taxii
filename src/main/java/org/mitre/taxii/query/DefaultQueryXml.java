package org.mitre.taxii.query;

/*
Copyright (c) 2014, The MITRE Corporation
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
    * Neither the name of The MITRE Corporation nor the 
      names of its contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 */

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.dom.DOMResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.mitre.taxii.messages.xmldsig.Signature;
import org.mitre.taxii.util.Validation;
import org.mitre.taxii.util.ValidationErrorHandler;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * Provides a JAXB environment for TAXII Default Query objects similar to 
 * what {@link org.mitre.taxii.messages.TaxiiXml} provides.
 * 
 * This class is slightly different in that Schematron conformance is not supported
 * (as of this writing there were no Schematron rules for queries). This class
 * also contains a {@link DefaultQueryInfo} field that contains the query object
 * to be operated on whereas in {@link org.mitre.taxii.messages.TaxiiXml} the 
 * JAXB object is kept separate.
 * 
 * @author jasenj1
 */
public final class DefaultQueryXml {
    /** Format ID for this version of TAXII Default Query */
    public static final String FID_TAXII_DEFAULT_QUERY_10 = "urn:taxii.mitre.org:query:default:1.0";

    /** XML Schema document location. */
    private static final String TAXII_DEFAULT_QUERY_SCHEMA = "/TAXII_DefaultQuery.xsd";

    // Capability Module IDs
    /** Capability Module ID for Core */
    public static final String CM_CORE = "urn:taxii.mitre.org:query:capability:core-1";
    
    /** Capability Module ID for Regex */ 
    public static final String CM_REGEX = "urn:taxii.mitre.org:query:capability:regex-1";
    
    /** Capability Module ID for Timestamp */
    public static final String CM_TIMESTAMP = "urn:taxii.mitre.org:query:capability:timestamp-1";

    /** Tuple of all capability modules defined in TAXII Default Query 1.0 */
    public static final List<String> CM_IDS = Arrays.asList(CM_CORE, CM_REGEX, CM_TIMESTAMP);

    // Operators
    /** Operator OR */
    public static final String OP_OR = "OR";
    /** Operator AND */
    public static final String OP_AND = "AND";

    /**  Tuple of all operators */
    public static final List<String> OP_TYPES = Arrays.asList(OP_OR, OP_AND);

    /** Status Type indicating an unsupported capability module */
    public static final String ST_UNSUPPORTED_CAPABILITY_MODULE = "UNSUPPORTED_CAPABILITY_MODULE";
    /** Status Type indicating an unsupported targeting expression */
    public static final String ST_UNSUPPORTED_TARGETING_EXPRESSION = "UNSUPPORTED_TARGETING_EXPRESSION";
    /** Status Type indicating an unsupported targeting expression id */
    public static final String ST_UNSUPPORTED_TARGETING_EXPRESSION_ID = "UNSUPPORTED_TARGETING_EXPRESSION_ID";
    
    private final JAXBContext jaxbContext;
    private final Schema defaultQuerySchema;
    
    DefaultQueryInfo dqi;

    private DefaultQueryXml(JAXBContext context, Schema schema) {
        this.jaxbContext = context;
        this.defaultQuerySchema = schema;
    }
    
    public static DefaultQueryXml newInstance() {
        return new DefaultQueryXml(newJAXBContext(), newSchema());
    }
    
    public void setDefaultQueryInfo(DefaultQueryInfo dqi) {
        this.dqi = dqi;
    }
    
    public DefaultQueryInfo getDefaultQueryInfo() {
        return this.dqi;
    }

    /**
     * Returns a JAXBContext for the Default Query and XML Digital Signature classes.
     * 
     * @throws RuntimeException 
     *              if a deployment error prevents 
     *              the JAXBContext from being created
     */
    private static JAXBContext newJAXBContext() {
        try {
            return JAXBContext.newInstance(DefaultQueryXml.class.getPackage().getName() + ":"
                            + Signature.class.getPackage().getName());
        } catch (JAXBException e) {
            throw new RuntimeException("Deployment error", e);
        }
    }

    /**
     * Returns a JAXP Schema that can be used to validate against the 
     * Default Query schema
     * 
     * @throws RuntimeException 
     *              if a deployment error prevents the Schema from 
     *              being parsed
     */
    private static Schema newSchema() {
        final SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            return sf.newSchema(org.mitre.taxii.messages.xml10.ObjectFactory.class.getResource(TAXII_DEFAULT_QUERY_SCHEMA));
        } catch (SAXException e) {
            throw new RuntimeException("Deployment error: can't parse Default Query schema", e);
        }
    }

    /**
     * Returns a marshaller for the TAXII Default Query binding.
     * classes.
     * 
     * @param prettyPrint
     *              Returns a marshaller that indents the output if true.
     * @return a marshaller
     * @throws JAXBException 
     *              if an error was encountered while creating the Marshaller
     */
    public Marshaller createMarshaller(
            boolean prettyPrint)
            throws JAXBException {
        final Marshaller m = jaxbContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, prettyPrint);
        return m;
    }

    /**
     * Marshals the DefaultQueryInfo to an XML String. 
     * 
     * @return XML string.
     */
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

    /**
     * Marshals the DefaultQueryInfo to a DOM Element.
     * 
     * @return DOM Element
     */
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
    
    /**
     * Validates the given message, returning all accumulated errors and warnings.
     * 
     * @return 
     *       The validation results, including all errors and warnings.  
     * @throws JAXBException 
     *      If the message couldn't be validated because of an underlying JAXB error
     * @throws IOException 
     *      If the underlying {@link org.xml.sax.XMLReader} throws an
     *      {@link IOException}.
     * @throws SAXException 
     *      on any fatal validation error 
     */
    public Validation validateAll() 
            throws JAXBException, SAXException, IOException {
        return validate(this.dqi, false);
    }
    
    /**
     * Validates the given message, throwing a SAXException on the first
     * validation error encountered.
     * 
     * @return    
     *       The validation results, including any warnings.  If this method 
     *       returns successfully, then isSuccess() on the returned object will
     *       always return true.  
     * @throws JAXBException 
     *      If the message couldn't be validated because of an underlying JAXB error
     * @throws IOException 
     *      If the underlying {@link org.xml.sax.XMLReader} throws an
     *      {@link IOException}.
     * @throws SAXException 
     *      On the first validation error 
     */
    public Validation validateFast() 
            throws JAXBException, SAXException, IOException {
        return validate(this.dqi, true);
    }

   /**
    * Validates the given message.
    * 
    * <p>Technique derived from 
    * <a href="http://blog.bdoughan.com/2010/11/validate-jaxb-object-model-with-xml.html">Validate a JAXB Object Model With an XML Schema</a>
    * blog post.</p>
    *
    * @param m
    *       Message to validate
    * @param failFast
    *       If true, then a SAXException will be thrown on the first error 
    *       encountered; otherwise,
    *       all errors and warnings are returned in the Validation object.
    *       
    * @returns 
    *       The validation results.  If failFast is true,
    *       then a successful return indicates success, results.isSuccess() will 
    *       be true, and results will include any 
    *       validation warnings. If failFast is false, then the 
    *       results will include all errors and warnings.  
    * @throws JAXBException 
    *      If the message couldn't be validated because of an underlying JAXB error
    * @throws IOException 
    *      If the underlying {@link org.xml.sax.XMLReader} throws an
    *      {@link IOException}.
    * @throws SAXException 
    *      If failFast is true, then a SAXException will be thrown on the first
    *      validation error encountered. If failFast is false, then a 
    *      SAXException indicates a fatal error. 
    */
    private Validation validate(DefaultQueryInfo m, 
            boolean failFast
            ) 
            throws JAXBException, SAXException, IOException {
        JAXBSource source = new JAXBSource(jaxbContext, m);
        Validator validator = defaultQuerySchema.newValidator();
        final Validation results = new Validation();
        final ValidationErrorHandler errorHandler = new ValidationErrorHandler(results, failFast);
        validator.setErrorHandler(errorHandler);
        validator.validate(source);
                
        return results;
    }
    
}
