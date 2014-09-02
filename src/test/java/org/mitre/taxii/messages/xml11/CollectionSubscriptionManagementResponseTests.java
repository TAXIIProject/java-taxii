package org.mitre.taxii.messages.xml11;

import java.io.IOException;
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
public class CollectionSubscriptionManagementResponseTests {
    private final ObjectFactory factory = new ObjectFactory();
    private final TaxiiXmlFactory txf = new TaxiiXmlFactory();
    private final TaxiiXmlImpl taxiiXml;
    
    private ServiceContactInfoType poll1, poll2, poll3;
    private SubscriptionRecordType sub1, sub2, sub3;
    private SubscriptionParametersType sp1;
    private PushParameterType pp1;
    
    public CollectionSubscriptionManagementResponseTests() {
        txf.addJaxbContextPackage(DefaultQuery.class.getPackage().getName());
        taxiiXml = txf.getTaxiiXml();
        setup();        
    }
    
    private void setup() {
        poll1 = factory.createServiceContactInfoType()
                    .withProtocolBinding(Versions.VID_TAXII_HTTPS_10)
                    .withAddress("https://example.com/poll1/")
                    .withMessageBindings(Versions.VID_TAXII_XML_11);
        
        poll2 = factory.createServiceContactInfoType()
                    .withProtocolBinding(Versions.VID_TAXII_HTTPS_10)
                    .withAddress("https://example.com/poll2/")
                    .withMessageBindings(Versions.VID_TAXII_XML_11);

        poll3 = factory.createServiceContactInfoType()
                    .withProtocolBinding(Versions.VID_TAXII_HTTPS_10)
                    .withAddress("https://example.com/poll3/")
                    .withMessageBindings(Versions.VID_TAXII_XML_11);
        
        TestType test1 = new TestType()
                    .withCapabilityId(DefaultQueryXml.CM_CORE)
                    .withRelationship("equals")
                    .withParameters(
                            new ParameterType("Test value", "value"),
                            new ParameterType("case_sensitive_string", "match_type")
                    );

        CriterionType criterion1 = new CriterionType()
                            .withTarget("**")
                            .withTest(test1);
        
        CriteriaType criteria1 = new CriteriaType()
                .withOperator(DefaultQueryXml.OP_AND)
                .withCriteriasAndCriterions(criterion1);

        DefaultQuery query1 = new DefaultQuery()
            .withTargetingExpressionId(ContentBindings.CB_STIX_XML_11)
            .withCriteria(criteria1);


        sp1 = factory.createSubscriptionParametersType()
                    .withResponseType(ResponseTypeEnum.COUNT_ONLY)
                    .withContentBindings(factory.createContentBindingIDType().withBindingId(ContentBindings.CB_STIX_XML_11))
                    .withQuery(new QueryType().withFormatId(DefaultQueryXml.FID_TAXII_DEFAULT_QUERY_10).withContent(query1));                    

        pp1 = factory.createPushParameterType()
                    .withProtocolBinding(Versions.VID_TAXII_HTTPS_10)
                    .withAddress("https://example.com/inboxAddress/")
                    .withMessageBinding(Versions.VID_TAXII_XML_11);
        
        sub1 = factory.createSubscriptionRecordType()
                    .withStatus(SubscriptionStatusEnum.ACTIVE)
                    .withSubscriptionID("Subs001")
                    .withSubscriptionParameters(sp1)
                    .withPushParameters(pp1)
                    .withPollInstances(poll1, poll2, poll3);
        
        sub2 = factory.createSubscriptionRecordType()
                    .withStatus(SubscriptionStatusEnum.PAUSED)
                    .withSubscriptionID("Subs001")
                    .withSubscriptionParameters(sp1)
                    .withPushParameters(pp1);
        
        sub3 = factory.createSubscriptionRecordType()
                    .withStatus(SubscriptionStatusEnum.PAUSED)
                    .withSubscriptionID("Subs001");        
    }
    
    @Test
    public void testSubsResp1() throws JAXBException, SAXException, IOException {
        SubscriptionManagementResponse smr1 = factory.createSubscriptionManagementResponse()
                .withMessageId("SubsResp01")
                .withInResponseTo("xyz")
                .withCollectionName("abc123")
                .withMessage("Hullo!")
                .withSubscriptions(sub1, sub2, sub3);
        
        TestUtil.roundTripMessage(taxiiXml, smr1, false);        
    }
    
    @Test
    public void testSubsResp2() throws JAXBException, SAXException, IOException {
        SubscriptionManagementResponse smr1 = factory.createSubscriptionManagementResponse()
                .withMessageId("SubsResp02")
                .withInResponseTo("xyz")
                .withCollectionName("abc123");
        
        TestUtil.roundTripMessage(taxiiXml, smr1, false);        
    }

    @Test
    public void testSubsResp3() throws JAXBException, SAXException, IOException {
        SubscriptionManagementResponse smr1 = factory.createSubscriptionManagementResponse()
                .withMessageId("SubsResp03")
                .withInResponseTo("xyz")
                .withCollectionName("abc123")
                .withSubscriptions(sub1, sub2, sub3);
        
        TestUtil.roundTripMessage(taxiiXml, smr1, false);        
    }

    @Test
    public void testSubsResp4() throws JAXBException, SAXException, IOException {
        SubscriptionManagementResponse smr1 = factory.createSubscriptionManagementResponse()
                .withMessageId("SubsResp04")
                .withInResponseTo("xyz")
                .withCollectionName("abc123")
                .withMessage("Hullo!");
        
        TestUtil.roundTripMessage(taxiiXml, smr1, false);        
    }
    
    @Test
    public void testSubsRespDeprecated() throws JAXBException, SAXException, IOException {
        SubscriptionRecordType sub = factory.createSubscriptionRecordType()
                    .withSubscriptionID("Subs001")
                    .withSubscriptionParameters(sp1)
                    .withPushParameters(pp1)
                    .withPollInstances(poll1);
        
        SubscriptionManagementResponse smr1 = factory.createSubscriptionManagementResponse()
                .withMessageId("SubsResp01")
                .withInResponseTo("xyz")
                .withCollectionName("abc123")
                .withSubscriptions(sub);
        
        TestUtil.roundTripMessage(taxiiXml, smr1, false);                        
    }
    
}
