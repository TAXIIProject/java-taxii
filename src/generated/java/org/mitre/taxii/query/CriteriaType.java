
package org.mitre.taxii.query;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 * <p>Java class for CriteriaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CriteriaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="Criteria" type="{http://taxii.mitre.org/query/taxii_default_query-1}CriteriaType"/>
 *         &lt;element name="Criterion" type="{http://taxii.mitre.org/query/taxii_default_query-1}CriterionType"/>
 *       &lt;/choice>
 *       &lt;attribute name="operator" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="OR"/>
 *             &lt;pattern value="AND"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CriteriaType", propOrder = {
    "criteriasAndCriterions"
})
public class CriteriaType implements Equals, HashCode
{

    @XmlElements({
        @XmlElement(name = "Criteria", type = CriteriaType.class),
        @XmlElement(name = "Criterion", type = CriterionType.class)
    })
    protected List<Object> criteriasAndCriterions;
    @XmlAttribute(name = "operator", required = true)
    protected String operator;

    /**
     * Gets the value of the criteriasAndCriterions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the criteriasAndCriterions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCriteriasAndCriterions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CriteriaType }
     * {@link CriterionType }
     * 
     * 
     */
    public List<Object> getCriteriasAndCriterions() {
        if (criteriasAndCriterions == null) {
            criteriasAndCriterions = new ArrayList<Object>();
        }
        return this.criteriasAndCriterions;
    }

    /**
     * Gets the value of the operator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Sets the value of the operator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperator(String value) {
        this.operator = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CriteriaType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CriteriaType that = ((CriteriaType) object);
        {
            List<Object> lhsCriteriasAndCriterions;
            lhsCriteriasAndCriterions = (((this.criteriasAndCriterions!= null)&&(!this.criteriasAndCriterions.isEmpty()))?this.getCriteriasAndCriterions():null);
            List<Object> rhsCriteriasAndCriterions;
            rhsCriteriasAndCriterions = (((that.criteriasAndCriterions!= null)&&(!that.criteriasAndCriterions.isEmpty()))?that.getCriteriasAndCriterions():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "criteriasAndCriterions", lhsCriteriasAndCriterions), LocatorUtils.property(thatLocator, "criteriasAndCriterions", rhsCriteriasAndCriterions), lhsCriteriasAndCriterions, rhsCriteriasAndCriterions)) {
                return false;
            }
        }
        {
            String lhsOperator;
            lhsOperator = this.getOperator();
            String rhsOperator;
            rhsOperator = that.getOperator();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "operator", lhsOperator), LocatorUtils.property(thatLocator, "operator", rhsOperator), lhsOperator, rhsOperator)) {
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
            List<Object> theCriteriasAndCriterions;
            theCriteriasAndCriterions = (((this.criteriasAndCriterions!= null)&&(!this.criteriasAndCriterions.isEmpty()))?this.getCriteriasAndCriterions():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "criteriasAndCriterions", theCriteriasAndCriterions), currentHashCode, theCriteriasAndCriterions);
        }
        {
            String theOperator;
            theOperator = this.getOperator();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "operator", theOperator), currentHashCode, theOperator);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
