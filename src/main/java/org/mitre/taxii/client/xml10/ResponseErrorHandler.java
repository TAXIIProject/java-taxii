package org.mitre.taxii.client.xml10;
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

import javax.net.ssl.SSLException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.mitre.taxii.messages.xml10.MessageType;
import org.mitre.taxii.messages.xml10.ObjectFactory;
import org.mitre.taxii.messages.xml10.StatusMessage;
import org.mitre.taxii.messages.xml10.StatusTypeEnum;

/**
 * This class handles generating {@link StatusMessage}s for TAXII 1.0 when
 * an error occurs while handling the response from the TAXII server.
 * 
 * @author jasenj1
 */
public class ResponseErrorHandler extends org.mitre.taxii.client.HttpResponseErrorHandler {

    /** Build a status message based to the HTTP response code. */
    @Override
    public StatusMessage buildStatusCodeStatusMessage(CloseableHttpResponse response, Object msgIn) {
        String msgId = ((MessageType)msgIn).getMessageId();
        ObjectFactory factory = new ObjectFactory();
        StatusMessage msg = factory.createStatusMessage()
                                .withInResponseTo(msgId)
                                .withMessageId("0");
        
        switch (response.getStatusLine().getStatusCode()) {
            case 400: // Bad Request
            case 413: // Request Entity Too Large
                    msg.setStatusType(StatusTypeEnum.BAD_MESSAGE.name());
                    break;

            case 401: // Unauthorized
            case 403: // Forbidden
            case 407: // Proxy Authentication Required
                    msg.setStatusType(StatusTypeEnum.UNAUTHORIZED.name());
                    break;

            case 406: // Not Acceptable
            case 415: // Unsupported Media Type
                    msg.setStatusType(StatusTypeEnum.UNSUPPORTED_MESSAGE.name());
                    break;
                
            default:
                    msg.setStatusType(StatusTypeEnum.FAILURE.name());
        }
        
        String msgStr = buildResponseStr(response);
        
        msg.setMessage(msgStr);
        
        return msg;
    }
    
    
    /**
     * Construct an "UNAUTHORIZED" StatusMessage.
     * 
     * <p>Section 5.2 of the TAXII HTTP Protocol Binding Specification states:</p>
     * <p>
     * "If TLS is used, problems with the TLS handshake or connection are indicated
     * using a TLS Alert Protocol Record. This section defines rules for interpreting
     * a TLS Alert Protocol Record as a TAXII Status Message. Treat a TLS Alert
     * Protocol Record as being equivalent to a TAXII Status Message with the 
     * following properties:
     * </p>
     * <ul>
     * <li>Status = Use the appropriate TAXII Status Type as identified in Table 3.</li>
     * <li>Message = The TLS Alert, represented as a hexadecimal string."</li>
     * </ul>
     * <p>
     * Unfortunately, Java does not give us access to the TLS Alert, so we'll 
     * just make all the Statuses UNAUTHORIZED and return the exception's message.
     * </p>
     * 
     * @param ex
     * @param message
     * @return "UNAUTHORIZED" status message.
     */ 
    @Override
    public StatusMessage buildSSLErrorStatusMessage(SSLException ex, Object message) {
        if (!(message instanceof MessageType)) {
            return null; // Probably ought to throw an exception here.
        }
        String msgId = ((MessageType)message).getMessageId();
        
        ObjectFactory factory = new ObjectFactory();
        StatusMessage msg = factory.createStatusMessage()
                                .withInResponseTo(msgId)
                                .withMessageId("0");
        
        msg.setStatusType(StatusTypeEnum.UNAUTHORIZED.name());
        msg.setMessage(ex.getMessage());

        return msg;
    }
    
    
}
