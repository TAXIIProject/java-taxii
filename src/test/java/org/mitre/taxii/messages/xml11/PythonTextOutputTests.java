package org.mitre.taxii.messages.xml11;

import java.math.BigInteger;
import org.junit.Test;

public class PythonTextOutputTests {

    @Test
    public void SupportedQueryTypeTest() {
        ObjectFactory of = new ObjectFactory();        
        SupportedQueryType obj = of.createSupportedQueryType().withFormatId("Test Format ID");
        
        String s = PythonTextOutput.toText(obj);
        System.out.println(s);
    }

    @Test
    public void QueryTypeTest() {
        ObjectFactory of = new ObjectFactory();        
        QueryType obj = of.createQueryType().withFormatId("Test Format ID");
        
        String s = PythonTextOutput.toText(obj);
        System.out.println(s);
    }
    
    @Test
    public void ContentBindingIDTypeTest() {
        ObjectFactory of = new ObjectFactory();        
        ContentBindingIDType obj = of.createContentBindingIDType().withBindingId("Test Binding ID")
                                .withSubtypes(
                                        of.createSubtypeType().withSubtypeId("Subtype 1")
                                       ,of.createSubtypeType().withSubtypeId("Subtype 2")
                                       ,of.createSubtypeType().withSubtypeId("Subtype 3")
                                );
        String s = PythonTextOutput.toText(obj);
        System.out.println(s);        
    }
    
    @Test
    public void RecordCountTypeTest() {
        ObjectFactory of = new ObjectFactory();        
        RecordCountType obj = of.createRecordCountType().withValue(BigInteger.valueOf(5));

        String s = PythonTextOutput.toText(obj);
        System.out.println(s);                
    }
    
    @Test
    public void ContentBlockTest() {
        ObjectFactory of = new ObjectFactory(); 
        ContentBlock obj = of.createContentBlock()
                .withContentBinding(of.createContentInstanceType().withBindingId("Test Binding ID"))
                .withPadding("Some padding");
                 // .withTimestampLabel(null)
        
        String s = PythonTextOutput.toText(obj);
        System.out.println(s);                
    }
    
    @Test
    public void PushParameterTypeTest() {
        ObjectFactory of = new ObjectFactory(); 
        PushParameterType obj = of.createPushParameterType()
                .withAddress("http://inbox-address.org")
                .withMessageBinding("message binding")
                .withProtocolBinding("protocol binding");
        
        String s = PythonTextOutput.toText(obj);
        System.out.println(s);                
    }
    
    @Test
    public void DiscoveryResponseTest() {
        ObjectFactory of = new ObjectFactory();
        DiscoveryResponse obj = of.createDiscoveryResponse()
                .withInResponseTo("in response to 10")
                .withMessageId("msg id 001")
                .withExtendedHeaders(
                        of.createExtendedHeadersType().withExtendedHeaders(
                                of.createExtendedHeaderType().withName("Extended Header 1").withContent("Content 1"),
                                of.createExtendedHeaderType().withName("Extended Header 2").withContent("Content 2")
                        )
                )
                .withServiceInstances(
                    of.createServiceInstanceType()
                        .withAddress("http://address1.com")
                        .withAvailable(Boolean.TRUE)
                        .withServiceType(ServiceTypeEnum.DISCOVERY)
                        .withServiceVersion("version 1")
                        .withProtocolBinding("sample protocol binding")
                        .withMessageBindings("msg binding1", "msg binding 2")
                        .withMessage("a message")
                        .withSupportedQueries(
                            of.createSupportedQueryType().withFormatId("Test Format ID"),
                            of.createSupportedQueryType().withFormatId("Test Format ID 2")
                        ),
                    of.createServiceInstanceType()
                        .withAddress("http://address2.com")
                        .withAvailable(Boolean.TRUE)
                        .withServiceType(ServiceTypeEnum.INBOX)
                        .withServiceVersion("version 1")
                        .withProtocolBinding("sample protocol binding")
                        .withMessageBindings("msg binding1", "msg binding 2")
                        .withMessage("a message 2")
                        .withSupportedQueries(
                            of.createSupportedQueryType().withFormatId("Test Format ID"),
                            of.createSupportedQueryType().withFormatId("Test Format ID 2")
                        )
                        .withContentBindings(
                            of.createContentBindingIDType().withBindingId("Binding ID 1")
                        )
                );

        String s = PythonTextOutput.toText(obj);
        System.out.println(s);                        
    }
}
