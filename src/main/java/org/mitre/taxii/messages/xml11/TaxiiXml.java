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

package org.mitre.taxii.messages.xml11;

import java.io.StringWriter;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.mitre.taxii.messages.xmldsig.Signature;
import org.xml.sax.SAXException;

/**
 * JAXB utility class
 * 
 * @author JCRANFORD
 */
public final class TaxiiXml {

    private static final String TAXII_SCHEMA_RESOURCE = "/TAXII_XMLMessageBinding_Schema-xjc.xsd";
    
    private final JAXBContext jaxbContext;
    private final Schema taxiiSchema;
    
    private TaxiiXml(JAXBContext context, Schema schema) {
        jaxbContext = context;
        taxiiSchema = schema;
    }
    
    
    
    /**
     * Creates a new instance of the TaxiiXml utility class.
     * 
     * @throws RuntimeException
     *              if a deployment error prevents the underlying JAXBContext
     *              from being created or the Schema from being parsed
     */
    public static TaxiiXml newInstance() {
        return new TaxiiXml(newJAXBContext(), newSchema());
    }
    
    
    /**
     * Returns a JAXBContext for the TAXII XML Message Binding 1.1 classes.
     * 
     * @throws RuntimeException 
     *              if a deployment error prevents 
     *              the JAXBContext from being created
     */
    public static JAXBContext newJAXBContext() {
        try {
            return JAXBContext.newInstance(TaxiiXml.class.getPackage().getName() + ":"
                            + Signature.class.getPackage().getName());
        } catch (JAXBException e) {
            throw new RuntimeException("Deployment error", e);
        }
    }

    
    /**
     * Returns a marshaller for the TAXII XML Message Binding 1.1
     * classes.
     * 
     * @param validate
     *              Returns a validating marshaller if true. 
     * @param prettyPrint
     *              Returns a marshaller that indents the output if true.
     * @throws JAXBException 
     *              if an error was encountered while creating the Marshaller
     */
    public Marshaller createMarshaller(
            boolean validate, 
            boolean prettyPrint)
            throws JAXBException {
        final Marshaller m = jaxbContext.createMarshaller();
        if (validate) {
            m.setSchema(taxiiSchema);
        }
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, prettyPrint);
        return m;
    }
    
    
    /**
     * Returns a JAXP Schema that can be used to validate against the TAXII
     * XML Message Binding 1.1 schema.
     * 
     * @throws RuntimeException 
     *              if a deployment error prevents the TAXII Schema from 
     *              being parsed
     */
    public static Schema newSchema() {
        final SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            return sf.newSchema(ObjectFactory.class.getResource(TAXII_SCHEMA_RESOURCE));
        } catch (SAXException e) {
            throw new RuntimeException("Deployment error: can't parse TAXII schema", e);
        }
    }
    
    
    // TODO - validate method using technique at 
    // http://blog.bdoughan.com/2010/11/validate-jaxb-object-model-with-xml.html
    // plus extra validation not done by the schema - see TODO.txt for details.
   

    /**
     * Marshals a given TAXII Message to an XML String. 
     * 
     * @throws JAXBException 
     *           if any unexpected problem occurs during marshalling
     */
    public String marshalToString(final Marshaller m, final MessageType msg)
            throws JAXBException {
        final StringWriter sw = new StringWriter();
        m.marshal(msg, sw);
        return sw.toString();
    }
    
    
    /** 
     * Returns an Unmarshaller for the TAXII XML Message Binding 1.1 classes.
     * 
     * @param validate
     *              Returns a validating unmarshaller if true.
     * @throws JAXBException 
     *              if an error occurs creating the Unmarshaller
     */
    public Unmarshaller createUnmarshaller(boolean validate) throws JAXBException {
        final Unmarshaller u = jaxbContext.createUnmarshaller();
        if (validate) {
            u.setSchema(taxiiSchema);
        }
        return u;
    }
    
}
