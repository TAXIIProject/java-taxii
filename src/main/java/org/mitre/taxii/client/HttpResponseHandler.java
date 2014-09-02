/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mitre.taxii.client;

import java.io.IOException;
import javax.net.ssl.SSLException;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author jasenj1
 */
public abstract class HttpResponseHandler {
    
    public abstract Object buildStatusCodeStatusMessage(CloseableHttpResponse response, Object message);
    public abstract Object buildSSLErrorStatusMessage(SSLException ex, Object message);
    
    /**
     * Render the headers and the response content as a string.
     * This could include more things such as the status code.
     * 
     * @param response
     * @return 
     */
     public String buildResponseStr(CloseableHttpResponse response) {
        StringBuilder sb = new StringBuilder();
        
        HeaderIterator hi = response.headerIterator();
        while (hi.hasNext()) {
            Header header = hi.nextHeader();
            sb.append(header.getName()).append(": ").append(header.getValue()).append("\r\n");                        
        }
        sb.append("\r\n");
        try {
            sb.append(EntityUtils.toString(response.getEntity()));            
        } catch (IOException | IllegalStateException ex) {
            // Don't care
        }
        
        return sb.toString();
    }
    
}
