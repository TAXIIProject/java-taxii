package org.mitre.taxii.messages.xml11;

import java.io.StringReader;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.junit.Test;

/**
 *
 * @author jasenj1
 */
public class GettingStarted {

    @Test
    public void unmarshalTest() throws JAXBException {
    String xml = "<Status_Message status_type='SUCCESS' in_response_to='urn:uuid:8fef148a-b186-45a0-a2da-9915daf621b1' "
            +" message_id='SM02' xmlns='http://taxii.mitre.org/messages/taxii_xml_binding-1.1'/>";

    TaxiiXmlFactory txf = new TaxiiXmlFactory();
    TaxiiXml taxiiXml = txf.createTaxiiXml();

    Unmarshaller unmarshaller = taxiiXml.getJaxbContext().createUnmarshaller();

    StatusMessage message = (StatusMessage) unmarshaller.unmarshal(new StringReader(xml));
    
    System.out.println(message.toString());

    }
}
