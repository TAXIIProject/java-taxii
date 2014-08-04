
package org.mitre.taxii.messages.xml11;

import java.util.ArrayList;
import java.util.Collection;
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
 * Contains a description of an established (or formerly established if
 *                 there was an UNSUBSCRIBE action) subscription to a Data Collection.
 * 
 * <p>Java class for SubscriptionRecordType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscriptionRecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Subscription_ID" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="Subscription_Parameters" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}SubscriptionParametersType" minOccurs="0"/>
 *         &lt;element name="Push_Parameters" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}PushParameterType" minOccurs="0"/>
 *         &lt;element name="Poll_Instance" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}ServiceContactInfoType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="status" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}SubscriptionStatusEnum" default="ACTIVE" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriptionRecordType", propOrder = {
    "subscriptionID",
    "subscriptionParameters",
    "pushParameters",
    "pollInstances"
})
public class SubscriptionRecordType implements Equals, HashCode
{

    @XmlElement(name = "Subscription_ID", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String subscriptionID;
    @XmlElement(name = "Subscription_Parameters")
    protected SubscriptionParametersType subscriptionParameters;
    @XmlElement(name = "Push_Parameters")
    protected PushParameterType pushParameters;
    @XmlElement(name = "Poll_Instance")
    protected List<ServiceContactInfoType> pollInstances;
    @XmlAttribute(name = "status")
    protected SubscriptionStatusEnum status;

    /**
     * Default no-arg constructor
     * 
     */
    public SubscriptionRecordType() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public SubscriptionRecordType(final String subscriptionID, final SubscriptionParametersType subscriptionParameters, final PushParameterType pushParameters, final List<ServiceContactInfoType> pollInstances, final SubscriptionStatusEnum status) {
        this.subscriptionID = subscriptionID;
        this.subscriptionParameters = subscriptionParameters;
        this.pushParameters = pushParameters;
        this.pollInstances = pollInstances;
        this.status = status;
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
     * Gets the value of the subscriptionParameters property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionParametersType }
     *     
     */
    public SubscriptionParametersType getSubscriptionParameters() {
        return subscriptionParameters;
    }

    /**
     * Sets the value of the subscriptionParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionParametersType }
     *     
     */
    public void setSubscriptionParameters(SubscriptionParametersType value) {
        this.subscriptionParameters = value;
    }

    /**
     * Gets the value of the pushParameters property.
     * 
     * @return
     *     possible object is
     *     {@link PushParameterType }
     *     
     */
    public PushParameterType getPushParameters() {
        return pushParameters;
    }

    /**
     * Sets the value of the pushParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link PushParameterType }
     *     
     */
    public void setPushParameters(PushParameterType value) {
        this.pushParameters = value;
    }

    /**
     * Gets the value of the pollInstances property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pollInstances property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPollInstances().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceContactInfoType }
     * 
     * 
     */
    public List<ServiceContactInfoType> getPollInstances() {
        if (pollInstances == null) {
            pollInstances = new ArrayList<ServiceContactInfoType>();
        }
        return this.pollInstances;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionStatusEnum }
     *     
     */
    public SubscriptionStatusEnum getStatus() {
        if (status == null) {
            return SubscriptionStatusEnum.ACTIVE;
        } else {
            return status;
        }
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionStatusEnum }
     *     
     */
    public void setStatus(SubscriptionStatusEnum value) {
        this.status = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SubscriptionRecordType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SubscriptionRecordType that = ((SubscriptionRecordType) object);
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
            SubscriptionParametersType lhsSubscriptionParameters;
            lhsSubscriptionParameters = this.getSubscriptionParameters();
            SubscriptionParametersType rhsSubscriptionParameters;
            rhsSubscriptionParameters = that.getSubscriptionParameters();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "subscriptionParameters", lhsSubscriptionParameters), LocatorUtils.property(thatLocator, "subscriptionParameters", rhsSubscriptionParameters), lhsSubscriptionParameters, rhsSubscriptionParameters)) {
                return false;
            }
        }
        {
            PushParameterType lhsPushParameters;
            lhsPushParameters = this.getPushParameters();
            PushParameterType rhsPushParameters;
            rhsPushParameters = that.getPushParameters();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pushParameters", lhsPushParameters), LocatorUtils.property(thatLocator, "pushParameters", rhsPushParameters), lhsPushParameters, rhsPushParameters)) {
                return false;
            }
        }
        {
            List<ServiceContactInfoType> lhsPollInstances;
            lhsPollInstances = (((this.pollInstances!= null)&&(!this.pollInstances.isEmpty()))?this.getPollInstances():null);
            List<ServiceContactInfoType> rhsPollInstances;
            rhsPollInstances = (((that.pollInstances!= null)&&(!that.pollInstances.isEmpty()))?that.getPollInstances():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pollInstances", lhsPollInstances), LocatorUtils.property(thatLocator, "pollInstances", rhsPollInstances), lhsPollInstances, rhsPollInstances)) {
                return false;
            }
        }
        {
            SubscriptionStatusEnum lhsStatus;
            lhsStatus = this.getStatus();
            SubscriptionStatusEnum rhsStatus;
            rhsStatus = that.getStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "status", lhsStatus), LocatorUtils.property(thatLocator, "status", rhsStatus), lhsStatus, rhsStatus)) {
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
            SubscriptionParametersType theSubscriptionParameters;
            theSubscriptionParameters = this.getSubscriptionParameters();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "subscriptionParameters", theSubscriptionParameters), currentHashCode, theSubscriptionParameters);
        }
        {
            PushParameterType thePushParameters;
            thePushParameters = this.getPushParameters();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pushParameters", thePushParameters), currentHashCode, thePushParameters);
        }
        {
            List<ServiceContactInfoType> thePollInstances;
            thePollInstances = (((this.pollInstances!= null)&&(!this.pollInstances.isEmpty()))?this.getPollInstances():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pollInstances", thePollInstances), currentHashCode, thePollInstances);
        }
        {
            SubscriptionStatusEnum theStatus;
            theStatus = this.getStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "status", theStatus), currentHashCode, theStatus);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public SubscriptionRecordType withSubscriptionID(String value) {
        setSubscriptionID(value);
        return this;
    }

    public SubscriptionRecordType withSubscriptionParameters(SubscriptionParametersType value) {
        setSubscriptionParameters(value);
        return this;
    }

    public SubscriptionRecordType withPushParameters(PushParameterType value) {
        setPushParameters(value);
        return this;
    }

    public SubscriptionRecordType withPollInstances(ServiceContactInfoType... values) {
        if (values!= null) {
            for (ServiceContactInfoType value: values) {
                getPollInstances().add(value);
            }
        }
        return this;
    }

    public SubscriptionRecordType withPollInstances(Collection<ServiceContactInfoType> values) {
        if (values!= null) {
            getPollInstances().addAll(values);
        }
        return this;
    }

    public SubscriptionRecordType withStatus(SubscriptionStatusEnum value) {
        setStatus(value);
        return this;
    }

}
