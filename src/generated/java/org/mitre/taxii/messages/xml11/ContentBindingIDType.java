
package org.mitre.taxii.messages.xml11;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Identifies a content binding and multiple possible subtypes
 * 
 * <p>Java class for ContentBindingIDType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContentBindingIDType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Subtype" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}SubtypeType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="binding_id" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContentBindingIDType", propOrder = {
    "subtype"
})
public class ContentBindingIDType {

    @XmlElement(name = "Subtype")
    protected List<SubtypeType> subtype;
    @XmlAttribute(name = "binding_id", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String bindingId;

    /**
     * Gets the value of the subtype property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subtype property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubtype().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubtypeType }
     * 
     * 
     */
    public List<SubtypeType> getSubtype() {
        if (subtype == null) {
            subtype = new ArrayList<SubtypeType>();
        }
        return this.subtype;
    }

    /**
     * Gets the value of the bindingId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBindingId() {
        return bindingId;
    }

    /**
     * Sets the value of the bindingId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBindingId(String value) {
        this.bindingId = value;
    }

}
