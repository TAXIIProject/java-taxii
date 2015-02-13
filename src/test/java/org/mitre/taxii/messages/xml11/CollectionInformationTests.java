package org.mitre.taxii.messages.xml11;

import java.io.IOException;
import java.math.BigInteger;
import javax.xml.bind.JAXBContext;
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
        // Use MOXy so we get JSON support
        System.setProperty(JAXBContext.JAXB_CONTEXT_FACTORY, "org.eclipse.persistence.jaxb.JAXBContextFactory");
        
        txf.addJaxbContextPackage(DefaultQuery.class.getPackage().getName());
        taxiiXml = txf.createTaxiiXml();
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
    
    private CollectionInformationRequest getCollectionInformationRequest() {
        CollectionInformationRequest cir = factory.createCollectionInformationRequest()
                                                .withMessageId("CIReq01");
        return cir;
    }
    @Test
    public void goodCollectionInformationRequestXML() throws JAXBException, SAXException, IOException {
        CollectionInformationRequest cir = getCollectionInformationRequest();
        TestUtil.roundTripMessage(taxiiXml, cir);        
    }
    
    @Test
     public void goodCollectionInformationRequestJSON() throws JAXBException, SAXException, IOException {
        CollectionInformationRequest cir = getCollectionInformationRequest();
        TestUtilJSON.roundTripMessage(taxiiXml, cir);        
    }
    
    private CollectionInformationResponse getCollectionInformationResponse01() {
        CollectionInformationResponse cir01 = factory.createCollectionInformationResponse()
                                                    .withMessageId("CIR01")
                                                    .withInResponseTo("0")
                                                    .withCollections(collection1);
        return cir01;
    }
    
    @Test
    public void goodCollectionInformationResponse01XML() throws JAXBException, SAXException, IOException {
        CollectionInformationResponse cir = getCollectionInformationResponse01();
        TestUtil.roundTripMessage(taxiiXml, cir);        
    }
    
    @Test
     public void goodCollectionInformationResponse01JSON() throws JAXBException, SAXException, IOException {
        CollectionInformationResponse cir = getCollectionInformationResponse01();
        TestUtilJSON.roundTripMessage(taxiiXml, cir);        
    }

    private CollectionInformationResponse getCollectionInformationResponse02() {
        CollectionInformationResponse cir02 = factory.createCollectionInformationResponse()
                                                    .withMessageId("CIR02")
                                                    .withInResponseTo("0")
                                                    .withCollections(collection1, collection2, collection3, collection4);
        return cir02;
    }

    @Test
    public void goodCollectionInformationResponse02XML() throws JAXBException, SAXException, IOException {
        CollectionInformationResponse cir = getCollectionInformationResponse02();
        TestUtil.roundTripMessage(taxiiXml, cir);        
    }
    
    @Test
     public void goodCollectionInformationResponse02JSON() throws JAXBException, SAXException, IOException {
        CollectionInformationResponse cir = getCollectionInformationResponse02();
        TestUtilJSON.roundTripMessage(taxiiXml, cir);        
    }
    
    private CollectionInformationResponse getCollectionInformationResponse03() {
        CollectionInformationResponse cir03 = factory.createCollectionInformationResponse()
                                                    .withMessageId("CIR03")
                                                    .withInResponseTo("0")
                                                    .withCollections(collection3);
        return cir03;
    }
    
    @Test
    public void goodCollectionInformationResponse03XML() throws JAXBException, SAXException, IOException {
        CollectionInformationResponse cir = getCollectionInformationResponse03();
        TestUtil.roundTripMessage(taxiiXml, cir);        
    }
    
    @Test
     public void goodCollectionInformationResponse03JSON() throws JAXBException, SAXException, IOException {
        CollectionInformationResponse cir = getCollectionInformationResponse03();
        TestUtilJSON.roundTripMessage(taxiiXml, cir);        
    }
    

    private CollectionInformationResponse getCollectionInformationResponse04() {
        CollectionInformationResponse cir04 = factory.createCollectionInformationResponse()
                                                    .withMessageId("CIR04")
                                                    .withInResponseTo("0")
                                                    .withCollections(collection1, collection4);
        return cir04;
    }
    
    @Test
    public void goodCollectionInformationResponse04XML() throws JAXBException, SAXException, IOException {
        CollectionInformationResponse cir = getCollectionInformationResponse04();
        TestUtil.roundTripMessage(taxiiXml, cir);        
    }
    
    @Test
     public void goodCollectionInformationResponse04JSON() throws JAXBException, SAXException, IOException {
        CollectionInformationResponse cir = getCollectionInformationResponse04();
        TestUtilJSON.roundTripMessage(taxiiXml, cir);        
    }
    

    private CollectionInformationResponse getCollectionInformationResponse05() {
        CollectionInformationResponse cir05 = factory.createCollectionInformationResponse()
                                                    .withMessageId("CIR05")
                                                    .withInResponseTo("0")
                                                    .withCollections(collection2, collection4);
        return cir05;
    }
    
    @Test
    public void goodCollectionInformationResponse05XML() throws JAXBException, SAXException, IOException {
        CollectionInformationResponse cir05 = getCollectionInformationResponse05();
        TestUtil.roundTripMessage(taxiiXml, cir05);        
    }
    
    @Test
     public void goodCollectionInformationResponse05JSON() throws JAXBException, SAXException, IOException {
        CollectionInformationResponse cir05 = getCollectionInformationResponse05();
        TestUtilJSON.roundTripMessage(taxiiXml, cir05);        
    }
   

    private CollectionInformationResponse getDeprecatedCollectionInformationResponse() {
        
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
        return cir;
    }
    
    @Test
    public void deprecatedCollectionInformationResponseXML() throws JAXBException, SAXException, IOException {
        CollectionInformationResponse cir = getDeprecatedCollectionInformationResponse();
        TestUtil.roundTripMessage(taxiiXml, cir);        
    }
    
    @Test
    public void deprecatedCollectionInformationResponseJSON() throws JAXBException, SAXException, IOException {
        CollectionInformationResponse cir = getDeprecatedCollectionInformationResponse();
        TestUtilJSON.roundTripMessage(taxiiXml, cir);        
    }
        
}
