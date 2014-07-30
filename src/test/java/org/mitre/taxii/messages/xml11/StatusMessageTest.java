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

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;
import org.mitre.taxii.Messages;
import org.mitre.taxii.util.Validation;
import org.xml.sax.SAXException;

import static org.junit.Assert.*;

/**
 * Unit tests for XML Message Binding 1.1.
 * 
 * @author Jonathan W. Cranford
 */
public class StatusMessageTest implements StatusDetails, StatusTypes {
    
    private static final String INVALID_XML_RESOURCE = "/invalid.xml";

    private final ObjectFactory factory = new ObjectFactory();
    private final TaxiiXml taxiiXml;
    private final boolean debug = Boolean.getBoolean("debug"); 
    
    public StatusMessageTest() {
        taxiiXml = TaxiiXml.newInstance();
    }
    
    
    /** 
     * Verify that a custom status message can be created and round-tripped
     * successfully.
     */
    @Test
    public void testCustom() throws Exception {
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
        sm.setStatusType(STATUS_TYPE_SUCCESS);
        
        final StatusDetailType detailsHolder = factory.createStatusDetailType();
        final List<StatusDetailDetailType> details = detailsHolder.getDetails();
        
        details.add(StatusMessages.createStatusDetailDetail("custom_status_detail_name", "Custom status detail value"));
        details.add(StatusMessages.createStatusDetailDetail("Custom_detail_2", "this one has"));
        details.add(StatusMessages.createStatusDetailDetail("Custom_detail_2", "multiple values"));
        
//        final StatusDetailDetailType detail2 = factory.createStatusDetailDetailType();
//        detail2.setName("Custom_detail_2");
//        final List<Object> d2Contents = detail2.getContent();
//        // TODO Fix this mapping - don't allow multiple strings to be added to a collection,
//        // since the list of strings collapse into a single text node on 
//        // marshalling.  Instead, multiple StatusDetailDetailTypes should
//        // be created with the same name, one value per StatusDetailDetailType.
//        d2Contents.add("this one has");
////        d2Contents.add("multiple values");
//        details.add(detail2);
        
        sm.setStatusDetail(detailsHolder);
        sm.setMessage("This is a test message");
        
        roundTripMessage(sm);
    }
    

    /**
     * Verify that an Invalid Response Part status message can be created
     * and successfully round-tripped.
     */
    @Test
    public void goodInvalidResponsePart() throws Exception {
        final StatusMessage sm = StatusMessages.createInvalidResponsePart(2345);
        sm.setMessageId("goodInvalidResponsePart");
        sm.setInResponseTo(Messages.generateMessageId());
        sm.setMessage("This is a valid test status message");
        
        roundTripMessage(sm);
    }
    
    
    /** 
     * Verify that an bad Invalid Response Part status message with no status details
     * fails validation.
     */
    @Test
    public void badInvalidResponsePart1() throws Exception {
        final StatusMessage sm = factory.createStatusMessage();
        sm.setMessageId("badInvalidResponsePart1");
        sm.setInResponseTo(Messages.generateMessageId());
        sm.setStatusType(STATUS_TYPE_INVALID_RESPONSE_PART);

        // this should fail validation because it's missing any status details
        try {
            // Here we call validateFast() to test it.  Note that other 
            // tests call validateAll().  Both must be tested.  
            // validateFast() throws an exception under more circumstances,
            // so other tests prefer validateAll() so that more of the 
            // validation code is tested.
            taxiiXml.validateFast(sm);
            fail("Expected validation error!");
        }
        catch (SAXException e) {
            assertTrue(e.getMessage().contains(STATUS_DETAIL_MAX_PART_NUMBER));
        }
    }
    
    
    /** 
     * Verify that an bad Invalid Response Part status message without a max
     * part number fails validation.
     */
    @Test
    public void badInvalidResponsePart2() throws Exception {
        final StatusMessage sm = factory.createStatusMessage();
        sm.setMessageId("badInvalidResponsePart2");
        sm.setInResponseTo(Messages.generateMessageId());
        sm.setStatusType(STATUS_TYPE_INVALID_RESPONSE_PART);

        final StatusDetailType detailsHolder = factory.createStatusDetailType();
        final List<StatusDetailDetailType> details = detailsHolder.getDetails();
        
        final StatusDetailDetailType detaildetail = factory.createStatusDetailDetailType();
        detaildetail.setName("custom header");
        detaildetail.getContent().add("custom value");
        details.add(detaildetail);
        sm.setStatusDetail(detailsHolder);
        
        // this should fail validation because it's missing the required
        // max part number
        try {
            taxiiXml.validateFast(sm);
            fail("Expected validation error!");
        }
        catch (SAXException e) {
            if (e.getMessage() == null) {
                throw e;
            }
            assertTrue(e.getMessage().contains(STATUS_DETAIL_MAX_PART_NUMBER));
        }
    }
    
    
    /**
     * Unmarshal some invalid XML and verify that validation fails.
     * @throws JAXBException 
     */
    @Test
    public void invalidXML() throws Exception {
        final Unmarshaller u = taxiiXml.getJaxbContext().createUnmarshaller();
        MessageType msg = (MessageType) u.unmarshal(getClass().getResource(INVALID_XML_RESOURCE));
        
        Validation results = taxiiXml.validateAll(msg);
        assertTrue(results.isFailure());
        if (debug) {
            System.out.print("Validation results: ");
            System.out.println(results.getAllErrorsAndWarnings());
        }
    }
    
    
    /**
     * Verify a Success message can be created and round-tripped successfully.
     */
    @Test
    public void goodSuccessMessage() throws Exception {
        /* test case from libtaxii:
         * 
         * sm02 = tm11.StatusMessage(
         *          message_id = 'SM02', #Required
                in_response_to = tm11.generate_message_id(), #Required, should be the ID of the message that this is in response to
                status_type = tm11.ST_SUCCESS, #Required
                status_detail = None, #Required/optional depending on Status Type. See spec for details
                message = None# Optional
        )
        round_trip_message(sm02)
         */
        final StatusMessage sm02 = factory.createStatusMessage();
        sm02.setMessageId("SM02");
        sm02.setInResponseTo(Messages.generateMessageId());
        sm02.setStatusType(STATUS_TYPE_SUCCESS);
        roundTripMessage(sm02);
    }
    
    
    /**
     * Verify that a StatusMessage missing a message id fails validation.
     */
    @Test
    public void missingMessageId() throws Exception {
        final StatusMessage sm02 = factory.createStatusMessage();
//        sm02.setMessageId("SM02");
        sm02.setInResponseTo(Messages.generateMessageId());
        sm02.setStatusType(STATUS_TYPE_SUCCESS);
        Validation results = taxiiXml.validateAll(sm02);
        assertTrue(results.isFailure());
        if (debug) {
            System.out.print("Validation results: ");
            System.out.println(results.getAllErrorsAndWarnings());
        }
    }
       
    
    /**
     * Verify that a StatusMessage missing the InResponseTo field fails validation.
     */
    @Test
    public void missingInResponseTo() throws Exception {
        final StatusMessage sm02 = factory.createStatusMessage();
        sm02.setMessageId("SM02");
//        sm02.setInResponseTo(Messages.generateMessageId());
        sm02.setStatusType(STATUS_TYPE_SUCCESS);
        Validation results = taxiiXml.validateAll(sm02);
        assertTrue(results.isFailure());
        if (debug) {
            System.out.print("Validation results: ");
            System.out.println(results.getAllErrorsAndWarnings());
        }
    }
       
    
    /**
     * Verify that a StatusMessage missing a status type fails validation.
     */
    @Test
    public void missingStatusType() throws Exception {
        final StatusMessage sm02 = factory.createStatusMessage();
        sm02.setMessageId("SM02");
        sm02.setInResponseTo(Messages.generateMessageId());
//        sm02.setStatusType(StatusTypes.ST_SUCCESS);
        Validation results = taxiiXml.validateAll(sm02);
        assertTrue(results.isFailure());
        if (debug) {
            System.out.print("Validation results: ");
            System.out.println(results.getAllErrorsAndWarnings());
        }
    }
       
    
    /** 
     * Verify a Destination Collection Error can be created and round-tripped 
     * successfully. 
     */
    @Test
    public void goodDestinationCollectionError() throws Exception {
        /* test case from libtaxii:
         * 
        sm03 = tm11.StatusMessage(
                message_id = 'SM03', #Required
                in_response_to = tm11.generate_message_id(), #Required, should be the ID of the message that this is in response to
                status_type = tm11.ST_DESTINATION_COLLECTION_ERROR, #Required
                status_detail = {'ACCEPTABLE_DESTINATION': ['Collection1','Collection2']}, #Required/optional depending on Status Type. See spec for details
                message = None# Optional
        )
        round_trip_message(sm03)
        */
        final StatusMessage sm03 = new StatusMessage();
        sm03.setMessageId("SM03");
        sm03.setInResponseTo(Messages.generateMessageId());
        sm03.setStatusType(STATUS_TYPE_DESTINATION_COLLECTION_ERROR);
        
        final StatusDetailType detailsHolder = new StatusDetailType();
        final List<StatusDetailDetailType> details = detailsHolder.getDetails();
        details.add(StatusMessages.createStatusDetailDetail(STATUS_DETAIL_ACCEPTABLE_DESTINATION, "Collection1"));
        details.add(StatusMessages.createStatusDetailDetail(STATUS_DETAIL_ACCEPTABLE_DESTINATION, "Collection2"));
        sm03.setStatusDetail(detailsHolder);
        
        roundTripMessage(sm03);
    }


    private void roundTripMessage(MessageType msg) throws Exception {
        final Marshaller m = taxiiXml.createMarshaller(true);
        final Unmarshaller u = taxiiXml.getJaxbContext().createUnmarshaller();
        
        assertValid(msg);
        final String xmlString = taxiiXml.marshalToString(m, msg);
        final MessageType msgFromXml = 
                (MessageType) u.unmarshal(new StringReader(xmlString));
        assertValid(msgFromXml);
        final String xmlString2 = taxiiXml.marshalToString(m, msgFromXml);
        
        if (debug) {
            System.out.println(xmlString);
        }
        
        // do the XML-object-XML round trip comparison first because it's
        // easier to debug
        assertEquals("round tripping from XML to object back to XML failed",
                xmlString, xmlString2);
        assertEquals("round tripping from object to XML back to object failed! ",
                msg, msgFromXml);
    }
    
    
    private void assertValid(MessageType msg) 
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
