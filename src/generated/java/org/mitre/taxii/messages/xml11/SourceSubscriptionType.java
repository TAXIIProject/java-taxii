
package org.mitre.taxii.messages.xml11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Describes a subscription to a collection, and the portion of that
 *                 collection that is being serviced by a message.
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
 *         &lt;element name="Subscription_ID" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="Exclusive_Begin_Timestamp" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}TimestampLabelType" minOccurs="0"/>
 *         &lt;element name="Inclusive_End_Timestamp" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}TimestampLabelType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="collection_name" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
public class SourceSubscriptionType {

    @XmlElement(name = "Subscription_ID", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String subscriptionID;
    @XmlElement(name = "Exclusive_Begin_Timestamp")
    protected XMLGregorianCalendar exclusiveBeginTimestamp;
    @XmlElement(name = "Inclusive_End_Timestamp")
    protected XMLGregorianCalendar inclusiveEndTimestamp;
    @XmlAttribute(name = "collection_name", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String collectionName;

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

}
