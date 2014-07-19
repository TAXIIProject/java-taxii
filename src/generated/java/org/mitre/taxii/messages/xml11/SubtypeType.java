
package org.mitre.taxii.messages.xml11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


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
public class SubtypeType
    implements Equals
{

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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SubtypeType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SubtypeType that = ((SubtypeType) object);
        {
            String lhsSubtypeId;
            lhsSubtypeId = this.getSubtypeId();
            String rhsSubtypeId;
            rhsSubtypeId = that.getSubtypeId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "subtypeId", lhsSubtypeId), LocatorUtils.property(thatLocator, "subtypeId", rhsSubtypeId), lhsSubtypeId, rhsSubtypeId)) {
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
