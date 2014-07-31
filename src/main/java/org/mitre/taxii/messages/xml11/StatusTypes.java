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

/**
 * Status Type constants for XML Message Binding 1.1, adapted from libtaxii.
 * 
 * <p>
 * Note that all the status types from XML Message Binding 1.0 are still valid
 * in version 1.1; this interface simply adds additional constants for 
 * version 1.1.
 * </p>
 * 
 * @author Jonathan W. Cranford
 */
public interface StatusTypes extends org.mitre.taxii.messages.xml10.StatusTypes {

    /* Constant identifying a Status Type of Asynchronous Poll Error */
    String STATUS_TYPE_ASYNCHRONOUS_POLL_ERROR = "ASYNCHRONOUS_POLL_ERROR";
    
    /* Constant identifying a Status Type of Destination Collection Error */
    String STATUS_TYPE_DESTINATION_COLLECTION_ERROR = "DESTINATION_COLLECTION_ERROR";

    /* Constant identifying a Status Type of Invalid Response Part */
    String STATUS_TYPE_INVALID_RESPONSE_PART = "INVALID_RESPONSE_PART";

    /* Constant identifying a Status Type of Network Error */
    String STATUS_TYPE_NETWORK_ERROR = "NETWORK_ERROR";

    /* Constant identifying a Status Type of Pending */
    String STATUS_TYPE_PENDING = "PENDING";

    /* Constant identifying a Status Type of Unsupported Query Format */
    String STATUS_TYPE_UNSUPPORTED_QUERY = "UNSUPPORTED_QUERY";

}
