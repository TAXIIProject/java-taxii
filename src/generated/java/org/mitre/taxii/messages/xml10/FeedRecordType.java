
package org.mitre.taxii.messages.xml10;

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
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * A record for a data feed.
 * 
 * <p>Java class for FeedRecordType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedRecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Content_Binding" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="Push_Method" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1}PushMethodType" maxOccurs="unbounded"/>
 *             &lt;element name="Polling_Service" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1}ServiceContactInfoType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;element name="Polling_Service" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1}ServiceContactInfoType" maxOccurs="unbounded"/>
 *         &lt;/choice>
 *         &lt;element name="Subscription_Service" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1}ServiceContactInfoType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="feed_name" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="available" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedRecordType", propOrder = {
    "description",
    "contentBindings",
    "pushMethods",
    "pollingServices",
    "subscriptionServices"
})
public class FeedRecordType
    implements Equals, HashCode
{

    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "Content_Binding", required = true)
    @XmlSchemaType(name = "anyURI")
    protected List<String> contentBindings;
    @XmlElement(name = "Push_Method")
    protected List<PushMethodType> pushMethods;
    @XmlElement(name = "Polling_Service")
    protected List<ServiceContactInfoType> pollingServices;
    @XmlElement(name = "Subscription_Service")
    protected List<ServiceContactInfoType> subscriptionServices;
    @XmlAttribute(name = "feed_name", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String feedName;
    @XmlAttribute(name = "available")
    protected Boolean available;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
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
     * Gets the value of the pushMethods property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pushMethods property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPushMethods().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PushMethodType }
     * 
     * 
     */
    public List<PushMethodType> getPushMethods() {
        if (pushMethods == null) {
            pushMethods = new ArrayList<PushMethodType>();
        }
        return this.pushMethods;
    }

    /**
     * Gets the value of the pollingServices property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pollingServices property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPollingServices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceContactInfoType }
     * 
     * 
     */
    public List<ServiceContactInfoType> getPollingServices() {
        if (pollingServices == null) {
            pollingServices = new ArrayList<ServiceContactInfoType>();
        }
        return this.pollingServices;
    }

    /**
     * Gets the value of the subscriptionServices property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subscriptionServices property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubscriptionServices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceContactInfoType }
     * 
     * 
     */
    public List<ServiceContactInfoType> getSubscriptionServices() {
        if (subscriptionServices == null) {
            subscriptionServices = new ArrayList<ServiceContactInfoType>();
        }
        return this.subscriptionServices;
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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FeedRecordType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final FeedRecordType that = ((FeedRecordType) object);
        {
            String lhsDescription;
            lhsDescription = this.getDescription();
            String rhsDescription;
            rhsDescription = that.getDescription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "description", lhsDescription), LocatorUtils.property(thatLocator, "description", rhsDescription), lhsDescription, rhsDescription)) {
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
            List<PushMethodType> lhsPushMethods;
            lhsPushMethods = (((this.pushMethods!= null)&&(!this.pushMethods.isEmpty()))?this.getPushMethods():null);
            List<PushMethodType> rhsPushMethods;
            rhsPushMethods = (((that.pushMethods!= null)&&(!that.pushMethods.isEmpty()))?that.getPushMethods():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pushMethods", lhsPushMethods), LocatorUtils.property(thatLocator, "pushMethods", rhsPushMethods), lhsPushMethods, rhsPushMethods)) {
                return false;
            }
        }
        {
            List<ServiceContactInfoType> lhsPollingServices;
            lhsPollingServices = (((this.pollingServices!= null)&&(!this.pollingServices.isEmpty()))?this.getPollingServices():null);
            List<ServiceContactInfoType> rhsPollingServices;
            rhsPollingServices = (((that.pollingServices!= null)&&(!that.pollingServices.isEmpty()))?that.getPollingServices():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pollingServices", lhsPollingServices), LocatorUtils.property(thatLocator, "pollingServices", rhsPollingServices), lhsPollingServices, rhsPollingServices)) {
                return false;
            }
        }
        {
            List<ServiceContactInfoType> lhsSubscriptionServices;
            lhsSubscriptionServices = (((this.subscriptionServices!= null)&&(!this.subscriptionServices.isEmpty()))?this.getSubscriptionServices():null);
            List<ServiceContactInfoType> rhsSubscriptionServices;
            rhsSubscriptionServices = (((that.subscriptionServices!= null)&&(!that.subscriptionServices.isEmpty()))?that.getSubscriptionServices():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "subscriptionServices", lhsSubscriptionServices), LocatorUtils.property(thatLocator, "subscriptionServices", rhsSubscriptionServices), lhsSubscriptionServices, rhsSubscriptionServices)) {
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
            Boolean lhsAvailable;
            lhsAvailable = this.isAvailable();
            Boolean rhsAvailable;
            rhsAvailable = that.isAvailable();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "available", lhsAvailable), LocatorUtils.property(thatLocator, "available", rhsAvailable), lhsAvailable, rhsAvailable)) {
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
            String theDescription;
            theDescription = this.getDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "description", theDescription), currentHashCode, theDescription);
        }
        {
            List<String> theContentBindings;
            theContentBindings = (((this.contentBindings!= null)&&(!this.contentBindings.isEmpty()))?this.getContentBindings():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contentBindings", theContentBindings), currentHashCode, theContentBindings);
        }
        {
            List<PushMethodType> thePushMethods;
            thePushMethods = (((this.pushMethods!= null)&&(!this.pushMethods.isEmpty()))?this.getPushMethods():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pushMethods", thePushMethods), currentHashCode, thePushMethods);
        }
        {
            List<ServiceContactInfoType> thePollingServices;
            thePollingServices = (((this.pollingServices!= null)&&(!this.pollingServices.isEmpty()))?this.getPollingServices():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pollingServices", thePollingServices), currentHashCode, thePollingServices);
        }
        {
            List<ServiceContactInfoType> theSubscriptionServices;
            theSubscriptionServices = (((this.subscriptionServices!= null)&&(!this.subscriptionServices.isEmpty()))?this.getSubscriptionServices():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "subscriptionServices", theSubscriptionServices), currentHashCode, theSubscriptionServices);
        }
        {
            String theFeedName;
            theFeedName = this.getFeedName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "feedName", theFeedName), currentHashCode, theFeedName);
        }
        {
            Boolean theAvailable;
            theAvailable = this.isAvailable();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "available", theAvailable), currentHashCode, theAvailable);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
