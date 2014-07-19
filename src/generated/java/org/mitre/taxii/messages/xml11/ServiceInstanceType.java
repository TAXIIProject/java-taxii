
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
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
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
 * &lt;complexType name="ServiceInstanceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}BindingsGroup"/>
 *         &lt;element name="Supported_Query" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}SupportedQueryType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Content_Binding" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}ContentBindingIDType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="service_type" use="required" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}ServiceTypeEnum" />
 *       &lt;attribute name="available" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="service_version" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceInstanceType", propOrder = {
    "protocolBinding",
    "address",
    "messageBinding",
    "supportedQuery",
    "contentBinding",
    "message"
})
public class ServiceInstanceType
    implements Equals
{

    @XmlElement(name = "Protocol_Binding", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String protocolBinding;
    @XmlElement(name = "Address", required = true)
    protected String address;
    @XmlElement(name = "Message_Binding", required = true)
    @XmlSchemaType(name = "anyURI")
    protected List<String> messageBinding;
    @XmlElement(name = "Supported_Query")
    protected List<SupportedQueryType> supportedQuery;
    @XmlElement(name = "Content_Binding")
    protected List<ContentBindingIDType> contentBinding;
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
     * Gets the value of the messageBinding property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messageBinding property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessageBinding().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMessageBinding() {
        if (messageBinding == null) {
            messageBinding = new ArrayList<String>();
        }
        return this.messageBinding;
    }

    /**
     * Gets the value of the supportedQuery property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedQuery property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedQuery().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupportedQueryType }
     * 
     * 
     */
    public List<SupportedQueryType> getSupportedQuery() {
        if (supportedQuery == null) {
            supportedQuery = new ArrayList<SupportedQueryType>();
        }
        return this.supportedQuery;
    }

    /**
     * Gets the value of the contentBinding property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contentBinding property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContentBinding().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContentBindingIDType }
     * 
     * 
     */
    public List<ContentBindingIDType> getContentBinding() {
        if (contentBinding == null) {
            contentBinding = new ArrayList<ContentBindingIDType>();
        }
        return this.contentBinding;
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
            List<String> lhsMessageBinding;
            lhsMessageBinding = (((this.messageBinding!= null)&&(!this.messageBinding.isEmpty()))?this.getMessageBinding():null);
            List<String> rhsMessageBinding;
            rhsMessageBinding = (((that.messageBinding!= null)&&(!that.messageBinding.isEmpty()))?that.getMessageBinding():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "messageBinding", lhsMessageBinding), LocatorUtils.property(thatLocator, "messageBinding", rhsMessageBinding), lhsMessageBinding, rhsMessageBinding)) {
                return false;
            }
        }
        {
            List<SupportedQueryType> lhsSupportedQuery;
            lhsSupportedQuery = (((this.supportedQuery!= null)&&(!this.supportedQuery.isEmpty()))?this.getSupportedQuery():null);
            List<SupportedQueryType> rhsSupportedQuery;
            rhsSupportedQuery = (((that.supportedQuery!= null)&&(!that.supportedQuery.isEmpty()))?that.getSupportedQuery():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "supportedQuery", lhsSupportedQuery), LocatorUtils.property(thatLocator, "supportedQuery", rhsSupportedQuery), lhsSupportedQuery, rhsSupportedQuery)) {
                return false;
            }
        }
        {
            List<ContentBindingIDType> lhsContentBinding;
            lhsContentBinding = (((this.contentBinding!= null)&&(!this.contentBinding.isEmpty()))?this.getContentBinding():null);
            List<ContentBindingIDType> rhsContentBinding;
            rhsContentBinding = (((that.contentBinding!= null)&&(!that.contentBinding.isEmpty()))?that.getContentBinding():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contentBinding", lhsContentBinding), LocatorUtils.property(thatLocator, "contentBinding", rhsContentBinding), lhsContentBinding, rhsContentBinding)) {
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

}
