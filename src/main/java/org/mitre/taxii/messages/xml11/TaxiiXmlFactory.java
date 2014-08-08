package org.mitre.taxii.messages.xml11;

import java.util.ArrayList;

/**
 *
 * @author jasenj1
 */
public class TaxiiXmlFactory {
    
        private ArrayList<String>contextPackages = null;
        
        // Default Constructor.
        public TaxiiXmlFactory() {
            contextPackages = new ArrayList<>();                        
        }
        
        public void addJaxbContextPackage(String packageName) {
            contextPackages.add(packageName);
        }
        
        public ArrayList<String>getContextPackages() {
            return contextPackages;
        }
        
        public TaxiiXml getTaxiiXml() {
            TaxiiXml taxiiXml = TaxiiXml.newInstance();
            if (!contextPackages.isEmpty()) {
                taxiiXml.addJaxbContextPath(contextPackages);
            }
            taxiiXml.initializeJaxbContext();
                                                         
            return taxiiXml;
        }
            
}
