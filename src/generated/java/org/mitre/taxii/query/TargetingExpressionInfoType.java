
package org.mitre.taxii.query;

import java.util.ArrayList;
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
 * <p>Java class for TargetingExpressionInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TargetingExpressionInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Preferred_Scope" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Allowed_Scope" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="targeting_expression_id" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetingExpressionInfoType", propOrder = {
    "preferredScopes",
    "allowedScopes"
})
public class TargetingExpressionInfoType
    implements Equals, HashCode
{

    @XmlElement(name = "Preferred_Scope")
    protected List<String> preferredScopes;
    @XmlElement(name = "Allowed_Scope")
    protected List<String> allowedScopes;
    @XmlAttribute(name = "targeting_expression_id")
    @XmlSchemaType(name = "anyURI")
    protected String targetingExpressionId;

    /**
     * Gets the value of the preferredScopes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the preferredScopes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPreferredScopes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPreferredScopes() {
        if (preferredScopes == null) {
            preferredScopes = new ArrayList<String>();
        }
        return this.preferredScopes;
    }

    /**
     * Gets the value of the allowedScopes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedScopes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedScopes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAllowedScopes() {
        if (allowedScopes == null) {
            allowedScopes = new ArrayList<String>();
        }
        return this.allowedScopes;
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
        if (!(object instanceof TargetingExpressionInfoType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final TargetingExpressionInfoType that = ((TargetingExpressionInfoType) object);
        {
            List<String> lhsPreferredScopes;
            lhsPreferredScopes = (((this.preferredScopes!= null)&&(!this.preferredScopes.isEmpty()))?this.getPreferredScopes():null);
            List<String> rhsPreferredScopes;
            rhsPreferredScopes = (((that.preferredScopes!= null)&&(!that.preferredScopes.isEmpty()))?that.getPreferredScopes():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "preferredScopes", lhsPreferredScopes), LocatorUtils.property(thatLocator, "preferredScopes", rhsPreferredScopes), lhsPreferredScopes, rhsPreferredScopes)) {
                return false;
            }
        }
        {
            List<String> lhsAllowedScopes;
            lhsAllowedScopes = (((this.allowedScopes!= null)&&(!this.allowedScopes.isEmpty()))?this.getAllowedScopes():null);
            List<String> rhsAllowedScopes;
            rhsAllowedScopes = (((that.allowedScopes!= null)&&(!that.allowedScopes.isEmpty()))?that.getAllowedScopes():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "allowedScopes", lhsAllowedScopes), LocatorUtils.property(thatLocator, "allowedScopes", rhsAllowedScopes), lhsAllowedScopes, rhsAllowedScopes)) {
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
            List<String> thePreferredScopes;
            thePreferredScopes = (((this.preferredScopes!= null)&&(!this.preferredScopes.isEmpty()))?this.getPreferredScopes():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "preferredScopes", thePreferredScopes), currentHashCode, thePreferredScopes);
        }
        {
            List<String> theAllowedScopes;
            theAllowedScopes = (((this.allowedScopes!= null)&&(!this.allowedScopes.isEmpty()))?this.getAllowedScopes():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "allowedScopes", theAllowedScopes), currentHashCode, theAllowedScopes);
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
