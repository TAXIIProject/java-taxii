
package org.mitre.taxii.messages.xml10;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ServiceTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="DISCOVERY"/&gt;
 *     &lt;enumeration value="FEED_MANAGEMENT"/&gt;
 *     &lt;enumeration value="INBOX"/&gt;
 *     &lt;enumeration value="POLL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ServiceTypeEnum")
@XmlEnum
public enum ServiceTypeEnum {


    /**
     * Discovery Service
     * 
     */
    DISCOVERY,

    /**
     * Feed Management Service
     * 
     */
    FEED_MANAGEMENT,

    /**
     * Inbox Service
     * 
     */
    INBOX,

    /**
     * Poll Service
     * 
     */
    POLL;

    public String value() {
        return name();
    }

    public static ServiceTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}
