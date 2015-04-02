
package org.mitre.taxii.messages.xml10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * The base type of request messages.
 * 
 * <p>Java class for RequestMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://taxii.mitre.org/messages/taxii_xml_binding-1}MessageType"&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestMessageType")
@XmlSeeAlso({
    InboxMessage.class,
    PollRequest.class,
    SubscriptionManagementRequest.class,
    FeedInformationRequest.class,
    DiscoveryRequest.class
})
public abstract class RequestMessageType
    extends MessageType
    implements Equals, HashCode
{


    /**
     * Default no-arg constructor
     * 
     */
    public RequestMessageType() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public RequestMessageType(final ExtendedHeadersType extendedHeaders, final String messageId) {
        super(extendedHeaders, messageId);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof RequestMessageType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    @Override
    public RequestMessageType withExtendedHeaders(ExtendedHeadersType value) {
        setExtendedHeaders(value);
        return this;
    }

    @Override
    public RequestMessageType withMessageId(String value) {
        setMessageId(value);
        return this;
    }

}
