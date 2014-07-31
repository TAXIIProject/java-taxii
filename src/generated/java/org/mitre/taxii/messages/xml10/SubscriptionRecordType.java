
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
 * Contains a description of an established (or formerly established if there was an UNSUBSCRIBE action) subscription to a Data Feed.
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
 *         &lt;element name="Push_Parameters" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1}PushParameterType" minOccurs="0"/>
 *         &lt;element name="Poll_Instance" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1}ServiceContactInfoType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="subscription_id" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriptionRecordType", propOrder = {
    "pushParameters",
    "pollInstances"
})
public class SubscriptionRecordType
    implements Equals, HashCode
{

    @XmlElement(name = "Push_Parameters")
    protected PushParameterType pushParameters;
    @XmlElement(name = "Poll_Instance")
    protected List<ServiceContactInfoType> pollInstances;
    @XmlAttribute(name = "subscription_id", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String subscriptionId;

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
        if (!(object instanceof SubscriptionRecordType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SubscriptionRecordType that = ((SubscriptionRecordType) object);
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
