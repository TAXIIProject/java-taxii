
package org.mitre.taxii.messages.xml11;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


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
    "pollInstance"
})
public class SubscriptionRecordType {

    @XmlElement(name = "Subscription_ID", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String subscriptionID;
    @XmlElement(name = "Subscription_Parameters")
    protected SubscriptionParametersType subscriptionParameters;
    @XmlElement(name = "Push_Parameters")
    protected PushParameterType pushParameters;
    @XmlElement(name = "Poll_Instance")
    protected List<ServiceContactInfoType> pollInstance;
    @XmlAttribute(name = "status")
    protected SubscriptionStatusEnum status;

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
     * Gets the value of the pollInstance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pollInstance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPollInstance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceContactInfoType }
     * 
     * 
     */
    public List<ServiceContactInfoType> getPollInstance() {
        if (pollInstance == null) {
            pollInstance = new ArrayList<ServiceContactInfoType>();
        }
        return this.pollInstance;
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

}
