package org.mitre.taxii.messages.xml10;

import java.util.ArrayList;
import java.util.List;
import org.mitre.taxii.ResourcePaths;
import org.mitre.taxii.Versions;
import org.mitre.taxii.messages.xmldsig.Signature;

/**
 *
 * @author jasenj1
 */
public class TaxiiXmlFactory {
    
        private final List<String>contextPackages = new ArrayList<>();
        
        public TaxiiXmlFactory() {
            addJaxbContextPackage(Signature.class.getPackage().getName());
        }
        
        public final void addJaxbContextPackage(String packageName) {
            contextPackages.add(packageName);
        }
        
        public List<String>getContextPackages() {
            return contextPackages;
        }
        
        public TaxiiXml getTaxiiXml() {
            TaxiiXml tx =  new TaxiiXml(
                            Versions.VID_TAXII_XML_10,
                            Versions.VID_TAXII_SERVICES_10,
                            this.getClass().getPackage().getName(),
                            contextPackages, 
                            ResourcePaths.TAXII_10_SCHEMA_RESOURCE, 
                            ResourcePaths.TAXII_10_SCHEMATRON_XSLT_RESOURCE);
            return tx;
        }
            
}
