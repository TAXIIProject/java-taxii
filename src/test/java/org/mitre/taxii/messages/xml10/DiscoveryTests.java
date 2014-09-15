package org.mitre.taxii.messages.xml10;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
public class DiscoveryTests {

    private final ObjectFactory factory = new ObjectFactory();
    private final TaxiiXmlFactory txf = new TaxiiXmlFactory();
    private final TaxiiXml taxiiXml;    
    private final boolean debug = true; // Boolean.getBoolean("debug");
    
    private ServiceInstanceType si1, si2, si3, si4, si5;
    
    public DiscoveryTests() {
        txf.addJaxbContextPackage(DefaultQuery.class.getPackage().getName());
        taxiiXml = txf.getTaxiiXml();
        setupServiceInstances();               
    }
        
    private void setupServiceInstances() {
        
        // Service Instance 1
        si1 = factory.createServiceInstanceType()
                        .withServiceType(ServiceTypeEnum.POLL)
                        .withServiceVersion(Versions.VID_TAXII_SERVICES_10)
                        .withProtocolBinding(Versions.VID_TAXII_HTTP_10)
                        .withAddress("http://example.com/poll/")
                        .withMessageBindings(Versions.VID_TAXII_XML_10)
                        .withAvailable(true)
                        .withMessage("This is a message.");
        
        // Service Instance 2
        si2 = factory.createServiceInstanceType()
                        .withServiceType(ServiceTypeEnum.POLL)
                        .withServiceVersion(Versions.VID_TAXII_SERVICES_10)
                        .withProtocolBinding(Versions.VID_TAXII_HTTP_10)
                        .withAddress("http://example.com/poll/")
                        .withMessageBindings(Versions.VID_TAXII_XML_10)
                        .withAvailable(true)
                        .withMessage("This is a message.");
        
        // Service Instance 3
        si3 = factory.createServiceInstanceType()
                        .withServiceType(ServiceTypeEnum.INBOX)
                        .withServiceVersion(Versions.VID_TAXII_SERVICES_10)
                        .withProtocolBinding(Versions.VID_TAXII_HTTP_10)
                        .withAddress("http://example.com/inbox/")
                        .withMessageBindings(Versions.VID_TAXII_XML_10)
                        .withContentBindings(
                                ContentBindings.CB_STIX_XML_11,
                                ContentBindings.CB_STIX_XML_101,
                                ContentBindings.CB_STIX_XML_10                                
                                )
                        .withAvailable(false)
                        .withMessage("This is a message. Yipee!");
        
        // Service Instance 4
        si4 = factory.createServiceInstanceType()
                        .withServiceType(ServiceTypeEnum.DISCOVERY)
                        .withServiceVersion(Versions.VID_TAXII_SERVICES_10)
                        .withProtocolBinding(Versions.VID_TAXII_HTTP_10)
                        .withAddress("http://example.com/discovery/")
                        .withMessageBindings(Versions.VID_TAXII_XML_10)
                        .withMessage("This is a message. Yipee!");

    }

    @Test
    public void goodDiscoveryRequestWithExtendedHeaders() throws URISyntaxException, JAXBException, SAXException, IOException {
        DiscoveryRequest dr = new DiscoveryRequest()
                                    .withMessageId("00");
        MessageHelper.addExtendedHeader(dr, new URI("ext_header1"), "value1");
        MessageHelper.addExtendedHeader(dr, new URI("ext_header2"), "value2");
        
        TestUtil.roundTripMessage(taxiiXml, dr);
    }

    @Test
    public void goodDiscoveryResponse01() throws JAXBException, SAXException, IOException {
        DiscoveryResponse dr01 = factory.createDiscoveryResponse()
                                        .withMessageId("01")
                                        .withInResponseTo("00");
        TestUtil.roundTripMessage(taxiiXml, dr01);
    }
    
    @Test
    public void goodDiscoveryResponse02() throws JAXBException, SAXException, IOException {
        DiscoveryResponse dr02 = factory.createDiscoveryResponse()
                                        .withMessageId("02")
                                        .withInResponseTo("01")
                                        .withServiceInstances(si1, si3);
        TestUtil.roundTripMessage(taxiiXml, dr02, false, true); // Don't pretty print. It causes problems with the query info.
    }
    
    @Test
    public void goodDiscoveryResponse03() throws JAXBException, SAXException, IOException {
        DiscoveryResponse dr03 = factory.createDiscoveryResponse()
                                        .withMessageId("03")
                                        .withInResponseTo("02")
                                        .withServiceInstances(si2, si4);
        TestUtil.roundTripMessage(taxiiXml, dr03, false, true); // Don't pretty print. It causes problems with the query info.        
    }
    
    @Test
    public void goodDiscoveryResponse04() throws JAXBException, SAXException, IOException {
        DiscoveryResponse dr04 = factory.createDiscoveryResponse()
                                        .withMessageId("04")
                                        .withInResponseTo("03")
                                        .withServiceInstances(si1, si2, si4);
        TestUtil.roundTripMessage(taxiiXml, dr04, false, true);  // Don't pretty print. It causes problems with the query info.                
    }

    @Test
    public void goodDiscoveryResponse05() throws JAXBException, SAXException, IOException {
        DiscoveryResponse dr05 = factory.createDiscoveryResponse()
                                        .withMessageId("05")
                                        .withInResponseTo("04")
                                        .withServiceInstances(si1, si2, si3, si4);
        TestUtil.roundTripMessage(taxiiXml, dr05, false, true);  // Don't pretty print. It causes problems with the query info.                
    }
}
