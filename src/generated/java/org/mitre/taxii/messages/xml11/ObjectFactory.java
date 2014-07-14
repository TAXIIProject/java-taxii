
package org.mitre.taxii.messages.xml11;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.mitre.taxii.messages.xml11 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PollFulfillment_QNAME = new QName("http://taxii.mitre.org/messages/taxii_xml_binding-1.1", "Poll_Fulfillment");
    private final static QName _InboxMessage_QNAME = new QName("http://taxii.mitre.org/messages/taxii_xml_binding-1.1", "Inbox_Message");
    private final static QName _StatusMessage_QNAME = new QName("http://taxii.mitre.org/messages/taxii_xml_binding-1.1", "Status_Message");
    private final static QName _PollResponse_QNAME = new QName("http://taxii.mitre.org/messages/taxii_xml_binding-1.1", "Poll_Response");
    private final static QName _DiscoveryResponse_QNAME = new QName("http://taxii.mitre.org/messages/taxii_xml_binding-1.1", "Discovery_Response");
    private final static QName _CollectionInformationResponse_QNAME = new QName("http://taxii.mitre.org/messages/taxii_xml_binding-1.1", "Collection_Information_Response");
    private final static QName _SubscriptionManagementRequest_QNAME = new QName("http://taxii.mitre.org/messages/taxii_xml_binding-1.1", "Subscription_Management_Request");
    private final static QName _PollRequest_QNAME = new QName("http://taxii.mitre.org/messages/taxii_xml_binding-1.1", "Poll_Request");
    private final static QName _DiscoveryRequest_QNAME = new QName("http://taxii.mitre.org/messages/taxii_xml_binding-1.1", "Discovery_Request");
    private final static QName _SubscriptionManagementResponse_QNAME = new QName("http://taxii.mitre.org/messages/taxii_xml_binding-1.1", "Subscription_Management_Response");
    private final static QName _CollectionInformationRequest_QNAME = new QName("http://taxii.mitre.org/messages/taxii_xml_binding-1.1", "Collection_Information_Request");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.mitre.taxii.messages.xml11
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TAXIIInboxMessageType }
     * 
     */
    public TAXIIInboxMessageType createTAXIIInboxMessageType() {
        return new TAXIIInboxMessageType();
    }

    /**
     * Create an instance of {@link TAXIIPollRequestType }
     * 
     */
    public TAXIIPollRequestType createTAXIIPollRequestType() {
        return new TAXIIPollRequestType();
    }

    /**
     * Create an instance of {@link TAXIIDiscoveryRequestType }
     * 
     */
    public TAXIIDiscoveryRequestType createTAXIIDiscoveryRequestType() {
        return new TAXIIDiscoveryRequestType();
    }

    /**
     * Create an instance of {@link TAXIISubscriptionManagementResponseType }
     * 
     */
    public TAXIISubscriptionManagementResponseType createTAXIISubscriptionManagementResponseType() {
        return new TAXIISubscriptionManagementResponseType();
    }

    /**
     * Create an instance of {@link TAXIIPollFulfillmentType }
     * 
     */
    public TAXIIPollFulfillmentType createTAXIIPollFulfillmentType() {
        return new TAXIIPollFulfillmentType();
    }

    /**
     * Create an instance of {@link TAXIISubscriptionManagementRequestType }
     * 
     */
    public TAXIISubscriptionManagementRequestType createTAXIISubscriptionManagementRequestType() {
        return new TAXIISubscriptionManagementRequestType();
    }

    /**
     * Create an instance of {@link TAXIIStatusMessageType }
     * 
     */
    public TAXIIStatusMessageType createTAXIIStatusMessageType() {
        return new TAXIIStatusMessageType();
    }

    /**
     * Create an instance of {@link TAXIIPollResponseType }
     * 
     */
    public TAXIIPollResponseType createTAXIIPollResponseType() {
        return new TAXIIPollResponseType();
    }

    /**
     * Create an instance of {@link TAXIICollectionInformationRequestType }
     * 
     */
    public TAXIICollectionInformationRequestType createTAXIICollectionInformationRequestType() {
        return new TAXIICollectionInformationRequestType();
    }

    /**
     * Create an instance of {@link TAXIICollectionInformationResponseType }
     * 
     */
    public TAXIICollectionInformationResponseType createTAXIICollectionInformationResponseType() {
        return new TAXIICollectionInformationResponseType();
    }

    /**
     * Create an instance of {@link TAXIIDiscoveryResponseType }
     * 
     */
    public TAXIIDiscoveryResponseType createTAXIIDiscoveryResponseType() {
        return new TAXIIDiscoveryResponseType();
    }

    /**
     * Create an instance of {@link SupportedQueryType }
     * 
     */
    public SupportedQueryType createSupportedQueryType() {
        return new SupportedQueryType();
    }

    /**
     * Create an instance of {@link SourceSubscriptionType }
     * 
     */
    public SourceSubscriptionType createSourceSubscriptionType() {
        return new SourceSubscriptionType();
    }

    /**
     * Create an instance of {@link ServiceInstanceType }
     * 
     */
    public ServiceInstanceType createServiceInstanceType() {
        return new ServiceInstanceType();
    }

    /**
     * Create an instance of {@link ExtendedHeadersType }
     * 
     */
    public ExtendedHeadersType createExtendedHeadersType() {
        return new ExtendedHeadersType();
    }

    /**
     * Create an instance of {@link ServiceContactInfoType }
     * 
     */
    public ServiceContactInfoType createServiceContactInfoType() {
        return new ServiceContactInfoType();
    }

    /**
     * Create an instance of {@link PollParametersType }
     * 
     */
    public PollParametersType createPollParametersType() {
        return new PollParametersType();
    }

    /**
     * Create an instance of {@link ContentBlockType }
     * 
     */
    public ContentBlockType createContentBlockType() {
        return new ContentBlockType();
    }

    /**
     * Create an instance of {@link PushParameterType }
     * 
     */
    public PushParameterType createPushParameterType() {
        return new PushParameterType();
    }

    /**
     * Create an instance of {@link CollectionRecordType }
     * 
     */
    public CollectionRecordType createCollectionRecordType() {
        return new CollectionRecordType();
    }

    /**
     * Create an instance of {@link SubscriptionRecordType }
     * 
     */
    public SubscriptionRecordType createSubscriptionRecordType() {
        return new SubscriptionRecordType();
    }

    /**
     * Create an instance of {@link SubscriptionParametersType }
     * 
     */
    public SubscriptionParametersType createSubscriptionParametersType() {
        return new SubscriptionParametersType();
    }

    /**
     * Create an instance of {@link InboxServiceBindingsType }
     * 
     */
    public InboxServiceBindingsType createInboxServiceBindingsType() {
        return new InboxServiceBindingsType();
    }

    /**
     * Create an instance of {@link SubtypeType }
     * 
     */
    public SubtypeType createSubtypeType() {
        return new SubtypeType();
    }

    /**
     * Create an instance of {@link AnyMixedContentType }
     * 
     */
    public AnyMixedContentType createAnyMixedContentType() {
        return new AnyMixedContentType();
    }

    /**
     * Create an instance of {@link PushMethodType }
     * 
     */
    public PushMethodType createPushMethodType() {
        return new PushMethodType();
    }

    /**
     * Create an instance of {@link QueryType }
     * 
     */
    public QueryType createQueryType() {
        return new QueryType();
    }

    /**
     * Create an instance of {@link RecordCountType }
     * 
     */
    public RecordCountType createRecordCountType() {
        return new RecordCountType();
    }

    /**
     * Create an instance of {@link StatusDetailDetailType }
     * 
     */
    public StatusDetailDetailType createStatusDetailDetailType() {
        return new StatusDetailDetailType();
    }

    /**
     * Create an instance of {@link ContentBindingIDType }
     * 
     */
    public ContentBindingIDType createContentBindingIDType() {
        return new ContentBindingIDType();
    }

    /**
     * Create an instance of {@link ExtendedHeaderType }
     * 
     */
    public ExtendedHeaderType createExtendedHeaderType() {
        return new ExtendedHeaderType();
    }

    /**
     * Create an instance of {@link ContentInstanceType }
     * 
     */
    public ContentInstanceType createContentInstanceType() {
        return new ContentInstanceType();
    }

    /**
     * Create an instance of {@link StatusDetailType }
     * 
     */
    public StatusDetailType createStatusDetailType() {
        return new StatusDetailType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAXIIPollFulfillmentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://taxii.mitre.org/messages/taxii_xml_binding-1.1", name = "Poll_Fulfillment")
    public JAXBElement<TAXIIPollFulfillmentType> createPollFulfillment(TAXIIPollFulfillmentType value) {
        return new JAXBElement<TAXIIPollFulfillmentType>(_PollFulfillment_QNAME, TAXIIPollFulfillmentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAXIIInboxMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://taxii.mitre.org/messages/taxii_xml_binding-1.1", name = "Inbox_Message")
    public JAXBElement<TAXIIInboxMessageType> createInboxMessage(TAXIIInboxMessageType value) {
        return new JAXBElement<TAXIIInboxMessageType>(_InboxMessage_QNAME, TAXIIInboxMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAXIIStatusMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://taxii.mitre.org/messages/taxii_xml_binding-1.1", name = "Status_Message")
    public JAXBElement<TAXIIStatusMessageType> createStatusMessage(TAXIIStatusMessageType value) {
        return new JAXBElement<TAXIIStatusMessageType>(_StatusMessage_QNAME, TAXIIStatusMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAXIIPollResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://taxii.mitre.org/messages/taxii_xml_binding-1.1", name = "Poll_Response")
    public JAXBElement<TAXIIPollResponseType> createPollResponse(TAXIIPollResponseType value) {
        return new JAXBElement<TAXIIPollResponseType>(_PollResponse_QNAME, TAXIIPollResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAXIIDiscoveryResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://taxii.mitre.org/messages/taxii_xml_binding-1.1", name = "Discovery_Response")
    public JAXBElement<TAXIIDiscoveryResponseType> createDiscoveryResponse(TAXIIDiscoveryResponseType value) {
        return new JAXBElement<TAXIIDiscoveryResponseType>(_DiscoveryResponse_QNAME, TAXIIDiscoveryResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAXIICollectionInformationResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://taxii.mitre.org/messages/taxii_xml_binding-1.1", name = "Collection_Information_Response")
    public JAXBElement<TAXIICollectionInformationResponseType> createCollectionInformationResponse(TAXIICollectionInformationResponseType value) {
        return new JAXBElement<TAXIICollectionInformationResponseType>(_CollectionInformationResponse_QNAME, TAXIICollectionInformationResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAXIISubscriptionManagementRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://taxii.mitre.org/messages/taxii_xml_binding-1.1", name = "Subscription_Management_Request")
    public JAXBElement<TAXIISubscriptionManagementRequestType> createSubscriptionManagementRequest(TAXIISubscriptionManagementRequestType value) {
        return new JAXBElement<TAXIISubscriptionManagementRequestType>(_SubscriptionManagementRequest_QNAME, TAXIISubscriptionManagementRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAXIIPollRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://taxii.mitre.org/messages/taxii_xml_binding-1.1", name = "Poll_Request")
    public JAXBElement<TAXIIPollRequestType> createPollRequest(TAXIIPollRequestType value) {
        return new JAXBElement<TAXIIPollRequestType>(_PollRequest_QNAME, TAXIIPollRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAXIIDiscoveryRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://taxii.mitre.org/messages/taxii_xml_binding-1.1", name = "Discovery_Request")
    public JAXBElement<TAXIIDiscoveryRequestType> createDiscoveryRequest(TAXIIDiscoveryRequestType value) {
        return new JAXBElement<TAXIIDiscoveryRequestType>(_DiscoveryRequest_QNAME, TAXIIDiscoveryRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAXIISubscriptionManagementResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://taxii.mitre.org/messages/taxii_xml_binding-1.1", name = "Subscription_Management_Response")
    public JAXBElement<TAXIISubscriptionManagementResponseType> createSubscriptionManagementResponse(TAXIISubscriptionManagementResponseType value) {
        return new JAXBElement<TAXIISubscriptionManagementResponseType>(_SubscriptionManagementResponse_QNAME, TAXIISubscriptionManagementResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAXIICollectionInformationRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://taxii.mitre.org/messages/taxii_xml_binding-1.1", name = "Collection_Information_Request")
    public JAXBElement<TAXIICollectionInformationRequestType> createCollectionInformationRequest(TAXIICollectionInformationRequestType value) {
        return new JAXBElement<TAXIICollectionInformationRequestType>(_CollectionInformationRequest_QNAME, TAXIICollectionInformationRequestType.class, null, value);
    }

}
