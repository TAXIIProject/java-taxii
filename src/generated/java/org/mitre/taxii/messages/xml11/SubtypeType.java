
package org.mitre.taxii.messages.xml11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Identifies a Content Binding Subtype
 * 
 * <p>Java class for SubtypeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubtypeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="subtype_id" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubtypeType")
public class SubtypeType {

    @XmlAttribute(name = "subtype_id", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String subtypeId;

    /**
     * Gets the value of the subtypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubtypeId() {
        return subtypeId;
    }

    /**
     * Sets the value of the subtypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubtypeId(String value) {
        this.subtypeId = value;
    }

}
