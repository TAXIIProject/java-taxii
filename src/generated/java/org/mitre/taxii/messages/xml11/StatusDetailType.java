
package org.mitre.taxii.messages.xml11;

import java.util.ArrayList;
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
    "detail"
})
public class StatusDetailType
    implements Equals, HashCode
{

    @XmlElement(name = "Detail", required = true)
    protected List<StatusDetailDetailType> detail;

    /**
     * Gets the value of the detail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StatusDetailDetailType }
     * 
     * 
     */
    public List<StatusDetailDetailType> getDetail() {
        if (detail == null) {
            detail = new ArrayList<StatusDetailDetailType>();
        }
        return this.detail;
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
            List<StatusDetailDetailType> lhsDetail;
            lhsDetail = (((this.detail!= null)&&(!this.detail.isEmpty()))?this.getDetail():null);
            List<StatusDetailDetailType> rhsDetail;
            rhsDetail = (((that.detail!= null)&&(!that.detail.isEmpty()))?that.getDetail():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "detail", lhsDetail), LocatorUtils.property(thatLocator, "detail", rhsDetail), lhsDetail, rhsDetail)) {
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
            List<StatusDetailDetailType> theDetail;
            theDetail = (((this.detail!= null)&&(!this.detail.isEmpty()))?this.getDetail():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "detail", theDetail), currentHashCode, theDetail);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
