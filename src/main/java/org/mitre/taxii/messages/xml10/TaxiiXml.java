package org.mitre.taxii.messages.xml10;

import java.util.List;
import org.mitre.taxii.client.HttpResponseHandler;
import org.mitre.taxii.client.xml10.ResponseHandler;

/**
 *
 * @author jasenj1
 */
public class TaxiiXml extends org.mitre.taxii.messages.TaxiiXml {

    private HttpResponseHandler responseHandler = new ResponseHandler();
    
    public TaxiiXml(String taxiiVersion, String serviceVersion, String taxiiPackage, List<String> otherPackages, String schemaLocation, String validatorLocation) {
        super(taxiiVersion, serviceVersion, taxiiPackage, otherPackages, schemaLocation, validatorLocation);
    }
    
    public boolean isRequestMessage(Object message) {
        return (message instanceof RequestMessageType);
    }
    
    public HttpResponseHandler getResponseHandler() {
        return responseHandler;
    }    
}
