
package org.mitre.taxii.messages.xml11;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


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
public class ExtendedHeadersType {

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

}
