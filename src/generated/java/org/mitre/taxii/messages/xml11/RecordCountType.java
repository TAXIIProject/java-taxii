
package org.mitre.taxii.messages.xml11;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * Contains information about the number of applicable records in a
 *                 result set.
 * 
 * <p>Java class for RecordCountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecordCountType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>nonNegativeInteger">
 *       &lt;attribute name="partial_count" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecordCountType", propOrder = {
    "value"
})
public class RecordCountType
    implements Equals, HashCode
{

    @XmlValue
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger value;
    @XmlAttribute(name = "partial_count")
    protected Boolean partialCount;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setValue(BigInteger value) {
        this.value = value;
    }

    /**
     * Gets the value of the partialCount property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isPartialCount() {
        if (partialCount == null) {
            return false;
        } else {
            return partialCount;
        }
    }

    /**
     * Sets the value of the partialCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPartialCount(Boolean value) {
        this.partialCount = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof RecordCountType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final RecordCountType that = ((RecordCountType) object);
        {
            BigInteger lhsValue;
            lhsValue = this.getValue();
            BigInteger rhsValue;
            rhsValue = that.getValue();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "value", lhsValue), LocatorUtils.property(thatLocator, "value", rhsValue), lhsValue, rhsValue)) {
                return false;
            }
        }
        {
            boolean lhsPartialCount;
            lhsPartialCount = ((this.partialCount!= null)?this.isPartialCount():false);
            boolean rhsPartialCount;
            rhsPartialCount = ((that.partialCount!= null)?that.isPartialCount():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "partialCount", lhsPartialCount), LocatorUtils.property(thatLocator, "partialCount", rhsPartialCount), lhsPartialCount, rhsPartialCount)) {
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
            BigInteger theValue;
            theValue = this.getValue();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "value", theValue), currentHashCode, theValue);
        }
        {
            boolean thePartialCount;
            thePartialCount = ((this.partialCount!= null)?this.isPartialCount():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "partialCount", thePartialCount), currentHashCode, thePartialCount);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
