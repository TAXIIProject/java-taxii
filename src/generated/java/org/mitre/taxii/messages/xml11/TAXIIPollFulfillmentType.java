
package org.mitre.taxii.messages.xml11;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
import org.mitre.taxii.messages.xmldsig.SignatureType;


/**
 * A request to to collect a prepared result set.
 * 
 * <p>Java class for TAXIIPollFulfillmentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAXIIPollFulfillmentType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}RequestMessageType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="collection_name" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="result_id" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="result_part_number" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAXIIPollFulfillmentType", propOrder = {
    "signature"
})
public class TAXIIPollFulfillmentType
    extends RequestMessageType
    implements Equals, HashCode
{

    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected SignatureType signature;
    @XmlAttribute(name = "collection_name", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String collectionName;
    @XmlAttribute(name = "result_id", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String resultId;
    @XmlAttribute(name = "result_part_number")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger resultPartNumber;

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
        return resultPartNumber;
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
        if (!(object instanceof TAXIIPollFulfillmentType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final TAXIIPollFulfillmentType that = ((TAXIIPollFulfillmentType) object);
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
            String lhsCollectionName;
            lhsCollectionName = this.getCollectionName();
            String rhsCollectionName;
            rhsCollectionName = that.getCollectionName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "collectionName", lhsCollectionName), LocatorUtils.property(thatLocator, "collectionName", rhsCollectionName), lhsCollectionName, rhsCollectionName)) {
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
            SignatureType theSignature;
            theSignature = this.getSignature();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signature", theSignature), currentHashCode, theSignature);
        }
        {
            String theCollectionName;
            theCollectionName = this.getCollectionName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "collectionName", theCollectionName), currentHashCode, theCollectionName);
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

}
