/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mitre.taxii.messages.xml11;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.oxm.MediaType;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mitre.taxii.query.DefaultQuery;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 *
 * @author jasenj1
 */

@RunWith(Parameterized.class)
public class PythonTextOutputFileTests {
    private static TaxiiXml taxiiXml;
    private static Unmarshaller unmarshaller;

    private static final String inputPath = "src/test/resources/python_output/1.1";
    private static final String outputPath = "build/test-results";

    private static File outDir;

    @Parameterized.Parameter(0)
    public File file;

    @BeforeClass
    public static void init() throws Exception {
        // Use MOXy so we get JSON support
        System.setProperty(JAXBContext.JAXB_CONTEXT_FACTORY, "org.eclipse.persistence.jaxb.JAXBContextFactory");
        
        
        TaxiiXmlFactory txf = new TaxiiXmlFactory();
        txf.addJaxbContextPackage(DefaultQuery.class.getPackage().getName());
        taxiiXml = txf.createTaxiiXml();
        unmarshaller = taxiiXml.getJaxbContext().createUnmarshaller();
        outDir = new File(outputPath);
    }

    @Parameterized.Parameters(name="{index} - {0}")
    public static Iterable<File[]> data() throws IOException {
        final List<File[]> data = new ArrayList<>();
        Files.walkFileTree(
                Paths.get(inputPath),
                new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        if (!file.toFile().isHidden()) {
                            data.add(new File[] { file.toFile() });
                        }
                        return FileVisitResult.CONTINUE;
                    }
                });
        return data;
    }
    
    @Test
    public void testFile() throws Exception {
        MessageType m;
        try {
            m = (MessageType) unmarshaller.unmarshal(file);
        } catch (Exception ex) {
            if (file.getName().endsWith("-invalid.xml")) {
                assertTrue(ex.toString(),true);
            } else {
                fail(ex.toString());
            }
            System.out.println(String.format("'%s' failed validation. %s", file.getName(),ex.toString()));
            return;
        }
        String outName = file.getName().replaceFirst("[.][^.]+$", "");
        
        // Write Python text output
        File txtOutFile = new File(outDir, outName + ".txt");
        Writer txtWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(txtOutFile), "utf-8"));
        String s = PythonTextOutput.toText(m);
        System.out.println(s);
        txtWriter.write(s);
        txtWriter.close();
        
        // Write XML output
        File xmlOutFile = new File(outDir, outName + ".xml");
        Writer xmlWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(xmlOutFile), "utf-8"));
        String xml = taxiiXml.marshalToString(m, true);
        System.out.println(xml);
        xmlWriter.write(xml);
        xmlWriter.close();
        
        // Write JSON output
        File jsonOutFile = new File(outDir, outName + ".json");
        Writer jsonWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(jsonOutFile), "utf-8"));
        final StringWriter sw = new StringWriter();        
        Marshaller marshaller = taxiiXml.createMarshaller(true);
        // Tell the marshaller to output JSON.
        marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);
        marshaller.marshal(m, sw);
        String json = sw.toString();
        System.out.println(json);
        jsonWriter.write(json);
        jsonWriter.close();
    }
    
}
