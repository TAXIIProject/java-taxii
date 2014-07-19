
package org.mitre.taxii.messages.xml11;

import java.math.BigInteger;
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
 * A record for a data collection.
 * 
 * <p>Java class for CollectionRecordType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CollectionRecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Collection_Volume" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="Content_Binding" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}ContentBindingIDType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Push_Method" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}PushMethodType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Polling_Service" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}ServiceContactInfoType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Subscription_Service" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}ServiceContactInfoType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Receiving_Inbox_Service" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}InboxServiceBindingsType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="collection_name" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="collection_type" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}CollectionTypeEnum" default="DATA_FEED" />
 *       &lt;attribute name="available" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CollectionRecordType", propOrder = {
    "description",
    "collectionVolume",
    "contentBindings",
    "pushMethods",
    "pollingServices",
    "subscriptionServices",
    "receivingInboxServices"
})
public class CollectionRecordType
    implements Equals, HashCode
{

    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "Collection_Volume")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger collectionVolume;
    @XmlElement(name = "Content_Binding")
    protected List<ContentBindingIDType> contentBindings;
    @XmlElement(name = "Push_Method")
    protected List<PushMethodType> pushMethods;
    @XmlElement(name = "Polling_Service")
    protected List<ServiceContactInfoType> pollingServices;
    @XmlElement(name = "Subscription_Service")
    protected List<ServiceContactInfoType> subscriptionServices;
    @XmlElement(name = "Receiving_Inbox_Service")
    protected List<InboxServiceBindingsType> receivingInboxServices;
    @XmlAttribute(name = "collection_name", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String collectionName;
    @XmlAttribute(name = "collection_type")
    protected CollectionTypeEnum collectionType;
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
     * Gets the value of the collectionVolume property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCollectionVolume() {
        return collectionVolume;
    }

    /**
     * Sets the value of the collectionVolume property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCollectionVolume(BigInteger value) {
        this.collectionVolume = value;
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
     * Gets the value of the receivingInboxServices property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the receivingInboxServices property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReceivingInboxServices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InboxServiceBindingsType }
     * 
     * 
     */
    public List<InboxServiceBindingsType> getReceivingInboxServices() {
        if (receivingInboxServices == null) {
            receivingInboxServices = new ArrayList<InboxServiceBindingsType>();
        }
        return this.receivingInboxServices;
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

    /**
     * Gets the value of the collectionType property.
     * 
     * @return
     *     possible object is
     *     {@link CollectionTypeEnum }
     *     
     */
    public CollectionTypeEnum getCollectionType() {
        if (collectionType == null) {
            return CollectionTypeEnum.DATA_FEED;
        } else {
            return collectionType;
        }
    }

    /**
     * Sets the value of the collectionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CollectionTypeEnum }
     *     
     */
    public void setCollectionType(CollectionTypeEnum value) {
        this.collectionType = value;
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
        if (!(object instanceof CollectionRecordType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CollectionRecordType that = ((CollectionRecordType) object);
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
            BigInteger lhsCollectionVolume;
            lhsCollectionVolume = this.getCollectionVolume();
            BigInteger rhsCollectionVolume;
            rhsCollectionVolume = that.getCollectionVolume();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "collectionVolume", lhsCollectionVolume), LocatorUtils.property(thatLocator, "collectionVolume", rhsCollectionVolume), lhsCollectionVolume, rhsCollectionVolume)) {
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
            List<InboxServiceBindingsType> lhsReceivingInboxServices;
            lhsReceivingInboxServices = (((this.receivingInboxServices!= null)&&(!this.receivingInboxServices.isEmpty()))?this.getReceivingInboxServices():null);
            List<InboxServiceBindingsType> rhsReceivingInboxServices;
            rhsReceivingInboxServices = (((that.receivingInboxServices!= null)&&(!that.receivingInboxServices.isEmpty()))?that.getReceivingInboxServices():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "receivingInboxServices", lhsReceivingInboxServices), LocatorUtils.property(thatLocator, "receivingInboxServices", rhsReceivingInboxServices), lhsReceivingInboxServices, rhsReceivingInboxServices)) {
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
        {
            CollectionTypeEnum lhsCollectionType;
            lhsCollectionType = this.getCollectionType();
            CollectionTypeEnum rhsCollectionType;
            rhsCollectionType = that.getCollectionType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "collectionType", lhsCollectionType), LocatorUtils.property(thatLocator, "collectionType", rhsCollectionType), lhsCollectionType, rhsCollectionType)) {
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
            BigInteger theCollectionVolume;
            theCollectionVolume = this.getCollectionVolume();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "collectionVolume", theCollectionVolume), currentHashCode, theCollectionVolume);
        }
        {
            List<ContentBindingIDType> theContentBindings;
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
            List<InboxServiceBindingsType> theReceivingInboxServices;
            theReceivingInboxServices = (((this.receivingInboxServices!= null)&&(!this.receivingInboxServices.isEmpty()))?this.getReceivingInboxServices():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "receivingInboxServices", theReceivingInboxServices), currentHashCode, theReceivingInboxServices);
        }
        {
            String theCollectionName;
            theCollectionName = this.getCollectionName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "collectionName", theCollectionName), currentHashCode, theCollectionName);
        }
        {
            CollectionTypeEnum theCollectionType;
            theCollectionType = this.getCollectionType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "collectionType", theCollectionType), currentHashCode, theCollectionType);
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
