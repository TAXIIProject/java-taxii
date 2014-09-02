package org.mitre.stix.messages;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import org.junit.Test;
import org.mitre.stix.common_1.IndicatorBaseType;
import org.mitre.stix.indicator_2.IndicatorType;
import org.mitre.stix.stix_1.IndicatorsType;
import org.mitre.stix.stix_1.ObjectFactory;
import org.mitre.stix.stix_1.STIXType;

public class StixTests {
    private final ObjectFactory factory = new ObjectFactory();
    
    @Test
    public void createSTIX() throws JAXBException {
        
        IndicatorType ind = new IndicatorType();
        ind.setId(new QName("IndicatorID"));
        
        IndicatorsType indsType = factory.createIndicatorsType();
        List<IndicatorBaseType> indList = indsType.getIndicator();
        indList.add(ind);
        
        STIXType st = factory.createSTIXType();
        st.setId(new QName("theName"));
        st.setVersion("1.0");
        st.setIndicators(indsType);
                        
        JAXBElement sp = factory.createSTIXPackage(st);

        JAXBContext context = JAXBContext.newInstance(STIXType.class);
        
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                
        final Unmarshaller u = context.createUnmarshaller();

        // Render the JAXB object to a string.
        final StringWriter sw = new StringWriter();
        m.marshal(sp, sw);        
        String xmlString = sw.toString();

        System.out.println("Original Object:\n");
        System.out.println(xmlString);
        System.out.println("\n");
        
        // Parse the rendered string back into a JAXB object.
        final JAXBElement<STIXType> objFromXml = u.unmarshal(new StreamSource(new StringReader(xmlString)), STIXType.class);

        // Render the reconstructed JAXB object to a string.
        sw.getBuffer().setLength(0);
        m.marshal(objFromXml, sw);        
        final String xmlString2 = sw.toString();
        
            System.out.println("Unmarshaled Object:\n");
            System.out.println(xmlString2);        
    }
    
}
