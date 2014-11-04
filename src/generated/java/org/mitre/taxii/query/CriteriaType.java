
package org.mitre.taxii.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 * <p>Java class for CriteriaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CriteriaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Criteria" type="{http://taxii.mitre.org/query/taxii_default_query-1}CriteriaType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Criterion" type="{http://taxii.mitre.org/query/taxii_default_query-1}CriterionType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
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
    "criterias",
    "criterions"
})
public class CriteriaType implements Equals, HashCode
{

    @XmlElement(name = "Criteria")
    protected List<CriteriaType> criterias;
    @XmlElement(name = "Criterion")
    protected List<CriterionType> criterions;
    @XmlAttribute(name = "operator", required = true)
    protected String operator;

    /**
     * Default no-arg constructor
     * 
     */
    public CriteriaType() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public CriteriaType(final List<CriteriaType> criterias, final List<CriterionType> criterions, final String operator) {
        this.criterias = criterias;
        this.criterions = criterions;
        this.operator = operator;
    }

    /**
     * Gets the value of the criterias property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the criterias property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCriterias().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CriteriaType }
     * 
     * 
     */
    public List<CriteriaType> getCriterias() {
        if (criterias == null) {
            criterias = new ArrayList<CriteriaType>();
        }
        return this.criterias;
    }

    /**
     * Gets the value of the criterions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the criterions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCriterions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CriterionType }
     * 
     * 
     */
    public List<CriterionType> getCriterions() {
        if (criterions == null) {
            criterions = new ArrayList<CriterionType>();
        }
        return this.criterions;
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
            List<CriteriaType> lhsCriterias;
            lhsCriterias = (((this.criterias!= null)&&(!this.criterias.isEmpty()))?this.getCriterias():null);
            List<CriteriaType> rhsCriterias;
            rhsCriterias = (((that.criterias!= null)&&(!that.criterias.isEmpty()))?that.getCriterias():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "criterias", lhsCriterias), LocatorUtils.property(thatLocator, "criterias", rhsCriterias), lhsCriterias, rhsCriterias)) {
                return false;
            }
        }
        {
            List<CriterionType> lhsCriterions;
            lhsCriterions = (((this.criterions!= null)&&(!this.criterions.isEmpty()))?this.getCriterions():null);
            List<CriterionType> rhsCriterions;
            rhsCriterions = (((that.criterions!= null)&&(!that.criterions.isEmpty()))?that.getCriterions():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "criterions", lhsCriterions), LocatorUtils.property(thatLocator, "criterions", rhsCriterions), lhsCriterions, rhsCriterions)) {
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
            List<CriteriaType> theCriterias;
            theCriterias = (((this.criterias!= null)&&(!this.criterias.isEmpty()))?this.getCriterias():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "criterias", theCriterias), currentHashCode, theCriterias);
        }
        {
            List<CriterionType> theCriterions;
            theCriterions = (((this.criterions!= null)&&(!this.criterions.isEmpty()))?this.getCriterions():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "criterions", theCriterions), currentHashCode, theCriterions);
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

    public CriteriaType withCriterias(CriteriaType... values) {
        if (values!= null) {
            for (CriteriaType value: values) {
                getCriterias().add(value);
            }
        }
        return this;
    }

    public CriteriaType withCriterias(Collection<CriteriaType> values) {
        if (values!= null) {
            getCriterias().addAll(values);
        }
        return this;
    }

    public CriteriaType withCriterions(CriterionType... values) {
        if (values!= null) {
            for (CriterionType value: values) {
                getCriterions().add(value);
            }
        }
        return this;
    }

    public CriteriaType withCriterions(Collection<CriterionType> values) {
        if (values!= null) {
            getCriterions().addAll(values);
        }
        return this;
    }

    public CriteriaType withOperator(String value) {
        setOperator(value);
        return this;
    }

}
