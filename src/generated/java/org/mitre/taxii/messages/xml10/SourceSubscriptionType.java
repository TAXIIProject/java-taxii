
package org.mitre.taxii.messages.xml10;

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
 * Describes a subscription to a feed, and the portion of that feed that is being serviced by a message.
 * 
 * <p>Java class for SourceSubscriptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SourceSubscriptionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Inclusive_Begin_Timestamp" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1}TimestampLabelType" minOccurs="0"/>
 *         &lt;element name="Inclusive_End_Timestamp" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1}TimestampLabelType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="feed_name" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="subscription_id" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SourceSubscriptionType", propOrder = {
    "inclusiveBeginTimestamp",
    "inclusiveEndTimestamp"
})
public class SourceSubscriptionType
    implements Equals, HashCode
{

    @XmlElement(name = "Inclusive_Begin_Timestamp")
    protected XMLGregorianCalendar inclusiveBeginTimestamp;
    @XmlElement(name = "Inclusive_End_Timestamp", required = true)
    protected XMLGregorianCalendar inclusiveEndTimestamp;
    @XmlAttribute(name = "feed_name", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String feedName;
    @XmlAttribute(name = "subscription_id")
    @XmlSchemaType(name = "anyURI")
    protected String subscriptionId;

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
        if (!(object instanceof SourceSubscriptionType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SourceSubscriptionType that = ((SourceSubscriptionType) object);
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
        int currentHashCode = 1;
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

}
