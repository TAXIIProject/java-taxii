
package org.mitre.taxii.messages.xml11;

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
import org.mitre.taxii.messages.xmldsig.SignatureType;


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
    "destinationCollectionName",
    "message",
    "sourceSubscription",
    "recordCount",
    "contentBlock",
    "signature"
})
public class TAXIIInboxMessageType
    extends RequestMessageType
    implements Equals
{

    @XmlElement(name = "Destination_Collection_Name")
    @XmlSchemaType(name = "anyURI")
    protected List<String> destinationCollectionName;
    @XmlElement(name = "Message")
    protected String message;
    @XmlElement(name = "Source_Subscription")
    protected SourceSubscriptionType sourceSubscription;
    @XmlElement(name = "Record_Count")
    protected RecordCountType recordCount;
    @XmlElement(name = "Content_Block")
    protected List<ContentBlockType> contentBlock;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected SignatureType signature;
    @XmlAttribute(name = "result_id")
    @XmlSchemaType(name = "anyURI")
    protected String resultId;

    /**
     * Gets the value of the destinationCollectionName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the destinationCollectionName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDestinationCollectionName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDestinationCollectionName() {
        if (destinationCollectionName == null) {
            destinationCollectionName = new ArrayList<String>();
        }
        return this.destinationCollectionName;
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
     * Gets the value of the contentBlock property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contentBlock property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContentBlock().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContentBlockType }
     * 
     * 
     */
    public List<ContentBlockType> getContentBlock() {
        if (contentBlock == null) {
            contentBlock = new ArrayList<ContentBlockType>();
        }
        return this.contentBlock;
    }

    /**
     * An XML Digital Signature scoped to this message.
     * 
     * @return
     *     possible object is
     *     {@link SignatureType }
     *     
     */
    public SignatureType getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureType }
     *     
     */
    public void setSignature(SignatureType value) {
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
        if (!(object instanceof TAXIIInboxMessageType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final TAXIIInboxMessageType that = ((TAXIIInboxMessageType) object);
        {
            List<String> lhsDestinationCollectionName;
            lhsDestinationCollectionName = (((this.destinationCollectionName!= null)&&(!this.destinationCollectionName.isEmpty()))?this.getDestinationCollectionName():null);
            List<String> rhsDestinationCollectionName;
            rhsDestinationCollectionName = (((that.destinationCollectionName!= null)&&(!that.destinationCollectionName.isEmpty()))?that.getDestinationCollectionName():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "destinationCollectionName", lhsDestinationCollectionName), LocatorUtils.property(thatLocator, "destinationCollectionName", rhsDestinationCollectionName), lhsDestinationCollectionName, rhsDestinationCollectionName)) {
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
            List<ContentBlockType> lhsContentBlock;
            lhsContentBlock = (((this.contentBlock!= null)&&(!this.contentBlock.isEmpty()))?this.getContentBlock():null);
            List<ContentBlockType> rhsContentBlock;
            rhsContentBlock = (((that.contentBlock!= null)&&(!that.contentBlock.isEmpty()))?that.getContentBlock():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contentBlock", lhsContentBlock), LocatorUtils.property(thatLocator, "contentBlock", rhsContentBlock), lhsContentBlock, rhsContentBlock)) {
                return false;
            }
        }
        {
            SignatureType lhsSignature;
            lhsSignature = this.getSignature();
            SignatureType rhsSignature;
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

}
