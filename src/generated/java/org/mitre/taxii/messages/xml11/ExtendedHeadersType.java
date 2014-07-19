
package org.mitre.taxii.messages.xml11;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
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
 * &lt;complexType name="ExtendedHeadersType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Extended_Header" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}ExtendedHeaderType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtendedHeadersType", propOrder = {
    "extendedHeader"
})
public class ExtendedHeadersType
    implements Equals
{

    @XmlElement(name = "Extended_Header", required = true)
    protected List<ExtendedHeaderType> extendedHeader;

    /**
     * Gets the value of the extendedHeader property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extendedHeader property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtendedHeader().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtendedHeaderType }
     * 
     * 
     */
    public List<ExtendedHeaderType> getExtendedHeader() {
        if (extendedHeader == null) {
            extendedHeader = new ArrayList<ExtendedHeaderType>();
        }
        return this.extendedHeader;
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
            List<ExtendedHeaderType> lhsExtendedHeader;
            lhsExtendedHeader = (((this.extendedHeader!= null)&&(!this.extendedHeader.isEmpty()))?this.getExtendedHeader():null);
            List<ExtendedHeaderType> rhsExtendedHeader;
            rhsExtendedHeader = (((that.extendedHeader!= null)&&(!that.extendedHeader.isEmpty()))?that.getExtendedHeader():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "extendedHeader", lhsExtendedHeader), LocatorUtils.property(thatLocator, "extendedHeader", rhsExtendedHeader), lhsExtendedHeader, rhsExtendedHeader)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

}
