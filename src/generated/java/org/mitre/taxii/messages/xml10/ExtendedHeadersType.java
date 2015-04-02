
package org.mitre.taxii.messages.xml10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 * Holds one or more extended headers for the message.
 * 
 * <p>Java class for ExtendedHeadersType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtendedHeadersType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Extended_Header" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1}ExtendedHeaderType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtendedHeadersType", propOrder = {
    "extendedHeaders"
})
public class ExtendedHeadersType implements Equals, HashCode
{

    @XmlElement(name = "Extended_Header", required = true)
    protected List<ExtendedHeaderType> extendedHeaders;

    /**
     * Default no-arg constructor
     * 
     */
    public ExtendedHeadersType() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public ExtendedHeadersType(final List<ExtendedHeaderType> extendedHeaders) {
        this.extendedHeaders = extendedHeaders;
    }

    /**
     * Gets the value of the extendedHeaders property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extendedHeaders property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtendedHeaders().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtendedHeaderType }
     * 
     * 
     */
    public List<ExtendedHeaderType> getExtendedHeaders() {
        if (extendedHeaders == null) {
            extendedHeaders = new ArrayList<ExtendedHeaderType>();
        }
        return this.extendedHeaders;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ExtendedHeadersType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ExtendedHeadersType that = ((ExtendedHeadersType) object);
        {
            List<ExtendedHeaderType> lhsExtendedHeaders;
            lhsExtendedHeaders = (((this.extendedHeaders!= null)&&(!this.extendedHeaders.isEmpty()))?this.getExtendedHeaders():null);
            List<ExtendedHeaderType> rhsExtendedHeaders;
            rhsExtendedHeaders = (((that.extendedHeaders!= null)&&(!that.extendedHeaders.isEmpty()))?that.getExtendedHeaders():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "extendedHeaders", lhsExtendedHeaders), LocatorUtils.property(thatLocator, "extendedHeaders", rhsExtendedHeaders), lhsExtendedHeaders, rhsExtendedHeaders)) {
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
            List<ExtendedHeaderType> theExtendedHeaders;
            theExtendedHeaders = (((this.extendedHeaders!= null)&&(!this.extendedHeaders.isEmpty()))?this.getExtendedHeaders():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "extendedHeaders", theExtendedHeaders), currentHashCode, theExtendedHeaders);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public ExtendedHeadersType withExtendedHeaders(ExtendedHeaderType... values) {
        if (values!= null) {
            for (ExtendedHeaderType value: values) {
                getExtendedHeaders().add(value);
            }
        }
        return this;
    }

    public ExtendedHeadersType withExtendedHeaders(Collection<ExtendedHeaderType> values) {
        if (values!= null) {
            getExtendedHeaders().addAll(values);
        }
        return this;
    }

}
