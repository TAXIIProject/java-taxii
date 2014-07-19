
package org.mitre.taxii.messages.xml11;

import java.util.ArrayList;
import java.util.List;
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
import org.mitre.taxii.messages.xmldsig.SignatureType;


/**
 * Response to a Discovery Request. Contains 0 or more Service records.
 * 
 * <p>Java class for TAXIIDiscoveryResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAXIIDiscoveryResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}ResponseMessageType">
 *       &lt;sequence>
 *         &lt;element name="Service_Instance" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}ServiceInstanceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAXIIDiscoveryResponseType", propOrder = {
    "serviceInstance",
    "signature"
})
public class TAXIIDiscoveryResponseType
    extends ResponseMessageType
    implements Equals, HashCode
{

    @XmlElement(name = "Service_Instance")
    protected List<ServiceInstanceType> serviceInstance;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected SignatureType signature;

    /**
     * Gets the value of the serviceInstance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceInstance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceInstance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceInstanceType }
     * 
     * 
     */
    public List<ServiceInstanceType> getServiceInstance() {
        if (serviceInstance == null) {
            serviceInstance = new ArrayList<ServiceInstanceType>();
        }
        return this.serviceInstance;
    }

    /**
     * An XML Digital Signature scoped to this message.
     * 
     * @return
     *     possible object is
     *     {@link SignatureType }
     *     
     */
    public SignatureType getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureType }
     *     
     */
    public void setSignature(SignatureType value) {
        this.signature = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof TAXIIDiscoveryResponseType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final TAXIIDiscoveryResponseType that = ((TAXIIDiscoveryResponseType) object);
        {
            List<ServiceInstanceType> lhsServiceInstance;
            lhsServiceInstance = (((this.serviceInstance!= null)&&(!this.serviceInstance.isEmpty()))?this.getServiceInstance():null);
            List<ServiceInstanceType> rhsServiceInstance;
            rhsServiceInstance = (((that.serviceInstance!= null)&&(!that.serviceInstance.isEmpty()))?that.getServiceInstance():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "serviceInstance", lhsServiceInstance), LocatorUtils.property(thatLocator, "serviceInstance", rhsServiceInstance), lhsServiceInstance, rhsServiceInstance)) {
                return false;
            }
        }
        {
            SignatureType lhsSignature;
            lhsSignature = this.getSignature();
            SignatureType rhsSignature;
            rhsSignature = that.getSignature();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "signature", lhsSignature), LocatorUtils.property(thatLocator, "signature", rhsSignature), lhsSignature, rhsSignature)) {
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
        int currentHashCode = super.hashCode(locator, strategy);
        {
            List<ServiceInstanceType> theServiceInstance;
            theServiceInstance = (((this.serviceInstance!= null)&&(!this.serviceInstance.isEmpty()))?this.getServiceInstance():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "serviceInstance", theServiceInstance), currentHashCode, theServiceInstance);
        }
        {
            SignatureType theSignature;
            theSignature = this.getSignature();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signature", theSignature), currentHashCode, theSignature);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
