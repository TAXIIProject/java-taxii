
package org.mitre.taxii.messages.xml11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
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
 * &lt;complexType name="ContentInstanceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Subtype" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}SubtypeType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="binding_id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContentInstanceType", propOrder = {
    "subtype"
})
public class ContentInstanceType implements Equals, HashCode
{

    @XmlElement(name = "Subtype")
    protected SubtypeType subtype;
    @XmlAttribute(name = "binding_id", required = true)
    protected String bindingId;

    /**
     * Default no-arg constructor
     * 
     */
    public ContentInstanceType() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public ContentInstanceType(final SubtypeType subtype, final String bindingId) {
        this.subtype = subtype;
        this.bindingId = bindingId;
    }

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

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            SubtypeType theSubtype;
            theSubtype = this.getSubtype();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "subtype", theSubtype), currentHashCode, theSubtype);
        }
        {
            String theBindingId;
            theBindingId = this.getBindingId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bindingId", theBindingId), currentHashCode, theBindingId);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public ContentInstanceType withSubtype(SubtypeType value) {
        setSubtype(value);
        return this;
    }

    public ContentInstanceType withBindingId(String value) {
        setBindingId(value);
        return this;
    }

}
