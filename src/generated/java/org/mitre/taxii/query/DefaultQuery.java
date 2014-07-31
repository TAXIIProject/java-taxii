
package org.mitre.taxii.query;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 * <p>Java class for DefaultQueryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DefaultQueryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Criteria" type="{http://taxii.mitre.org/query/taxii_default_query-1}CriteriaType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="targeting_expression_id" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DefaultQueryType", propOrder = {
    "criteria"
})
@XmlRootElement(name = "Default_Query")
public class DefaultQuery
    implements Equals, HashCode
{

    @XmlElement(name = "Criteria", required = true)
    protected CriteriaType criteria;
    @XmlAttribute(name = "targeting_expression_id", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String targetingExpressionId;

    /**
     * Gets the value of the criteria property.
     * 
     * @return
     *     possible object is
     *     {@link CriteriaType }
     *     
     */
    public CriteriaType getCriteria() {
        return criteria;
    }

    /**
     * Sets the value of the criteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link CriteriaType }
     *     
     */
    public void setCriteria(CriteriaType value) {
        this.criteria = value;
    }

    /**
     * Gets the value of the targetingExpressionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetingExpressionId() {
        return targetingExpressionId;
    }

    /**
     * Sets the value of the targetingExpressionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetingExpressionId(String value) {
        this.targetingExpressionId = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DefaultQuery)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DefaultQuery that = ((DefaultQuery) object);
        {
            CriteriaType lhsCriteria;
            lhsCriteria = this.getCriteria();
            CriteriaType rhsCriteria;
            rhsCriteria = that.getCriteria();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "criteria", lhsCriteria), LocatorUtils.property(thatLocator, "criteria", rhsCriteria), lhsCriteria, rhsCriteria)) {
                return false;
            }
        }
        {
            String lhsTargetingExpressionId;
            lhsTargetingExpressionId = this.getTargetingExpressionId();
            String rhsTargetingExpressionId;
            rhsTargetingExpressionId = that.getTargetingExpressionId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "targetingExpressionId", lhsTargetingExpressionId), LocatorUtils.property(thatLocator, "targetingExpressionId", rhsTargetingExpressionId), lhsTargetingExpressionId, rhsTargetingExpressionId)) {
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
            CriteriaType theCriteria;
            theCriteria = this.getCriteria();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "criteria", theCriteria), currentHashCode, theCriteria);
        }
        {
            String theTargetingExpressionId;
            theTargetingExpressionId = this.getTargetingExpressionId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "targetingExpressionId", theTargetingExpressionId), currentHashCode, theTargetingExpressionId);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
