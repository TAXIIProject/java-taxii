
package org.mitre.taxii.messages.xml10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * A response to a Feed Information Request. Contains 0 or more feed records.
 * 
 * <p>Java class for TAXIIFeedInformationResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAXIIFeedInformationResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://taxii.mitre.org/messages/taxii_xml_binding-1}ResponseMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Feed" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1}FeedRecordType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAXIIFeedInformationResponseType", propOrder = {
    "feeds",
    "signature"
})
@XmlRootElement(name = "Feed_Information_Response")
public class FeedInformationResponse
    extends ResponseMessageType
    implements Equals, HashCode
{

    @XmlElement(name = "Feed")
    protected List<FeedRecordType> feeds;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected Signature signature;

    /**
     * Default no-arg constructor
     * 
     */
    public FeedInformationResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public FeedInformationResponse(final ExtendedHeadersType extendedHeaders, final String messageId, final String inResponseTo, final List<FeedRecordType> feeds, final Signature signature) {
        super(extendedHeaders, messageId, inResponseTo);
        this.feeds = feeds;
        this.signature = signature;
    }

    /**
     * Gets the value of the feeds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feeds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeeds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeedRecordType }
     * 
     * 
     */
    public List<FeedRecordType> getFeeds() {
        if (feeds == null) {
            feeds = new ArrayList<FeedRecordType>();
        }
        return this.feeds;
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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FeedInformationResponse)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final FeedInformationResponse that = ((FeedInformationResponse) object);
        {
            List<FeedRecordType> lhsFeeds;
            lhsFeeds = (((this.feeds!= null)&&(!this.feeds.isEmpty()))?this.getFeeds():null);
            List<FeedRecordType> rhsFeeds;
            rhsFeeds = (((that.feeds!= null)&&(!that.feeds.isEmpty()))?that.getFeeds():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "feeds", lhsFeeds), LocatorUtils.property(thatLocator, "feeds", rhsFeeds), lhsFeeds, rhsFeeds)) {
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
        int currentHashCode = super.hashCode(locator, strategy);
        {
            List<FeedRecordType> theFeeds;
            theFeeds = (((this.feeds!= null)&&(!this.feeds.isEmpty()))?this.getFeeds():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "feeds", theFeeds), currentHashCode, theFeeds);
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

    public FeedInformationResponse withFeeds(FeedRecordType... values) {
        if (values!= null) {
            for (FeedRecordType value: values) {
                getFeeds().add(value);
            }
        }
        return this;
    }

    public FeedInformationResponse withFeeds(Collection<FeedRecordType> values) {
        if (values!= null) {
            getFeeds().addAll(values);
        }
        return this;
    }

    public FeedInformationResponse withSignature(Signature value) {
        setSignature(value);
        return this;
    }

    @Override
    public FeedInformationResponse withInResponseTo(String value) {
        setInResponseTo(value);
        return this;
    }

    @Override
    public FeedInformationResponse withExtendedHeaders(ExtendedHeadersType value) {
        setExtendedHeaders(value);
        return this;
    }

    @Override
    public FeedInformationResponse withMessageId(String value) {
        setMessageId(value);
        return this;
    }

}
