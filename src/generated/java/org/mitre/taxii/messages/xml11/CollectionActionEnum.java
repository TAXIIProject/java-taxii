
package org.mitre.taxii.messages.xml11;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CollectionActionEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CollectionActionEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SUBSCRIBE"/&gt;
 *     &lt;enumeration value="UNSUBSCRIBE"/&gt;
 *     &lt;enumeration value="PAUSE"/&gt;
 *     &lt;enumeration value="RESUME"/&gt;
 *     &lt;enumeration value="STATUS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CollectionActionEnum")
@XmlEnum
public enum CollectionActionEnum {


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
     * Pause delivery of an existing subscription.
     * 
     */
    PAUSE,

    /**
     * Resume delivery of an existing subscription.
     * 
     */
    RESUME,

    /**
     * Ask about the requester's established subscriptions for this collection.
     * 
     */
    STATUS;

    public String value() {
        return name();
    }

    public static CollectionActionEnum fromValue(String v) {
        return valueOf(v);
    }

}
