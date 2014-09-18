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

import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import org.mitre.taxii.ContentBindings;
import org.mitre.taxii.Versions;

import org.xml.sax.SAXException;

/**
 * Unit tests for XML Message Binding 1.1.
 * 
 * @author Jonathan W. Cranford
 */
public class StatusMessageTests {
    
    private final ObjectFactory factory = new ObjectFactory();
    private final TaxiiXmlFactory txf;
    private final TaxiiXml taxiiXml;
    
    public StatusMessageTests() {
        txf = new TaxiiXmlFactory();
        taxiiXml = txf.getTaxiiXml();
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
        
        TestUtil.roundTripMessage(taxiiXml, sm);
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
        sm02.setInResponseTo(MessageHelper.generateMessageId());
        sm02.setStatusType(StatusTypeEnum.SUCCESS.toString());
        
        TestUtil.roundTripMessage(taxiiXml, sm02);
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
        sm03.setInResponseTo(MessageHelper.generateMessageId());
        sm03.setStatusType(StatusTypeEnum.DESTINATION_COLLECTION_ERROR.toString());
                   
        StatusMessageHelper.addDetail(sm03, new URI(StatusDetailEnum.ACCEPTABLE_DESTINATION.name()), "Collection1", "Collection2");
                
        TestUtil.roundTripMessage(taxiiXml, sm03);
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
        sm04.setInResponseTo(MessageHelper.generateMessageId());
        sm04.setMessage("This is a valid test status message");
        
        TestUtil.roundTripMessage(taxiiXml, sm04);
    }
    
    @Test
    public void goodNotFound() throws JAXBException, SAXException, IOException, URISyntaxException {
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
                                    .withInResponseTo(MessageHelper.generateMessageId())
                                    .withStatusType(StatusTypeEnum.NOT_FOUND.toString());
        
        StatusMessageHelper.addDetail(sm05, new URI(StatusDetailEnum.ITEM.name()), "Collection1");

        TestUtil.roundTripMessage(taxiiXml, sm05);        
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
        sm06.setInResponseTo(MessageHelper.generateMessageId());
        
        /* The manual way.
        
        StatusMessage sm06 = new StatusMessage()
                                    .withMessageId("SM06")
                                    .withInResponseTo(MessageHelper.generateMessageId())
                                    .withStatusType(StatusTypeEnum.PENDING.toString());
        
        StatusMessageHelper.addDetail(sm06, STATUS_DETAIL_ESTIMATED_WAIT, 900);
        StatusMessageHelper.addDetail(sm06, STATUS_DETAIL_RESULT_ID, "Result1");
        StatusMessageHelper.addDetail(sm06, STATUS_DETAIL_WILL_PUSH, Boolean.FALSE);
        */
        
        TestUtil.roundTripMessage(taxiiXml, sm06);        
    }
    
    @Test
    public void goodRetry() throws JAXBException, SAXException, IOException, URISyntaxException {
        /**
        def test_status_message_07(self):
            sm07 = tm11.StatusMessage(
                message_id='SM07',  # Required
                in_response_to=tm11.generate_message_id(),  # Required, should be the ID of the message that this is in response to
                status_type=tm11.ST_RETRY,  # Required
                status_detail={'ESTIMATED_WAIT': 900},  # Required/optional depending on Status Type. See spec for details
                message=None  # Optional
            )
        round_trip_message(sm07)

        */
        
        StatusMessage sm07 = new StatusMessage()
                                    .withMessageId("SM07")
                                    .withInResponseTo(MessageHelper.generateMessageId())
                                    .withStatusType(StatusTypeEnum.RETRY.toString());
        StatusMessageHelper.addDetail(sm07, new URI(StatusDetailEnum.ESTIMATED_WAIT.name()), 900);
        
        TestUtil.roundTripMessage(taxiiXml, sm07);
    }
    
    @Test
    public void goodUnsupportedMessageBinding() throws JAXBException, SAXException, IOException, URISyntaxException {
        /*
        def test_status_message_08(self):
            sm08 = tm11.StatusMessage(
                    message_id='SM08',  # Required
                    in_response_to=tm11.generate_message_id(),  # Required, should be the ID of the message that this is in response to
                    status_type=tm11.ST_UNSUPPORTED_MESSAGE_BINDING,  # Required
                    status_detail={'SUPPORTED_BINDING': [t.VID_TAXII_XML_10, t.VID_TAXII_XML_11]},  # Required/optional depending on Status Type. See spec for details
                    message=None  # Optional
            )
            round_trip_message(sm08)               
        */
        StatusMessage sm08 = new StatusMessage()
                                    .withMessageId("SM08")
                                    .withInResponseTo(MessageHelper.generateMessageId())
                                    .withStatusType(StatusTypeEnum.UNSUPPORTED_MESSAGE.toString());
        StatusMessageHelper.addDetail(sm08, new URI(StatusDetailEnum.SUPPORTED_BINDING.name()), Versions.VID_TAXII_XML_10, Versions.VID_TAXII_XML_11);
        
        TestUtil.roundTripMessage(taxiiXml, sm08);        
    }
    
    @Test
    public void goodUnsupportedContentBinding() throws JAXBException, SAXException, IOException, URISyntaxException {
        /*
        def test_status_message_09(self):
        sm09 = tm11.StatusMessage(
                message_id='SM09',  # Required
                in_response_to=tm11.generate_message_id(),  # Required, should be the ID of the message that this is in response to
                status_type=tm11.ST_UNSUPPORTED_CONTENT_BINDING,  # Required
                status_detail={'SUPPORTED_CONTENT': ['%s>%s,%s' % (tm11.ContentBinding, 'subtype1', 'subtype2'), t.CB_STIX_XML_101]},  # Required/optional depending on Status Type. See spec for details
                message=None  # Optional
        )
        round_trip_message(sm09)                
        */
        
        StatusMessage sm09 = new StatusMessage()
                                    .withMessageId("SM09")
                                    .withInResponseTo(MessageHelper.generateMessageId())
                                    .withStatusType(StatusTypeEnum.UNSUPPORTED_CONTENT.toString());
        StatusMessageHelper.addDetail(sm09, new URI(StatusDetailEnum.SUPPORTED_CONTENT.name()), ContentBindings.CB_STIX_XML_101);
        
        TestUtil.roundTripMessage(taxiiXml, sm09);                
    }
    
    //======================================
        
}
