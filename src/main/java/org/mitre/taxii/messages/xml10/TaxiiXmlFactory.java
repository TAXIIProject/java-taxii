package org.mitre.taxii.messages.xml10;
/*
Copyright (c) 2014, The MITRE Corporation
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
    * Neither the name of The MITRE Corporation nor the 
      names of its contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 */

import java.util.ArrayList;
import java.util.List;
import org.mitre.taxii.ResourcePaths;
import org.mitre.taxii.Versions;
import org.mitre.taxii.messages.xmldsig.Signature;

/**
 * Class used to create instances of TaxiiXml for a specific version of TAXII.
 * This factory ensures the TaxiiXml object is initialized properly and ready
 * for use.
 * 
 * @author jasenj1
 */
public class TaxiiXmlFactory {
    
        private final List<String>contextPackages = new ArrayList<>();
        
        
        public TaxiiXmlFactory() {
            addJaxbContextPackage(Signature.class.getPackage().getName());
        }
        
        /**
         * Add A JAXB context package to this factory. The factory will create
         * a TaxiiXml object that knows how to handle all of the JAXB classes
         * declared in the package. For example, "org.mitre.taxii.query" to 
         * handle the TAXII default query classes.
         * 
         * @param packageName 
         */
        public final void addJaxbContextPackage(String packageName) {
            contextPackages.add(packageName);
        }
        
        /**
         * 
         * @return live list of the JAXB context package names this factory
         * knows about.
         */
        public List<String>getContextPackages() {
            return contextPackages;
        }
        
        /**
         * Generate a TaxiiXml object configured for TAXII 1.0 messages.
         * 
         * @return a TaxiiXml object configured for TAXII 1.0 messages.
         */
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
