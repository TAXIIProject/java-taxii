
package org.mitre.taxii.messages.xml11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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


/**
 * Describes a subscription to a collection, and the portion of that
 *                 collection that is being serviced by a message.
 * 
 * <p>Java class for SourceSubscriptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SourceSubscriptionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Subscription_ID" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *         &lt;element name="Exclusive_Begin_Timestamp" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}TimestampLabelType" minOccurs="0"/&gt;
 *         &lt;element name="Inclusive_End_Timestamp" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}TimestampLabelType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="collection_name" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SourceSubscriptionType", propOrder = {
    "subscriptionID",
    "exclusiveBeginTimestamp",
    "inclusiveEndTimestamp"
})
public class SourceSubscriptionType implements Equals, HashCode
{

    @XmlElement(name = "Subscription_ID", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String subscriptionID;
    @XmlElement(name = "Exclusive_Begin_Timestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar exclusiveBeginTimestamp;
    @XmlElement(name = "Inclusive_End_Timestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar inclusiveEndTimestamp;
    @XmlAttribute(name = "collection_name", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String collectionName;

    /**
     * Default no-arg constructor
     * 
     */
    public SourceSubscriptionType() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public SourceSubscriptionType(final String subscriptionID, final XMLGregorianCalendar exclusiveBeginTimestamp, final XMLGregorianCalendar inclusiveEndTimestamp, final String collectionName) {
        this.subscriptionID = subscriptionID;
        this.exclusiveBeginTimestamp = exclusiveBeginTimestamp;
        this.inclusiveEndTimestamp = inclusiveEndTimestamp;
        this.collectionName = collectionName;
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
        if (!(object instanceof SourceSubscriptionType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SourceSubscriptionType that = ((SourceSubscriptionType) object);
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
        int currentHashCode = 1;
        {
            String theSubscriptionID;
            theSubscriptionID = this.getSubscriptionID();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "subscriptionID", theSubscriptionID), currentHashCode, theSubscriptionID);
        }
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

    public SourceSubscriptionType withSubscriptionID(String value) {
        setSubscriptionID(value);
        return this;
    }

    public SourceSubscriptionType withExclusiveBeginTimestamp(XMLGregorianCalendar value) {
        setExclusiveBeginTimestamp(value);
        return this;
    }

    public SourceSubscriptionType withInclusiveEndTimestamp(XMLGregorianCalendar value) {
        setInclusiveEndTimestamp(value);
        return this;
    }

    public SourceSubscriptionType withCollectionName(String value) {
        setCollectionName(value);
        return this;
    }

}
