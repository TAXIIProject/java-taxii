package org.mitre.taxii.messages;

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
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SAXDestination;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XsltExecutable;
import net.sf.saxon.s9api.XsltTransformer;
import org.mitre.taxii.client.HttpResponseErrorHandler;

// import org.mitre.taxii.messages.xmldsig.Signature;
import org.mitre.taxii.util.Iterators;
import org.mitre.taxii.util.Validation;
import org.mitre.taxii.util.ValidationErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * JAXB utility class.
 * 
 * <p>
 * This class provides a JAXB environment for marshaling, unmarshaling, and validating
 * TAXII messages. There are concrete subclasses to handle specific versions of TAXII.
 * 
 * The factory class for a specific version of TAXII should be used to create a TaxiiXml
 * object. There are a number of version specific parameters that must be set to 
 * create a useful TaxiiXml, the factories ensure the object is initialized properly.
 * </p>
 * <h3>Usage example</h3>
 * <p>
 * The following example demonstrates creating a TaxiiXml object and using it to
 * validate, marshal, and unmarshal a simple TAXII message.
 * </p>
 * <pre>
 *      ObjectFactory of = new ObjectFactory(); // JAXB factory for TAXII 
 *      TaxiiXmlFactory txf = new TaxiiXmlFactory(); // Create a factory with the default configuration.
 *      TaxiiXml taxiiXml = txf.createTaxiiXml(); // get a properly configured TaxiiXml
 * 
 *      DiscoveryMessage dm = of.createDiscoveryMessage()
 *                              .withMessageId(MessageHelper.generateMessageId());
 * 
 *      Validation results = taxiiXml.validateFast(dm, true); // Validate, failing on first error encountered, and perfoming Schematron validation.
 * 
 *      String xmlStr = taxiiXml.marshalToString(dm, true);
 * 
 *      DiscoveryMessage dm2 = taxiiXml.getJaxbContext().createUnmarshaller().unmarshal(new StringReader(xmlString));
 * 
 * </pre>
 * <h3>Validation</h3>
 * <p>
 * Note that {@link #validateFast(Object, boolean)} and {@link #validateAll(Object, boolean)}
 * perform validation checks beyond those done by the underlying XML schema; thus,
 * these methods should be preferred over doing schema validation during 
 * JAXB marshalling and unmarshalling.  Specifically, 
 * {@link Marshaller#setSchema(Schema)} and 
 * {@link Unmarshaller#setSchema(Schema)} should NOT be used for validation, as
 * the additional code checks would not be performed;
 * instead, {@link #validateFast(Object, boolean)} or 
 * {@link #validateAll(Object, boolean)} should be called before marshalling 
 * and after unmarshalling.
 * </p> 
 * 
 * <p>
 * The following examples show how validation should be done before marshalling
 * or after unmarshalling.  
 * </p>
 * 
 * 
 * <h3>Fast Validation before Marshalling</h3>
 *  
 * <pre>
 try {
   TaxiiXmlFactory txf = new TaxiiXmlFactory();
   TaxiiXml taxiiXml = txf.createTaxiiXml();
   Validation results = taxiiXml.validateFast(msg, true);
   if (results.hasWarnings()) {
     System.out.print("Validation warnings: ");
     System.out.println(results.getAllWarnings());
   }
   Marshaller m = taxiiXml.createMarshaller(true);
   m.marshal(msg, System.out);
 }
 catch (SAXParseException e) {
   System.err.print("Validation error: ");
   System.err.println(Validation.formatException(e));
 } 
 catch (SAXException e) {
   System.err.print("Validation error: ");
   e.printStackTrace();
 }
 </pre>
 * 
 * 
 * <h3>Fast Validation after Unmarshalling</h3>
 * 
 * <pre>
 try {
   TaxiiXmlFactory txf = new TaxiiXmlFactory();
   TaxiiXml taxiiXml = txf.createTaxiiXml();
   Unmarshaller u = taxiiXML.getJaxbContext().createUnmarshaller();
   MessageType msg = (MessageType) u.unmarshal(input);
   Validation results = taxiiXml.validateFast(msg, true);
   if (results.hasWarnings()) {
     System.out.print("Validation warnings: ");
     System.out.println(results.getAllWarnings());
   }
   // do something with msg
 }
 catch (SAXParseException e) {
   System.err.print("Validation error: ");
   System.err.println(Validation.formatException(e));
 } 
 catch (SAXException e) {
   System.err.print("Validation error: ");
   e.printStackTrace();
 }
 </pre>
 * 
 *
 * <h3>Comprehensive Validation before Marshalling</h3>
 * 
 * <pre>
 try {
   TaxiiXmlFactory txf = new TaxiiXmlFactory();
   TaxiiXml taxiiXml = txf.createTaxiiXml();
   Validation results = taxiiXml.validateAll(msg, true);
   if (results.isSuccess()) {
     if (results.hasWarnings()) {
     System.out.print("Validation warnings: ");
       System.out.println(results.getAllWarnings());
     }
     Marshaller m = taxiiXml.createMarshaller(true);
     m.marshal(msg, System.out);
   }
   else {  // validation errors and warnings together
     System.err.print("Validation results: ");
     System.err.println(results.getAllErrorsAndWarnings());
   }
 }
 catch (SAXParseException e) {
   System.err.print("Fatal validation error: ");
   System.err.println(Validation.formatException(e));
 } 
 catch (SAXException e) {
   System.err.print("Fatal validation error: ");
   e.printStackTrace();
 }
 </pre>
 * 
 * 
 * <h3>Comprehensive Validation after Unmarshalling</h3>
 * 
 * <pre>
 try {
   TaxiiXmlFactory txf = new TaxiiXmlFactory();
   TaxiiXml taxiiXml = txf.createTaxiiXml();
   Unmarshaller u = taxiiXML.getJaxbContext().createUnmarshaller();
   MessageType msg = (MessageType) u.unmarshal(input);
   Validation results = taxiiXml.validateAll(msg, true);
   if (results.isSuccess()) {
     if (results.hasWarnings()) {
       System.out.print("Validation warnings: ");
       System.out.println(results.getAllWarnings());
     }
     // do something with msg
   }
   else {  // validation errors and warnings together
     System.err.print("Validation results: ");
     System.err.println(results.getAllErrorsAndWarnings());
   }
 }
 catch (SAXParseException e) {
   System.err.print("Fatal validation error: ");
   System.err.println(Validation.formatException(e));
 } 
 catch (SAXException e) {
   System.err.print("Fatal validation error: ");
   e.printStackTrace();
 }
 </pre>
 * 
 * 
 * @author Jonathan W. Cranford & Jasen Jacobsen
 */
public abstract class TaxiiXml {
        
    private final JAXBContext jaxbContext;
    private final Schema taxiiSchema;
    private final XsltExecutable schematronValidator;
    private final List<String> contextEntries;
    private final String taxiiVersion;
    private final String serviceVersion;
            
    /**
     * Constructor that takes additional JAXB packages, used in initializing 
     * the JAXB Context.
     * 
     * For internal use. Use a TaxiiXmlFactory of the proper version to create
     * a TaxiiXml instance.
     * 
     * @see org.mitre.taxii.messages.xml10.TaxiiXmlFactory
     * @see org.mitre.taxii.messages.xml11.TaxiiXmlFactory
     * 
     * @param taxiiVersion
     * @param serviceVersion
     * @param taxiiPackage
     * @param otherPackages
     * @param schemaLocation
     * @param validatorLocation
     * @throws RuntimeException
     *              if a deployment error prevents the underlying JAXBContext
     *              from being created, the Schema from being parsed, or 
     *              the validating stylesheet from being compiled.
     */
    public TaxiiXml(String taxiiVersion, String serviceVersion, String taxiiPackage, List<String> otherPackages, String schemaLocation, String validatorLocation) {
        contextEntries = initializeJaxbContextEntries();
        contextEntries.add(taxiiPackage);
        contextEntries.addAll(otherPackages);
        jaxbContext = newJaxbContext(contextEntries);
        taxiiSchema = newSchema(schemaLocation);
        schematronValidator = newValidator(validatorLocation);
        this.taxiiVersion = taxiiVersion;
        this.serviceVersion = serviceVersion;
    }
    
    
    /**
     * Initialize the JAXB Context with known contexts that every instance of
     * TaxiiXml will need to know.
     * 
     */
    private static List<String> initializeJaxbContextEntries() {
        List<String> contextEntries = new ArrayList<>();
// The Python library does not include the digital signature schema by default. No need for Java to.        
//        contextEntries.add(Signature.class.getPackage().getName());
        return contextEntries;
    }


    /**
     * set the JAXBContext for the TAXII XML Message Binding 1.0 classes.
     * 
     * @throws RuntimeException 
     *              if a deployment error prevents 
     *              the JAXBContext from being created
     */
    private static JAXBContext newJaxbContext(List<String> contextEntries) {
        try {      
            return JAXBContext.newInstance(Iterators.join(contextEntries.iterator(), ":"));
        } catch (JAXBException e) {
            throw new RuntimeException("Deployment error", e);
        }
    }
                
    /**
     * Returns a marshaller for the TAXII XML Message Binding 1.0
     * classes.
     * 
     * @param prettyPrint
     *              Returns a marshaller that indents the output if true.
     * @return a marshaller to serialize TAXII XML objects.
     * @throws JAXBException 
     *              if an error was encountered while creating the Marshaler
     */
    public Marshaller createMarshaller(
            boolean prettyPrint)
            throws JAXBException {
        final Marshaller m = jaxbContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, prettyPrint);
        return m;
    }
    
    
    /**
     * Returns a JAXP Schema that can be used to validate against the TAXII
     * XML Message Binding 1.0 schema.
     * 
     * @throws RuntimeException 
     *              if a deployment error prevents the TAXII Schema from 
     *              being parsed
     */
    private Schema newSchema(String schemaLocation) {
        final SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            final URL resource = getClass().getResource(schemaLocation);
            if (resource == null) {
                throw new RuntimeException("Deployment error: can't find TAXII 1.0 schema (" + schemaLocation + ")");
            }
            return sf.newSchema(resource);
        } catch (SAXException e) {
            throw new RuntimeException("Deployment error: can't parse TAXII schema", e);
        }
    }
    
    
    /**
     * Compiles the (Schematron-derived) XSLT stylesheet that implements additional validation checks.
     */
    private XsltExecutable newValidator(String validatorPath) {
        // This method should only be called once in the constructor, and the
        // stylesheet is only compiled once, so we
        // don't cache any of these objects like we normally would.
        final URL resource = getClass().getResource(validatorPath);
        if (resource == null) {
            throw new RuntimeException("Deployment error: can't find additional TAXII validator (" + validatorPath + ")");
        }
        try {
            final boolean useLicensedEdition = false;
            return new Processor(useLicensedEdition).newXsltCompiler()
                    .compile(new StreamSource(resource.toString()));
        } 
        catch (SaxonApiException e) {
            throw new RuntimeException("Deployment error: The validator stylesheet contains static errors or it cannot be read. See the standard error output for details.",
                    e);
        }
    }
    
    /**
     * Validates the given message, returning all accumulated errors and warnings.
     * 
     * @param m
     *       The message to validate
     * @param checkSpecConformance      
     *       Check conformance to specification beyond what XML Schema provides.
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
    public Validation validateAll(Object m, boolean checkSpecConformance) 
            throws JAXBException, SAXException, IOException {
        return validate(m, false, checkSpecConformance);
    }
    
    
    /**
     * Validates the given message, throwing a SAXException on the first
     * validation error encountered.
     * 
     * @param m
     *       The message to validate
     * @param checkSpecConformance      
     *       Check conformance to specification beyond what XML Schema provides.
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
    public Validation validateFast(Object m, boolean checkSpecConformance) 
            throws JAXBException, SAXException, IOException {
        return validate(m, true, checkSpecConformance);
    }
    

    /**
     * Marshals a given TAXII Message to an XML String. 
     * 
     * @throws JAXBException 
     *           if any unexpected problem occurs during marshalling
     */
    public String marshalToString(final Marshaller m, final Object msg)
            throws JAXBException {
        final StringWriter sw = new StringWriter();
        m.marshal(msg, sw);
        return sw.toString();
    }
    
    public String marshalToString(final Object msg, boolean prettyPrint) throws JAXBException {
        Marshaller m = createMarshaller(prettyPrint);
        final StringWriter sw = new StringWriter();
        m.marshal(msg, sw);
        return sw.toString();        
    }
       
    /**
     * Returns the JAXB Context.
     */
    public JAXBContext getJaxbContext() {
        return jaxbContext;
    }
    
    
    /**
     * Returns a read-only list of JAXB packages that the underlying JAXB Context
     * knows about.  
     */
    public List<String> getJaxbContextPath() {
        return Collections.unmodifiableList(contextEntries);
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
    * @param checkSpecConformance      
    *       Check conformance to specification beyond what XML Schema provides.
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
    private Validation validate(Object m, 
            boolean failFast, 
            boolean checkSpecConformance) 
            throws JAXBException, SAXException, IOException {
        JAXBSource source = new JAXBSource(jaxbContext, m);
        Validator validator = taxiiSchema.newValidator();
        final Validation results = new Validation();
        final ValidationErrorHandler errorHandler = new ValidationErrorHandler(results, failFast);
        validator.setErrorHandler(errorHandler);
        validator.validate(source);
        
        if (results.isSuccess() && checkSpecConformance) {
            checkConformance(m, errorHandler);
            if (results.isFailure() && failFast) {
                throw new SAXException("Conformance failure: " + results.getAllErrors());
            }
        }
        
        return results;
    }
    
    /**
     * Check conformance to TAXII specification beyond what XML Schema provides. 
     */
    private void checkConformance(Object m, 
            ValidationErrorHandler errorHandler) {
        final XsltTransformer transformer = schematronValidator.load();
        transformer.setMessageListener(errorHandler);
        try {
            transformer.setSource(new JAXBSource(jaxbContext, m));
            transformer.setDestination(new SAXDestination(new DefaultHandler()));
            transformer.transform();
        } 
        catch (SaxonApiException | JAXBException e) {
            errorHandler.getResults().addError("Conformance error: " + e.getMessage());
        } 
    }
    
    public String getTaxiiVersion() {
        return this.taxiiVersion;
    }

    public String getServiceVersion() {
        return this.serviceVersion;               
    }    
    
    public abstract HttpResponseErrorHandler getResponseHandler();
    public abstract boolean isRequestMessage(Object message);
}
