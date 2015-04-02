
package org.mitre.taxii.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
 * <p>Java class for TestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="Parameter" type="{http://taxii.mitre.org/query/taxii_default_query-1}ParameterType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="capability_id" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *       &lt;attribute name="relationship" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TestType", propOrder = {
    "parameters"
})
public class TestType implements Equals, HashCode
{

    @XmlElement(name = "Parameter")
    protected List<ParameterType> parameters;
    @XmlAttribute(name = "capability_id", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String capabilityId;
    @XmlAttribute(name = "relationship", required = true)
    protected String relationship;

    /**
     * Default no-arg constructor
     * 
     */
    public TestType() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public TestType(final List<ParameterType> parameters, final String capabilityId, final String relationship) {
        this.parameters = parameters;
        this.capabilityId = capabilityId;
        this.relationship = relationship;
    }

    /**
     * Gets the value of the parameters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParameterType }
     * 
     * 
     */
    public List<ParameterType> getParameters() {
        if (parameters == null) {
            parameters = new ArrayList<ParameterType>();
        }
        return this.parameters;
    }

    /**
     * Gets the value of the capabilityId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapabilityId() {
        return capabilityId;
    }

    /**
     * Sets the value of the capabilityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapabilityId(String value) {
        this.capabilityId = value;
    }

    /**
     * Gets the value of the relationship property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelationship() {
        return relationship;
    }

    /**
     * Sets the value of the relationship property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelationship(String value) {
        this.relationship = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof TestType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final TestType that = ((TestType) object);
        {
            List<ParameterType> lhsParameters;
            lhsParameters = (((this.parameters!= null)&&(!this.parameters.isEmpty()))?this.getParameters():null);
            List<ParameterType> rhsParameters;
            rhsParameters = (((that.parameters!= null)&&(!that.parameters.isEmpty()))?that.getParameters():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "parameters", lhsParameters), LocatorUtils.property(thatLocator, "parameters", rhsParameters), lhsParameters, rhsParameters)) {
                return false;
            }
        }
        {
            String lhsCapabilityId;
            lhsCapabilityId = this.getCapabilityId();
            String rhsCapabilityId;
            rhsCapabilityId = that.getCapabilityId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "capabilityId", lhsCapabilityId), LocatorUtils.property(thatLocator, "capabilityId", rhsCapabilityId), lhsCapabilityId, rhsCapabilityId)) {
                return false;
            }
        }
        {
            String lhsRelationship;
            lhsRelationship = this.getRelationship();
            String rhsRelationship;
            rhsRelationship = that.getRelationship();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "relationship", lhsRelationship), LocatorUtils.property(thatLocator, "relationship", rhsRelationship), lhsRelationship, rhsRelationship)) {
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
            List<ParameterType> theParameters;
            theParameters = (((this.parameters!= null)&&(!this.parameters.isEmpty()))?this.getParameters():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "parameters", theParameters), currentHashCode, theParameters);
        }
        {
            String theCapabilityId;
            theCapabilityId = this.getCapabilityId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "capabilityId", theCapabilityId), currentHashCode, theCapabilityId);
        }
        {
            String theRelationship;
            theRelationship = this.getRelationship();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "relationship", theRelationship), currentHashCode, theRelationship);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public TestType withParameters(ParameterType... values) {
        if (values!= null) {
            for (ParameterType value: values) {
                getParameters().add(value);
            }
        }
        return this;
    }

    public TestType withParameters(Collection<ParameterType> values) {
        if (values!= null) {
            getParameters().addAll(values);
        }
        return this;
    }

    public TestType withCapabilityId(String value) {
        setCapabilityId(value);
        return this;
    }

    public TestType withRelationship(String value) {
        setRelationship(value);
        return this;
    }

}
