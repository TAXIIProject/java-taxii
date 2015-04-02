
package org.mitre.taxii.messages.xml10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
import org.mitre.taxii.messages.xmldsig.Signature;


/**
 * Response to a Discovery Request. Contains 0 or more Service records.
 * 
 * <p>Java class for TAXIIDiscoveryResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAXIIDiscoveryResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://taxii.mitre.org/messages/taxii_xml_binding-1}ResponseMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Service_Instance" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1}ServiceInstanceType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAXIIDiscoveryResponseType", propOrder = {
    "serviceInstances",
    "signature"
})
@XmlRootElement(name = "Discovery_Response")
public class DiscoveryResponse
    extends ResponseMessageType
    implements Equals, HashCode
{

    @XmlElement(name = "Service_Instance")
    protected List<ServiceInstanceType> serviceInstances;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected Signature signature;

    /**
     * Default no-arg constructor
     * 
     */
    public DiscoveryResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public DiscoveryResponse(final ExtendedHeadersType extendedHeaders, final String messageId, final String inResponseTo, final List<ServiceInstanceType> serviceInstances, final Signature signature) {
        super(extendedHeaders, messageId, inResponseTo);
        this.serviceInstances = serviceInstances;
        this.signature = signature;
    }

    /**
     * Gets the value of the serviceInstances property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceInstances property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceInstances().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceInstanceType }
     * 
     * 
     */
    public List<ServiceInstanceType> getServiceInstances() {
        if (serviceInstances == null) {
            serviceInstances = new ArrayList<ServiceInstanceType>();
        }
        return this.serviceInstances;
    }

    /**
     * An XML Digital Signature scoped to this message.
     * 
     * @return
     *     possible object is
     *     {@link Signature }
     *     
     */
    public Signature getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     {@link Signature }
     *     
     */
    public void setSignature(Signature value) {
        this.signature = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DiscoveryResponse)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final DiscoveryResponse that = ((DiscoveryResponse) object);
        {
            List<ServiceInstanceType> lhsServiceInstances;
            lhsServiceInstances = (((this.serviceInstances!= null)&&(!this.serviceInstances.isEmpty()))?this.getServiceInstances():null);
            List<ServiceInstanceType> rhsServiceInstances;
            rhsServiceInstances = (((that.serviceInstances!= null)&&(!that.serviceInstances.isEmpty()))?that.getServiceInstances():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "serviceInstances", lhsServiceInstances), LocatorUtils.property(thatLocator, "serviceInstances", rhsServiceInstances), lhsServiceInstances, rhsServiceInstances)) {
                return false;
            }
        }
        {
            Signature lhsSignature;
            lhsSignature = this.getSignature();
            Signature rhsSignature;
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
            List<ServiceInstanceType> theServiceInstances;
            theServiceInstances = (((this.serviceInstances!= null)&&(!this.serviceInstances.isEmpty()))?this.getServiceInstances():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "serviceInstances", theServiceInstances), currentHashCode, theServiceInstances);
        }
        {
            Signature theSignature;
            theSignature = this.getSignature();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signature", theSignature), currentHashCode, theSignature);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public DiscoveryResponse withServiceInstances(ServiceInstanceType... values) {
        if (values!= null) {
            for (ServiceInstanceType value: values) {
                getServiceInstances().add(value);
            }
        }
        return this;
    }

    public DiscoveryResponse withServiceInstances(Collection<ServiceInstanceType> values) {
        if (values!= null) {
            getServiceInstances().addAll(values);
        }
        return this;
    }

    public DiscoveryResponse withSignature(Signature value) {
        setSignature(value);
        return this;
    }

    @Override
    public DiscoveryResponse withInResponseTo(String value) {
        setInResponseTo(value);
        return this;
    }

    @Override
    public DiscoveryResponse withExtendedHeaders(ExtendedHeadersType value) {
        setExtendedHeaders(value);
        return this;
    }

    @Override
    public DiscoveryResponse withMessageId(String value) {
        setMessageId(value);
        return this;
    }

}
