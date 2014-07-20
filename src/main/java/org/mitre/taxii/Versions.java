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

package org.mitre.taxii;

/**
 * Version ID Constants, adapted from libtaxii.
 * 
 * @author Jonathan W. Cranford
 */
public interface Versions {

    /* ### TAXII Version IDs ### */

    /**  Version ID for the TAXII Services Specification 1.0 */
    String VID_TAXII_SERVICES_10 = "urn:taxii.mitre.org:services:1.0";
    
    /** Version ID for the TAXII Services Specification 1.1 */
    String VID_TAXII_SERVICES_11 = "urn:taxii.mitre.org:services:1.1";
    
    /** Version ID for the TAXII XML Message Binding Specification 1.0 */
    String VID_TAXII_XML_10 = "urn:taxii.mitre.org:message:xml:1.0";
    
    /** Version ID for the TAXII XML Message Binding Specification 1.1 */
    String VID_TAXII_XML_11 = "urn:taxii.mitre.org:message:xml:1.1";
    
    /** Version ID for the TAXII HTTP Protocol Binding Specification 1.0 */
    String VID_TAXII_HTTP_10 = "urn:taxii.mitre.org:protocol:http:1.0";
    
    /** Version ID for the TAXII HTTPS Protocol Binding Specification 1.0 */
    String VID_TAXII_HTTPS_10 = "urn:taxii.mitre.org:protocol:https:1.0";

    /* # Third Party Version IDs */
    
    /** Version ID for the CERT EU JSON Message Binding */
    String VID_CERT_EU_JSON_10 = "urn:cert.europa.eu:message:json:1.0";

}
