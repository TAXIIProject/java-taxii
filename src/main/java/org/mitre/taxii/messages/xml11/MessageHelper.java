package org.mitre.taxii.messages.xml11;

import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jasenj1
 */
public class MessageHelper {
    
    public static ExtendedHeaderType createExtendedHeader(final URI name, final Object value) {
        final ExtendedHeaderType eht = new ExtendedHeaderType().withName(name.toString());
        eht.getContent().add(value.toString());        
        return eht;
    }
    
    public static MessageType addExtendedHeader(final MessageType m, final URI name, final Object... value) {
        
        ExtendedHeadersType eht = m.getExtendedHeaders();
        
        if (null == eht) { // There are no extended headers. Add them.
            final ExtendedHeadersType newEht = new ExtendedHeadersType();
            m.setExtendedHeaders(newEht);
            eht = m.getExtendedHeaders();
        }
        
        final List<ExtendedHeaderType> extendedHeaders = eht.getExtendedHeaders();
        
        for (Object item: value) {
            final ExtendedHeaderType eh = createExtendedHeader(name, item);
            extendedHeaders.add(eh);             
        }
        
        return m;
        
    }
    
    public void addExtendedHeaders(final MessageType m, final Map headerMap) {
        
    }
    
}
