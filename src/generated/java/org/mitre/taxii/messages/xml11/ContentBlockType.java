
package org.mitre.taxii.messages.xml11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.mitre.taxii.messages.xml11.xmldsig.SignatureType;


/**
 * Contains one piece of content as a content.
 * 
 * <p>Java class for ContentBlockType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContentBlockType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Content_Binding" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}ContentInstanceType"/>
 *         &lt;element name="Content" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}AnyMixedContentType"/>
 *         &lt;element name="Timestamp_Label" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}TimestampLabelType" minOccurs="0"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Padding" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
public class ContentBlockType {

    @XmlElement(name = "Content_Binding", required = true)
    protected ContentInstanceType contentBinding;
    @XmlElement(name = "Content", required = true)
    protected AnyMixedContentType content;
    @XmlElement(name = "Timestamp_Label")
    protected XMLGregorianCalendar timestampLabel;
    @XmlElement(name = "Message")
    protected String message;
    @XmlElement(name = "Padding")
    protected String padding;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected SignatureType signature;

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

}
