
package org.mitre.taxii.messages.xml11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * The base type of response messages.
 * 
 * <p>Java class for ResponseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseMessageType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}MessageType">
 *       &lt;attribute name="in_response_to" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseMessageType")
@XmlSeeAlso({
    TAXIISubscriptionManagementResponseType.class,
    TAXIIStatusMessageType.class,
    TAXIIPollResponseType.class,
    TAXIICollectionInformationResponseType.class,
    TAXIIDiscoveryResponseType.class
})
public abstract class ResponseMessageType
    extends MessageType
    implements Equals
{

    @XmlAttribute(name = "in_response_to", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String inResponseTo;

    /**
     * Gets the value of the inResponseTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInResponseTo() {
        return inResponseTo;
    }

    /**
     * Sets the value of the inResponseTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInResponseTo(String value) {
        this.inResponseTo = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ResponseMessageType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final ResponseMessageType that = ((ResponseMessageType) object);
        {
            String lhsInResponseTo;
            lhsInResponseTo = this.getInResponseTo();
            String rhsInResponseTo;
            rhsInResponseTo = that.getInResponseTo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "inResponseTo", lhsInResponseTo), LocatorUtils.property(thatLocator, "inResponseTo", rhsInResponseTo), lhsInResponseTo, rhsInResponseTo)) {
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
