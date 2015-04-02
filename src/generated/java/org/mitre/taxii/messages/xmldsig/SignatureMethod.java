
package org.mitre.taxii.messages.xmldsig;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
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


/**
 * <p>Java class for SignatureMethodType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SignatureMethodType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HMACOutputLength" type="{http://www.w3.org/2000/09/xmldsig#}HMACOutputLengthType" minOccurs="0"/&gt;
 *         &lt;any namespace='##other' maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignatureMethodType", propOrder = {
    "content"
})
@XmlRootElement(name = "SignatureMethod")
public class SignatureMethod implements Equals, HashCode
{

    @XmlElementRef(name = "HMACOutputLength", namespace = "http://www.w3.org/2000/09/xmldsig#", type = JAXBElement.class, required = false)
    @XmlMixed
    @XmlAnyElement(lax = true)
    protected List<java.lang.Object> content;
    @XmlAttribute(name = "Algorithm", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String algorithm;

    /**
     * Default no-arg constructor
     * 
     */
    public SignatureMethod() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public SignatureMethod(final List<java.lang.Object> content, final String algorithm) {
        this.content = content;
        this.algorithm = algorithm;
    }

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link java.lang.Object }
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link String }
     * 
     * 
     */
    public List<java.lang.Object> getContent() {
        if (content == null) {
            content = new ArrayList<java.lang.Object>();
        }
        return this.content;
    }

    /**
     * Gets the value of the algorithm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * Sets the value of the algorithm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlgorithm(String value) {
        this.algorithm = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, java.lang.Object object, EqualsStrategy strategy) {
        if (!(object instanceof SignatureMethod)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SignatureMethod that = ((SignatureMethod) object);
        {
            List<java.lang.Object> lhsContent;
            lhsContent = (((this.content!= null)&&(!this.content.isEmpty()))?this.getContent():null);
            List<java.lang.Object> rhsContent;
            rhsContent = (((that.content!= null)&&(!that.content.isEmpty()))?that.getContent():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "content", lhsContent), LocatorUtils.property(thatLocator, "content", rhsContent), lhsContent, rhsContent)) {
                return false;
            }
        }
        {
            String lhsAlgorithm;
            lhsAlgorithm = this.getAlgorithm();
            String rhsAlgorithm;
            rhsAlgorithm = that.getAlgorithm();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "algorithm", lhsAlgorithm), LocatorUtils.property(thatLocator, "algorithm", rhsAlgorithm), lhsAlgorithm, rhsAlgorithm)) {
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
            List<java.lang.Object> theContent;
            theContent = (((this.content!= null)&&(!this.content.isEmpty()))?this.getContent():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "content", theContent), currentHashCode, theContent);
        }
        {
            String theAlgorithm;
            theAlgorithm = this.getAlgorithm();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "algorithm", theAlgorithm), currentHashCode, theAlgorithm);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public SignatureMethod withContent(java.lang.Object... values) {
        if (values!= null) {
            for (java.lang.Object value: values) {
                getContent().add(value);
            }
        }
        return this;
    }

    public SignatureMethod withContent(Collection<java.lang.Object> values) {
        if (values!= null) {
            getContent().addAll(values);
        }
        return this;
    }

    public SignatureMethod withAlgorithm(String value) {
        setAlgorithm(value);
        return this;
    }

}
