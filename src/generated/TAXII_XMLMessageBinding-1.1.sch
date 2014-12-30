<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<sch:schema xmlns:sch="http://purl.oclc.org/dsdl/schematron"
            xmlns:xs="http://www.w3.org/2001/XMLSchema"
            queryBinding="xslt2">
   <sch:ns xmlns="http://taxii.mitre.org/messages/taxii_xml_binding-1.1"
           xmlns:taxii="http://taxii.mitre.org/messages/taxii_xml_binding-1.1"
           xmlns:ds="http://www.w3.org/2000/09/xmldsig#"
           prefix="taxii"
           uri="http://taxii.mitre.org/messages/taxii_xml_binding-1.1"/>
   <sch:pattern xmlns="http://taxii.mitre.org/messages/taxii_xml_binding-1.1"
                xmlns:taxii="http://taxii.mitre.org/messages/taxii_xml_binding-1.1"
                xmlns:ds="http://www.w3.org/2000/09/xmldsig#">
                    <sch:title>Status Message Rules</sch:title>
                    <sch:rule context="/taxii:Status_Message[@status_type = 'INVALID_RESPONSE_PART']">
                        <sch:assert test="taxii:Status_Detail/taxii:Detail[@name='MAX_PART_NUMBER'] castable as xs:integer and xs:integer(taxii:Status_Detail/taxii:Detail[@name='MAX_PART_NUMBER']) &gt; 0">
                            A Status Message of type INVALID_RESPONSE_PART requires a MAX_PART_NUMBER Status Detail that is
                            a positive integer.
                        </sch:assert>
                    </sch:rule>
                    
                    <sch:rule context="/taxii:Status_Message[@status_type = 'PENDING']">
                        <sch:assert test="taxii:Status_Detail/taxii:Detail[@name='ESTIMATED_WAIT'] castable as xs:integer and xs:integer(taxii:Status_Detail/taxii:Detail[@name='ESTIMATED_WAIT']) &gt; 0">
                            A Status Message of type PENDING requires an ESTIMATED_WAIT Status Detail that is 
                            a positiveInteger.
                        </sch:assert>
                        <sch:assert test="string-length(taxii:Status_Detail/taxii:Detail[@name='RESULT_ID']) &gt; 0">
                            A Status Message of type PENDING requires a RESULT_ID Status Detail that is 
                            a URI.
                        </sch:assert>
                        <sch:assert test="taxii:Status_Detail/taxii:Detail[@name='WILL_PUSH'] castable as xs:boolean">
                            A Status Message of type PENDING requires a WILL_PUSH Status Detail that is 
                            a boolean.
                        </sch:assert>
                    </sch:rule>
                    
                    <sch:rule context="/taxii:Status_Message[@status_type = 'RETRY']/taxii:Status_Detail/taxii:Detail[@name='ESTIMATED_WAIT']">
                        <sch:assert test=". castable as xs:integer and xs:integer(.) &gt; 0">
                            A Status Message of type RETRY has an optional ESTIMATED_WAIT Status
                            Detail of type positiveInteger.
                        </sch:assert>
                    </sch:rule>
                </sch:pattern>
   <sch:pattern xmlns="http://taxii.mitre.org/messages/taxii_xml_binding-1.1"
                xmlns:taxii="http://taxii.mitre.org/messages/taxii_xml_binding-1.1"
                xmlns:ds="http://www.w3.org/2000/09/xmldsig#">
                            <sch:title>Content_Binding only present when @service_type=INBOX. XML Binding Spec section 3.3. </sch:title>
                            <sch:rule context="taxii:Service_Instance/taxii:Content_Binding">
                                <sch:assert test="../@service_type='INBOX'">If Content_Binding is present, @service_type SHOULD be "INBOX".</sch:assert>
                            </sch:rule>                                                           
                        </sch:pattern>
   <sch:pattern xmlns="http://taxii.mitre.org/messages/taxii_xml_binding-1.1"
                xmlns:taxii="http://taxii.mitre.org/messages/taxii_xml_binding-1.1"
                xmlns:ds="http://www.w3.org/2000/09/xmldsig#">
                    <sch:title>Subscription Management Request Rules</sch:title>
                    <sch:rule context="/taxii:Subscription_Management_Request[@action='UNSUBSCRIBE' or @action='PAUSE' or @action='RESUME']">
                        <sch:assert test="taxii:Subscription_ID">
                            Subscription_ID MUST be present if the action is UNSUBSCRIBE, PAUSE, or RESUME.
                        </sch:assert>
                    </sch:rule>
                    
                    <sch:rule context="/taxii:Subscription_Management_Request[@action='SUBSCRIBE']">
                        <sch:assert test="taxii:Subscription_Parameters">
                            Subscription Parameters MUST be present if the action is SUBSCRIBE.
                        </sch:assert>
                    </sch:rule>
                </sch:pattern>
   <sch:pattern xmlns="http://taxii.mitre.org/messages/taxii_xml_binding-1.1"
                xmlns:taxii="http://taxii.mitre.org/messages/taxii_xml_binding-1.1"
                xmlns:ds="http://www.w3.org/2000/09/xmldsig#">
                    <sch:title>Poll Request Rules</sch:title>
                    <sch:rule context="/taxii:Poll_Request[taxii:Exclusive_Begin_Timestamp and taxii:Inclusive_End_Timestamp]">
                        <sch:assert test="taxii:Inclusive_End_Timestamp &gt; taxii:Exclusive_Begin_Timestamp">
                            If both Exclusive_Begin_Timestamp and Inclusive_End_Timestamp 
                            are present in a Poll_Request, the Inclusive_End_Timestamp 
                            MUST be greater than Exclusive_Begin_Timestamp.
                        </sch:assert>
                    </sch:rule>
                </sch:pattern>
   <sch:pattern xmlns="http://taxii.mitre.org/messages/taxii_xml_binding-1.1"
                xmlns:taxii="http://taxii.mitre.org/messages/taxii_xml_binding-1.1"
                xmlns:ds="http://www.w3.org/2000/09/xmldsig#">
                    <sch:title>Poll Response Rules</sch:title>
                    <sch:rule context="/taxii:Poll_Response">
                        <sch:assert test="if (@more = true()) then (string-length(@result_id) &gt; 0) else true()">
                            The result_id attribute MUST be present if the more field is set to true.
                        </sch:assert>
                        <sch:assert test="if (taxii:Content_Block or taxii:Record_Count) then (xs:integer(taxii:Record_Count) &gt;= count(taxii:Content_Block)) else true()">
                            Record_Count MUST be greater than or equal to the number of 
                            Content Blocks.
                        </sch:assert>
                    </sch:rule>
                </sch:pattern>
   <sch:pattern xmlns="http://taxii.mitre.org/messages/taxii_xml_binding-1.1"
                xmlns:taxii="http://taxii.mitre.org/messages/taxii_xml_binding-1.1"
                xmlns:ds="http://www.w3.org/2000/09/xmldsig#">
                    <sch:title>Inbox Message Rules</sch:title>
                    <sch:rule context="/taxii:Inbox_Message">
                        <sch:assert test="if (taxii:Content_Block or taxii:Record_Count) then (xs:integer(taxii:Record_Count) &gt;= count(taxii:Content_Block)) else true()">
                            Record_Count MUST be greater than or equal to the number of 
                            Content Blocks.
                        </sch:assert>
                    </sch:rule>
                </sch:pattern>
   <sch:diagnostics/>
</sch:schema>
