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
                    <sch:rule context="/taxii:Status_Message[@status_type = 'UNSUPPORTED_MESSAGE']/taxii:Status_Detail">
                        <sch:assert test="every $token in tokenize(., ' ') satisfies $token castable as xs:anyURI">
                            Status_Detail must contain a space-separated list of Message Binding IDs indicating supported message bindings.
                        </sch:assert>
                    </sch:rule>
                    <sch:rule context="/taxii:Status_Message[@status_type = 'UNSUPPORTED_CONTENT']/taxii:Status_Detail">
                        <sch:assert test="every $token in tokenize(., ' ') satisfies $token castable as xs:anyURI">
                            Status_Detail must contain a space-separated list of Content Binding IDs indicating supported content bindings.
                        </sch:assert>
                    </sch:rule>
                    <sch:rule context="/taxii:Status_Message[@status_type = 'UNSUPPORTED_PROTOCOL']/taxii:Status_Detail">
                        <sch:assert test="every $token in tokenize(., ' ') satisfies $token castable as xs:anyURI">
                            Status_Detail must contain a space-separated list of Protocol Binding IDs indicating supported protocol bindings.
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
   <sch:pattern xmlns="http://taxii.mitre.org/messages/taxii_xml_binding-1"
                xmlns:taxii="http://taxii.mitre.org/messages/taxii_xml_binding-1"
                xmlns:ds="http://www.w3.org/2000/09/xmldsig#">
                    <sch:title>Subscription Management Request Rules</sch:title>
                    <sch:rule context="/taxii:Subscription_Management_Request[@action='UNSUBSCRIBE']">
                        <sch:assert test="@subscription_id">
                            @subscription_id MUST be present if the action is UNSUBSCRIBE.
                        </sch:assert>
                    </sch:rule>                    
                    <sch:rule context="/taxii:Subscription_Management_Request[not(@action='UNSUBSCRIBE')]">
                        <sch:assert test="not(@subscription_id)">
                            @subscription_id SHOULD not be present if the action is not UNSUBSCRIBE.
                        </sch:assert>
                    </sch:rule>                    
                    <sch:rule context="/taxii:Subscription_Management_Request[not(@action='SUBSCRIBE')]">
                        <sch:assert test="not(Push_Parameters)">
                            For values of @action other than SUBSCRIBE senders SHOULD NOT include Push_Parameters.
                        </sch:assert>
                    </sch:rule>                    
                </sch:pattern>
   <sch:diagnostics/>
</sch:schema>
