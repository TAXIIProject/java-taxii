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
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class StatusMessageTest implements StatusDetails {
    
    private static final String INVALID_XML_RESOURCE = "/invalid.xml";

    private final ObjectFactory factory = new ObjectFactory();
    private final TaxiiXml taxiiXml;
    private final boolean debug = true; // Boolean.getBoolean("debug"); 
    
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
        sm.setStatusType(StatusTypeEnum.SUCCESS.toString());
        
        StatusMessageHelper.addDetail(sm, "custom_status_detail_name", "Custom status detail value");
        StatusMessageHelper.addDetail(sm, "Custom_detail_2", "this one has", "multiple values");        
        
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
        
        sm.setMessage("This is a test message");
        
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
        sm.setStatusType(StatusTypeEnum.INVALID_RESPONSE_PART.toString());

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
        sm.setStatusType(StatusTypeEnum.INVALID_RESPONSE_PART.toString());

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
        sm02.setStatusType(StatusTypeEnum.SUCCESS.toString());
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
        sm02.setStatusType(StatusTypeEnum.SUCCESS.toString());
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
        sm02.setStatusType(StatusTypeEnum.SUCCESS.toString());
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
        sm03.setStatusType(StatusTypeEnum.DESTINATION_COLLECTION_ERROR.toString());
                   
        StatusMessageHelper.addDetail(sm03, STATUS_DETAIL_ACCEPTABLE_DESTINATION, "Collection1", "Collection2");
                
        roundTripMessage(sm03);
    }

    /**
     * Verify that an Invalid Response Part status message can be created
     * and successfully round-tripped.
     */
    @Test
    public void goodInvalidResponsePart() throws Exception, JAXBException, JAXBException, SAXException {
    /**
        def test_status_message_04(self):
            sm04 = tm11.StatusMessage(
            message_id='SM04',  # Required
            in_response_to=tm11.generate_message_id(),  # Required, should be the ID of the message that this is in response to
            status_type=tm11.ST_INVALID_RESPONSE_PART,  # Required
            status_detail={'MAX_PART_NUMBER': 4},  # Required/optional depending on Status Type. See spec for details
            message=None  # Optional
        )
        round_trip_message(sm04)
    */

        final StatusMessage sm04 = StatusMessageHelper.createInvalidResponsePart(4);
        sm04.setMessageId("SM04");
        sm04.setInResponseTo(Messages.generateMessageId());
        sm04.setMessage("This is a valid test status message");
        
        roundTripMessage(sm04);
    }
    
    @Test
    public void goodNotFound() throws JAXBException, SAXException, IOException {
        /**
        def test_status_message_05(self):
            sm05 = tm11.StatusMessage(
                message_id='SM05',  # Required
                in_response_to=tm11.generate_message_id(),  # Required, should be the ID of the message that this is in response to
                status_type=tm11.ST_NOT_FOUND,  # Required
                status_detail={'ITEM': 'Collection1'},  # Required/optional depending on Status Type. See spec for details
                message=None  # Optional
            )
            round_trip_message(sm05)
         */
        
        StatusMessage sm05 = new StatusMessage()
                                    .withMessageId("SM05")
                                    .withInResponseTo(Messages.generateMessageId())
                                    .withStatusType(StatusTypeEnum.NOT_FOUND.toString());
        
        StatusMessageHelper.addDetail(sm05, STATUS_DETAIL_ITEM, "Collection1");

        roundTripMessage(sm05);        
    }
    
    @Test
    public void goodPending() throws JAXBException, SAXException, IOException, URISyntaxException {
        /**
        def test_status_message_06(self):
            sm06 = tm11.StatusMessage(
                    message_id='SM06',  # Required
                    in_response_to=tm11.generate_message_id(),  # Required, should be the ID of the message that this is in response to
                    status_type=tm11.ST_PENDING,  # Required
                    status_detail={'ESTIMATED_WAIT': 900, 'RESULT_ID': 'Result1', 'WILL_PUSH': False},  # Required/optional depending on Status Type. See spec for details
                    message=None  # Optional
            )
            round_trip_message(sm06)
        */
        
        StatusMessage sm06 = StatusMessageHelper.createPending(900, new URI("Result1"), false);
        sm06.setMessageId("SM06");
        sm06.setInResponseTo(Messages.generateMessageId());
        
        /* The manual way.
        StatusMessage sm06 = new StatusMessage()
                                    .withMessageId("SM06")
                                    .withInResponseTo(Messages.generateMessageId())
                                    .withStatusType(StatusTypeEnum.PENDING.toString());
        
        StatusMessageHelper.addDetail(sm06, STATUS_DETAIL_ESTIMATED_WAIT, 900);
        StatusMessageHelper.addDetail(sm06, STATUS_DETAIL_RESULT_ID, "Result1");
        StatusMessageHelper.addDetail(sm06, STATUS_DETAIL_WILL_PUSH, Boolean.FALSE);
        */
        
        roundTripMessage(sm06);        
    }
    
    /**
     * Confirm that a JAXB MessageType Object matches itself when marshaled to
     * a String and back.
     * 
     * @param msg
     * @throws Exception 
     */
    private void roundTripMessage(MessageType msg) throws JAXBException, SAXException, IOException {
        final Marshaller m = taxiiXml.createMarshaller(true);
        final Unmarshaller u = taxiiXml.getJaxbContext().createUnmarshaller();
        final String rawString = taxiiXml.marshalToString(m, msg);

        if (debug) {
            System.out.println("raw unvalidated XML:\n");
            System.out.println(rawString);
        }

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
