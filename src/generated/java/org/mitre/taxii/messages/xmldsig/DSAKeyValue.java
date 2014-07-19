
package org.mitre.taxii.messages.xmldsig;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 * <p>Java class for DSAKeyValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DSAKeyValueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;sequence minOccurs="0">
 *           &lt;element name="P" type="{http://www.w3.org/2000/09/xmldsig#}CryptoBinary"/>
 *           &lt;element name="Q" type="{http://www.w3.org/2000/09/xmldsig#}CryptoBinary"/>
 *         &lt;/sequence>
 *         &lt;element name="G" type="{http://www.w3.org/2000/09/xmldsig#}CryptoBinary" minOccurs="0"/>
 *         &lt;element name="Y" type="{http://www.w3.org/2000/09/xmldsig#}CryptoBinary"/>
 *         &lt;element name="J" type="{http://www.w3.org/2000/09/xmldsig#}CryptoBinary" minOccurs="0"/>
 *         &lt;sequence minOccurs="0">
 *           &lt;element name="Seed" type="{http://www.w3.org/2000/09/xmldsig#}CryptoBinary"/>
 *           &lt;element name="PgenCounter" type="{http://www.w3.org/2000/09/xmldsig#}CryptoBinary"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSAKeyValueType", propOrder = {
    "p",
    "q",
    "g",
    "y",
    "j",
    "seed",
    "pgenCounter"
})
@XmlRootElement(name = "DSAKeyValue")
public class DSAKeyValue implements Equals, HashCode
{

    @XmlElement(name = "P")
    protected byte[] p;
    @XmlElement(name = "Q")
    protected byte[] q;
    @XmlElement(name = "G")
    protected byte[] g;
    @XmlElement(name = "Y", required = true)
    protected byte[] y;
    @XmlElement(name = "J")
    protected byte[] j;
    @XmlElement(name = "Seed")
    protected byte[] seed;
    @XmlElement(name = "PgenCounter")
    protected byte[] pgenCounter;

    /**
     * Gets the value of the p property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getP() {
        return p;
    }

    /**
     * Sets the value of the p property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setP(byte[] value) {
        this.p = value;
    }

    /**
     * Gets the value of the q property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getQ() {
        return q;
    }

    /**
     * Sets the value of the q property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setQ(byte[] value) {
        this.q = value;
    }

    /**
     * Gets the value of the g property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getG() {
        return g;
    }

    /**
     * Sets the value of the g property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setG(byte[] value) {
        this.g = value;
    }

    /**
     * Gets the value of the y property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getY() {
        return y;
    }

    /**
     * Sets the value of the y property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setY(byte[] value) {
        this.y = value;
    }

    /**
     * Gets the value of the j property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getJ() {
        return j;
    }

    /**
     * Sets the value of the j property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setJ(byte[] value) {
        this.j = value;
    }

    /**
     * Gets the value of the seed property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getSeed() {
        return seed;
    }

    /**
     * Sets the value of the seed property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setSeed(byte[] value) {
        this.seed = value;
    }

    /**
     * Gets the value of the pgenCounter property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getPgenCounter() {
        return pgenCounter;
    }

    /**
     * Sets the value of the pgenCounter property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPgenCounter(byte[] value) {
        this.pgenCounter = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, java.lang.Object object, EqualsStrategy strategy) {
        if (!(object instanceof DSAKeyValue)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DSAKeyValue that = ((DSAKeyValue) object);
        {
            byte[] lhsP;
            lhsP = this.getP();
            byte[] rhsP;
            rhsP = that.getP();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "p", lhsP), LocatorUtils.property(thatLocator, "p", rhsP), lhsP, rhsP)) {
                return false;
            }
        }
        {
            byte[] lhsQ;
            lhsQ = this.getQ();
            byte[] rhsQ;
            rhsQ = that.getQ();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "q", lhsQ), LocatorUtils.property(thatLocator, "q", rhsQ), lhsQ, rhsQ)) {
                return false;
            }
        }
        {
            byte[] lhsG;
            lhsG = this.getG();
            byte[] rhsG;
            rhsG = that.getG();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "g", lhsG), LocatorUtils.property(thatLocator, "g", rhsG), lhsG, rhsG)) {
                return false;
            }
        }
        {
            byte[] lhsY;
            lhsY = this.getY();
            byte[] rhsY;
            rhsY = that.getY();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "y", lhsY), LocatorUtils.property(thatLocator, "y", rhsY), lhsY, rhsY)) {
                return false;
            }
        }
        {
            byte[] lhsJ;
            lhsJ = this.getJ();
            byte[] rhsJ;
            rhsJ = that.getJ();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "j", lhsJ), LocatorUtils.property(thatLocator, "j", rhsJ), lhsJ, rhsJ)) {
                return false;
            }
        }
        {
            byte[] lhsSeed;
            lhsSeed = this.getSeed();
            byte[] rhsSeed;
            rhsSeed = that.getSeed();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "seed", lhsSeed), LocatorUtils.property(thatLocator, "seed", rhsSeed), lhsSeed, rhsSeed)) {
                return false;
            }
        }
        {
            byte[] lhsPgenCounter;
            lhsPgenCounter = this.getPgenCounter();
            byte[] rhsPgenCounter;
            rhsPgenCounter = that.getPgenCounter();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pgenCounter", lhsPgenCounter), LocatorUtils.property(thatLocator, "pgenCounter", rhsPgenCounter), lhsPgenCounter, rhsPgenCounter)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(java.lang.Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            byte[] theP;
            theP = this.getP();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "p", theP), currentHashCode, theP);
        }
        {
            byte[] theQ;
            theQ = this.getQ();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "q", theQ), currentHashCode, theQ);
        }
        {
            byte[] theG;
            theG = this.getG();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "g", theG), currentHashCode, theG);
        }
        {
            byte[] theY;
            theY = this.getY();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "y", theY), currentHashCode, theY);
        }
        {
            byte[] theJ;
            theJ = this.getJ();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "j", theJ), currentHashCode, theJ);
        }
        {
            byte[] theSeed;
            theSeed = this.getSeed();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "seed", theSeed), currentHashCode, theSeed);
        }
        {
            byte[] thePgenCounter;
            thePgenCounter = this.getPgenCounter();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pgenCounter", thePgenCounter), currentHashCode, thePgenCounter);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
