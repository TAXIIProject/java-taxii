
package org.mitre.taxii.messages.xml11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * Contains one piece of content as a content.
 * 
 * <p>Java class for ContentBlockType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContentBlockType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Content_Binding" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}ContentInstanceType"/&gt;
 *         &lt;element name="Content" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}AnyMixedContentType"/&gt;
 *         &lt;element name="Timestamp_Label" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}TimestampLabelType" minOccurs="0"/&gt;
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Padding" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContentBlockType", propOrder = {
    "contentBinding",
    "content",
    "timestampLabel",
    "message",
    "padding",
    "signature"
})
@XmlRootElement(name = "Content_Block")
public class ContentBlock implements Equals, HashCode
{

    @XmlElement(name = "Content_Binding", required = true)
    protected ContentInstanceType contentBinding;
    @XmlElement(name = "Content", required = true)
    protected AnyMixedContentType content;
    @XmlElement(name = "Timestamp_Label")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timestampLabel;
    @XmlElement(name = "Message")
    protected String message;
    @XmlElement(name = "Padding")
    protected String padding;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected Signature signature;

    /**
     * Default no-arg constructor
     * 
     */
    public ContentBlock() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public ContentBlock(final ContentInstanceType contentBinding, final AnyMixedContentType content, final XMLGregorianCalendar timestampLabel, final String message, final String padding, final Signature signature) {
        this.contentBinding = contentBinding;
        this.content = content;
        this.timestampLabel = timestampLabel;
        this.message = message;
        this.padding = padding;
        this.signature = signature;
    }

    /**
     * Gets the value of the contentBinding property.
     * 
     * @return
     *     possible object is
     *     {@link ContentInstanceType }
     *     
     */
    public ContentInstanceType getContentBinding() {
        return contentBinding;
    }

    /**
     * Sets the value of the contentBinding property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentInstanceType }
     *     
     */
    public void setContentBinding(ContentInstanceType value) {
        this.contentBinding = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link AnyMixedContentType }
     *     
     */
    public AnyMixedContentType getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnyMixedContentType }
     *     
     */
    public void setContent(AnyMixedContentType value) {
        this.content = value;
    }

    /**
     * Gets the value of the timestampLabel property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimestampLabel() {
        return timestampLabel;
    }

    /**
     * Sets the value of the timestampLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimestampLabel(XMLGregorianCalendar value) {
        this.timestampLabel = value;
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
     * Gets the value of the padding property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPadding() {
        return padding;
    }

    /**
     * Sets the value of the padding property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPadding(String value) {
        this.padding = value;
    }

    /**
     * An XML Digital Signature scoped to this Content_Block.
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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ContentBlock)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ContentBlock that = ((ContentBlock) object);
        {
            ContentInstanceType lhsContentBinding;
            lhsContentBinding = this.getContentBinding();
            ContentInstanceType rhsContentBinding;
            rhsContentBinding = that.getContentBinding();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contentBinding", lhsContentBinding), LocatorUtils.property(thatLocator, "contentBinding", rhsContentBinding), lhsContentBinding, rhsContentBinding)) {
                return false;
            }
        }
        {
            AnyMixedContentType lhsContent;
            lhsContent = this.getContent();
            AnyMixedContentType rhsContent;
            rhsContent = that.getContent();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "content", lhsContent), LocatorUtils.property(thatLocator, "content", rhsContent), lhsContent, rhsContent)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsTimestampLabel;
            lhsTimestampLabel = this.getTimestampLabel();
            XMLGregorianCalendar rhsTimestampLabel;
            rhsTimestampLabel = that.getTimestampLabel();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "timestampLabel", lhsTimestampLabel), LocatorUtils.property(thatLocator, "timestampLabel", rhsTimestampLabel), lhsTimestampLabel, rhsTimestampLabel)) {
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
            String lhsPadding;
            lhsPadding = this.getPadding();
            String rhsPadding;
            rhsPadding = that.getPadding();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "padding", lhsPadding), LocatorUtils.property(thatLocator, "padding", rhsPadding), lhsPadding, rhsPadding)) {
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
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            ContentInstanceType theContentBinding;
            theContentBinding = this.getContentBinding();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contentBinding", theContentBinding), currentHashCode, theContentBinding);
        }
        {
            AnyMixedContentType theContent;
            theContent = this.getContent();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "content", theContent), currentHashCode, theContent);
        }
        {
            XMLGregorianCalendar theTimestampLabel;
            theTimestampLabel = this.getTimestampLabel();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "timestampLabel", theTimestampLabel), currentHashCode, theTimestampLabel);
        }
        {
            String theMessage;
            theMessage = this.getMessage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "message", theMessage), currentHashCode, theMessage);
        }
        {
            String thePadding;
            thePadding = this.getPadding();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "padding", thePadding), currentHashCode, thePadding);
        }
        {
            Signature theSignature;
            theSignature = this.getSignature();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signature", theSignature), currentHashCode, theSignature);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public ContentBlock withContentBinding(ContentInstanceType value) {
        setContentBinding(value);
        return this;
    }

    public ContentBlock withContent(AnyMixedContentType value) {
        setContent(value);
        return this;
    }

    public ContentBlock withTimestampLabel(XMLGregorianCalendar value) {
        setTimestampLabel(value);
        return this;
    }

    public ContentBlock withMessage(String value) {
        setMessage(value);
        return this;
    }

    public ContentBlock withPadding(String value) {
        setPadding(value);
        return this;
    }

    public ContentBlock withSignature(Signature value) {
        setSignature(value);
        return this;
    }

}
