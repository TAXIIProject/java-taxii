
package org.mitre.taxii.messages.xml11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * <p>Java class for SubscriptionParametersType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscriptionParametersType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response_Type" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}ResponseTypeEnum" minOccurs="0"/&gt;
 *         &lt;element name="Content_Binding" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}ContentBindingIDType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Query" type="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}QueryType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriptionParametersType", propOrder = {
    "responseType",
    "contentBindings",
    "query"
})
public class SubscriptionParametersType implements Equals, HashCode
{

    @XmlElement(name = "Response_Type", defaultValue = "FULL")
    @XmlSchemaType(name = "string")
    protected ResponseTypeEnum responseType = ResponseTypeEnum.FULL;
    @XmlElement(name = "Content_Binding")
    protected List<ContentBindingIDType> contentBindings;
    @XmlElement(name = "Query")
    protected QueryType query;

    /**
     * Default no-arg constructor
     * 
     */
    public SubscriptionParametersType() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public SubscriptionParametersType(final ResponseTypeEnum responseType, final List<ContentBindingIDType> contentBindings, final QueryType query) {
        this.responseType = responseType;
        this.contentBindings = contentBindings;
        this.query = query;
    }

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
     * Gets the value of the contentBindings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contentBindings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContentBindings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContentBindingIDType }
     * 
     * 
     */
    public List<ContentBindingIDType> getContentBindings() {
        if (contentBindings == null) {
            contentBindings = new ArrayList<ContentBindingIDType>();
        }
        return this.contentBindings;
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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SubscriptionParametersType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SubscriptionParametersType that = ((SubscriptionParametersType) object);
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
            List<ContentBindingIDType> lhsContentBindings;
            lhsContentBindings = (((this.contentBindings!= null)&&(!this.contentBindings.isEmpty()))?this.getContentBindings():null);
            List<ContentBindingIDType> rhsContentBindings;
            rhsContentBindings = (((that.contentBindings!= null)&&(!that.contentBindings.isEmpty()))?that.getContentBindings():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contentBindings", lhsContentBindings), LocatorUtils.property(thatLocator, "contentBindings", rhsContentBindings), lhsContentBindings, rhsContentBindings)) {
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
            List<ContentBindingIDType> theContentBindings;
            theContentBindings = (((this.contentBindings!= null)&&(!this.contentBindings.isEmpty()))?this.getContentBindings():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contentBindings", theContentBindings), currentHashCode, theContentBindings);
        }
        {
            QueryType theQuery;
            theQuery = this.getQuery();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "query", theQuery), currentHashCode, theQuery);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public SubscriptionParametersType withResponseType(ResponseTypeEnum value) {
        setResponseType(value);
        return this;
    }

    public SubscriptionParametersType withContentBindings(ContentBindingIDType... values) {
        if (values!= null) {
            for (ContentBindingIDType value: values) {
                getContentBindings().add(value);
            }
        }
        return this;
    }

    public SubscriptionParametersType withContentBindings(Collection<ContentBindingIDType> values) {
        if (values!= null) {
            getContentBindings().addAll(values);
        }
        return this;
    }

    public SubscriptionParametersType withQuery(QueryType value) {
        setQuery(value);
        return this;
    }

}
