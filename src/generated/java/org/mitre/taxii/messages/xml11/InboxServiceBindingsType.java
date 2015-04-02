
package org.mitre.taxii.messages.xml11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * Contains binding information for an Inbox Service
 * 
 * <p>Java class for InboxServiceBindingsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InboxServiceBindingsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;group ref="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}BindingsGroup"/&gt;
 *         &lt;element name="Content_Binding" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}ContentBindingIDType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InboxServiceBindingsType", propOrder = {
    "protocolBinding",
    "address",
    "messageBindings",
    "contentBindings"
})
public class InboxServiceBindingsType implements Equals, HashCode
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
    protected List<ContentBindingIDType> contentBindings;

    /**
     * Default no-arg constructor
     * 
     */
    public InboxServiceBindingsType() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public InboxServiceBindingsType(final String protocolBinding, final String address, final List<String> messageBindings, final List<ContentBindingIDType> contentBindings) {
        this.protocolBinding = protocolBinding;
        this.address = address;
        this.messageBindings = messageBindings;
        this.contentBindings = contentBindings;
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
     * {@link ContentBindingIDType }
     * 
     * 
     */
    public List<ContentBindingIDType> getContentBindings() {
        if (contentBindings == null) {
            contentBindings = new ArrayList<ContentBindingIDType>();
        }
        return this.contentBindings;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof InboxServiceBindingsType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final InboxServiceBindingsType that = ((InboxServiceBindingsType) object);
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
            List<ContentBindingIDType> lhsContentBindings;
            lhsContentBindings = (((this.contentBindings!= null)&&(!this.contentBindings.isEmpty()))?this.getContentBindings():null);
            List<ContentBindingIDType> rhsContentBindings;
            rhsContentBindings = (((that.contentBindings!= null)&&(!that.contentBindings.isEmpty()))?that.getContentBindings():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contentBindings", lhsContentBindings), LocatorUtils.property(thatLocator, "contentBindings", rhsContentBindings), lhsContentBindings, rhsContentBindings)) {
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
            List<ContentBindingIDType> theContentBindings;
            theContentBindings = (((this.contentBindings!= null)&&(!this.contentBindings.isEmpty()))?this.getContentBindings():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contentBindings", theContentBindings), currentHashCode, theContentBindings);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public InboxServiceBindingsType withProtocolBinding(String value) {
        setProtocolBinding(value);
        return this;
    }

    public InboxServiceBindingsType withAddress(String value) {
        setAddress(value);
        return this;
    }

    public InboxServiceBindingsType withMessageBindings(String... values) {
        if (values!= null) {
            for (String value: values) {
                getMessageBindings().add(value);
            }
        }
        return this;
    }

    public InboxServiceBindingsType withMessageBindings(Collection<String> values) {
        if (values!= null) {
            getMessageBindings().addAll(values);
        }
        return this;
    }

    public InboxServiceBindingsType withContentBindings(ContentBindingIDType... values) {
        if (values!= null) {
            for (ContentBindingIDType value: values) {
                getContentBindings().add(value);
            }
        }
        return this;
    }

    public InboxServiceBindingsType withContentBindings(Collection<ContentBindingIDType> values) {
        if (values!= null) {
            getContentBindings().addAll(values);
        }
        return this;
    }

}
