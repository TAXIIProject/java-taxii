
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
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
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
    "contentBinding",
    "pushMethod",
    "pollingService",
    "subscriptionService",
    "receivingInboxService"
})
public class CollectionRecordType
    implements Equals
{

    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "Collection_Volume")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger collectionVolume;
    @XmlElement(name = "Content_Binding")
    protected List<ContentBindingIDType> contentBinding;
    @XmlElement(name = "Push_Method")
    protected List<PushMethodType> pushMethod;
    @XmlElement(name = "Polling_Service")
    protected List<ServiceContactInfoType> pollingService;
    @XmlElement(name = "Subscription_Service")
    protected List<ServiceContactInfoType> subscriptionService;
    @XmlElement(name = "Receiving_Inbox_Service")
    protected List<InboxServiceBindingsType> receivingInboxService;
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
     * Gets the value of the pushMethod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pushMethod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPushMethod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PushMethodType }
     * 
     * 
     */
    public List<PushMethodType> getPushMethod() {
        if (pushMethod == null) {
            pushMethod = new ArrayList<PushMethodType>();
        }
        return this.pushMethod;
    }

    /**
     * Gets the value of the pollingService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pollingService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPollingService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceContactInfoType }
     * 
     * 
     */
    public List<ServiceContactInfoType> getPollingService() {
        if (pollingService == null) {
            pollingService = new ArrayList<ServiceContactInfoType>();
        }
        return this.pollingService;
    }

    /**
     * Gets the value of the subscriptionService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subscriptionService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubscriptionService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceContactInfoType }
     * 
     * 
     */
    public List<ServiceContactInfoType> getSubscriptionService() {
        if (subscriptionService == null) {
            subscriptionService = new ArrayList<ServiceContactInfoType>();
        }
        return this.subscriptionService;
    }

    /**
     * Gets the value of the receivingInboxService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the receivingInboxService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReceivingInboxService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InboxServiceBindingsType }
     * 
     * 
     */
    public List<InboxServiceBindingsType> getReceivingInboxService() {
        if (receivingInboxService == null) {
            receivingInboxService = new ArrayList<InboxServiceBindingsType>();
        }
        return this.receivingInboxService;
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
            List<ContentBindingIDType> lhsContentBinding;
            lhsContentBinding = (((this.contentBinding!= null)&&(!this.contentBinding.isEmpty()))?this.getContentBinding():null);
            List<ContentBindingIDType> rhsContentBinding;
            rhsContentBinding = (((that.contentBinding!= null)&&(!that.contentBinding.isEmpty()))?that.getContentBinding():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contentBinding", lhsContentBinding), LocatorUtils.property(thatLocator, "contentBinding", rhsContentBinding), lhsContentBinding, rhsContentBinding)) {
                return false;
            }
        }
        {
            List<PushMethodType> lhsPushMethod;
            lhsPushMethod = (((this.pushMethod!= null)&&(!this.pushMethod.isEmpty()))?this.getPushMethod():null);
            List<PushMethodType> rhsPushMethod;
            rhsPushMethod = (((that.pushMethod!= null)&&(!that.pushMethod.isEmpty()))?that.getPushMethod():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pushMethod", lhsPushMethod), LocatorUtils.property(thatLocator, "pushMethod", rhsPushMethod), lhsPushMethod, rhsPushMethod)) {
                return false;
            }
        }
        {
            List<ServiceContactInfoType> lhsPollingService;
            lhsPollingService = (((this.pollingService!= null)&&(!this.pollingService.isEmpty()))?this.getPollingService():null);
            List<ServiceContactInfoType> rhsPollingService;
            rhsPollingService = (((that.pollingService!= null)&&(!that.pollingService.isEmpty()))?that.getPollingService():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pollingService", lhsPollingService), LocatorUtils.property(thatLocator, "pollingService", rhsPollingService), lhsPollingService, rhsPollingService)) {
                return false;
            }
        }
        {
            List<ServiceContactInfoType> lhsSubscriptionService;
            lhsSubscriptionService = (((this.subscriptionService!= null)&&(!this.subscriptionService.isEmpty()))?this.getSubscriptionService():null);
            List<ServiceContactInfoType> rhsSubscriptionService;
            rhsSubscriptionService = (((that.subscriptionService!= null)&&(!that.subscriptionService.isEmpty()))?that.getSubscriptionService():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "subscriptionService", lhsSubscriptionService), LocatorUtils.property(thatLocator, "subscriptionService", rhsSubscriptionService), lhsSubscriptionService, rhsSubscriptionService)) {
                return false;
            }
        }
        {
            List<InboxServiceBindingsType> lhsReceivingInboxService;
            lhsReceivingInboxService = (((this.receivingInboxService!= null)&&(!this.receivingInboxService.isEmpty()))?this.getReceivingInboxService():null);
            List<InboxServiceBindingsType> rhsReceivingInboxService;
            rhsReceivingInboxService = (((that.receivingInboxService!= null)&&(!that.receivingInboxService.isEmpty()))?that.getReceivingInboxService():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "receivingInboxService", lhsReceivingInboxService), LocatorUtils.property(thatLocator, "receivingInboxService", rhsReceivingInboxService), lhsReceivingInboxService, rhsReceivingInboxService)) {
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

}
