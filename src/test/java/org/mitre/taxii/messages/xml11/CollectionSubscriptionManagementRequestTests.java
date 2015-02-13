package org.mitre.taxii.messages.xml11;

import java.io.IOException;
import java.util.Date;
import javax.xml.bind.JAXBContext;
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
    
    private SubscriptionParametersType sp1;
    private PushParameterType pp1;
    private DefaultQuery query1, query2;
    private CriterionType criterion1, criterion2, criterion3;
    private CriteriaType criteria1, criteria2, criteria3;
    private TestType test1, test2, test3;
    
    
    public CollectionSubscriptionManagementRequestTests() {
        // Use MOXy so we get JSON support
        System.setProperty(JAXBContext.JAXB_CONTEXT_FACTORY, "org.eclipse.persistence.jaxb.JAXBContextFactory");
        
        txf.addJaxbContextPackage(DefaultQuery.class.getPackage().getName());
        taxiiXml = txf.createTaxiiXml();
        setupQueries();
        setupSubscriptionParameters();
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
    
    private void setupSubscriptionParameters() {
        sp1 = factory.createSubscriptionParametersType()
                    .withResponseType(ResponseTypeEnum.COUNT_ONLY)
                    .withContentBindings(factory.createContentBindingIDType().withBindingId(ContentBindings.CB_STIX_XML_11))
                    .withQuery(new QueryType().withFormatId(DefaultQueryXml.FID_TAXII_DEFAULT_QUERY_10).withContent(query1));                    
    }
    
    private void setupPushParameters() {
        pp1 = factory.createPushParameterType()
                    .withProtocolBinding(Versions.VID_TAXII_HTTPS_10)
                    .withAddress("https://example.com/inboxAddress/")
                    .withMessageBinding(Versions.VID_TAXII_XML_11);
    }
    
    private SubscriptionManagementRequest getSubsReq1() {
        SubscriptionManagementRequest smr1 = factory.createSubscriptionManagementRequest()
                                                .withMessageId("SubsReq01")
                                                .withAction(CollectionActionEnum.SUBSCRIBE)
                                                .withCollectionName("collection1")
                                                .withSubscriptionParameters(sp1)
                                                .withPushParameters(pp1);
        return smr1;
    }
    
    @Test
    public void goodSubsReq1XML() throws JAXBException, SAXException, IOException {
        TestUtil.roundTripMessage(taxiiXml, getSubsReq1(), false, true);        
    }
    
    @Test
     public void goodSubsReq1JSON() throws JAXBException, SAXException, IOException {
        TestUtilJSON.roundTripMessage(taxiiXml, getSubsReq1());        
    }
    
    
    private SubscriptionManagementRequest getSubsReq2() {
        SubscriptionManagementRequest smr2 = factory.createSubscriptionManagementRequest()
                                                .withMessageId("'SubsReq02'")
                                                .withAction(CollectionActionEnum.SUBSCRIBE)
                                                .withCollectionName("collection2")
                                                .withSubscriptionParameters(
                                                        factory.createSubscriptionParametersType()
                                                                .withResponseType(ResponseTypeEnum.FULL)
                                                                .withQuery(
                                                                    new QueryType()
                                                                            .withFormatId(DefaultQueryXml.FID_TAXII_DEFAULT_QUERY_10)
                                                                            .withContent(query2)
                                                                )
                                                );
        return smr2;
    }
    
    @Test
    public void goodSubsReq2XML() throws JAXBException, SAXException, IOException {
        TestUtil.roundTripMessage(taxiiXml, getSubsReq2(), false, true);        
    }
    
    @Test
     public void goodSubsReq2JSON() throws JAXBException, SAXException, IOException {
        TestUtilJSON.roundTripMessage(taxiiXml, getSubsReq2());        
    }
        
    private SubscriptionManagementRequest getSubsReq3() {
        SubscriptionManagementRequest smr3 = factory.createSubscriptionManagementRequest()
                                                    .withMessageId("SubsReq03")
                                                    .withAction(CollectionActionEnum.SUBSCRIBE)
                                                    .withCollectionName("collection213")
                                                    .withSubscriptionParameters(
                                                            factory.createSubscriptionParametersType()
                                                    );
        return smr3;
    }
    
    @Test
    public void goodSubsReq3XML() throws JAXBException, SAXException, IOException {
        TestUtil.roundTripMessage(taxiiXml, getSubsReq3());        
    }
    
    @Test
     public void goodSubsReq3JSON() throws JAXBException, SAXException, IOException {
        TestUtilJSON.roundTripMessage(taxiiXml, getSubsReq3());        
    }
    
    
    private SubscriptionManagementRequest getSubsReq4() {
        SubscriptionManagementRequest smr4 = factory.createSubscriptionManagementRequest()
                                                    .withMessageId("SubsReq04")
                                                    .withAction(CollectionActionEnum.SUBSCRIBE)
                                                    .withCollectionName("collection2")
    // NOTE: The Python library populates the parameters with a default value. JAXB doesn't support this - without customizing the generated classes.
                                                    .withSubscriptionParameters(
                                                            factory.createSubscriptionParametersType()
                                                    );
        return smr4;
    }

    @Test
    public void goodSubsReq4XML() throws JAXBException, SAXException, IOException {
        TestUtil.roundTripMessage(taxiiXml, getSubsReq4());        
    }
    
    @Test
     public void goodSubsReq4JSON() throws JAXBException, SAXException, IOException {
        TestUtilJSON.roundTripMessage(taxiiXml, getSubsReq4());        
    }
    
    private SubscriptionManagementRequest getSubsReq5() {
        SubscriptionManagementRequest smr5 = factory.createSubscriptionManagementRequest()
                                                    .withMessageId("SubsReq05")
                                                    .withAction(CollectionActionEnum.STATUS)
                                                    .withCollectionName("collection2")
                                                    .withSubscriptionID("id1");
        return smr5;
    }

    @Test
    public void goodSubsReq5XML() throws JAXBException, SAXException, IOException {
        TestUtil.roundTripMessage(taxiiXml, getSubsReq5());        
    }
    
    @Test
     public void goodSubsReq5JSON() throws JAXBException, SAXException, IOException {
        TestUtilJSON.roundTripMessage(taxiiXml, getSubsReq5());        
    }

    private SubscriptionManagementRequest getSubsReq6() throws JAXBException, SAXException, IOException {
        SubscriptionManagementRequest smr6 = factory.createSubscriptionManagementRequest()
                                                    .withMessageId("SubsReq06")
                                                    .withAction(CollectionActionEnum.STATUS)
                                                    .withCollectionName("collection2");
        return smr6;
    }

    @Test
    public void goodSubsReq6XML() throws JAXBException, SAXException, IOException {
        TestUtil.roundTripMessage(taxiiXml, getSubsReq6());        
    }
    
    @Test
     public void goodSubsReq6JSON() throws JAXBException, SAXException, IOException {
        TestUtilJSON.roundTripMessage(taxiiXml, getSubsReq6());        
    }
    
    private SubscriptionManagementRequest getSubsReq7() {
        SubscriptionManagementRequest smr7 = factory.createSubscriptionManagementRequest()
                                                    .withMessageId("SubsReq07")
                                                    .withAction(CollectionActionEnum.PAUSE)
                                                    .withCollectionName("collection2")
                                                    .withSubscriptionID("id1");
        return smr7;
    }

    @Test
    public void goodSubsReq7XML() throws JAXBException, SAXException, IOException {
        TestUtil.roundTripMessage(taxiiXml, getSubsReq7());        
    }
    
    @Test
     public void goodSubsReq7JSON() throws JAXBException, SAXException, IOException {
        TestUtilJSON.roundTripMessage(taxiiXml, getSubsReq7());        
    }
    
    private SubscriptionManagementRequest getSubsReq8() {
        SubscriptionManagementRequest smr8 = factory.createSubscriptionManagementRequest()
                                                    .withMessageId("SubsReq08")
                                                    .withAction(CollectionActionEnum.RESUME)
                                                    .withCollectionName("collection2")
                                                    .withSubscriptionID("id1");
        return smr8;
    }    
    @Test
    public void goodSubsReq8XML() throws JAXBException, SAXException, IOException {
        TestUtil.roundTripMessage(taxiiXml, getSubsReq8());        
    }
    
    @Test
     public void goodSubsReq8JSON() throws JAXBException, SAXException, IOException {
        TestUtilJSON.roundTripMessage(taxiiXml, getSubsReq8());        
    }
}
