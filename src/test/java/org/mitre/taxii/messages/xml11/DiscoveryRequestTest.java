/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mitre.taxii.messages.xml11;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.mitre.taxii.Messages;
import org.xml.sax.SAXException;

/**
 *
 * @author jasenj1
 */
public class DiscoveryRequestTest {

    private final TaxiiXml taxiiXml;
    private final boolean debug = true; // Boolean.getBoolean("debug"); 
    
    public DiscoveryRequestTest() {
        taxiiXml = TaxiiXml.newInstance();
    }
    
    @Test
    public void goodDiscoveryRequestWithExtendedHeaders() throws URISyntaxException, JAXBException, SAXException, IOException {
        DiscoveryRequest dr = new DiscoveryRequest()
                                    .withMessageId(Messages.generateMessageId());
        MessageHelper.addExtendedHeader(dr, new URI("ext_header1"), "value1");
        MessageHelper.addExtendedHeader(dr, new URI("ext_header2"), "value2");
        
        TestUtil.roundTripMessage(taxiiXml, dr);
    }
    
}
