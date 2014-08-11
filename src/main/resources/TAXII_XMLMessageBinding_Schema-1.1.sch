<?xml version="1.0" encoding="UTF-8"?>
<sch:schema xmlns:sch="http://purl.oclc.org/dsdl/schematron" queryBinding="xslt2">
    <sch:ns uri="http://taxii.mitre.org/messages/taxii_xml_binding-1.1" 
        prefix="taxii"/>
    
    <sch:pattern>
        <sch:title>Rules for TAXII Messages</sch:title>

        <sch:p>
            Each of the rules below are mutually exclusive; in Schematron,
            only the first matching rule will fire, and the associated asserts
            tested.
        </sch:p>
        
        <sch:rule context="/taxii:Status_Message[@status_type = 'INVALID_RESPONSE_PART']">
            <sch:assert 
                test="taxii:Status_Detail/taxii:Detail[@name='MAX_PART_NUMBER'] castable as xs:positiveInteger">
                A Status Message of type INVALID_RESPONSE_PART requires a MAX_PART_NUMBER Status Detail that is
                a positiveInteger.
            </sch:assert>
        </sch:rule>
        
        <sch:rule context="/taxii:Status_Message[@status_type = 'PENDING']">
            <sch:assert 
                test="taxii:Status_Detail/taxii:Detail[@name='ESTIMATED_WAIT'] castable as xs:positiveInteger">
                A Status Message of type PENDING requires an ESTIMATED_WAIT Status Detail that is 
                a positiveInteger.
            </sch:assert>
            <sch:assert 
                test="taxii:Status_Detail/taxii:Detail[@name='RESULT_ID'] castable as xs:anyURI">
                A Status Message of type PENDING requires a RESULT_ID Status Detail that is 
                a URI.
            </sch:assert>
            <sch:assert 
                test="taxii:Status_Detail/taxii:Detail[@name='WILL_PUSH'] castable as xs:boolean">
                A Status Message of type PENDING requires a WILL_PUSH Status Detail that is 
                a boolean.
            </sch:assert>
        </sch:rule>
        
        <sch:rule context="/taxii:Status_Message[@status_type = 'RETRY']/taxii:Status_Detail/taxii:Detail[@name='ESTIMATED_WAIT']">
            <sch:assert test=". castable as xs:positiveInteger">
                A Status Message of type RETRY has an optional ESTIMATED_WAIT Status
                Detail of type positiveInteger.
            </sch:assert>
        </sch:rule>
        
        <sch:rule context="/taxii:Subscription_Management_Request[@action='UNSUBSCRIBE' or @action='PAUSE' or @action='RESUME']">
            <sch:assert test="taxii:Subscription_ID">
                Subscription_ID MUST be present in UNSUBSCRIBE, PAUSE, and RESUME actions.
            </sch:assert>
        </sch:rule>
        
        <sch:rule context="/taxii:Subscription_Management_Request[@action='SUBSCRIBE']">
            <sch:assert test="taxii:Subscription_Parameters">
                Subscription Parameters MUST be present in SUBSCRIBE actions.
            </sch:assert>
        </sch:rule>
    </sch:pattern>
</sch:schema>