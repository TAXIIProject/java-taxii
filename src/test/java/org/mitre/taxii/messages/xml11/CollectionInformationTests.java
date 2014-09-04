package org.mitre.taxii.messages.xml11;

import java.io.IOException;
import java.math.BigInteger;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.mitre.taxii.ContentBindings;
import org.mitre.taxii.Versions;
import org.mitre.taxii.query.DefaultQuery;
import org.xml.sax.SAXException;

/**
 *
 * @author jasenj1
 */
public class CollectionInformationTests {
    
    private final ObjectFactory factory = new ObjectFactory();
    private final TaxiiXmlFactory txf = new TaxiiXmlFactory();
    private final TaxiiXml taxiiXml;    
    
    PushMethodType pm1;
    ServiceContactInfoType ps1, ps2, ss1, ss2;
    InboxServiceBindingsType is1, is2;

    SubscriptionManagementRequest smr1, smr2;
    CollectionRecordType collection1, collection2, collection3, collection4;
        
    public CollectionInformationTests() {
        txf.addJaxbContextPackage(DefaultQuery.class.getPackage().getName());
        taxiiXml = txf.getTaxiiXml();
        setupPushMethods();
        setupServiceContactInfo();
        setupCollectionRecords();
    }
    
    private void setupPushMethods() {
        pm1 = factory.createPushMethodType()
                .withProtocolBinding(Versions.VID_TAXII_HTTP_10)
                .withMessageBindings(Versions.VID_TAXII_XML_11);
    }
    
    private void setupServiceContactInfo() {
        
        // Polling Services
        ps1 = factory.createServiceContactInfoType()
                    .withProtocolBinding(Versions.VID_TAXII_HTTP_10)
                    .withAddress("https://example.com/TheGreatestPollService")
                    .withMessageBindings(Versions.VID_TAXII_XML_11);
        
        ps2 = factory.createServiceContactInfoType()
                    .withProtocolBinding(Versions.VID_TAXII_HTTP_10)
                    .withAddress("https://example.com/TheOtherPollService")
                    .withMessageBindings(Versions.VID_TAXII_XML_11);
        
        // Subscription Sercvices
        ss1 = factory.createServiceContactInfoType()
                    .withProtocolBinding(Versions.VID_TAXII_HTTP_10)
                    .withAddress("https://example.com/TheSubscriptionService")
                    .withMessageBindings(Versions.VID_TAXII_XML_11);

        ss2 = factory.createServiceContactInfoType()
                    .withProtocolBinding(Versions.VID_TAXII_HTTP_10)
                    .withAddress("https://example.com/TheSubscriptionService")
                    .withMessageBindings(Versions.VID_TAXII_XML_11);
        
        // Inbox Services
        is1 = factory.createInboxServiceBindingsType()
                    .withProtocolBinding(Versions.VID_TAXII_HTTP_10)
                    .withAddress("https://example.com/inbox/")
                    .withMessageBindings(Versions.VID_TAXII_XML_11);
        
        is2 = factory.createInboxServiceBindingsType()
                    .withProtocolBinding(Versions.VID_TAXII_HTTP_10)
                    .withAddress("https://example.com/inbox/")
                    .withMessageBindings(Versions.VID_TAXII_XML_11)
                    .withContentBindings(
                            factory.createContentBindingIDType()
                                .withBindingId(ContentBindings.CB_STIX_XML_11)
                                .withSubtypes(
                                        factory.createSubtypeType().withSubtypeId("example1"),
                                        factory.createSubtypeType().withSubtypeId("example2")                                    
                                )
                    );                
    }
    
    private void setupCollectionRecords() {
        collection1 = factory.createCollectionRecordType()
                            .withCollectionName("collection1")
                            .withCollectionType(CollectionTypeEnum.DATA_FEED)
                            .withAvailable(false)
                            .withDescription("This is a collection")
                            .withCollectionVolume(BigInteger.valueOf(4))
                            .withContentBindings(factory.createContentBindingIDType().withBindingId(ContentBindings.CB_STIX_XML_101))
                            .withPushMethods(pm1)
                            .withPollingServices(ps1, ps2)
                            .withSubscriptionServices(ss1, ss2)
                            .withReceivingInboxServices(is1, is2);
        
        collection2 = factory.createCollectionRecordType()
                            .withCollectionName("collection2")
                            .withCollectionType(CollectionTypeEnum.DATA_SET)
                            .withDescription("Warrgghghglble.");
        
        collection3 = factory.createCollectionRecordType()
                            .withCollectionName("collection3")
                            .withDescription("You must pay all the dollars to have this information.")
                            .withContentBindings(
                                    factory.createContentBindingIDType().withBindingId(ContentBindings.CB_STIX_XML_10),
                                    factory.createContentBindingIDType().withBindingId(ContentBindings.CB_STIX_XML_11)                                    
                                )
                            .withPollingServices(ps2)
                            .withSubscriptionServices(ss2)
                            .withReceivingInboxServices(is2);
        
        collection4 = factory.createCollectionRecordType()
                            .withCollectionName("collection4")
                            .withDescription("So improve information. Much amaze.")
                            .withContentBindings(
                                factory.createContentBindingIDType()
                                    .withBindingId(ContentBindings.CB_STIX_XML_101)
                                    .withSubtypes(
                                        factory.createSubtypeType().withSubtypeId("ex1"),
                                        factory.createSubtypeType().withSubtypeId("ex2"),                                    
                                        factory.createSubtypeType().withSubtypeId("ex3")
                                )
                            )
                            .withReceivingInboxServices(is1, is2);                                                        
    }
    
    @Test 
    public void goodCollectionInformationRequest() throws JAXBException, SAXException, IOException {
        CollectionInformationRequest cir = factory.createCollectionInformationRequest()
                                                .withMessageId("CIReq01");
        TestUtil.roundTripMessage(taxiiXml, cir);        
    }
    
    @Test
    public void goodCollectionInformationResponse01() throws JAXBException, SAXException, IOException {
        CollectionInformationResponse cir01 = factory.createCollectionInformationResponse()
                                                    .withMessageId("CIR01")
                                                    .withInResponseTo("0")
                                                    .withCollections(collection1);
        TestUtil.roundTripMessage(taxiiXml, cir01);        
    }

    @Test
    public void goodCollectionInformationResponse02() throws JAXBException, SAXException, IOException {
        CollectionInformationResponse cir02 = factory.createCollectionInformationResponse()
                                                    .withMessageId("CIR02")
                                                    .withInResponseTo("0")
                                                    .withCollections(collection1, collection2, collection3, collection4);
        TestUtil.roundTripMessage(taxiiXml, cir02);        
    }

    @Test
    public void goodCollectionInformationResponse03() throws JAXBException, SAXException, IOException {
        CollectionInformationResponse cir03 = factory.createCollectionInformationResponse()
                                                    .withMessageId("CIR03")
                                                    .withInResponseTo("0")
                                                    .withCollections(collection3);
        TestUtil.roundTripMessage(taxiiXml, cir03);        
    }

    @Test
    public void goodCollectionInformationResponse04() throws JAXBException, SAXException, IOException {
        CollectionInformationResponse cir04 = factory.createCollectionInformationResponse()
                                                    .withMessageId("CIR04")
                                                    .withInResponseTo("0")
                                                    .withCollections(collection1, collection4);
        TestUtil.roundTripMessage(taxiiXml, cir04);        
    }

    @Test
    public void goodCollectionInformationResponse05() throws JAXBException, SAXException, IOException {
        CollectionInformationResponse cir05 = factory.createCollectionInformationResponse()
                                                    .withMessageId("CIR05")
                                                    .withInResponseTo("0")
                                                    .withCollections(collection2, collection4);
        TestUtil.roundTripMessage(taxiiXml, cir05);        
    }

    @Test
    public void deprecatedCollectionInformationResponse()  throws JAXBException, SAXException, IOException {
        
        PushMethodType pm = factory.createPushMethodType()
                                .withProtocolBinding(Versions.VID_TAXII_HTTP_10)
                                .withMessageBindings(Versions.VID_TAXII_XML_11);
        
        ServiceContactInfoType ps = factory.createServiceContactInfoType()
                                    .withProtocolBinding(Versions.VID_TAXII_HTTPS_10)
                                    .withAddress("https://example.com/TheGreatestPollService")
                                    .withMessageBindings(Versions.VID_TAXII_XML_11);

        ServiceContactInfoType ss = factory.createServiceContactInfoType()
                    .withProtocolBinding(Versions.VID_TAXII_HTTPS_10)
                    .withAddress("https://example.com/TheSubscriptionService")
                    .withMessageBindings(Versions.VID_TAXII_XML_11);

        InboxServiceBindingsType is = factory.createInboxServiceBindingsType()
                    .withProtocolBinding(Versions.VID_TAXII_HTTPS_10)
                    .withAddress("https://example.com/inbox/")
                    .withMessageBindings(Versions.VID_TAXII_XML_11);
        
        CollectionRecordType ci = factory.createCollectionRecordType()
                                        .withCollectionName("collection1")
                                        .withDescription("This is a collection")
                                        .withPushMethods(pm)
                                        .withPollingServices(ps)
                                        .withSubscriptionServices(ss)
                                        .withReceivingInboxServices(is);
        
        CollectionInformationResponse cir = factory.createCollectionInformationResponse()
                                                    .withMessageId("CIR05")
                                                    .withInResponseTo("0")
                                                    .withCollections(ci);

        TestUtil.roundTripMessage(taxiiXml, cir);
    }
}
