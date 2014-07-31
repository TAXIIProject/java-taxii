
package org.mitre.taxii.messages.xml10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
import org.mitre.taxii.messages.xmldsig.Signature;


/**
 * Request management of a feed subscription (including creation of a new subscription).
 * 
 * <p>Java class for TAXIISubscriptionManagementRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAXIISubscriptionManagementRequestType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://taxii.mitre.org/messages/taxii_xml_binding-1}RequestMessageType">
 *       &lt;sequence>
 *         &lt;element name="Push_Parameters" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1}PushParameterType" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="action" use="required" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1}FeedActionEnum" />
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
@XmlType(name = "TAXIISubscriptionManagementRequestType", propOrder = {
    "pushParameters",
    "signature"
})
@XmlRootElement(name = "Subscription_Management_Request")
public class SubscriptionManagementRequest
    extends RequestMessageType
    implements Equals, HashCode
{

    @XmlElement(name = "Push_Parameters")
    protected PushParameterType pushParameters;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected Signature signature;
    @XmlAttribute(name = "action", required = true)
    protected FeedActionEnum action;
    @XmlAttribute(name = "feed_name", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String feedName;
    @XmlAttribute(name = "subscription_id")
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
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link FeedActionEnum }
     *     
     */
    public FeedActionEnum getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeedActionEnum }
     *     
     */
    public void setAction(FeedActionEnum value) {
        this.action = value;
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
        if (!(object instanceof SubscriptionManagementRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final SubscriptionManagementRequest that = ((SubscriptionManagementRequest) object);
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
            Signature lhsSignature;
            lhsSignature = this.getSignature();
            Signature rhsSignature;
            rhsSignature = that.getSignature();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "signature", lhsSignature), LocatorUtils.property(thatLocator, "signature", rhsSignature), lhsSignature, rhsSignature)) {
                return false;
            }
        }
        {
            FeedActionEnum lhsAction;
            lhsAction = this.getAction();
            FeedActionEnum rhsAction;
            rhsAction = that.getAction();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "action", lhsAction), LocatorUtils.property(thatLocator, "action", rhsAction), lhsAction, rhsAction)) {
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
            PushParameterType thePushParameters;
            thePushParameters = this.getPushParameters();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pushParameters", thePushParameters), currentHashCode, thePushParameters);
        }
        {
            Signature theSignature;
            theSignature = this.getSignature();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signature", theSignature), currentHashCode, theSignature);
        }
        {
            FeedActionEnum theAction;
            theAction = this.getAction();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "action", theAction), currentHashCode, theAction);
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
