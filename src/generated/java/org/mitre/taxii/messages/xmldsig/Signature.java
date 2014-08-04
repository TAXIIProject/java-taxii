
package org.mitre.taxii.messages.xmldsig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Java class for SignatureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SignatureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}SignedInfo"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}SignatureValue"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}KeyInfo" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Object" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignatureType", propOrder = {
    "signedInfo",
    "signatureValue",
    "keyInfo",
    "objects"
})
@XmlRootElement(name = "Signature")
public class Signature implements Equals, HashCode
{

    @XmlElement(name = "SignedInfo", required = true)
    protected SignedInfo signedInfo;
    @XmlElement(name = "SignatureValue", required = true)
    protected SignatureValue signatureValue;
    @XmlElement(name = "KeyInfo")
    protected KeyInfo keyInfo;
    @XmlElement(name = "Object")
    protected List<org.mitre.taxii.messages.xmldsig.Object> objects;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Default no-arg constructor
     * 
     */
    public Signature() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public Signature(final SignedInfo signedInfo, final SignatureValue signatureValue, final KeyInfo keyInfo, final List<org.mitre.taxii.messages.xmldsig.Object> objects, final String id) {
        this.signedInfo = signedInfo;
        this.signatureValue = signatureValue;
        this.keyInfo = keyInfo;
        this.objects = objects;
        this.id = id;
    }

    /**
     * Gets the value of the signedInfo property.
     * 
     * @return
     *     possible object is
     *     {@link SignedInfo }
     *     
     */
    public SignedInfo getSignedInfo() {
        return signedInfo;
    }

    /**
     * Sets the value of the signedInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignedInfo }
     *     
     */
    public void setSignedInfo(SignedInfo value) {
        this.signedInfo = value;
    }

    /**
     * Gets the value of the signatureValue property.
     * 
     * @return
     *     possible object is
     *     {@link SignatureValue }
     *     
     */
    public SignatureValue getSignatureValue() {
        return signatureValue;
    }

    /**
     * Sets the value of the signatureValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureValue }
     *     
     */
    public void setSignatureValue(SignatureValue value) {
        this.signatureValue = value;
    }

    /**
     * Gets the value of the keyInfo property.
     * 
     * @return
     *     possible object is
     *     {@link KeyInfo }
     *     
     */
    public KeyInfo getKeyInfo() {
        return keyInfo;
    }

    /**
     * Sets the value of the keyInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeyInfo }
     *     
     */
    public void setKeyInfo(KeyInfo value) {
        this.keyInfo = value;
    }

    /**
     * Gets the value of the objects property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objects property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjects().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link org.mitre.taxii.messages.xmldsig.Object }
     * 
     * 
     */
    public List<org.mitre.taxii.messages.xmldsig.Object> getObjects() {
        if (objects == null) {
            objects = new ArrayList<org.mitre.taxii.messages.xmldsig.Object>();
        }
        return this.objects;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, java.lang.Object object, EqualsStrategy strategy) {
        if (!(object instanceof Signature)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Signature that = ((Signature) object);
        {
            SignedInfo lhsSignedInfo;
            lhsSignedInfo = this.getSignedInfo();
            SignedInfo rhsSignedInfo;
            rhsSignedInfo = that.getSignedInfo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "signedInfo", lhsSignedInfo), LocatorUtils.property(thatLocator, "signedInfo", rhsSignedInfo), lhsSignedInfo, rhsSignedInfo)) {
                return false;
            }
        }
        {
            SignatureValue lhsSignatureValue;
            lhsSignatureValue = this.getSignatureValue();
            SignatureValue rhsSignatureValue;
            rhsSignatureValue = that.getSignatureValue();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "signatureValue", lhsSignatureValue), LocatorUtils.property(thatLocator, "signatureValue", rhsSignatureValue), lhsSignatureValue, rhsSignatureValue)) {
                return false;
            }
        }
        {
            KeyInfo lhsKeyInfo;
            lhsKeyInfo = this.getKeyInfo();
            KeyInfo rhsKeyInfo;
            rhsKeyInfo = that.getKeyInfo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "keyInfo", lhsKeyInfo), LocatorUtils.property(thatLocator, "keyInfo", rhsKeyInfo), lhsKeyInfo, rhsKeyInfo)) {
                return false;
            }
        }
        {
            List<org.mitre.taxii.messages.xmldsig.Object> lhsObjects;
            lhsObjects = (((this.objects!= null)&&(!this.objects.isEmpty()))?this.getObjects():null);
            List<org.mitre.taxii.messages.xmldsig.Object> rhsObjects;
            rhsObjects = (((that.objects!= null)&&(!that.objects.isEmpty()))?that.getObjects():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "objects", lhsObjects), LocatorUtils.property(thatLocator, "objects", rhsObjects), lhsObjects, rhsObjects)) {
                return false;
            }
        }
        {
            String lhsId;
            lhsId = this.getId();
            String rhsId;
            rhsId = that.getId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "id", lhsId), LocatorUtils.property(thatLocator, "id", rhsId), lhsId, rhsId)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(java.lang.Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            SignedInfo theSignedInfo;
            theSignedInfo = this.getSignedInfo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signedInfo", theSignedInfo), currentHashCode, theSignedInfo);
        }
        {
            SignatureValue theSignatureValue;
            theSignatureValue = this.getSignatureValue();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signatureValue", theSignatureValue), currentHashCode, theSignatureValue);
        }
        {
            KeyInfo theKeyInfo;
            theKeyInfo = this.getKeyInfo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "keyInfo", theKeyInfo), currentHashCode, theKeyInfo);
        }
        {
            List<org.mitre.taxii.messages.xmldsig.Object> theObjects;
            theObjects = (((this.objects!= null)&&(!this.objects.isEmpty()))?this.getObjects():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "objects", theObjects), currentHashCode, theObjects);
        }
        {
            String theId;
            theId = this.getId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "id", theId), currentHashCode, theId);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public Signature withSignedInfo(SignedInfo value) {
        setSignedInfo(value);
        return this;
    }

    public Signature withSignatureValue(SignatureValue value) {
        setSignatureValue(value);
        return this;
    }

    public Signature withKeyInfo(KeyInfo value) {
        setKeyInfo(value);
        return this;
    }

    public Signature withObjects(org.mitre.taxii.messages.xmldsig.Object... values) {
        if (values!= null) {
            for (org.mitre.taxii.messages.xmldsig.Object value: values) {
                getObjects().add(value);
            }
        }
        return this;
    }

    public Signature withObjects(Collection<org.mitre.taxii.messages.xmldsig.Object> values) {
        if (values!= null) {
            getObjects().addAll(values);
        }
        return this;
    }

    public Signature withId(String value) {
        setId(value);
        return this;
    }

}
