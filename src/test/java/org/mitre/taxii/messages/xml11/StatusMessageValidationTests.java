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

import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;
import org.mitre.taxii.ContentBindings;
import org.mitre.taxii.Messages;
import org.mitre.taxii.Versions;
import org.mitre.taxii.util.Validation;
import org.xml.sax.SAXException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 *
 * @author jasenj1
 */
public class StatusMessageValidationTests implements StatusDetails, Versions, ContentBindings {
    private static final String INVALID_XML_RESOURCE = "/xsd/1.1/StatusMessage-Success-invalid.xml";

    private final ObjectFactory factory = new ObjectFactory();
    private final TaxiiXmlFactory txf;
    private final TaxiiXml taxiiXml;
    private final boolean debug = true; // Boolean.getBoolean("debug");
    
    public StatusMessageValidationTests() {
        txf = new TaxiiXmlFactory();
        taxiiXml = txf.getTaxiiXml();
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
            taxiiXml.validateFast(sm, true);
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
            taxiiXml.validateFast(sm, true);
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
        
        Validation results = taxiiXml.validateAll(msg, false);
        assertTrue(results.isFailure());
        if (debug) {
            System.out.print("Validation results: ");
            System.out.println(results.getAllErrorsAndWarnings());
        }
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
        Validation results = taxiiXml.validateAll(sm02, false);
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
        Validation results = taxiiXml.validateAll(sm02, false);
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
        Validation results = taxiiXml.validateAll(sm02, false);
        assertTrue(results.isFailure());
        if (debug) {
            System.out.print("Validation results: ");
            System.out.println(results.getAllErrorsAndWarnings());
        }
    }

}
