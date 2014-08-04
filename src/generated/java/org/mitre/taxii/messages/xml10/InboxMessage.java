
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
 * Push message to exchange content.
 * 
 * <p>Java class for TAXIIInboxMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAXIIInboxMessageType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://taxii.mitre.org/messages/taxii_xml_binding-1}RequestMessageType">
 *       &lt;sequence>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Source_Subscription" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1}SourceSubscriptionType" minOccurs="0"/>
 *         &lt;element name="Content_Block" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1}ContentBlockType" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "TAXIIInboxMessageType", propOrder = {
    "message",
    "sourceSubscription",
    "contentBlocks",
    "signature"
})
@XmlRootElement(name = "Inbox_Message")
public class InboxMessage
    extends RequestMessageType
    implements Equals, HashCode
{

    @XmlElement(name = "Message")
    protected String message;
    @XmlElement(name = "Source_Subscription")
    protected SourceSubscriptionType sourceSubscription;
    @XmlElement(name = "Content_Block")
    protected List<ContentBlockType> contentBlocks;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected Signature signature;

    /**
     * Default no-arg constructor
     * 
     */
    public InboxMessage() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public InboxMessage(final ExtendedHeadersType extendedHeaders, final String messageId, final String message, final SourceSubscriptionType sourceSubscription, final List<ContentBlockType> contentBlocks, final Signature signature) {
        super(extendedHeaders, messageId);
        this.message = message;
        this.sourceSubscription = sourceSubscription;
        this.contentBlocks = contentBlocks;
        this.signature = signature;
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
     * Gets the value of the sourceSubscription property.
     * 
     * @return
     *     possible object is
     *     {@link SourceSubscriptionType }
     *     
     */
    public SourceSubscriptionType getSourceSubscription() {
        return sourceSubscription;
    }

    /**
     * Sets the value of the sourceSubscription property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceSubscriptionType }
     *     
     */
    public void setSourceSubscription(SourceSubscriptionType value) {
        this.sourceSubscription = value;
    }

    /**
     * Gets the value of the contentBlocks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contentBlocks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContentBlocks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContentBlockType }
     * 
     * 
     */
    public List<ContentBlockType> getContentBlocks() {
        if (contentBlocks == null) {
            contentBlocks = new ArrayList<ContentBlockType>();
        }
        return this.contentBlocks;
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
        if (!(object instanceof InboxMessage)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final InboxMessage that = ((InboxMessage) object);
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
            SourceSubscriptionType lhsSourceSubscription;
            lhsSourceSubscription = this.getSourceSubscription();
            SourceSubscriptionType rhsSourceSubscription;
            rhsSourceSubscription = that.getSourceSubscription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sourceSubscription", lhsSourceSubscription), LocatorUtils.property(thatLocator, "sourceSubscription", rhsSourceSubscription), lhsSourceSubscription, rhsSourceSubscription)) {
                return false;
            }
        }
        {
            List<ContentBlockType> lhsContentBlocks;
            lhsContentBlocks = (((this.contentBlocks!= null)&&(!this.contentBlocks.isEmpty()))?this.getContentBlocks():null);
            List<ContentBlockType> rhsContentBlocks;
            rhsContentBlocks = (((that.contentBlocks!= null)&&(!that.contentBlocks.isEmpty()))?that.getContentBlocks():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contentBlocks", lhsContentBlocks), LocatorUtils.property(thatLocator, "contentBlocks", rhsContentBlocks), lhsContentBlocks, rhsContentBlocks)) {
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
            String theMessage;
            theMessage = this.getMessage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "message", theMessage), currentHashCode, theMessage);
        }
        {
            SourceSubscriptionType theSourceSubscription;
            theSourceSubscription = this.getSourceSubscription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sourceSubscription", theSourceSubscription), currentHashCode, theSourceSubscription);
        }
        {
            List<ContentBlockType> theContentBlocks;
            theContentBlocks = (((this.contentBlocks!= null)&&(!this.contentBlocks.isEmpty()))?this.getContentBlocks():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contentBlocks", theContentBlocks), currentHashCode, theContentBlocks);
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

    public InboxMessage withMessage(String value) {
        setMessage(value);
        return this;
    }

    public InboxMessage withSourceSubscription(SourceSubscriptionType value) {
        setSourceSubscription(value);
        return this;
    }

    public InboxMessage withContentBlocks(ContentBlockType... values) {
        if (values!= null) {
            for (ContentBlockType value: values) {
                getContentBlocks().add(value);
            }
        }
        return this;
    }

    public InboxMessage withContentBlocks(Collection<ContentBlockType> values) {
        if (values!= null) {
            getContentBlocks().addAll(values);
        }
        return this;
    }

    public InboxMessage withSignature(Signature value) {
        setSignature(value);
        return this;
    }

    @Override
    public InboxMessage withExtendedHeaders(ExtendedHeadersType value) {
        setExtendedHeaders(value);
        return this;
    }

    @Override
    public InboxMessage withMessageId(String value) {
        setMessageId(value);
        return this;
    }

}
