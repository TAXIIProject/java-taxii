
package org.mitre.taxii.messages.xmldsig;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * <p>Java class for RSAKeyValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RSAKeyValueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Modulus" type="{http://www.w3.org/2000/09/xmldsig#}CryptoBinary"/>
 *         &lt;element name="Exponent" type="{http://www.w3.org/2000/09/xmldsig#}CryptoBinary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RSAKeyValueType", propOrder = {
    "modulus",
    "exponent"
})
public class RSAKeyValueType
    implements Equals, HashCode
{

    @XmlElement(name = "Modulus", required = true)
    protected byte[] modulus;
    @XmlElement(name = "Exponent", required = true)
    protected byte[] exponent;

    /**
     * Gets the value of the modulus property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getModulus() {
        return modulus;
    }

    /**
     * Sets the value of the modulus property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setModulus(byte[] value) {
        this.modulus = value;
    }

    /**
     * Gets the value of the exponent property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getExponent() {
        return exponent;
    }

    /**
     * Sets the value of the exponent property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setExponent(byte[] value) {
        this.exponent = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof RSAKeyValueType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final RSAKeyValueType that = ((RSAKeyValueType) object);
        {
            byte[] lhsModulus;
            lhsModulus = this.getModulus();
            byte[] rhsModulus;
            rhsModulus = that.getModulus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "modulus", lhsModulus), LocatorUtils.property(thatLocator, "modulus", rhsModulus), lhsModulus, rhsModulus)) {
                return false;
            }
        }
        {
            byte[] lhsExponent;
            lhsExponent = this.getExponent();
            byte[] rhsExponent;
            rhsExponent = that.getExponent();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "exponent", lhsExponent), LocatorUtils.property(thatLocator, "exponent", rhsExponent), lhsExponent, rhsExponent)) {
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
            byte[] theModulus;
            theModulus = this.getModulus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "modulus", theModulus), currentHashCode, theModulus);
        }
        {
            byte[] theExponent;
            theExponent = this.getExponent();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "exponent", theExponent), currentHashCode, theExponent);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
