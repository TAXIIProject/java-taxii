
package org.mitre.taxii.messages.xml11;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubscriptionStatusEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SubscriptionStatusEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ACTIVE"/&gt;
 *     &lt;enumeration value="PAUSED"/&gt;
 *     &lt;enumeration value="UNSUBSCRIBED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SubscriptionStatusEnum")
@XmlEnum
public enum SubscriptionStatusEnum {


    /**
     * The subscription is in an active state
     * 
     */
    ACTIVE,

    /**
     * The subscription is in a paused state
     * 
     */
    PAUSED,

    /**
     * The subscription has just been unsubscribed
     * 
     */
    UNSUBSCRIBED;

    public String value() {
        return name();
    }

    public static SubscriptionStatusEnum fromValue(String v) {
        return valueOf(v);
    }

}
