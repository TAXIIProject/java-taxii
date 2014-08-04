
package org.mitre.taxii.messages.xmldsig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
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
import org.w3c.dom.Element;


/**
 * <p>Java class for PGPDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PGPDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element name="PGPKeyID" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *           &lt;element name="PGPKeyPacket" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *           &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element name="PGPKeyPacket" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *           &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PGPDataType", propOrder = {
    "pgpKeyID",
    "pgpKeyPacket",
    "anies"
})
@XmlRootElement(name = "PGPData")
public class PGPData implements Equals, HashCode
{

    @XmlElement(name = "PGPKeyID")
    protected byte[] pgpKeyID;
    @XmlElement(name = "PGPKeyPacket")
    protected byte[] pgpKeyPacket;
    @XmlAnyElement
    protected List<Element> anies;

    /**
     * Default no-arg constructor
     * 
     */
    public PGPData() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public PGPData(final byte[] pgpKeyID, final byte[] pgpKeyPacket, final List<Element> anies) {
        this.pgpKeyID = pgpKeyID;
        this.pgpKeyPacket = pgpKeyPacket;
        this.anies = anies;
    }

    /**
     * Gets the value of the pgpKeyID property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getPGPKeyID() {
        return pgpKeyID;
    }

    /**
     * Sets the value of the pgpKeyID property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPGPKeyID(byte[] value) {
        this.pgpKeyID = value;
    }

    /**
     * Gets the value of the pgpKeyPacket property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getPGPKeyPacket() {
        return pgpKeyPacket;
    }

    /**
     * Sets the value of the pgpKeyPacket property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPGPKeyPacket(byte[] value) {
        this.pgpKeyPacket = value;
    }

    /**
     * Gets the value of the anies property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anies property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnies().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * 
     * 
     */
    public List<Element> getAnies() {
        if (anies == null) {
            anies = new ArrayList<Element>();
        }
        return this.anies;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, java.lang.Object object, EqualsStrategy strategy) {
        if (!(object instanceof PGPData)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PGPData that = ((PGPData) object);
        {
            byte[] lhsPGPKeyID;
            lhsPGPKeyID = this.getPGPKeyID();
            byte[] rhsPGPKeyID;
            rhsPGPKeyID = that.getPGPKeyID();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pgpKeyID", lhsPGPKeyID), LocatorUtils.property(thatLocator, "pgpKeyID", rhsPGPKeyID), lhsPGPKeyID, rhsPGPKeyID)) {
                return false;
            }
        }
        {
            byte[] lhsPGPKeyPacket;
            lhsPGPKeyPacket = this.getPGPKeyPacket();
            byte[] rhsPGPKeyPacket;
            rhsPGPKeyPacket = that.getPGPKeyPacket();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pgpKeyPacket", lhsPGPKeyPacket), LocatorUtils.property(thatLocator, "pgpKeyPacket", rhsPGPKeyPacket), lhsPGPKeyPacket, rhsPGPKeyPacket)) {
                return false;
            }
        }
        {
            List<Element> lhsAnies;
            lhsAnies = (((this.anies!= null)&&(!this.anies.isEmpty()))?this.getAnies():null);
            List<Element> rhsAnies;
            rhsAnies = (((that.anies!= null)&&(!that.anies.isEmpty()))?that.getAnies():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "anies", lhsAnies), LocatorUtils.property(thatLocator, "anies", rhsAnies), lhsAnies, rhsAnies)) {
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
            byte[] thePGPKeyID;
            thePGPKeyID = this.getPGPKeyID();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pgpKeyID", thePGPKeyID), currentHashCode, thePGPKeyID);
        }
        {
            byte[] thePGPKeyPacket;
            thePGPKeyPacket = this.getPGPKeyPacket();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pgpKeyPacket", thePGPKeyPacket), currentHashCode, thePGPKeyPacket);
        }
        {
            List<Element> theAnies;
            theAnies = (((this.anies!= null)&&(!this.anies.isEmpty()))?this.getAnies():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "anies", theAnies), currentHashCode, theAnies);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public PGPData withPGPKeyID(byte[] value) {
        setPGPKeyID(value);
        return this;
    }

    public PGPData withPGPKeyPacket(byte[] value) {
        setPGPKeyPacket(value);
        return this;
    }

    public PGPData withAnies(Element... values) {
        if (values!= null) {
            for (Element value: values) {
                getAnies().add(value);
            }
        }
        return this;
    }

    public PGPData withAnies(Collection<Element> values) {
        if (values!= null) {
            getAnies().addAll(values);
        }
        return this;
    }

}
