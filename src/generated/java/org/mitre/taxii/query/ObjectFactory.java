
package org.mitre.taxii.query;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.mitre.taxii.query package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.mitre.taxii.query
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DefaultQuery }
     * 
     */
    public DefaultQuery createDefaultQuery() {
        return new DefaultQuery();
    }

    /**
     * Create an instance of {@link CriteriaType }
     * 
     */
    public CriteriaType createCriteriaType() {
        return new CriteriaType();
    }

    /**
     * Create an instance of {@link DefaultQueryInfo }
     * 
     */
    public DefaultQueryInfo createDefaultQueryInfo() {
        return new DefaultQueryInfo();
    }

    /**
     * Create an instance of {@link TargetingExpressionInfoType }
     * 
     */
    public TargetingExpressionInfoType createTargetingExpressionInfoType() {
        return new TargetingExpressionInfoType();
    }

    /**
     * Create an instance of {@link ParameterType }
     * 
     */
    public ParameterType createParameterType() {
        return new ParameterType();
    }

    /**
     * Create an instance of {@link CriterionType }
     * 
     */
    public CriterionType createCriterionType() {
        return new CriterionType();
    }

    /**
     * Create an instance of {@link TestType }
     * 
     */
    public TestType createTestType() {
        return new TestType();
    }

}
