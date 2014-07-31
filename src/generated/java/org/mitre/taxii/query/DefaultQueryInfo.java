
package org.mitre.taxii.query;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 * <p>Java class for DefaultQueryInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DefaultQueryInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Targeting_Expression_Info" type="{http://taxii.mitre.org/query/taxii_default_query-1}TargetingExpressionInfoType"/>
 *         &lt;element name="Capability_Module" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DefaultQueryInfoType", propOrder = {
    "targetingExpressionInfo",
    "capabilityModules"
})
@XmlRootElement(name = "Default_Query_Info")
public class DefaultQueryInfo
    implements Equals, HashCode
{

    @XmlElement(name = "Targeting_Expression_Info", required = true)
    protected TargetingExpressionInfoType targetingExpressionInfo;
    @XmlElement(name = "Capability_Module", required = true)
    @XmlSchemaType(name = "anyURI")
    protected List<String> capabilityModules;

    /**
     * Gets the value of the targetingExpressionInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TargetingExpressionInfoType }
     *     
     */
    public TargetingExpressionInfoType getTargetingExpressionInfo() {
        return targetingExpressionInfo;
    }

    /**
     * Sets the value of the targetingExpressionInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetingExpressionInfoType }
     *     
     */
    public void setTargetingExpressionInfo(TargetingExpressionInfoType value) {
        this.targetingExpressionInfo = value;
    }

    /**
     * Gets the value of the capabilityModules property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the capabilityModules property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCapabilityModules().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCapabilityModules() {
        if (capabilityModules == null) {
            capabilityModules = new ArrayList<String>();
        }
        return this.capabilityModules;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DefaultQueryInfo)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DefaultQueryInfo that = ((DefaultQueryInfo) object);
        {
            TargetingExpressionInfoType lhsTargetingExpressionInfo;
            lhsTargetingExpressionInfo = this.getTargetingExpressionInfo();
            TargetingExpressionInfoType rhsTargetingExpressionInfo;
            rhsTargetingExpressionInfo = that.getTargetingExpressionInfo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "targetingExpressionInfo", lhsTargetingExpressionInfo), LocatorUtils.property(thatLocator, "targetingExpressionInfo", rhsTargetingExpressionInfo), lhsTargetingExpressionInfo, rhsTargetingExpressionInfo)) {
                return false;
            }
        }
        {
            List<String> lhsCapabilityModules;
            lhsCapabilityModules = (((this.capabilityModules!= null)&&(!this.capabilityModules.isEmpty()))?this.getCapabilityModules():null);
            List<String> rhsCapabilityModules;
            rhsCapabilityModules = (((that.capabilityModules!= null)&&(!that.capabilityModules.isEmpty()))?that.getCapabilityModules():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "capabilityModules", lhsCapabilityModules), LocatorUtils.property(thatLocator, "capabilityModules", rhsCapabilityModules), lhsCapabilityModules, rhsCapabilityModules)) {
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
            TargetingExpressionInfoType theTargetingExpressionInfo;
            theTargetingExpressionInfo = this.getTargetingExpressionInfo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "targetingExpressionInfo", theTargetingExpressionInfo), currentHashCode, theTargetingExpressionInfo);
        }
        {
            List<String> theCapabilityModules;
            theCapabilityModules = (((this.capabilityModules!= null)&&(!this.capabilityModules.isEmpty()))?this.getCapabilityModules():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "capabilityModules", theCapabilityModules), currentHashCode, theCapabilityModules);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
