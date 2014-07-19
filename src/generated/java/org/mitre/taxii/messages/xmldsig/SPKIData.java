
package org.mitre.taxii.messages.xmldsig;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementRef;
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
 * <p>Java class for SPKIDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SPKIDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element name="SPKISexp" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;any processContents='lax' namespace='##other' minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SPKIDataType", propOrder = {
    "spkiSexpsAndAnies"
})
@XmlRootElement(name = "SPKIData")
public class SPKIData implements Equals, HashCode
{

    @XmlElementRef(name = "SPKISexp", namespace = "http://www.w3.org/2000/09/xmldsig#", type = JAXBElement.class)
    @XmlAnyElement
    protected List<java.lang.Object> spkiSexpsAndAnies;

    /**
     * Gets the value of the spkiSexpsAndAnies property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the spkiSexpsAndAnies property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSPKISexpsAndAnies().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     * 
     * 
     */
    public List<java.lang.Object> getSPKISexpsAndAnies() {
        if (spkiSexpsAndAnies == null) {
            spkiSexpsAndAnies = new ArrayList<java.lang.Object>();
        }
        return this.spkiSexpsAndAnies;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, java.lang.Object object, EqualsStrategy strategy) {
        if (!(object instanceof SPKIData)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SPKIData that = ((SPKIData) object);
        {
            List<java.lang.Object> lhsSPKISexpsAndAnies;
            lhsSPKISexpsAndAnies = (((this.spkiSexpsAndAnies!= null)&&(!this.spkiSexpsAndAnies.isEmpty()))?this.getSPKISexpsAndAnies():null);
            List<java.lang.Object> rhsSPKISexpsAndAnies;
            rhsSPKISexpsAndAnies = (((that.spkiSexpsAndAnies!= null)&&(!that.spkiSexpsAndAnies.isEmpty()))?that.getSPKISexpsAndAnies():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "spkiSexpsAndAnies", lhsSPKISexpsAndAnies), LocatorUtils.property(thatLocator, "spkiSexpsAndAnies", rhsSPKISexpsAndAnies), lhsSPKISexpsAndAnies, rhsSPKISexpsAndAnies)) {
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
            List<java.lang.Object> theSPKISexpsAndAnies;
            theSPKISexpsAndAnies = (((this.spkiSexpsAndAnies!= null)&&(!this.spkiSexpsAndAnies.isEmpty()))?this.getSPKISexpsAndAnies():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "spkiSexpsAndAnies", theSPKISexpsAndAnies), currentHashCode, theSPKISexpsAndAnies);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
