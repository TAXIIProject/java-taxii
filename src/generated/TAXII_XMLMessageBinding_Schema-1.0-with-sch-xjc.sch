<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<sch:schema xmlns:sch="http://purl.oclc.org/dsdl/schematron"
            xmlns:xs="http://www.w3.org/2001/XMLSchema"
            queryBinding="xslt2">
   <sch:ns xmlns="http://taxii.mitre.org/messages/taxii_xml_binding-1"
           xmlns:taxii="http://taxii.mitre.org/messages/taxii_xml_binding-1"
           xmlns:ds="http://www.w3.org/2000/09/xmldsig#"
           prefix="taxii"
           uri="http://taxii.mitre.org/messages/taxii_xml_binding-1"/>
   <sch:pattern xmlns="http://taxii.mitre.org/messages/taxii_xml_binding-1"
                xmlns:taxii="http://taxii.mitre.org/messages/taxii_xml_binding-1"
                xmlns:ds="http://www.w3.org/2000/09/xmldsig#">
                    <sch:title>Status Message Rules</sch:title>
                    <sch:rule context="/taxii:Status_Message[@status_type = 'RETRY']/taxii:Status_Detail">
                        <sch:assert test=". castable as xs:dateTime">
                            A Status Message of type RETRY should have a Status_Detail containing a timestamp.
                        </sch:assert>
                    </sch:rule>
                </sch:pattern>
   <sch:pattern xmlns="http://taxii.mitre.org/messages/taxii_xml_binding-1"
                xmlns:taxii="http://taxii.mitre.org/messages/taxii_xml_binding-1"
                xmlns:ds="http://www.w3.org/2000/09/xmldsig#">
                            <sch:title>Content_Binding only present when @service_type=INBOX. XML Binding Spec section 3.3. </sch:title>
                            <sch:rule context="taxii:Service_Instance/taxii:Content_Binding">
                                <sch:assert test="../@service_type='INBOX'">If Content_Binding is present, @service_type SHOULD be "INBOX".</sch:assert>
                            </sch:rule>                                                           
                        </sch:pattern>
   <sch:diagnostics/>
</sch:schema>
