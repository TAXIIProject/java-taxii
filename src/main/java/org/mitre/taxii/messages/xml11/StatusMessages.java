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

/**
 * Utility methods for Status Messages.
 * 
 * @author Jonathan W. Cranford 
 */
public final class StatusMessages implements StatusDetails, StatusTypes {
    
    private static final ObjectFactory factory = new ObjectFactory();

    // TODO look at mapping extended headers and status details using 
    // a map instead of a list - that would make it easier to find headers
    // or status details by name.
    // See http://stackoverflow.com/questions/11329388/jaxb-mapping-for-a-map
    
    /**
     * Returns the contents of the named status detail record.
     *
     * @return the contents of the named status detail record, or null if no
     *          such status detail record exists.
     */
    public static List<?> findStatusDetailContentByName(StatusMessage msg, String name) {
        if (msg.getStatusDetail() == null) {
            return null;
        }
        if (name == null) {
            return null;    // assume names must be non-null
        }
        for (StatusDetailDetailType detail : msg.getStatusDetail().getDetails()) {
            if (name.equals(detail.getName())) {
                return detail.getContent();
            }
        }
        return null;
    }
    
    
    /**
     * Utility method to create an Invalid Response Part Status Message 
     * with the given maximum part number.
     */
    public static StatusMessage createInvalidResponsePart(int maxPartNumber) {
        final StatusMessage sm = factory.createStatusMessage();
        sm.setStatusType(STATUS_TYPE_INVALID_RESPONSE_PART);
        
        final StatusDetailType detailsHolder = factory.createStatusDetailType();
        final List<StatusDetailDetailType> details = detailsHolder.getDetails();
        
        final StatusDetailDetailType detail1 = factory.createStatusDetailDetailType();
        detail1.setName(STATUS_DETAIL_MAX_PART_NUMBER);
        detail1.getContent().add(String.valueOf(maxPartNumber));
        details.add(detail1);
        
        sm.setStatusDetail(detailsHolder);
        return sm;
    }


    /**
     * Utility method to create a status detail with the given name and value.
     * 
     * <p>
     * When dealing with Strings, this method is far preferable to using 
     * the JAXB classes directly.  Specifically, adding multiple Strings 
     * to the list returned by {@link StatusDetailDetailType#getContent()}
     * results in the Strings being squashed into the same text node in the 
     * resulting XML.  Instead, the right way to express a 
     * Status Detail with multiple string values is to *repeat* the
     * name and give it another value.  The XML should look like this:
     * </p>
     * 
     * <xmp>
    <Status_Detail>
        <Detail name="custom_status_detail_name">Custom status detail value</Detail>
        <Detail name="Custom_detail_2">this one has</Detail>
        <Detail name="Custom_detail_2">multiple values</Detail>
    </Status_Detail>
     * </xmp>
     */
    public static StatusDetailDetailType createStatusDetailDetail(
            final String name, 
            final Object value) {
        final StatusDetailDetailType detail1 = new StatusDetailDetailType();
        detail1.setName(name);
        detail1.getContent().add(value);
        return detail1;
    }
    
    
    
    
}
