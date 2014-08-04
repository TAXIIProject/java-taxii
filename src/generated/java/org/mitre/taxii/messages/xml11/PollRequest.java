
package org.mitre.taxii.messages.xml11;

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
 * A request to Poll a data collection.
 * 
 * <p>Java class for TAXIIPollRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAXIIPollRequestType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}RequestMessageType">
 *       &lt;sequence>
 *         &lt;element name="Exclusive_Begin_Timestamp" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}TimestampLabelType" minOccurs="0"/>
 *         &lt;element name="Inclusive_End_Timestamp" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}TimestampLabelType" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="Subscription_ID" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *           &lt;element name="Poll_Parameters" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}PollParametersType"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="collection_name" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAXIIPollRequestType", propOrder = {
    "exclusiveBeginTimestamp",
    "inclusiveEndTimestamp",
    "pollParameters",
    "subscriptionID",
    "signature"
})
@XmlRootElement(name = "Poll_Request")
public class PollRequest
    extends RequestMessageType
    implements Equals, HashCode
{

    @XmlElement(name = "Exclusive_Begin_Timestamp")
    protected XMLGregorianCalendar exclusiveBeginTimestamp;
    @XmlElement(name = "Inclusive_End_Timestamp")
    protected XMLGregorianCalendar inclusiveEndTimestamp;
    @XmlElement(name = "Poll_Parameters")
    protected PollParametersType pollParameters;
    @XmlElement(name = "Subscription_ID")
    @XmlSchemaType(name = "anyURI")
    protected String subscriptionID;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected Signature signature;
    @XmlAttribute(name = "collection_name", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String collectionName;

    /**
     * Default no-arg constructor
     * 
     */
    public PollRequest() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public PollRequest(final ExtendedHeadersType extendedHeaders, final String messageId, final XMLGregorianCalendar exclusiveBeginTimestamp, final XMLGregorianCalendar inclusiveEndTimestamp, final PollParametersType pollParameters, final String subscriptionID, final Signature signature, final String collectionName) {
        super(extendedHeaders, messageId);
        this.exclusiveBeginTimestamp = exclusiveBeginTimestamp;
        this.inclusiveEndTimestamp = inclusiveEndTimestamp;
        this.pollParameters = pollParameters;
        this.subscriptionID = subscriptionID;
        this.signature = signature;
        this.collectionName = collectionName;
    }

    /**
     * Gets the value of the exclusiveBeginTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExclusiveBeginTimestamp() {
        return exclusiveBeginTimestamp;
    }

    /**
     * Sets the value of the exclusiveBeginTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExclusiveBeginTimestamp(XMLGregorianCalendar value) {
        this.exclusiveBeginTimestamp = value;
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
     * Gets the value of the pollParameters property.
     * 
     * @return
     *     possible object is
     *     {@link PollParametersType }
     *     
     */
    public PollParametersType getPollParameters() {
        return pollParameters;
    }

    /**
     * Sets the value of the pollParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link PollParametersType }
     *     
     */
    public void setPollParameters(PollParametersType value) {
        this.pollParameters = value;
    }

    /**
     * Gets the value of the subscriptionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriptionID() {
        return subscriptionID;
    }

    /**
     * Sets the value of the subscriptionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriptionID(String value) {
        this.subscriptionID = value;
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
     * Gets the value of the collectionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollectionName() {
        return collectionName;
    }

    /**
     * Sets the value of the collectionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollectionName(String value) {
        this.collectionName = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PollRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final PollRequest that = ((PollRequest) object);
        {
            XMLGregorianCalendar lhsExclusiveBeginTimestamp;
            lhsExclusiveBeginTimestamp = this.getExclusiveBeginTimestamp();
            XMLGregorianCalendar rhsExclusiveBeginTimestamp;
            rhsExclusiveBeginTimestamp = that.getExclusiveBeginTimestamp();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "exclusiveBeginTimestamp", lhsExclusiveBeginTimestamp), LocatorUtils.property(thatLocator, "exclusiveBeginTimestamp", rhsExclusiveBeginTimestamp), lhsExclusiveBeginTimestamp, rhsExclusiveBeginTimestamp)) {
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
            PollParametersType lhsPollParameters;
            lhsPollParameters = this.getPollParameters();
            PollParametersType rhsPollParameters;
            rhsPollParameters = that.getPollParameters();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pollParameters", lhsPollParameters), LocatorUtils.property(thatLocator, "pollParameters", rhsPollParameters), lhsPollParameters, rhsPollParameters)) {
                return false;
            }
        }
        {
            String lhsSubscriptionID;
            lhsSubscriptionID = this.getSubscriptionID();
            String rhsSubscriptionID;
            rhsSubscriptionID = that.getSubscriptionID();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "subscriptionID", lhsSubscriptionID), LocatorUtils.property(thatLocator, "subscriptionID", rhsSubscriptionID), lhsSubscriptionID, rhsSubscriptionID)) {
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
            String lhsCollectionName;
            lhsCollectionName = this.getCollectionName();
            String rhsCollectionName;
            rhsCollectionName = that.getCollectionName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "collectionName", lhsCollectionName), LocatorUtils.property(thatLocator, "collectionName", rhsCollectionName), lhsCollectionName, rhsCollectionName)) {
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
            XMLGregorianCalendar theExclusiveBeginTimestamp;
            theExclusiveBeginTimestamp = this.getExclusiveBeginTimestamp();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "exclusiveBeginTimestamp", theExclusiveBeginTimestamp), currentHashCode, theExclusiveBeginTimestamp);
        }
        {
            XMLGregorianCalendar theInclusiveEndTimestamp;
            theInclusiveEndTimestamp = this.getInclusiveEndTimestamp();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inclusiveEndTimestamp", theInclusiveEndTimestamp), currentHashCode, theInclusiveEndTimestamp);
        }
        {
            PollParametersType thePollParameters;
            thePollParameters = this.getPollParameters();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pollParameters", thePollParameters), currentHashCode, thePollParameters);
        }
        {
            String theSubscriptionID;
            theSubscriptionID = this.getSubscriptionID();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "subscriptionID", theSubscriptionID), currentHashCode, theSubscriptionID);
        }
        {
            Signature theSignature;
            theSignature = this.getSignature();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signature", theSignature), currentHashCode, theSignature);
        }
        {
            String theCollectionName;
            theCollectionName = this.getCollectionName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "collectionName", theCollectionName), currentHashCode, theCollectionName);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public PollRequest withExclusiveBeginTimestamp(XMLGregorianCalendar value) {
        setExclusiveBeginTimestamp(value);
        return this;
    }

    public PollRequest withInclusiveEndTimestamp(XMLGregorianCalendar value) {
        setInclusiveEndTimestamp(value);
        return this;
    }

    public PollRequest withPollParameters(PollParametersType value) {
        setPollParameters(value);
        return this;
    }

    public PollRequest withSubscriptionID(String value) {
        setSubscriptionID(value);
        return this;
    }

    public PollRequest withSignature(Signature value) {
        setSignature(value);
        return this;
    }

    public PollRequest withCollectionName(String value) {
        setCollectionName(value);
        return this;
    }

    @Override
    public PollRequest withExtendedHeaders(ExtendedHeadersType value) {
        setExtendedHeaders(value);
        return this;
    }

    @Override
    public PollRequest withMessageId(String value) {
        setMessageId(value);
        return this;
    }

}
