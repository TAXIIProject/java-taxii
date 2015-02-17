package org.mitre.taxii.messages.xml11;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.mitre.taxii.ContentBindings;
import org.mitre.taxii.query.DefaultQueryXml;
import org.mitre.taxii.Versions;
import org.mitre.taxii.query.DefaultQuery;
import org.mitre.taxii.query.DefaultQueryInfo;
import org.mitre.taxii.query.TargetingExpressionInfoType;
import org.xml.sax.SAXException;

/**
 *
 * @author jasenj1
 */
public class DiscoveryTests {

    private final ObjectFactory factory = new ObjectFactory();
    private final TaxiiXmlFactory txf = new TaxiiXmlFactory();
    private final TaxiiXml taxiiXml;    
    private final boolean debug = true; // Boolean.getBoolean("debug");
    
    private ServiceInstanceType si1, si2, si3, si4, si5;
    private DefaultQueryInfo tdq1, tdq2;
    private TargetingExpressionInfoType tei1, tei2;
    
    public DiscoveryTests() {
        // Use MOXy so we get JSON support
        System.setProperty(JAXBContext.JAXB_CONTEXT_FACTORY, "org.eclipse.persistence.jaxb.JAXBContextFactory");
        
        txf.addJaxbContextPackage(DefaultQuery.class.getPackage().getName());        
        taxiiXml = txf.createTaxiiXml();
        setupDefaultQueries();
        setupServiceInstances();               
    }
    
    private void setupDefaultQueries() {
                            
        tei1 = new TargetingExpressionInfoType()
                    .withTargetingExpressionId(ContentBindings.CB_STIX_XML_10)
                    .withAllowedScopes("**");
        
        tei2 = new TargetingExpressionInfoType()
                    .withTargetingExpressionId(ContentBindings.CB_STIX_XML_11)
                    .withPreferredScopes("STIX_Package/Indicators/Indicator/**");
        
        tdq1 = new DefaultQueryInfo()
                    .withTargetingExpressionInfo(tei1)
                    .withCapabilityModules(DefaultQueryXml.CM_CORE);
        
        tdq2 = new DefaultQueryInfo()
                    .withTargetingExpressionInfo(tei2)
                    .withCapabilityModules(DefaultQueryXml.CM_REGEX);                
    }    
    
    private void setupServiceInstances() {
        
        // Service Instance 1
        si1 = factory.createServiceInstanceType()
                        .withServiceType(ServiceTypeEnum.POLL)
                        .withServiceVersion(Versions.VID_TAXII_SERVICES_11)
                        .withProtocolBinding(Versions.VID_TAXII_HTTP_10)
                        .withAddress("http://example.com/poll/")
                        .withMessageBindings(Versions.VID_TAXII_XML_11)
                        .withAvailable(true)
                        .withMessage("This is a message.");
        SupportedQueryType sqt1 = new SupportedQueryType()
                                        .withFormatId(DefaultQueryXml.FID_TAXII_DEFAULT_QUERY_10)
                                        .withContent(tdq1);                                                
        si1.getSupportedQueries().add(sqt1);
        
        // Service Instance 2
        si2 = factory.createServiceInstanceType()
                        .withServiceType(ServiceTypeEnum.POLL)
                        .withServiceVersion(Versions.VID_TAXII_SERVICES_11)
                        .withProtocolBinding(Versions.VID_TAXII_HTTP_10)
                        .withAddress("http://example.com/poll/")
                        .withMessageBindings(Versions.VID_TAXII_XML_11)
                        .withAvailable(true)
                        .withMessage("This is a message.");
        SupportedQueryType sqt2 = new SupportedQueryType()
                                        .withFormatId(DefaultQueryXml.FID_TAXII_DEFAULT_QUERY_10)
                                        .withContent(tdq1, tdq2);                                                
        si2.getSupportedQueries().add(sqt2);
        
        // Service Instance 3
        si3 = factory.createServiceInstanceType()
                        .withServiceType(ServiceTypeEnum.INBOX)
                        .withServiceVersion(Versions.VID_TAXII_SERVICES_11)
                        .withProtocolBinding(Versions.VID_TAXII_HTTP_10)
                        .withAddress("http://example.com/inbox/")
                        .withMessageBindings(Versions.VID_TAXII_XML_11)
                        .withContentBindings(
                                factory.createContentBindingIDType().withBindingId(ContentBindings.CB_STIX_XML_11),
                                factory.createContentBindingIDType().withBindingId(ContentBindings.CB_STIX_XML_101),
                                factory.createContentBindingIDType().withBindingId(ContentBindings.CB_STIX_XML_10)                                
                                )
                        .withAvailable(false)
                        .withMessage("This is a message. Yipee!");
        
        // Service Instance 4
        si4 = factory.createServiceInstanceType()
                        .withServiceType(ServiceTypeEnum.DISCOVERY)
                        .withServiceVersion(Versions.VID_TAXII_SERVICES_11)
                        .withProtocolBinding(Versions.VID_TAXII_HTTP_10)
                        .withAddress("http://example.com/discovery/")
                        .withMessageBindings(Versions.VID_TAXII_XML_11)
                        .withMessage("This is a message. Yipee!");

        // Service Instance 5
        si5 = factory.createServiceInstanceType()
                        .withServiceType(ServiceTypeEnum.COLLECTION_MANAGEMENT)
                        .withServiceVersion(Versions.VID_TAXII_SERVICES_11)
                        .withProtocolBinding(Versions.VID_TAXII_HTTP_10)
                        .withAddress("http://example.com/collection_management/")
                        .withMessageBindings(Versions.VID_TAXII_XML_11)
                        .withMessage("This is a message. Yipee!");                            
    }

    private DiscoveryRequest getDiscoveryRequestWithExtendedHeaders() throws URISyntaxException {
        DiscoveryRequest dr = new DiscoveryRequest()
                                    .withMessageId(MessageHelper.generateMessageId());
        MessageHelper.addExtendedHeader(dr, new URI("ext_header1"), "value1");
        MessageHelper.addExtendedHeader(dr, new URI("ext_header2"), "value2");

        return dr;
    }
    
    @Test
    public void goodDiscoveryRequestWithExtendedHeadersXML() throws JAXBException, SAXException, IOException, URISyntaxException {
        TestUtil.roundTripMessage(taxiiXml, getDiscoveryRequestWithExtendedHeaders());
    }

    @Test
    public void goodDiscoveryRequestWithExtendedHeadersJSON() throws JAXBException, SAXException, IOException, URISyntaxException {
        TestUtilJSON.roundTripMessage(taxiiXml, getDiscoveryRequestWithExtendedHeaders());
    }

    
    private DiscoveryResponse getDiscoveryResponse01() {
        DiscoveryResponse dr01 = factory.createDiscoveryResponse()
                                        .withMessageId("DR01")
                                        .withInResponseTo("TheSecondIdentifier");
        return dr01;
    }
    
    @Test
    public void goodDiscoveryResponse01XML() throws JAXBException, SAXException, IOException, URISyntaxException {
        TestUtil.roundTripMessage(taxiiXml, getDiscoveryResponse01());
    }

    @Test
    public void goodDiscoveryResponse01JSON() throws JAXBException, SAXException, IOException, URISyntaxException {
        TestUtilJSON.roundTripMessage(taxiiXml, getDiscoveryResponse01());
    }
    
    
    
    private DiscoveryResponse getDiscoveryResponse02() {
        DiscoveryResponse dr02 = factory.createDiscoveryResponse()
                                        .withMessageId("DR02")
                                        .withInResponseTo("TheSecondIdentifier")
                                        .withServiceInstances(si1, si3, si5);
        return dr02;
    }

    @Test
    public void goodDiscoveryResponse02XML() throws JAXBException, SAXException, IOException, URISyntaxException {
        TestUtil.roundTripMessage(taxiiXml, getDiscoveryResponse02(), false, true); // Don't pretty print. It causes problems with the query info.
    }

    @Test
    public void goodDiscoveryResponse02JSON() throws JAXBException, SAXException, IOException, URISyntaxException {
        TestUtilJSON.roundTripMessage(taxiiXml, getDiscoveryResponse02(), false, true); // Don't pretty print. It causes problems with the query info.
    }
    
    private DiscoveryResponse getDiscoveryResponse03() {
        DiscoveryResponse dr03 = factory.createDiscoveryResponse()
                                        .withMessageId("DR03")
                                        .withInResponseTo("TheSecondIdentifier")
                                        .withServiceInstances(si2, si4);
        return dr03;
    }

    @Test
    public void goodDiscoveryResponse03XML() throws JAXBException, SAXException, IOException, URISyntaxException {
        TestUtil.roundTripMessage(taxiiXml, getDiscoveryResponse03(), false, true); // Don't pretty print. It causes problems with the query info.
    }

    @Test
    public void goodDiscoveryResponse03JSON() throws JAXBException, SAXException, IOException, URISyntaxException {
        TestUtilJSON.roundTripMessage(taxiiXml, getDiscoveryResponse03(), false, true); // Don't pretty print. It causes problems with the query info.
    }
    
    
    private DiscoveryResponse getDiscoveryResponse04() {
        DiscoveryResponse dr04 = factory.createDiscoveryResponse()
                                        .withMessageId("DR04")
                                        .withInResponseTo("TheSecondIdentifier")
                                        .withServiceInstances(si1, si2, si4);
        return dr04;
    }

    @Test
    public void goodDiscoveryResponse04XML() throws JAXBException, SAXException, IOException, URISyntaxException {
        TestUtil.roundTripMessage(taxiiXml, getDiscoveryResponse04(), false, true); // Don't pretty print. It causes problems with the query info.
    }

    @Test
    public void goodDiscoveryResponse04JSON() throws JAXBException, SAXException, IOException, URISyntaxException {
        TestUtilJSON.roundTripMessage(taxiiXml, getDiscoveryResponse04(), false, true); // Don't pretty print. It causes problems with the query info.
    }
    
    private DiscoveryResponse getDiscoveryResponse05() {
        DiscoveryResponse dr05 = factory.createDiscoveryResponse()
                                        .withMessageId("DR05")
                                        .withInResponseTo("TheSecondIdentifier")
                                        .withServiceInstances(si1, si2, si3, si4, si5);
        return dr05;
    }

    @Test
    public void goodDiscoveryResponse05XML() throws JAXBException, SAXException, IOException, URISyntaxException {
        TestUtil.roundTripMessage(taxiiXml, getDiscoveryResponse05(), false, true); // Don't pretty print. It causes problems with the query info.
    }

    @Test
    public void goodDiscoveryResponse05JSON() throws JAXBException, SAXException, IOException, URISyntaxException {
        TestUtilJSON.roundTripMessage(taxiiXml, getDiscoveryResponse05(), false, true); // Don't pretty print. It causes problems with the query info.
    }
    
    private DiscoveryResponse getDiscoveryResponseDeprecated() {
        ServiceInstanceType service = factory.createServiceInstanceType()
                                            .withServiceType(ServiceTypeEnum.COLLECTION_MANAGEMENT)
                                            .withServiceVersion(Versions.VID_TAXII_SERVICES_11)
                                            .withProtocolBinding(Versions.VID_TAXII_HTTP_10)
                                            .withAddress("http://example.com/collection_management/")
                                            .withMessageBindings(Versions.VID_TAXII_XML_11);
        DiscoveryResponse dr = factory.createDiscoveryResponse()
                                        .withMessageId("Deprecated")
                                        .withInResponseTo("TheSecondIdentifier")
                                        .withServiceInstances(service);
        return dr;
    }
    
    @Test
    public void goodDiscoveryResponseDeprecatedXML() throws JAXBException, SAXException, IOException, URISyntaxException {
        TestUtil.roundTripMessage(taxiiXml, getDiscoveryResponseDeprecated(), false, true); // Don't pretty print. It causes problems with the query info.
    }

    @Test
    public void goodDiscoveryResponseDeprecatedJSON() throws JAXBException, SAXException, IOException, URISyntaxException {
        TestUtilJSON.roundTripMessage(taxiiXml, getDiscoveryResponseDeprecated(), false, true); // Don't pretty print. It causes problems with the query info.
    }
    
}
