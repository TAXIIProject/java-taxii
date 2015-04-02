
package org.mitre.taxii.messages.xml10;

import java.util.ArrayList;
import java.util.Collection;
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
 * Describes one TAXII service.
 * 
 * <p>Java class for ServiceInstanceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceInstanceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;group ref="{http://taxii.mitre.org/messages/taxii_xml_binding-1}BindingsGroup"/&gt;
 *         &lt;element name="Content_Binding" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="service_type" use="required" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1}ServiceTypeEnum" /&gt;
 *       &lt;attribute name="available" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="service_version" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceInstanceType", propOrder = {
    "protocolBinding",
    "address",
    "messageBindings",
    "contentBindings",
    "message"
})
public class ServiceInstanceType implements Equals, HashCode
{

    @XmlElement(name = "Protocol_Binding", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String protocolBinding;
    @XmlElement(name = "Address", required = true)
    protected String address;
    @XmlElement(name = "Message_Binding", required = true)
    @XmlSchemaType(name = "anyURI")
    protected List<String> messageBindings;
    @XmlElement(name = "Content_Binding")
    @XmlSchemaType(name = "anyURI")
    protected List<String> contentBindings;
    @XmlElement(name = "Message")
    protected String message;
    @XmlAttribute(name = "service_type", required = true)
    protected ServiceTypeEnum serviceType;
    @XmlAttribute(name = "available")
    protected Boolean available;
    @XmlAttribute(name = "service_version", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String serviceVersion;

    /**
     * Default no-arg constructor
     * 
     */
    public ServiceInstanceType() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public ServiceInstanceType(final String protocolBinding, final String address, final List<String> messageBindings, final List<String> contentBindings, final String message, final ServiceTypeEnum serviceType, final Boolean available, final String serviceVersion) {
        this.protocolBinding = protocolBinding;
        this.address = address;
        this.messageBindings = messageBindings;
        this.contentBindings = contentBindings;
        this.message = message;
        this.serviceType = serviceType;
        this.available = available;
        this.serviceVersion = serviceVersion;
    }

    /**
     * Gets the value of the protocolBinding property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtocolBinding() {
        return protocolBinding;
    }

    /**
     * Sets the value of the protocolBinding property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtocolBinding(String value) {
        this.protocolBinding = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the messageBindings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messageBindings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessageBindings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMessageBindings() {
        if (messageBindings == null) {
            messageBindings = new ArrayList<String>();
        }
        return this.messageBindings;
    }

    /**
     * Gets the value of the contentBindings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contentBindings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContentBindings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getContentBindings() {
        if (contentBindings == null) {
            contentBindings = new ArrayList<String>();
        }
        return this.contentBindings;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceTypeEnum }
     *     
     */
    public ServiceTypeEnum getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceTypeEnum }
     *     
     */
    public void setServiceType(ServiceTypeEnum value) {
        this.serviceType = value;
    }

    /**
     * Gets the value of the available property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAvailable() {
        return available;
    }

    /**
     * Sets the value of the available property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAvailable(Boolean value) {
        this.available = value;
    }

    /**
     * Gets the value of the serviceVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceVersion() {
        return serviceVersion;
    }

    /**
     * Sets the value of the serviceVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceVersion(String value) {
        this.serviceVersion = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ServiceInstanceType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ServiceInstanceType that = ((ServiceInstanceType) object);
        {
            String lhsProtocolBinding;
            lhsProtocolBinding = this.getProtocolBinding();
            String rhsProtocolBinding;
            rhsProtocolBinding = that.getProtocolBinding();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "protocolBinding", lhsProtocolBinding), LocatorUtils.property(thatLocator, "protocolBinding", rhsProtocolBinding), lhsProtocolBinding, rhsProtocolBinding)) {
                return false;
            }
        }
        {
            String lhsAddress;
            lhsAddress = this.getAddress();
            String rhsAddress;
            rhsAddress = that.getAddress();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "address", lhsAddress), LocatorUtils.property(thatLocator, "address", rhsAddress), lhsAddress, rhsAddress)) {
                return false;
            }
        }
        {
            List<String> lhsMessageBindings;
            lhsMessageBindings = (((this.messageBindings!= null)&&(!this.messageBindings.isEmpty()))?this.getMessageBindings():null);
            List<String> rhsMessageBindings;
            rhsMessageBindings = (((that.messageBindings!= null)&&(!that.messageBindings.isEmpty()))?that.getMessageBindings():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "messageBindings", lhsMessageBindings), LocatorUtils.property(thatLocator, "messageBindings", rhsMessageBindings), lhsMessageBindings, rhsMessageBindings)) {
                return false;
            }
        }
        {
            List<String> lhsContentBindings;
            lhsContentBindings = (((this.contentBindings!= null)&&(!this.contentBindings.isEmpty()))?this.getContentBindings():null);
            List<String> rhsContentBindings;
            rhsContentBindings = (((that.contentBindings!= null)&&(!that.contentBindings.isEmpty()))?that.getContentBindings():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contentBindings", lhsContentBindings), LocatorUtils.property(thatLocator, "contentBindings", rhsContentBindings), lhsContentBindings, rhsContentBindings)) {
                return false;
            }
        }
        {
            String lhsMessage;
            lhsMessage = this.getMessage();
            String rhsMessage;
            rhsMessage = that.getMessage();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "message", lhsMessage), LocatorUtils.property(thatLocator, "message", rhsMessage), lhsMessage, rhsMessage)) {
                return false;
            }
        }
        {
            ServiceTypeEnum lhsServiceType;
            lhsServiceType = this.getServiceType();
            ServiceTypeEnum rhsServiceType;
            rhsServiceType = that.getServiceType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "serviceType", lhsServiceType), LocatorUtils.property(thatLocator, "serviceType", rhsServiceType), lhsServiceType, rhsServiceType)) {
                return false;
            }
        }
        {
            Boolean lhsAvailable;
            lhsAvailable = this.isAvailable();
            Boolean rhsAvailable;
            rhsAvailable = that.isAvailable();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "available", lhsAvailable), LocatorUtils.property(thatLocator, "available", rhsAvailable), lhsAvailable, rhsAvailable)) {
                return false;
            }
        }
        {
            String lhsServiceVersion;
            lhsServiceVersion = this.getServiceVersion();
            String rhsServiceVersion;
            rhsServiceVersion = that.getServiceVersion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "serviceVersion", lhsServiceVersion), LocatorUtils.property(thatLocator, "serviceVersion", rhsServiceVersion), lhsServiceVersion, rhsServiceVersion)) {
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
            String theProtocolBinding;
            theProtocolBinding = this.getProtocolBinding();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "protocolBinding", theProtocolBinding), currentHashCode, theProtocolBinding);
        }
        {
            String theAddress;
            theAddress = this.getAddress();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "address", theAddress), currentHashCode, theAddress);
        }
        {
            List<String> theMessageBindings;
            theMessageBindings = (((this.messageBindings!= null)&&(!this.messageBindings.isEmpty()))?this.getMessageBindings():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "messageBindings", theMessageBindings), currentHashCode, theMessageBindings);
        }
        {
            List<String> theContentBindings;
            theContentBindings = (((this.contentBindings!= null)&&(!this.contentBindings.isEmpty()))?this.getContentBindings():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contentBindings", theContentBindings), currentHashCode, theContentBindings);
        }
        {
            String theMessage;
            theMessage = this.getMessage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "message", theMessage), currentHashCode, theMessage);
        }
        {
            ServiceTypeEnum theServiceType;
            theServiceType = this.getServiceType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "serviceType", theServiceType), currentHashCode, theServiceType);
        }
        {
            Boolean theAvailable;
            theAvailable = this.isAvailable();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "available", theAvailable), currentHashCode, theAvailable);
        }
        {
            String theServiceVersion;
            theServiceVersion = this.getServiceVersion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "serviceVersion", theServiceVersion), currentHashCode, theServiceVersion);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public ServiceInstanceType withProtocolBinding(String value) {
        setProtocolBinding(value);
        return this;
    }

    public ServiceInstanceType withAddress(String value) {
        setAddress(value);
        return this;
    }

    public ServiceInstanceType withMessageBindings(String... values) {
        if (values!= null) {
            for (String value: values) {
                getMessageBindings().add(value);
            }
        }
        return this;
    }

    public ServiceInstanceType withMessageBindings(Collection<String> values) {
        if (values!= null) {
            getMessageBindings().addAll(values);
        }
        return this;
    }

    public ServiceInstanceType withContentBindings(String... values) {
        if (values!= null) {
            for (String value: values) {
                getContentBindings().add(value);
            }
        }
        return this;
    }

    public ServiceInstanceType withContentBindings(Collection<String> values) {
        if (values!= null) {
            getContentBindings().addAll(values);
        }
        return this;
    }

    public ServiceInstanceType withMessage(String value) {
        setMessage(value);
        return this;
    }

    public ServiceInstanceType withServiceType(ServiceTypeEnum value) {
        setServiceType(value);
        return this;
    }

    public ServiceInstanceType withAvailable(Boolean value) {
        setAvailable(value);
        return this;
    }

    public ServiceInstanceType withServiceVersion(String value) {
        setServiceVersion(value);
        return this;
    }

}
