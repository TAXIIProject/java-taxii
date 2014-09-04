package org.mitre.taxii.messages.xml10;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import org.junit.Test;
import org.mitre.taxii.ContentBindings;
import org.mitre.taxii.query.CriteriaType;
import org.mitre.taxii.query.CriterionType;
import org.mitre.taxii.query.DefaultQuery;
import org.mitre.taxii.query.DefaultQueryXml;
import org.mitre.taxii.query.ParameterType;
import org.mitre.taxii.query.TestType;
import org.xml.sax.SAXException;

/**
 *
 * @author jasenj1
 */
public class PollRequestTests {
    private final ObjectFactory factory = new ObjectFactory();
    private final TaxiiXmlFactory txf = new TaxiiXmlFactory();
    private final TaxiiXml taxiiXml;
    
    private TestType test1;
    private CriterionType criterion1;
    private CriteriaType criteria1;
    private DefaultQuery query1;
    
    public PollRequestTests() {
       txf.addJaxbContextPackage(DefaultQuery.class.getPackage().getName());
       taxiiXml = txf.getTaxiiXml();
       setup();
    }
    
    private void setup() {
        test1 = new TestType()
                    .withCapabilityId(DefaultQueryXml.CM_CORE)
                    .withRelationship("equals")
                    .withParameters(
                            new ParameterType("Test value", "value"),
                            new ParameterType("case_sensitive_string", "match_type")
                    );
        
        criterion1 = new CriterionType()
                            .withTarget("**")
                            .withTest(test1);
        
        criteria1 = new CriteriaType()
                        .withOperator(DefaultQueryXml.OP_AND)
                        .withCriteriasAndCriterions(criterion1);
        
        query1 = new DefaultQuery()
            .withTargetingExpressionId(ContentBindings.CB_STIX_XML_11)
            .withCriteria(criteria1);
    }
    
    @Test
    public void pollReq1() throws DatatypeConfigurationException, JAXBException, SAXException, IOException {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(new Date()); // Now.
        XMLGregorianCalendar beginTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        
        gc.setTime(new Date()); // Now.
        XMLGregorianCalendar endTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
                
        PollRequest pr1 = factory.createPollRequest()
                            .withMessageId("PollReq01")
                            .withExclusiveBeginTimestamp(beginTime.normalize()) // Normalize to UTC
                            .withInclusiveEndTimestamp(endTime.normalize())     // Normalize to UTC
                            .withSubscriptionId("12345");
        
        TestUtil.roundTripMessage(taxiiXml, pr1);                        
    }

    @Test
    public void pollReq2() throws DatatypeConfigurationException, JAXBException, SAXException, IOException {
        PollRequest pr2 = factory.createPollRequest()
                            .withMessageId("PollReq02")
                            .withSubscriptionId("Kenneth Coal Collection");
        
        TestUtil.roundTripMessage(taxiiXml, pr2);                        
    }

    @Test
    public void pollReq3() throws DatatypeConfigurationException, JAXBException, SAXException, IOException {
        
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(new Date()); // Now.
        XMLGregorianCalendar beginTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        
        XMLGregorianCalendar endTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        Duration oneHour = DatatypeFactory.newInstance().newDuration(1000*60*60); // One hour in milliseconds.
        endTime.add(oneHour);
        
        PollRequest pr3 = factory.createPollRequest()
                                .withMessageId("PollReq03")
                                .withExclusiveBeginTimestamp(beginTime)
                                .withInclusiveEndTimestamp(endTime);

        TestUtil.roundTripMessage(taxiiXml, pr3, false);                        
    }
    
    @Test
    public void pollReq4() throws DatatypeConfigurationException, JAXBException, SAXException, IOException {

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(new Date()); // Now.
        XMLGregorianCalendar endTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        
        PollRequest pr4 = factory.createPollRequest()
                            .withMessageId("PollReq04")
                            .withInclusiveEndTimestamp(endTime);
        TestUtil.roundTripMessage(taxiiXml, pr4);                        
    }

    @Test
    public void pollReq5() throws DatatypeConfigurationException, JAXBException, SAXException, IOException {
        
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(new Date()); // Now.
        XMLGregorianCalendar startTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);

        PollRequest pr5 = factory.createPollRequest()
                                .withMessageId("PollReq05")
                                .withExclusiveBeginTimestamp(startTime);
        TestUtil.roundTripMessage(taxiiXml, pr5, false);                                               
    }    
}
