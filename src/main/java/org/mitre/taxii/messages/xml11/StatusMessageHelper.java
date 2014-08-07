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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility methods for Status Messages.
 *
 * @author Jonathan W. Cranford
 */
public final class StatusMessageHelper implements StatusDetails {

    private static final ObjectFactory factory = new ObjectFactory();

    // TODO look at mapping extended headers and status details using 
    // a map instead of a list - that would make it easier to find headers
    // or status details by name.
    // See http://stackoverflow.com/questions/11329388/jaxb-mapping-for-a-map
    /**
     * Returns the contents of the named status detail record.
     *
     * @return the contents of the named status detail record, or null if no
     * such status detail record exists.
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
    
    
    // Utility methods to create Status Messages of various types.

    /**
     * Utility method to create an "Invalid Response Part" Status Message.
     * 
     * @param maxPartNumber
     * @return 
     */
    public static StatusMessage createInvalidResponsePart(int maxPartNumber) {
        final StatusMessage sm = factory.createStatusMessage();
        sm.setStatusType(StatusTypeEnum.INVALID_RESPONSE_PART.name());

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
     * Utility method to create a "Pending" Status Message.
     * 
     * @param estimatedWait
     * @param resultId
     * @param willPush
     * @return
     */
    public static StatusMessage createPending(final int estimatedWait, final URI resultId, final boolean willPush) {
        final StatusMessage sm = new StatusMessage().withStatusType(StatusTypeEnum.PENDING.toString());
        
        try {
            StatusMessageHelper.addDetail(sm, new URI(STATUS_DETAIL_ESTIMATED_WAIT), estimatedWait);
            StatusMessageHelper.addDetail(sm, new URI(STATUS_DETAIL_RESULT_ID), resultId);
            StatusMessageHelper.addDetail(sm, new URI(STATUS_DETAIL_WILL_PUSH), willPush);
        } catch (URISyntaxException ex) { // This shouldn't ever happen. 
            Logger.getLogger(StatusMessageHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sm;        
    }
        
    
    // Utility methods related to the Status_Detail portion of a Status Message.
    
    /**
     * Utility method to create a status detail with the given name and value.
     *
     * @param name
     * @param value
     * @return
     */
    public static StatusDetailDetailType createStatusDetailDetail(
            final URI name,
            final Object value) {
        final StatusDetailDetailType detail1 = factory.createStatusDetailDetailType();
        detail1.setName(name.toString());
        detail1.getContent().add(value.toString());
        return detail1;
    }

    /**
     * Add a set of "Detail" elements to a Status Message.
     * 
     * @param sm - The Status Message to be modified
     * @param detailsMap - The set of details to add.
     * @return
     */
    public static StatusMessage addDetails(final StatusMessage sm, final Map<URI, Object> detailsMap) {
        final Set<Map.Entry<URI, Object>> entries = detailsMap.entrySet();

        StatusDetailType sdt = sm.getStatusDetail();

        if (null == sdt) { // There are no details. Add them.
            final StatusDetailType newSdt = factory.createStatusDetailType();
            sm.setStatusDetail(newSdt);
            sdt = sm.getStatusDetail();
        }

        final List<StatusDetailDetailType> details = sdt.getDetails(); // If there are no details, we'll get an empty list, not null. By getting it we instantiate the list.

        for (Map.Entry<URI, Object> entry : entries) {
            final StatusDetailDetailType sddt = createStatusDetailDetail(entry.getKey(), entry.getValue());
            details.add(sddt);
        }

        return sm;
    }

    /**
     * Add a single detail to a Status Message. The content is a variable length list of arguments.
     * A set of detail elements with the same name will be created if multiple values are given.
     * NOTE: Each item in the content argument will be toString()ed when added to the detail element.
     * 
     * @param sm
     * @param name
     * @param content - list of values. These will be toString()ed.
     * @return
     */
    public static StatusMessage addDetail(final StatusMessage sm, final URI name, final Object... content) {

        StatusDetailType sdt = sm.getStatusDetail();

        if (null == sdt) { // There are no details. Add them.
            final StatusDetailType newSdt = factory.createStatusDetailType();
            sm.setStatusDetail(newSdt);
            sdt = sm.getStatusDetail();
        }

        final List<StatusDetailDetailType> details = sdt.getDetails(); // If there are no details, we'll get an empty list, not null. By getting it we instantiate the list.

        for (Object item : content) {
            final StatusDetailDetailType sddt = createStatusDetailDetail(name, item.toString());
            details.add(sddt);
        }

        return sm;
    }

}
