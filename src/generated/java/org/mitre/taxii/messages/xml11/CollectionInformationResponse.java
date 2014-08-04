
package org.mitre.taxii.messages.xml11;

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
 * A response to a Collection Information Request. Contains 0 or more Collection records.
 * 
 * <p>Java class for TAXIICollectionInformationResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAXIICollectionInformationResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}ResponseMessageType">
 *       &lt;sequence>
 *         &lt;element name="Collection" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}CollectionRecordType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAXIICollectionInformationResponseType", propOrder = {
    "collections",
    "signature"
})
@XmlRootElement(name = "Collection_Information_Response")
public class CollectionInformationResponse
    extends ResponseMessageType
    implements Equals, HashCode
{

    @XmlElement(name = "Collection")
    protected List<CollectionRecordType> collections;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected Signature signature;

    /**
     * Default no-arg constructor
     * 
     */
    public CollectionInformationResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public CollectionInformationResponse(final ExtendedHeadersType extendedHeaders, final String messageId, final String inResponseTo, final List<CollectionRecordType> collections, final Signature signature) {
        super(extendedHeaders, messageId, inResponseTo);
        this.collections = collections;
        this.signature = signature;
    }

    /**
     * Gets the value of the collections property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the collections property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCollections().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CollectionRecordType }
     * 
     * 
     */
    public List<CollectionRecordType> getCollections() {
        if (collections == null) {
            collections = new ArrayList<CollectionRecordType>();
        }
        return this.collections;
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
        if (!(object instanceof CollectionInformationResponse)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final CollectionInformationResponse that = ((CollectionInformationResponse) object);
        {
            List<CollectionRecordType> lhsCollections;
            lhsCollections = (((this.collections!= null)&&(!this.collections.isEmpty()))?this.getCollections():null);
            List<CollectionRecordType> rhsCollections;
            rhsCollections = (((that.collections!= null)&&(!that.collections.isEmpty()))?that.getCollections():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "collections", lhsCollections), LocatorUtils.property(thatLocator, "collections", rhsCollections), lhsCollections, rhsCollections)) {
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
            List<CollectionRecordType> theCollections;
            theCollections = (((this.collections!= null)&&(!this.collections.isEmpty()))?this.getCollections():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "collections", theCollections), currentHashCode, theCollections);
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

    public CollectionInformationResponse withCollections(CollectionRecordType... values) {
        if (values!= null) {
            for (CollectionRecordType value: values) {
                getCollections().add(value);
            }
        }
        return this;
    }

    public CollectionInformationResponse withCollections(Collection<CollectionRecordType> values) {
        if (values!= null) {
            getCollections().addAll(values);
        }
        return this;
    }

    public CollectionInformationResponse withSignature(Signature value) {
        setSignature(value);
        return this;
    }

    @Override
    public CollectionInformationResponse withInResponseTo(String value) {
        setInResponseTo(value);
        return this;
    }

    @Override
    public CollectionInformationResponse withExtendedHeaders(ExtendedHeadersType value) {
        setExtendedHeaders(value);
        return this;
    }

    @Override
    public CollectionInformationResponse withMessageId(String value) {
        setMessageId(value);
        return this;
    }

}
