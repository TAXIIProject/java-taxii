
package org.mitre.taxii.messages.xml10;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ServiceTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DISCOVERY"/>
 *     &lt;enumeration value="FEED_MANAGEMENT"/>
 *     &lt;enumeration value="INBOX"/>
 *     &lt;enumeration value="POLL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
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
