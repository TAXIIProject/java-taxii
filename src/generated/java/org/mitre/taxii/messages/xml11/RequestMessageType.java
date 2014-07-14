
package org.mitre.taxii.messages.xml11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * The base type of request messages.
 * 
 * <p>Java class for RequestMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestMessageType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://taxii.mitre.org/messages/taxii_xml_binding-1.1}MessageType">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestMessageType")
@XmlSeeAlso({
    TAXIIInboxMessageType.class,
    TAXIIPollRequestType.class,
    TAXIIDiscoveryRequestType.class,
    TAXIIPollFulfillmentType.class,
    TAXIISubscriptionManagementRequestType.class,
    TAXIICollectionInformationRequestType.class
})
public abstract class RequestMessageType
    extends MessageType
{


}
