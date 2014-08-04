
package org.mitre.taxii.messages.xml11;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StatusTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StatusTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ASYNCHRONOUS_POLL_ERROR"/>
 *     &lt;enumeration value="BAD_MESSAGE"/>
 *     &lt;enumeration value="DENIED"/>
 *     &lt;enumeration value="DESTINATION_COLLECTION_ERROR"/>
 *     &lt;enumeration value="FAILURE"/>
 *     &lt;enumeration value="INVALID_RESPONSE_PART"/>
 *     &lt;enumeration value="NETWORK_ERROR"/>
 *     &lt;enumeration value="NOT_FOUND"/>
 *     &lt;enumeration value="PENDING"/>
 *     &lt;enumeration value="POLLING_UNSUPPORTED"/>
 *     &lt;enumeration value="RETRY"/>
 *     &lt;enumeration value="SUCCESS"/>
 *     &lt;enumeration value="UNAUTHORIZED"/>
 *     &lt;enumeration value="UNSUPPORTED_MESSAGE"/>
 *     &lt;enumeration value="UNSUPPORTED_CONTENT"/>
 *     &lt;enumeration value="UNSUPPORTED_PROTOCOL"/>
 *     &lt;enumeration value="UNSUPPORTED_QUERY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StatusTypeEnum")
@XmlEnum
public enum StatusTypeEnum {


    /**
     * Asynchronous Poll Error - An error was detected while creating
     *                         an Asynchronous Poll result.
     * 
     */
    ASYNCHRONOUS_POLL_ERROR,

    /**
     * Bad Message - Recipient could not interpret the message.
     * 
     */
    BAD_MESSAGE,

    /**
     * Denied - Rejected for reasons other than authentication failure.
     * 
     */
    DENIED,

    /**
     * Destination Collection Error - indicates an error in the
     *                         specification of a destination Data Collection
     * 
     */
    DESTINATION_COLLECTION_ERROR,

    /**
     * Failure - General indication of failure.
     * 
     */
    FAILURE,

    /**
     * Invalid Response Part - Indicates that a request was made for
     *                         an invalid response part.
     * 
     */
    INVALID_RESPONSE_PART,

    /**
     * Network Error - Encapsulates an error encountered at the
     *                         network transport layer.
     * 
     */
    NETWORK_ERROR,

    /**
     * Not Found - Request was for an unknown target.
     * 
     */
    NOT_FOUND,

    /**
     * Pending - Indicates that a result set was not immediately
     *                         available but will be created and made available at a later time.
     * 
     */
    PENDING,

    /**
     * Polling Not Supported - Request for polling of content cannot be supported.
     * 
     */
    POLLING_UNSUPPORTED,

    /**
     * Retry - Unable to respond within current session but may be successfuly at a later time.
     * 
     */
    RETRY,

    /**
     * Success - Message successfully received and processed.
     * 
     */
    SUCCESS,

    /**
     * Unauthorized - Authentication missing or incorrect.
     * 
     */
    UNAUTHORIZED,

    /**
     * Unsupported Message Binding - Requested Message Binding not supported.
     * 
     */
    UNSUPPORTED_MESSAGE,

    /**
     * Unsupported Content Binding - Requested Content Binding not supported.
     * 
     */
    UNSUPPORTED_CONTENT,

    /**
     * Unsupported Protocol - Requested Protocol Binding not supported.
     * 
     */
    UNSUPPORTED_PROTOCOL,

    /**
     * Unsupported Query - Indicates the presence of a Query
     *                         expression that used an unsupported Query Format.
     * 
     */
    UNSUPPORTED_QUERY;

    public String value() {
        return name();
    }

    public static StatusTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}
