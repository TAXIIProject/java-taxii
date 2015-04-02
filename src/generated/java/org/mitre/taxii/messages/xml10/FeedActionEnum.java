
package org.mitre.taxii.messages.xml10;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeedActionEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FeedActionEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SUBSCRIBE"/&gt;
 *     &lt;enumeration value="UNSUBSCRIBE"/&gt;
 *     &lt;enumeration value="STATUS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "FeedActionEnum")
@XmlEnum
public enum FeedActionEnum {


    /**
     * Create a new subscription.
     * 
     */
    SUBSCRIBE,

    /**
     * Delete an existing subscription.
     * 
     */
    UNSUBSCRIBE,

    /**
     * Ask about the requester's established subscriptions for this feed.
     * 
     */
    STATUS;

    public String value() {
        return name();
    }

    public static FeedActionEnum fromValue(String v) {
        return valueOf(v);
    }

}
