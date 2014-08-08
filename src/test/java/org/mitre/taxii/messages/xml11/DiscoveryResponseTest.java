package org.mitre.taxii.messages.xml11;

import java.io.IOException;
import java.util.List;
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
public class DiscoveryResponseTest {

    private final ObjectFactory factory = new ObjectFactory();
    private final TaxiiXmlFactory txf = new TaxiiXmlFactory();
    private final TaxiiXml taxiiXml;    
    private final boolean debug = true; // Boolean.getBoolean("debug");
    
    private ServiceInstanceType si1, si2, si3, si4, si5;
    private DefaultQueryInfo tdq1, tdq2;
    private TargetingExpressionInfoType tei1, tei2;
    
    public DiscoveryResponseTest() {
        txf.addJaxbContextPackage(DefaultQuery.class.getPackage().getName());
        taxiiXml = txf.getTaxiiXml();
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
        si1 = factory.createServiceInstanceType()
                        .withServiceType(ServiceTypeEnum.POLL)
                        .withServiceVersion(Versions.VID_TAXII_SERVICES_11)
                        .withProtocolBinding(Versions.VID_TAXII_HTTP_10)
                        .withAddress("http://example.com/poll/")
                        .withMessageBindings(Versions.VID_TAXII_XML_11)
                        .withAvailable(true)
                        .withMessage("This is a message.");
        SupportedQueryType sqt = new SupportedQueryType()
                                        .withFormatId(DefaultQueryXml.FID_TAXII_DEFAULT_QUERY_10)
                                        .withContent(tdq1);                                                
        si1.getSupportedQueries().add(sqt);                
    }
    
    @Test
    public void goodDiscoveryResponse() throws JAXBException, SAXException, IOException {
        DiscoveryResponse dr01 = factory.createDiscoveryResponse()
                                        .withMessageId("DR01")
                                        .withInResponseTo("TheSecondIdentifier");
        TestUtil.roundTripMessage(taxiiXml, dr01);        
    }
    
    @Test
    public void goodDiscoveryResponseWithServices() throws JAXBException, SAXException, IOException {
        DiscoveryResponse dr02 = factory.createDiscoveryResponse()
                                        .withMessageId("DR02")
                                        .withInResponseTo("TheSecondIdentifier")
                                        .withServiceInstances(si1);
        TestUtil.roundTripMessage(taxiiXml, dr02);                
    }
}
