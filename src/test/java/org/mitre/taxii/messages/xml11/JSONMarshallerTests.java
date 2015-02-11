/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mitre.taxii.messages.xml11;

import java.io.StringWriter;
import java.net.URI;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.oxm.MediaType;
import org.junit.Test;

/**
 *
 * @author jasenj1
 */
public class JSONMarshallerTests {
    private static final boolean debug = true; // Boolean.getBoolean("debug"); 
    
    private final ObjectFactory factory = new ObjectFactory();
    private final TaxiiXmlFactory txf;
    private final TaxiiXml taxiiXml;
    
    public JSONMarshallerTests() {
        // Use MOXy so we get JSON support
        System.setProperty(JAXBContext.JAXB_CONTEXT_FACTORY, "org.eclipse.persistence.jaxb.JAXBContextFactory");
        txf = new TaxiiXmlFactory();
        taxiiXml = txf.createTaxiiXml();
    }
            
    /** 
     * Verify that a custom status message can be created and round-tripped
     * successfully.
     */
    @Test
    public void goodSuccess() throws Exception {
        /* test case from libtaxii:
         * 
         * sm01 = tm11.StatusMessage(
            message_id = 'SM01', #Required
            in_response_to = tm11.generate_message_id(), #Required, should be the ID of the message that this is in response to
            status_type = tm11.ST_SUCCESS, #Required
            status_detail = {'custom_status_detail_name': 'Custom status detail value', 
                            'Custom_detail_2': ['this one has', 'multiple values']}, #Required depending on Status Type. See spec for details
            message = 'This is a test message'#Optional
            )
            round_trip_message(sm01)
         */
        final StatusMessage sm = factory.createStatusMessage();
        sm.setMessageId("SM01");
        sm.setInResponseTo(MessageHelper.generateMessageId());
        sm.setStatusType(StatusTypeEnum.SUCCESS.toString());
        
        StatusMessageHelper.addDetail(sm, new URI("custom_status_detail_name"), "Custom status detail value");
        StatusMessageHelper.addDetail(sm, new URI("Custom_detail_2"), "this one has", "multiple values");        
                
        sm.setMessage("This is a test message");
        
        Marshaller m = taxiiXml.createMarshaller(true);
        // Tell the marshaller to output JSON.
        m.setProperty(MarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);
        
        // Render the JAXB object to a JSON string.
        final StringWriter sw = new StringWriter();
        m.marshal(sm, sw);        
        String jsonString = sw.toString();

        if (debug) {            
            System.out.println("JSON:\n");
            System.out.println(jsonString);
        }
        
        // TestUtil.roundTripMessage(taxiiXml, sm);
    }
                    
    
}
