
package org.mitre.taxii.messages.xml11;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CollectionTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CollectionTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="DATA_FEED"/&gt;
 *     &lt;enumeration value="DATA_SET"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CollectionTypeEnum")
@XmlEnum
public enum CollectionTypeEnum {


    /**
     * An ordered Data Collection
     * 
     */
    DATA_FEED,

    /**
     * An unordered Data Collection
     * 
     */
    DATA_SET;

    public String value() {
        return name();
    }

    public static CollectionTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}
