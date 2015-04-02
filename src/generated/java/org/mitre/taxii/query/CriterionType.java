
package org.mitre.taxii.query;

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
 * <p>Java class for CriterionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CriterionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Target" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Test" type="{http://taxii.mitre.org/query/taxii_default_query-1}TestType"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="negate" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CriterionType", propOrder = {
    "target",
    "test"
})
public class CriterionType implements Equals, HashCode
{

    @XmlElement(name = "Target", required = true)
    protected String target;
    @XmlElement(name = "Test", required = true)
    protected TestType test;
    @XmlAttribute(name = "negate")
    protected Boolean negate;

    /**
     * Default no-arg constructor
     * 
     */
    public CriterionType() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public CriterionType(final String target, final TestType test, final Boolean negate) {
        this.target = target;
        this.test = test;
        this.negate = negate;
    }

    /**
     * Gets the value of the target property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTarget(String value) {
        this.target = value;
    }

    /**
     * Gets the value of the test property.
     * 
     * @return
     *     possible object is
     *     {@link TestType }
     *     
     */
    public TestType getTest() {
        return test;
    }

    /**
     * Sets the value of the test property.
     * 
     * @param value
     *     allowed object is
     *     {@link TestType }
     *     
     */
    public void setTest(TestType value) {
        this.test = value;
    }

    /**
     * Gets the value of the negate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isNegate() {
        if (negate == null) {
            return false;
        } else {
            return negate;
        }
    }

    /**
     * Sets the value of the negate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNegate(Boolean value) {
        this.negate = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CriterionType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CriterionType that = ((CriterionType) object);
        {
            String lhsTarget;
            lhsTarget = this.getTarget();
            String rhsTarget;
            rhsTarget = that.getTarget();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "target", lhsTarget), LocatorUtils.property(thatLocator, "target", rhsTarget), lhsTarget, rhsTarget)) {
                return false;
            }
        }
        {
            TestType lhsTest;
            lhsTest = this.getTest();
            TestType rhsTest;
            rhsTest = that.getTest();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "test", lhsTest), LocatorUtils.property(thatLocator, "test", rhsTest), lhsTest, rhsTest)) {
                return false;
            }
        }
        {
            boolean lhsNegate;
            lhsNegate = ((this.negate!= null)?this.isNegate():false);
            boolean rhsNegate;
            rhsNegate = ((that.negate!= null)?that.isNegate():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "negate", lhsNegate), LocatorUtils.property(thatLocator, "negate", rhsNegate), lhsNegate, rhsNegate)) {
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
            String theTarget;
            theTarget = this.getTarget();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "target", theTarget), currentHashCode, theTarget);
        }
        {
            TestType theTest;
            theTest = this.getTest();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "test", theTest), currentHashCode, theTest);
        }
        {
            boolean theNegate;
            theNegate = ((this.negate!= null)?this.isNegate():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "negate", theNegate), currentHashCode, theNegate);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public CriterionType withTarget(String value) {
        setTarget(value);
        return this;
    }

    public CriterionType withTest(TestType value) {
        setTest(value);
        return this;
    }

    public CriterionType withNegate(Boolean value) {
        setNegate(value);
        return this;
    }

}
