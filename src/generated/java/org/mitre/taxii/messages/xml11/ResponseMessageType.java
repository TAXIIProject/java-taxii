
package org.mitre.taxii.messages.xml11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
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
 * The base type of response messages.
 * 
 * <p>Java class for ResponseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}MessageType"&gt;
 *       &lt;attribute name="in_response_to" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseMessageType")
@XmlSeeAlso({
    PollResponse.class,
    SubscriptionManagementResponse.class,
    CollectionInformationResponse.class,
    DiscoveryResponse.class,
    StatusMessage.class
})
public abstract class ResponseMessageType
    extends MessageType
    implements Equals, HashCode
{

    @XmlAttribute(name = "in_response_to", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String inResponseTo;

    /**
     * Default no-arg constructor
     * 
     */
    public ResponseMessageType() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public ResponseMessageType(final ExtendedHeadersType extendedHeaders, final String messageId, final String inResponseTo) {
        super(extendedHeaders, messageId);
        this.inResponseTo = inResponseTo;
    }

    /**
     * Gets the value of the inResponseTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInResponseTo() {
        return inResponseTo;
    }

    /**
     * Sets the value of the inResponseTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInResponseTo(String value) {
        this.inResponseTo = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ResponseMessageType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final ResponseMessageType that = ((ResponseMessageType) object);
        {
            String lhsInResponseTo;
            lhsInResponseTo = this.getInResponseTo();
            String rhsInResponseTo;
            rhsInResponseTo = that.getInResponseTo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "inResponseTo", lhsInResponseTo), LocatorUtils.property(thatLocator, "inResponseTo", rhsInResponseTo), lhsInResponseTo, rhsInResponseTo)) {
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
            String theInResponseTo;
            theInResponseTo = this.getInResponseTo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inResponseTo", theInResponseTo), currentHashCode, theInResponseTo);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public ResponseMessageType withInResponseTo(String value) {
        setInResponseTo(value);
        return this;
    }

    @Override
    public ResponseMessageType withExtendedHeaders(ExtendedHeadersType value) {
        setExtendedHeaders(value);
        return this;
    }

    @Override
    public ResponseMessageType withMessageId(String value) {
        setMessageId(value);
        return this;
    }

}
