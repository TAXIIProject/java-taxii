
package org.mitre.taxii.messages.xml11;

import java.util.ArrayList;
import java.util.List;
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
 * Push message to exchange content.
 * 
 * <p>Java class for TAXIIInboxMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAXIIInboxMessageType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}RequestMessageType">
 *       &lt;sequence>
 *         &lt;element name="Destination_Collection_Name" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Source_Subscription" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}SourceSubscriptionType" minOccurs="0"/>
 *         &lt;element name="Record_Count" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}RecordCountType" minOccurs="0"/>
 *         &lt;element name="Content_Block" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}ContentBlockType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="result_id" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAXIIInboxMessageType", propOrder = {
    "destinationCollectionNames",
    "message",
    "sourceSubscription",
    "recordCount",
    "contentBlocks",
    "signature"
})
@XmlRootElement(name = "Inbox_Message")
public class InboxMessage
    extends RequestMessageType
    implements Equals, HashCode
{

    @XmlElement(name = "Destination_Collection_Name")
    @XmlSchemaType(name = "anyURI")
    protected List<String> destinationCollectionNames;
    @XmlElement(name = "Message")
    protected String message;
    @XmlElement(name = "Source_Subscription")
    protected SourceSubscriptionType sourceSubscription;
    @XmlElement(name = "Record_Count")
    protected RecordCountType recordCount;
    @XmlElement(name = "Content_Block")
    protected List<ContentBlockType> contentBlocks;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected Signature signature;
    @XmlAttribute(name = "result_id")
    @XmlSchemaType(name = "anyURI")
    protected String resultId;

    /**
     * Gets the value of the destinationCollectionNames property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the destinationCollectionNames property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDestinationCollectionNames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDestinationCollectionNames() {
        if (destinationCollectionNames == null) {
            destinationCollectionNames = new ArrayList<String>();
        }
        return this.destinationCollectionNames;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the sourceSubscription property.
     * 
     * @return
     *     possible object is
     *     {@link SourceSubscriptionType }
     *     
     */
    public SourceSubscriptionType getSourceSubscription() {
        return sourceSubscription;
    }

    /**
     * Sets the value of the sourceSubscription property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceSubscriptionType }
     *     
     */
    public void setSourceSubscription(SourceSubscriptionType value) {
        this.sourceSubscription = value;
    }

    /**
     * Gets the value of the recordCount property.
     * 
     * @return
     *     possible object is
     *     {@link RecordCountType }
     *     
     */
    public RecordCountType getRecordCount() {
        return recordCount;
    }

    /**
     * Sets the value of the recordCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordCountType }
     *     
     */
    public void setRecordCount(RecordCountType value) {
        this.recordCount = value;
    }

    /**
     * Gets the value of the contentBlocks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contentBlocks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContentBlocks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContentBlockType }
     * 
     * 
     */
    public List<ContentBlockType> getContentBlocks() {
        if (contentBlocks == null) {
            contentBlocks = new ArrayList<ContentBlockType>();
        }
        return this.contentBlocks;
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
     * Gets the value of the resultId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultId() {
        return resultId;
    }

    /**
     * Sets the value of the resultId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultId(String value) {
        this.resultId = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof InboxMessage)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final InboxMessage that = ((InboxMessage) object);
        {
            List<String> lhsDestinationCollectionNames;
            lhsDestinationCollectionNames = (((this.destinationCollectionNames!= null)&&(!this.destinationCollectionNames.isEmpty()))?this.getDestinationCollectionNames():null);
            List<String> rhsDestinationCollectionNames;
            rhsDestinationCollectionNames = (((that.destinationCollectionNames!= null)&&(!that.destinationCollectionNames.isEmpty()))?that.getDestinationCollectionNames():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "destinationCollectionNames", lhsDestinationCollectionNames), LocatorUtils.property(thatLocator, "destinationCollectionNames", rhsDestinationCollectionNames), lhsDestinationCollectionNames, rhsDestinationCollectionNames)) {
                return false;
            }
        }
        {
            String lhsMessage;
            lhsMessage = this.getMessage();
            String rhsMessage;
            rhsMessage = that.getMessage();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "message", lhsMessage), LocatorUtils.property(thatLocator, "message", rhsMessage), lhsMessage, rhsMessage)) {
                return false;
            }
        }
        {
            SourceSubscriptionType lhsSourceSubscription;
            lhsSourceSubscription = this.getSourceSubscription();
            SourceSubscriptionType rhsSourceSubscription;
            rhsSourceSubscription = that.getSourceSubscription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sourceSubscription", lhsSourceSubscription), LocatorUtils.property(thatLocator, "sourceSubscription", rhsSourceSubscription), lhsSourceSubscription, rhsSourceSubscription)) {
                return false;
            }
        }
        {
            RecordCountType lhsRecordCount;
            lhsRecordCount = this.getRecordCount();
            RecordCountType rhsRecordCount;
            rhsRecordCount = that.getRecordCount();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "recordCount", lhsRecordCount), LocatorUtils.property(thatLocator, "recordCount", rhsRecordCount), lhsRecordCount, rhsRecordCount)) {
                return false;
            }
        }
        {
            List<ContentBlockType> lhsContentBlocks;
            lhsContentBlocks = (((this.contentBlocks!= null)&&(!this.contentBlocks.isEmpty()))?this.getContentBlocks():null);
            List<ContentBlockType> rhsContentBlocks;
            rhsContentBlocks = (((that.contentBlocks!= null)&&(!that.contentBlocks.isEmpty()))?that.getContentBlocks():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contentBlocks", lhsContentBlocks), LocatorUtils.property(thatLocator, "contentBlocks", rhsContentBlocks), lhsContentBlocks, rhsContentBlocks)) {
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
            String lhsResultId;
            lhsResultId = this.getResultId();
            String rhsResultId;
            rhsResultId = that.getResultId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "resultId", lhsResultId), LocatorUtils.property(thatLocator, "resultId", rhsResultId), lhsResultId, rhsResultId)) {
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
            List<String> theDestinationCollectionNames;
            theDestinationCollectionNames = (((this.destinationCollectionNames!= null)&&(!this.destinationCollectionNames.isEmpty()))?this.getDestinationCollectionNames():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "destinationCollectionNames", theDestinationCollectionNames), currentHashCode, theDestinationCollectionNames);
        }
        {
            String theMessage;
            theMessage = this.getMessage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "message", theMessage), currentHashCode, theMessage);
        }
        {
            SourceSubscriptionType theSourceSubscription;
            theSourceSubscription = this.getSourceSubscription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sourceSubscription", theSourceSubscription), currentHashCode, theSourceSubscription);
        }
        {
            RecordCountType theRecordCount;
            theRecordCount = this.getRecordCount();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recordCount", theRecordCount), currentHashCode, theRecordCount);
        }
        {
            List<ContentBlockType> theContentBlocks;
            theContentBlocks = (((this.contentBlocks!= null)&&(!this.contentBlocks.isEmpty()))?this.getContentBlocks():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contentBlocks", theContentBlocks), currentHashCode, theContentBlocks);
        }
        {
            Signature theSignature;
            theSignature = this.getSignature();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signature", theSignature), currentHashCode, theSignature);
        }
        {
            String theResultId;
            theResultId = this.getResultId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "resultId", theResultId), currentHashCode, theResultId);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
