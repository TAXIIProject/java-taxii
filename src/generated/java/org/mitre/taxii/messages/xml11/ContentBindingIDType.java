
package org.mitre.taxii.messages.xml11;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
    "subtypes"
})
public class ContentBindingIDType
    implements Equals, HashCode
{

    @XmlElement(name = "Subtype")
    protected List<SubtypeType> subtypes;
    @XmlAttribute(name = "binding_id", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String bindingId;

    /**
     * Gets the value of the subtypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subtypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubtypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubtypeType }
     * 
     * 
     */
    public List<SubtypeType> getSubtypes() {
        if (subtypes == null) {
            subtypes = new ArrayList<SubtypeType>();
        }
        return this.subtypes;
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
        if (!(object instanceof ContentBindingIDType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ContentBindingIDType that = ((ContentBindingIDType) object);
        {
            List<SubtypeType> lhsSubtypes;
            lhsSubtypes = (((this.subtypes!= null)&&(!this.subtypes.isEmpty()))?this.getSubtypes():null);
            List<SubtypeType> rhsSubtypes;
            rhsSubtypes = (((that.subtypes!= null)&&(!that.subtypes.isEmpty()))?that.getSubtypes():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "subtypes", lhsSubtypes), LocatorUtils.property(thatLocator, "subtypes", rhsSubtypes), lhsSubtypes, rhsSubtypes)) {
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
            List<SubtypeType> theSubtypes;
            theSubtypes = (((this.subtypes!= null)&&(!this.subtypes.isEmpty()))?this.getSubtypes():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "subtypes", theSubtypes), currentHashCode, theSubtypes);
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

}
