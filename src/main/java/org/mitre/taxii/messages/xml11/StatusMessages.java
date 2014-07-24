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
public final class StatusMessages {

    // TODO look at mapping extended headers and status details using 
    // a map instead of a list - that would make it easier to find headers
    // or status details by name
    
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
}
