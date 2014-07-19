
package org.mitre.taxii.messages.xml11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * Identifies a content nesting expression or a content binding and possible single subtype
 * 
 * <p>Java class for ContentInstanceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContentInstanceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Subtype" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}SubtypeType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="binding_id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContentInstanceType", propOrder = {
    "subtype"
})
public class ContentInstanceType
    implements Equals
{

    @XmlElement(name = "Subtype")
    protected SubtypeType subtype;
    @XmlAttribute(name = "binding_id", required = true)
    protected String bindingId;

    /**
     * Gets the value of the subtype property.
     * 
     * @return
     *     possible object is
     *     {@link SubtypeType }
     *     
     */
    public SubtypeType getSubtype() {
        return subtype;
    }

    /**
     * Sets the value of the subtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubtypeType }
     *     
     */
    public void setSubtype(SubtypeType value) {
        this.subtype = value;
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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ContentInstanceType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ContentInstanceType that = ((ContentInstanceType) object);
        {
            SubtypeType lhsSubtype;
            lhsSubtype = this.getSubtype();
            SubtypeType rhsSubtype;
            rhsSubtype = that.getSubtype();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "subtype", lhsSubtype), LocatorUtils.property(thatLocator, "subtype", rhsSubtype), lhsSubtype, rhsSubtype)) {
                return false;
            }
        }
        {
            String lhsBindingId;
            lhsBindingId = this.getBindingId();
            String rhsBindingId;
            rhsBindingId = that.getBindingId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bindingId", lhsBindingId), LocatorUtils.property(thatLocator, "bindingId", rhsBindingId), lhsBindingId, rhsBindingId)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

}
