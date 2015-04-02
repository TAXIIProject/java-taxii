
package org.mitre.taxii.messages.xml10;

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
 * Information on the protocols and message types that can be used to push content from a TAXII Data Feed.
 * 
 * <p>Java class for PushMethodType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PushMethodType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Protocol_Binding" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *         &lt;element name="Message_Binding" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PushMethodType", propOrder = {
    "protocolBinding",
    "messageBindings"
})
public class PushMethodType implements Equals, HashCode
{

    @XmlElement(name = "Protocol_Binding", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String protocolBinding;
    @XmlElement(name = "Message_Binding", required = true)
    @XmlSchemaType(name = "anyURI")
    protected List<String> messageBindings;

    /**
     * Default no-arg constructor
     * 
     */
    public PushMethodType() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public PushMethodType(final String protocolBinding, final List<String> messageBindings) {
        this.protocolBinding = protocolBinding;
        this.messageBindings = messageBindings;
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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PushMethodType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PushMethodType that = ((PushMethodType) object);
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
            List<String> lhsMessageBindings;
            lhsMessageBindings = (((this.messageBindings!= null)&&(!this.messageBindings.isEmpty()))?this.getMessageBindings():null);
            List<String> rhsMessageBindings;
            rhsMessageBindings = (((that.messageBindings!= null)&&(!that.messageBindings.isEmpty()))?that.getMessageBindings():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "messageBindings", lhsMessageBindings), LocatorUtils.property(thatLocator, "messageBindings", rhsMessageBindings), lhsMessageBindings, rhsMessageBindings)) {
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
            List<String> theMessageBindings;
            theMessageBindings = (((this.messageBindings!= null)&&(!this.messageBindings.isEmpty()))?this.getMessageBindings():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "messageBindings", theMessageBindings), currentHashCode, theMessageBindings);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public PushMethodType withProtocolBinding(String value) {
        setProtocolBinding(value);
        return this;
    }

    public PushMethodType withMessageBindings(String... values) {
        if (values!= null) {
            for (String value: values) {
                getMessageBindings().add(value);
            }
        }
        return this;
    }

    public PushMethodType withMessageBindings(Collection<String> values) {
        if (values!= null) {
            getMessageBindings().addAll(values);
        }
        return this;
    }

}
