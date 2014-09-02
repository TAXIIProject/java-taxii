package org.mitre.taxii.messages.xml10;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jasenj1
 */
public class TaxiiXmlFactory {
    
        private final List<String>contextPackages = new ArrayList<>();
        
        public void addJaxbContextPackage(String packageName) {
            contextPackages.add(packageName);
        }
        
        public List<String>getContextPackages() {
            return contextPackages;
        }
        
        public TaxiiXmlImpl getTaxiiXml() {
            return new TaxiiXmlImpl(contextPackages);
        }
            
}
