
package org.mitre.taxii.messages.xml11;

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
 * Contains machine readable information about a Status Message.
 * 
 * <p>Java class for StatusDetailType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatusDetailType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Detail" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}StatusDetailDetailType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatusDetailType", propOrder = {
    "details"
})
public class StatusDetailType implements Equals, HashCode
{

    @XmlElement(name = "Detail", required = true)
    protected List<StatusDetailDetailType> details;

    /**
     * Default no-arg constructor
     * 
     */
    public StatusDetailType() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public StatusDetailType(final List<StatusDetailDetailType> details) {
        this.details = details;
    }

    /**
     * Gets the value of the details property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the details property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StatusDetailDetailType }
     * 
     * 
     */
    public List<StatusDetailDetailType> getDetails() {
        if (details == null) {
            details = new ArrayList<StatusDetailDetailType>();
        }
        return this.details;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof StatusDetailType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final StatusDetailType that = ((StatusDetailType) object);
        {
            List<StatusDetailDetailType> lhsDetails;
            lhsDetails = (((this.details!= null)&&(!this.details.isEmpty()))?this.getDetails():null);
            List<StatusDetailDetailType> rhsDetails;
            rhsDetails = (((that.details!= null)&&(!that.details.isEmpty()))?that.getDetails():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "details", lhsDetails), LocatorUtils.property(thatLocator, "details", rhsDetails), lhsDetails, rhsDetails)) {
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
            List<StatusDetailDetailType> theDetails;
            theDetails = (((this.details!= null)&&(!this.details.isEmpty()))?this.getDetails():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "details", theDetails), currentHashCode, theDetails);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public StatusDetailType withDetails(StatusDetailDetailType... values) {
        if (values!= null) {
            for (StatusDetailDetailType value: values) {
                getDetails().add(value);
            }
        }
        return this;
    }

    public StatusDetailType withDetails(Collection<StatusDetailDetailType> values) {
        if (values!= null) {
            getDetails().addAll(values);
        }
        return this;
    }

}
