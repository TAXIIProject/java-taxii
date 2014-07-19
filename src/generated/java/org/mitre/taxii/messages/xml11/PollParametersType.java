
package org.mitre.taxii.messages.xml11;

import java.util.ArrayList;
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
 * Contains parameters for a Poll Request
 * 
 * <p>Java class for PollParametersType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PollParametersType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response_Type" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}ResponseTypeEnum" minOccurs="0"/>
 *         &lt;element name="Content_Binding" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}ContentBindingIDType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Query" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}QueryType" minOccurs="0"/>
 *         &lt;element name="Delivery_Parameters" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}PushParameterType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="allow_asynch" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PollParametersType", propOrder = {
    "responseType",
    "contentBinding",
    "query",
    "deliveryParameters"
})
public class PollParametersType
    implements Equals, HashCode
{

    @XmlElement(name = "Response_Type", defaultValue = "FULL")
    protected ResponseTypeEnum responseType;
    @XmlElement(name = "Content_Binding")
    protected List<ContentBindingIDType> contentBinding;
    @XmlElement(name = "Query")
    protected QueryType query;
    @XmlElement(name = "Delivery_Parameters")
    protected PushParameterType deliveryParameters;
    @XmlAttribute(name = "allow_asynch")
    protected Boolean allowAsynch;

    /**
     * Gets the value of the responseType property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseTypeEnum }
     *     
     */
    public ResponseTypeEnum getResponseType() {
        return responseType;
    }

    /**
     * Sets the value of the responseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseTypeEnum }
     *     
     */
    public void setResponseType(ResponseTypeEnum value) {
        this.responseType = value;
    }

    /**
     * Gets the value of the contentBinding property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contentBinding property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContentBinding().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContentBindingIDType }
     * 
     * 
     */
    public List<ContentBindingIDType> getContentBinding() {
        if (contentBinding == null) {
            contentBinding = new ArrayList<ContentBindingIDType>();
        }
        return this.contentBinding;
    }

    /**
     * Gets the value of the query property.
     * 
     * @return
     *     possible object is
     *     {@link QueryType }
     *     
     */
    public QueryType getQuery() {
        return query;
    }

    /**
     * Sets the value of the query property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryType }
     *     
     */
    public void setQuery(QueryType value) {
        this.query = value;
    }

    /**
     * Gets the value of the deliveryParameters property.
     * 
     * @return
     *     possible object is
     *     {@link PushParameterType }
     *     
     */
    public PushParameterType getDeliveryParameters() {
        return deliveryParameters;
    }

    /**
     * Sets the value of the deliveryParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link PushParameterType }
     *     
     */
    public void setDeliveryParameters(PushParameterType value) {
        this.deliveryParameters = value;
    }

    /**
     * Gets the value of the allowAsynch property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isAllowAsynch() {
        if (allowAsynch == null) {
            return false;
        } else {
            return allowAsynch;
        }
    }

    /**
     * Sets the value of the allowAsynch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowAsynch(Boolean value) {
        this.allowAsynch = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PollParametersType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PollParametersType that = ((PollParametersType) object);
        {
            ResponseTypeEnum lhsResponseType;
            lhsResponseType = this.getResponseType();
            ResponseTypeEnum rhsResponseType;
            rhsResponseType = that.getResponseType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "responseType", lhsResponseType), LocatorUtils.property(thatLocator, "responseType", rhsResponseType), lhsResponseType, rhsResponseType)) {
                return false;
            }
        }
        {
            List<ContentBindingIDType> lhsContentBinding;
            lhsContentBinding = (((this.contentBinding!= null)&&(!this.contentBinding.isEmpty()))?this.getContentBinding():null);
            List<ContentBindingIDType> rhsContentBinding;
            rhsContentBinding = (((that.contentBinding!= null)&&(!that.contentBinding.isEmpty()))?that.getContentBinding():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contentBinding", lhsContentBinding), LocatorUtils.property(thatLocator, "contentBinding", rhsContentBinding), lhsContentBinding, rhsContentBinding)) {
                return false;
            }
        }
        {
            QueryType lhsQuery;
            lhsQuery = this.getQuery();
            QueryType rhsQuery;
            rhsQuery = that.getQuery();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "query", lhsQuery), LocatorUtils.property(thatLocator, "query", rhsQuery), lhsQuery, rhsQuery)) {
                return false;
            }
        }
        {
            PushParameterType lhsDeliveryParameters;
            lhsDeliveryParameters = this.getDeliveryParameters();
            PushParameterType rhsDeliveryParameters;
            rhsDeliveryParameters = that.getDeliveryParameters();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "deliveryParameters", lhsDeliveryParameters), LocatorUtils.property(thatLocator, "deliveryParameters", rhsDeliveryParameters), lhsDeliveryParameters, rhsDeliveryParameters)) {
                return false;
            }
        }
        {
            boolean lhsAllowAsynch;
            lhsAllowAsynch = ((this.allowAsynch!= null)?this.isAllowAsynch():false);
            boolean rhsAllowAsynch;
            rhsAllowAsynch = ((that.allowAsynch!= null)?that.isAllowAsynch():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "allowAsynch", lhsAllowAsynch), LocatorUtils.property(thatLocator, "allowAsynch", rhsAllowAsynch), lhsAllowAsynch, rhsAllowAsynch)) {
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
            ResponseTypeEnum theResponseType;
            theResponseType = this.getResponseType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "responseType", theResponseType), currentHashCode, theResponseType);
        }
        {
            List<ContentBindingIDType> theContentBinding;
            theContentBinding = (((this.contentBinding!= null)&&(!this.contentBinding.isEmpty()))?this.getContentBinding():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contentBinding", theContentBinding), currentHashCode, theContentBinding);
        }
        {
            QueryType theQuery;
            theQuery = this.getQuery();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "query", theQuery), currentHashCode, theQuery);
        }
        {
            PushParameterType theDeliveryParameters;
            theDeliveryParameters = this.getDeliveryParameters();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deliveryParameters", theDeliveryParameters), currentHashCode, theDeliveryParameters);
        }
        {
            boolean theAllowAsynch;
            theAllowAsynch = ((this.allowAsynch!= null)?this.isAllowAsynch():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "allowAsynch", theAllowAsynch), currentHashCode, theAllowAsynch);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
