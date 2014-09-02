package org.mitre.taxii.client.xml10;

import javax.net.ssl.SSLException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.mitre.taxii.messages.xml10.MessageType;
import org.mitre.taxii.messages.xml10.ObjectFactory;
import org.mitre.taxii.messages.xml10.StatusMessage;
import org.mitre.taxii.messages.xml10.StatusTypeEnum;

/**
 *
 * @author jasenj1
 */
public class ResponseHandler extends org.mitre.taxii.client.HttpResponseHandler {
    /**
     * We received a response that did not contain the proper HEADER_X_TAXII_CONTENT_TYPE
     * value. Make up an appropriate Status Message.
     * 
     * @param response
     * @param msgIn
     * @return 
     */
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
     *   Section 5.2 of the TAXII HTTP Protocol Binding Specification states:
     * 
     * "If TLS is used, problems with the TLS handshake or connection are indicated
     * using a TLS Alert Protocol Record. This section defines rules for interpreting
     * a TLS Alert Protocol Record as a TAXII Status Message. Treat a TLS Alert
     * Protocol Record as being equivalent to a TAXII Status Message with the 
     * following properties:
     * Status = Use the appropriate TAXII Status Type as identified in Table 3.
     * Message = The TLS Alert, represented as a hexadecimal string."
     * 
     * Unfortunately, Java does not give us access to the TLS Alert, so we'll 
     * just make all the Statuses UNAUTHORIZED and return the exception's message.
     * 
     * @param ex
     * @param message
     * @return 
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
