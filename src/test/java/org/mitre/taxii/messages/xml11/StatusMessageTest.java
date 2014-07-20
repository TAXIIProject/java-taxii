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

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;
import org.mitre.taxii.Messages;

import static org.junit.Assert.*;

/**
 * Unit tests for XML Message Binding 1.1.
 * 
 * @author Jonathan W. Cranford
 */
public class StatusMessageTest {

    private final ObjectFactory factory = new ObjectFactory();
    private final TaxiiXml taxiiXml;
    private final boolean debug = Boolean.getBoolean("debug"); 
    
    public StatusMessageTest() {
        taxiiXml = TaxiiXml.newInstance();
    }
    
    
    @Test
    public void testCustom() throws JAXBException {
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
        sm.setInResponseTo(Messages.generateMessageId());
        sm.setStatusType(StatusTypes.ST_SUCCESS);
        
        final StatusDetailType detailsHolder = factory.createStatusDetailType();
        final List<StatusDetailDetailType> details = detailsHolder.getDetails();
        
        final StatusDetailDetailType detail1 = factory.createStatusDetailDetailType();
        detail1.setName("custom_status_detail_name");
        detail1.getContent().add("Custom status detail value");
        details.add(detail1);
        
        final StatusDetailDetailType detail2 = factory.createStatusDetailDetailType();
        detail2.setName("Custom_detail_2");
        final List<Object> d2Contents = detail2.getContent();
        d2Contents.add("this one has");
        d2Contents.add("multiple values");
        details.add(detail2);
        
        sm.setStatusDetail(detailsHolder);
        sm.setMessage("This is a test message");
        
        roundTripMessage(sm);
    }
    
    
    private void roundTripMessage(MessageType msg) throws JAXBException {
        final Marshaller m = taxiiXml.createMarshaller(true, true);
        final Unmarshaller u = taxiiXml.createUnmarshaller(true);
        
        final String xmlString = taxiiXml.marshalToString(m, msg);
        final MessageType msgFromXml = 
                (MessageType) u.unmarshal(new StringReader(xmlString));
        final String xmlString2 = taxiiXml.marshalToString(m, msgFromXml);
        final MessageType thereAndBackAgain = 
                (MessageType) u.unmarshal(new StringReader(xmlString2));
        
        if (debug) {
            System.out.println(xmlString);
        }
        
        // do the XML-object-XML round trip comparison first because it's
        // easier to debug
        assertEquals("round tripping from XML to object back to XML failed",
                xmlString, xmlString2);
        
        // Compare objects after they've been through a round trip.  The 
        // challenge is that it's possible to create an object with mixed
        // content using the API that collapses when marshalled so that the
        // round trip doesn't match the original object.  But going through
        // first round trip gets rid of those inconsistencies from the original 
        // object.
        assertEquals("round tripping from object to XML back to object failed! ",
                msgFromXml, thereAndBackAgain);
    }
    
}
