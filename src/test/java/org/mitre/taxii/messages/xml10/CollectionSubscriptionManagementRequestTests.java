package org.mitre.taxii.messages.xml10;

import java.io.IOException;
import java.util.Date;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.mitre.taxii.ContentBindings;
import org.mitre.taxii.Versions;
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
public class CollectionSubscriptionManagementRequestTests {
    private final ObjectFactory factory = new ObjectFactory();
    private final TaxiiXmlFactory txf = new TaxiiXmlFactory();
    private final TaxiiXml taxiiXml;
    
    private PushParameterType pp1;
    private DefaultQuery query1, query2;
    private CriterionType criterion1, criterion2, criterion3;
    private CriteriaType criteria1, criteria2, criteria3;
    private TestType test1, test2, test3;
    
    
    public CollectionSubscriptionManagementRequestTests() {
        txf.addJaxbContextPackage(DefaultQuery.class.getPackage().getName());
        taxiiXml = txf.createTaxiiXml();
        setupQueries();
        setupPushParameters();
    }
    
    private void setupQueries() {
        test1 = new TestType()
                    .withCapabilityId(DefaultQueryXml.CM_CORE)
                    .withRelationship("equals")
                    .withParameters(
                            new ParameterType("Test value", "value"),
                            new ParameterType("case_sensitive_string", "match_type")
                    );
        
        test2 = new TestType()
                    .withCapabilityId(DefaultQueryXml.CM_REGEX)
                    .withRelationship("matches")
                    .withParameters(
                            new ParameterType("[A-Z]*", "value"),
                            new ParameterType(Boolean.TRUE.toString(), "case_sensitive")
                    );
        
        test3 = new TestType()
                    .withCapabilityId(DefaultQueryXml.CM_TIMESTAMP)
                    .withRelationship("greater_than")
                    .withParameters(
                            new ParameterType(new Date().toString(),"value") // NOTE: This date format is most likely wrong. The date really needs to be rendered with a DateFormat
                    );
                                    
        criterion1 = new CriterionType()
                            .withTarget("**")
                            .withTest(test1);
        
        criterion2 = new CriterionType()
                            .withTarget("STIX_Package/Indicators/Indicator/@id")
                            .withTest(test2);
        
        criterion3 = new CriterionType()
                            .withTarget("**/Description")
                            .withTest(test3);
        
        criteria1 = new CriteriaType()
                        .withOperator(DefaultQueryXml.OP_AND)
                        .withCriterions(criterion1);

        criteria2 = new CriteriaType()
                        .withOperator(DefaultQueryXml.OP_OR)
                        .withCriterions(criterion1, criterion2, criterion3);
        
        criteria3 = new CriteriaType()
                        .withOperator(DefaultQueryXml.OP_AND)
                        .withCriterias(criteria2)
                        .withCriterions(criterion1, criterion3);
        
        query1 = new DefaultQuery()
                    .withTargetingExpressionId(ContentBindings.CB_STIX_XML_11)
                    .withCriteria(criteria1);
        
        query2 = new DefaultQuery()
                        .withTargetingExpressionId(ContentBindings.CB_STIX_XML_11)
                        .withCriteria(criteria3);                    
    }
        
    private void setupPushParameters() {
        pp1 = factory.createPushParameterType()
                    .withProtocolBinding(Versions.VID_TAXII_HTTPS_10)
                    .withAddress("https://example.com/inboxAddress/")
                    .withMessageBinding(Versions.VID_TAXII_XML_11);
    }
    
    @Test
    public void testSubsReq1() throws JAXBException, SAXException, IOException {
        SubscriptionManagementRequest smr1 = factory.createSubscriptionManagementRequest()
                                                .withMessageId("01")
                                                .withFeedName("Feed01")
                                                .withAction(FeedActionEnum.SUBSCRIBE)
                                                .withPushParameters(pp1);
        TestUtil.roundTripMessage(taxiiXml, smr1, false, true);                
    }
    
    @Test
    public void testSubsReq2() throws JAXBException, SAXException, IOException {
        SubscriptionManagementRequest smr2 = factory.createSubscriptionManagementRequest()
                                                .withMessageId("02")
                                                .withFeedName("Feed02")
                                                .withAction(FeedActionEnum.SUBSCRIBE);
                                                
        TestUtil.roundTripMessage(taxiiXml, smr2, false, true);                        
    }
    
    @Test
    public void testSubsReq3() throws JAXBException, SAXException, IOException {
        SubscriptionManagementRequest smr3 = factory.createSubscriptionManagementRequest()
                                                    .withMessageId("03")
                                                    .withFeedName("Feed03")
                                                    .withAction(FeedActionEnum.SUBSCRIBE);
        TestUtil.roundTripMessage(taxiiXml, smr3, false, true);                                                                                    
    }
    
    @Test
    public void testSubsReq4() throws JAXBException, SAXException, IOException {
        SubscriptionManagementRequest smr4 = factory.createSubscriptionManagementRequest()
                                                    .withMessageId("04")
                                                    .withFeedName("Feed04")
                                                    .withAction(FeedActionEnum.SUBSCRIBE);
        TestUtil.roundTripMessage(taxiiXml, smr4, false, true);                                                                                    
    }
    
    @Test
    public void testSubsReq5() throws JAXBException, SAXException, IOException {
        SubscriptionManagementRequest smr5 = factory.createSubscriptionManagementRequest()
                                                    .withMessageId("05")
                                                    .withFeedName("Feed05")                
                                                    .withAction(FeedActionEnum.STATUS);
        TestUtil.roundTripMessage(taxiiXml, smr5, false, true);                                                                                                    
    }

    @Test
    public void testSubsReq6() throws JAXBException, SAXException, IOException {
        SubscriptionManagementRequest smr6 = factory.createSubscriptionManagementRequest()
                                                    .withMessageId("06")
                                                    .withFeedName("Feed06")
                                                    .withAction(FeedActionEnum.STATUS);
        TestUtil.roundTripMessage(taxiiXml, smr6, false, true);                                                                                                    
    }
}
