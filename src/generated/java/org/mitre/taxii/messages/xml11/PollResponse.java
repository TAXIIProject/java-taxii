
package org.mitre.taxii.messages.xml11;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
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
 * Type for the Poll Response Messages.
 * 
 * <p>Java class for TAXIIPollResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAXIIPollResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}ResponseMessageType">
 *       &lt;sequence>
 *         &lt;element name="Subscription_ID" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="Exclusive_Begin_Timestamp" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}TimestampLabelType" minOccurs="0"/>
 *         &lt;element name="Inclusive_End_Timestamp" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}TimestampLabelType" minOccurs="0"/>
 *         &lt;element name="Record_Count" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}RecordCountType" minOccurs="0"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}Content_Block" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="collection_name" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="more" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="result_id" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="result_part_number" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" default="1" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAXIIPollResponseType", propOrder = {
    "subscriptionID",
    "exclusiveBeginTimestamp",
    "inclusiveEndTimestamp",
    "recordCount",
    "message",
    "contentBlocks",
    "signature"
})
@XmlRootElement(name = "Poll_Response")
public class PollResponse
    extends ResponseMessageType
    implements Equals, HashCode
{

    @XmlElement(name = "Subscription_ID")
    @XmlSchemaType(name = "anyURI")
    protected String subscriptionID;
    @XmlElement(name = "Exclusive_Begin_Timestamp")
    protected XMLGregorianCalendar exclusiveBeginTimestamp;
    @XmlElement(name = "Inclusive_End_Timestamp")
    protected XMLGregorianCalendar inclusiveEndTimestamp;
    @XmlElement(name = "Record_Count")
    protected RecordCountType recordCount;
    @XmlElement(name = "Message")
    protected String message;
    @XmlElement(name = "Content_Block")
    protected List<ContentBlock> contentBlocks;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected Signature signature;
    @XmlAttribute(name = "collection_name", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String collectionName;
    @XmlAttribute(name = "more")
    protected Boolean more;
    @XmlAttribute(name = "result_id")
    @XmlSchemaType(name = "anyURI")
    protected String resultId;
    @XmlAttribute(name = "result_part_number")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger resultPartNumber;

    /**
     * Default no-arg constructor
     * 
     */
    public PollResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public PollResponse(final ExtendedHeadersType extendedHeaders, final String messageId, final String inResponseTo, final String subscriptionID, final XMLGregorianCalendar exclusiveBeginTimestamp, final XMLGregorianCalendar inclusiveEndTimestamp, final RecordCountType recordCount, final String message, final List<ContentBlock> contentBlocks, final Signature signature, final String collectionName, final Boolean more, final String resultId, final BigInteger resultPartNumber) {
        super(extendedHeaders, messageId, inResponseTo);
        this.subscriptionID = subscriptionID;
        this.exclusiveBeginTimestamp = exclusiveBeginTimestamp;
        this.inclusiveEndTimestamp = inclusiveEndTimestamp;
        this.recordCount = recordCount;
        this.message = message;
        this.contentBlocks = contentBlocks;
        this.signature = signature;
        this.collectionName = collectionName;
        this.more = more;
        this.resultId = resultId;
        this.resultPartNumber = resultPartNumber;
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
     * Returned content.Gets the value of the contentBlocks property.
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
     * {@link ContentBlock }
     * 
     * 
     */
    public List<ContentBlock> getContentBlocks() {
        if (contentBlocks == null) {
            contentBlocks = new ArrayList<ContentBlock>();
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
     * Gets the value of the more property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isMore() {
        if (more == null) {
            return false;
        } else {
            return more;
        }
    }

    /**
     * Sets the value of the more property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMore(Boolean value) {
        this.more = value;
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

    /**
     * Gets the value of the resultPartNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getResultPartNumber() {
        if (resultPartNumber == null) {
            return new BigInteger("1");
        } else {
            return resultPartNumber;
        }
    }

    /**
     * Sets the value of the resultPartNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setResultPartNumber(BigInteger value) {
        this.resultPartNumber = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PollResponse)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final PollResponse that = ((PollResponse) object);
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
            XMLGregorianCalendar lhsExclusiveBeginTimestamp;
            lhsExclusiveBeginTimestamp = this.getExclusiveBeginTimestamp();
            XMLGregorianCalendar rhsExclusiveBeginTimestamp;
            rhsExclusiveBeginTimestamp = that.getExclusiveBeginTimestamp();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "exclusiveBeginTimestamp", lhsExclusiveBeginTimestamp), LocatorUtils.property(thatLocator, "exclusiveBeginTimestamp", rhsExclusiveBeginTimestamp), lhsExclusiveBeginTimestamp, rhsExclusiveBeginTimestamp)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsInclusiveEndTimestamp;
            lhsInclusiveEndTimestamp = this.getInclusiveEndTimestamp();
            XMLGregorianCalendar rhsInclusiveEndTimestamp;
            rhsInclusiveEndTimestamp = that.getInclusiveEndTimestamp();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "inclusiveEndTimestamp", lhsInclusiveEndTimestamp), LocatorUtils.property(thatLocator, "inclusiveEndTimestamp", rhsInclusiveEndTimestamp), lhsInclusiveEndTimestamp, rhsInclusiveEndTimestamp)) {
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
            String lhsMessage;
            lhsMessage = this.getMessage();
            String rhsMessage;
            rhsMessage = that.getMessage();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "message", lhsMessage), LocatorUtils.property(thatLocator, "message", rhsMessage), lhsMessage, rhsMessage)) {
                return false;
            }
        }
        {
            List<ContentBlock> lhsContentBlocks;
            lhsContentBlocks = (((this.contentBlocks!= null)&&(!this.contentBlocks.isEmpty()))?this.getContentBlocks():null);
            List<ContentBlock> rhsContentBlocks;
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
            String lhsCollectionName;
            lhsCollectionName = this.getCollectionName();
            String rhsCollectionName;
            rhsCollectionName = that.getCollectionName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "collectionName", lhsCollectionName), LocatorUtils.property(thatLocator, "collectionName", rhsCollectionName), lhsCollectionName, rhsCollectionName)) {
                return false;
            }
        }
        {
            boolean lhsMore;
            lhsMore = ((this.more!= null)?this.isMore():false);
            boolean rhsMore;
            rhsMore = ((that.more!= null)?that.isMore():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "more", lhsMore), LocatorUtils.property(thatLocator, "more", rhsMore), lhsMore, rhsMore)) {
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
        {
            BigInteger lhsResultPartNumber;
            lhsResultPartNumber = this.getResultPartNumber();
            BigInteger rhsResultPartNumber;
            rhsResultPartNumber = that.getResultPartNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "resultPartNumber", lhsResultPartNumber), LocatorUtils.property(thatLocator, "resultPartNumber", rhsResultPartNumber), lhsResultPartNumber, rhsResultPartNumber)) {
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
            String theSubscriptionID;
            theSubscriptionID = this.getSubscriptionID();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "subscriptionID", theSubscriptionID), currentHashCode, theSubscriptionID);
        }
        {
            XMLGregorianCalendar theExclusiveBeginTimestamp;
            theExclusiveBeginTimestamp = this.getExclusiveBeginTimestamp();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "exclusiveBeginTimestamp", theExclusiveBeginTimestamp), currentHashCode, theExclusiveBeginTimestamp);
        }
        {
            XMLGregorianCalendar theInclusiveEndTimestamp;
            theInclusiveEndTimestamp = this.getInclusiveEndTimestamp();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inclusiveEndTimestamp", theInclusiveEndTimestamp), currentHashCode, theInclusiveEndTimestamp);
        }
        {
            RecordCountType theRecordCount;
            theRecordCount = this.getRecordCount();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recordCount", theRecordCount), currentHashCode, theRecordCount);
        }
        {
            String theMessage;
            theMessage = this.getMessage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "message", theMessage), currentHashCode, theMessage);
        }
        {
            List<ContentBlock> theContentBlocks;
            theContentBlocks = (((this.contentBlocks!= null)&&(!this.contentBlocks.isEmpty()))?this.getContentBlocks():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contentBlocks", theContentBlocks), currentHashCode, theContentBlocks);
        }
        {
            Signature theSignature;
            theSignature = this.getSignature();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signature", theSignature), currentHashCode, theSignature);
        }
        {
            String theCollectionName;
            theCollectionName = this.getCollectionName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "collectionName", theCollectionName), currentHashCode, theCollectionName);
        }
        {
            boolean theMore;
            theMore = ((this.more!= null)?this.isMore():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "more", theMore), currentHashCode, theMore);
        }
        {
            String theResultId;
            theResultId = this.getResultId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "resultId", theResultId), currentHashCode, theResultId);
        }
        {
            BigInteger theResultPartNumber;
            theResultPartNumber = this.getResultPartNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "resultPartNumber", theResultPartNumber), currentHashCode, theResultPartNumber);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public PollResponse withSubscriptionID(String value) {
        setSubscriptionID(value);
        return this;
    }

    public PollResponse withExclusiveBeginTimestamp(XMLGregorianCalendar value) {
        setExclusiveBeginTimestamp(value);
        return this;
    }

    public PollResponse withInclusiveEndTimestamp(XMLGregorianCalendar value) {
        setInclusiveEndTimestamp(value);
        return this;
    }

    public PollResponse withRecordCount(RecordCountType value) {
        setRecordCount(value);
        return this;
    }

    public PollResponse withMessage(String value) {
        setMessage(value);
        return this;
    }

    public PollResponse withContentBlocks(ContentBlock... values) {
        if (values!= null) {
            for (ContentBlock value: values) {
                getContentBlocks().add(value);
            }
        }
        return this;
    }

    public PollResponse withContentBlocks(Collection<ContentBlock> values) {
        if (values!= null) {
            getContentBlocks().addAll(values);
        }
        return this;
    }

    public PollResponse withSignature(Signature value) {
        setSignature(value);
        return this;
    }

    public PollResponse withCollectionName(String value) {
        setCollectionName(value);
        return this;
    }

    public PollResponse withMore(Boolean value) {
        setMore(value);
        return this;
    }

    public PollResponse withResultId(String value) {
        setResultId(value);
        return this;
    }

    public PollResponse withResultPartNumber(BigInteger value) {
        setResultPartNumber(value);
        return this;
    }

    @Override
    public PollResponse withInResponseTo(String value) {
        setInResponseTo(value);
        return this;
    }

    @Override
    public PollResponse withExtendedHeaders(ExtendedHeadersType value) {
        setExtendedHeaders(value);
        return this;
    }

    @Override
    public PollResponse withMessageId(String value) {
        setMessageId(value);
        return this;
    }

}
