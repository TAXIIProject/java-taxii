
package org.mitre.taxii.messages.xml10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
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
 * Type for the Poll Response Messages.
 * 
 * <p>Java class for TAXIIPollResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAXIIPollResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://taxii.mitre.org/messages/taxii_xml_binding-1}ResponseMessageType">
 *       &lt;sequence>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Inclusive_Begin_Timestamp" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1}TimestampLabelType" minOccurs="0"/>
 *         &lt;element name="Inclusive_End_Timestamp" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1}TimestampLabelType"/>
 *         &lt;element name="Content_Block" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1}ContentBlockType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="feed_name" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="subscription_id" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAXIIPollResponseType", propOrder = {
    "message",
    "inclusiveBeginTimestamp",
    "inclusiveEndTimestamp",
    "contentBlocks",
    "signature"
})
@XmlRootElement(name = "Poll_Response")
public class PollResponse
    extends ResponseMessageType
    implements Equals, HashCode
{

    @XmlElement(name = "Message")
    protected String message;
    @XmlElement(name = "Inclusive_Begin_Timestamp")
    protected XMLGregorianCalendar inclusiveBeginTimestamp;
    @XmlElement(name = "Inclusive_End_Timestamp", required = true)
    protected XMLGregorianCalendar inclusiveEndTimestamp;
    @XmlElement(name = "Content_Block")
    protected List<ContentBlockType> contentBlocks;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected Signature signature;
    @XmlAttribute(name = "feed_name", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String feedName;
    @XmlAttribute(name = "subscription_id")
    @XmlSchemaType(name = "anyURI")
    protected String subscriptionId;

    /**
     * Default no-arg constructor
     * 
     */
    public PollResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public PollResponse(final ExtendedHeadersType extendedHeaders, final String messageId, final String inResponseTo, final String message, final XMLGregorianCalendar inclusiveBeginTimestamp, final XMLGregorianCalendar inclusiveEndTimestamp, final List<ContentBlockType> contentBlocks, final Signature signature, final String feedName, final String subscriptionId) {
        super(extendedHeaders, messageId, inResponseTo);
        this.message = message;
        this.inclusiveBeginTimestamp = inclusiveBeginTimestamp;
        this.inclusiveEndTimestamp = inclusiveEndTimestamp;
        this.contentBlocks = contentBlocks;
        this.signature = signature;
        this.feedName = feedName;
        this.subscriptionId = subscriptionId;
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
     * Gets the value of the inclusiveBeginTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInclusiveBeginTimestamp() {
        return inclusiveBeginTimestamp;
    }

    /**
     * Sets the value of the inclusiveBeginTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInclusiveBeginTimestamp(XMLGregorianCalendar value) {
        this.inclusiveBeginTimestamp = value;
    }

    /**
     * Gets the value of the inclusiveEndTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInclusiveEndTimestamp() {
        return inclusiveEndTimestamp;
    }

    /**
     * Sets the value of the inclusiveEndTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInclusiveEndTimestamp(XMLGregorianCalendar value) {
        this.inclusiveEndTimestamp = value;
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

    /**
     * Gets the value of the feedName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeedName() {
        return feedName;
    }

    /**
     * Sets the value of the feedName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeedName(String value) {
        this.feedName = value;
    }

    /**
     * Gets the value of the subscriptionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * Sets the value of the subscriptionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriptionId(String value) {
        this.subscriptionId = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PollResponse)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final PollResponse that = ((PollResponse) object);
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
            XMLGregorianCalendar lhsInclusiveBeginTimestamp;
            lhsInclusiveBeginTimestamp = this.getInclusiveBeginTimestamp();
            XMLGregorianCalendar rhsInclusiveBeginTimestamp;
            rhsInclusiveBeginTimestamp = that.getInclusiveBeginTimestamp();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "inclusiveBeginTimestamp", lhsInclusiveBeginTimestamp), LocatorUtils.property(thatLocator, "inclusiveBeginTimestamp", rhsInclusiveBeginTimestamp), lhsInclusiveBeginTimestamp, rhsInclusiveBeginTimestamp)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsInclusiveEndTimestamp;
            lhsInclusiveEndTimestamp = this.getInclusiveEndTimestamp();
            XMLGregorianCalendar rhsInclusiveEndTimestamp;
            rhsInclusiveEndTimestamp = that.getInclusiveEndTimestamp();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "inclusiveEndTimestamp", lhsInclusiveEndTimestamp), LocatorUtils.property(thatLocator, "inclusiveEndTimestamp", rhsInclusiveEndTimestamp), lhsInclusiveEndTimestamp, rhsInclusiveEndTimestamp)) {
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
        {
            String lhsFeedName;
            lhsFeedName = this.getFeedName();
            String rhsFeedName;
            rhsFeedName = that.getFeedName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "feedName", lhsFeedName), LocatorUtils.property(thatLocator, "feedName", rhsFeedName), lhsFeedName, rhsFeedName)) {
                return false;
            }
        }
        {
            String lhsSubscriptionId;
            lhsSubscriptionId = this.getSubscriptionId();
            String rhsSubscriptionId;
            rhsSubscriptionId = that.getSubscriptionId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "subscriptionId", lhsSubscriptionId), LocatorUtils.property(thatLocator, "subscriptionId", rhsSubscriptionId), lhsSubscriptionId, rhsSubscriptionId)) {
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
            XMLGregorianCalendar theInclusiveBeginTimestamp;
            theInclusiveBeginTimestamp = this.getInclusiveBeginTimestamp();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inclusiveBeginTimestamp", theInclusiveBeginTimestamp), currentHashCode, theInclusiveBeginTimestamp);
        }
        {
            XMLGregorianCalendar theInclusiveEndTimestamp;
            theInclusiveEndTimestamp = this.getInclusiveEndTimestamp();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inclusiveEndTimestamp", theInclusiveEndTimestamp), currentHashCode, theInclusiveEndTimestamp);
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
        {
            String theFeedName;
            theFeedName = this.getFeedName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "feedName", theFeedName), currentHashCode, theFeedName);
        }
        {
            String theSubscriptionId;
            theSubscriptionId = this.getSubscriptionId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "subscriptionId", theSubscriptionId), currentHashCode, theSubscriptionId);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public PollResponse withMessage(String value) {
        setMessage(value);
        return this;
    }

    public PollResponse withInclusiveBeginTimestamp(XMLGregorianCalendar value) {
        setInclusiveBeginTimestamp(value);
        return this;
    }

    public PollResponse withInclusiveEndTimestamp(XMLGregorianCalendar value) {
        setInclusiveEndTimestamp(value);
        return this;
    }

    public PollResponse withContentBlocks(ContentBlockType... values) {
        if (values!= null) {
            for (ContentBlockType value: values) {
                getContentBlocks().add(value);
            }
        }
        return this;
    }

    public PollResponse withContentBlocks(Collection<ContentBlockType> values) {
        if (values!= null) {
            getContentBlocks().addAll(values);
        }
        return this;
    }

    public PollResponse withSignature(Signature value) {
        setSignature(value);
        return this;
    }

    public PollResponse withFeedName(String value) {
        setFeedName(value);
        return this;
    }

    public PollResponse withSubscriptionId(String value) {
        setSubscriptionId(value);
        return this;
    }

    @Override
    public PollResponse withInResponseTo(String value) {
        setInResponseTo(value);
        return this;
    }

    @Override
    public PollResponse withExtendedHeaders(ExtendedHeadersType value) {
        setExtendedHeaders(value);
        return this;
    }

    @Override
    public PollResponse withMessageId(String value) {
        setMessageId(value);
        return this;
    }

}
