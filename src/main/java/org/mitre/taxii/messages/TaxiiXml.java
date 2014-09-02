package org.mitre.taxii.messages;

import java.io.IOException;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.mitre.taxii.client.HttpResponseHandler;
import org.mitre.taxii.util.Validation;
import org.xml.sax.SAXException;

/**
 *
 * @author jasenj1
 */
public interface TaxiiXml {

    /**
     * Returns a marshaller for the TAXII XML Message Binding classes.
     *
     * @param prettyPrint
     *              Returns a marshaller that indents the output if true.
     * @return
     * @throws JAXBException
     *              if an error was encountered while creating the Marshaller
     */
    Marshaller createMarshaller(boolean prettyPrint) throws JAXBException;

    /**
     * Returns the JAXB Context.
     * @return 
     */
    JAXBContext getJaxbContext();

    /**
     * Returns a read-only list of JAXB packages that the underlying JAXB Context
     * knows about.
     * @return 
     */
    List<String> getJaxbContextPath();

    /**
     * Marshals a given TAXII Message to an XML String.
     *
     * @param m
     * @param msg
     * @return 
     * @throws JAXBException
     *           if any unexpected problem occurs during marshaling
     */
    String marshalToString(final Marshaller m, final Object msg) throws JAXBException;

    String marshalToString(final Object msg, boolean prettyPrint) throws JAXBException;

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
    Validation validateAll(Object m, boolean checkSpecConformance) throws JAXBException, SAXException, IOException;

    /**
     * Validates the given message, throwing a SAXException on the first
     * validation error encountered.
     *
     * @param m
     *       The message to validate
     * @param checkSpecConformance
     *       Check conformance to specification beyond what XML Schema provides.
     * @return 
     *
     * @returns
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
    Validation validateFast(Object m, boolean checkSpecConformance) throws JAXBException, SAXException, IOException;
    
    String getTaxiiVersion();
    
    String getServiceVersion();
    
    HttpResponseHandler getResponseHandler();
    
    boolean isRequestMessage(Object msg);
}
