
package org.mitre.taxii.messages.xml10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 * Type used by TAXII Status Messages.
 * 
 * <p>Java class for TAXIIStatusMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAXIIStatusMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://taxii.mitre.org/messages/taxii_xml_binding-1}ResponseMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Status_Detail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="status_type" use="required" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1}StatusTypeType" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAXIIStatusMessageType", propOrder = {
    "statusDetail",
    "message",
    "signature"
})
@XmlRootElement(name = "Status_Message")
public class StatusMessage
    extends ResponseMessageType
    implements Equals, HashCode
{

    @XmlElement(name = "Status_Detail")
    protected String statusDetail;
    @XmlElement(name = "Message")
    protected String message;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected Signature signature;
    @XmlAttribute(name = "status_type", required = true)
    protected String statusType;

    /**
     * Default no-arg constructor
     * 
     */
    public StatusMessage() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public StatusMessage(final ExtendedHeadersType extendedHeaders, final String messageId, final String inResponseTo, final String statusDetail, final String message, final Signature signature, final String statusType) {
        super(extendedHeaders, messageId, inResponseTo);
        this.statusDetail = statusDetail;
        this.message = message;
        this.signature = signature;
        this.statusType = statusType;
    }

    /**
     * Gets the value of the statusDetail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusDetail() {
        return statusDetail;
    }

    /**
     * Sets the value of the statusDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusDetail(String value) {
        this.statusDetail = value;
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
     * Gets the value of the statusType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusType() {
        return statusType;
    }

    /**
     * Sets the value of the statusType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusType(String value) {
        this.statusType = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof StatusMessage)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final StatusMessage that = ((StatusMessage) object);
        {
            String lhsStatusDetail;
            lhsStatusDetail = this.getStatusDetail();
            String rhsStatusDetail;
            rhsStatusDetail = that.getStatusDetail();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "statusDetail", lhsStatusDetail), LocatorUtils.property(thatLocator, "statusDetail", rhsStatusDetail), lhsStatusDetail, rhsStatusDetail)) {
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
            Signature lhsSignature;
            lhsSignature = this.getSignature();
            Signature rhsSignature;
            rhsSignature = that.getSignature();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "signature", lhsSignature), LocatorUtils.property(thatLocator, "signature", rhsSignature), lhsSignature, rhsSignature)) {
                return false;
            }
        }
        {
            String lhsStatusType;
            lhsStatusType = this.getStatusType();
            String rhsStatusType;
            rhsStatusType = that.getStatusType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "statusType", lhsStatusType), LocatorUtils.property(thatLocator, "statusType", rhsStatusType), lhsStatusType, rhsStatusType)) {
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
            String theStatusDetail;
            theStatusDetail = this.getStatusDetail();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "statusDetail", theStatusDetail), currentHashCode, theStatusDetail);
        }
        {
            String theMessage;
            theMessage = this.getMessage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "message", theMessage), currentHashCode, theMessage);
        }
        {
            Signature theSignature;
            theSignature = this.getSignature();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signature", theSignature), currentHashCode, theSignature);
        }
        {
            String theStatusType;
            theStatusType = this.getStatusType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "statusType", theStatusType), currentHashCode, theStatusType);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public StatusMessage withStatusDetail(String value) {
        setStatusDetail(value);
        return this;
    }

    public StatusMessage withMessage(String value) {
        setMessage(value);
        return this;
    }

    public StatusMessage withSignature(Signature value) {
        setSignature(value);
        return this;
    }

    public StatusMessage withStatusType(String value) {
        setStatusType(value);
        return this;
    }

    @Override
    public StatusMessage withInResponseTo(String value) {
        setInResponseTo(value);
        return this;
    }

    @Override
    public StatusMessage withExtendedHeaders(ExtendedHeadersType value) {
        setExtendedHeaders(value);
        return this;
    }

    @Override
    public StatusMessage withMessageId(String value) {
        setMessageId(value);
        return this;
    }

}
