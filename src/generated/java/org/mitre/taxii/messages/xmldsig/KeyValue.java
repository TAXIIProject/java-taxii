
package org.mitre.taxii.messages.xmldsig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
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
import org.w3c.dom.Element;


/**
 * <p>Java class for KeyValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KeyValueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}DSAKeyValue"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}RSAKeyValue"/>
 *         &lt;any processContents='lax' namespace='##other'/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeyValueType", propOrder = {
    "content"
})
@XmlRootElement(name = "KeyValue")
public class KeyValue implements Equals, HashCode
{

    @XmlElementRefs({
        @XmlElementRef(name = "RSAKeyValue", namespace = "http://www.w3.org/2000/09/xmldsig#", type = RSAKeyValue.class, required = false),
        @XmlElementRef(name = "DSAKeyValue", namespace = "http://www.w3.org/2000/09/xmldsig#", type = DSAKeyValue.class, required = false)
    })
    @XmlMixed
    @XmlAnyElement(lax = true)
    protected List<java.lang.Object> content;

    /**
     * Default no-arg constructor
     * 
     */
    public KeyValue() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public KeyValue(final List<java.lang.Object> content) {
        this.content = content;
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
     * {@link RSAKeyValue }
     * {@link Element }
     * {@link DSAKeyValue }
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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, java.lang.Object object, EqualsStrategy strategy) {
        if (!(object instanceof KeyValue)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final KeyValue that = ((KeyValue) object);
        {
            List<java.lang.Object> lhsContent;
            lhsContent = (((this.content!= null)&&(!this.content.isEmpty()))?this.getContent():null);
            List<java.lang.Object> rhsContent;
            rhsContent = (((that.content!= null)&&(!that.content.isEmpty()))?that.getContent():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "content", lhsContent), LocatorUtils.property(thatLocator, "content", rhsContent), lhsContent, rhsContent)) {
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
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public KeyValue withContent(java.lang.Object... values) {
        if (values!= null) {
            for (java.lang.Object value: values) {
                getContent().add(value);
            }
        }
        return this;
    }

    public KeyValue withContent(Collection<java.lang.Object> values) {
        if (values!= null) {
            getContent().addAll(values);
        }
        return this;
    }

}
