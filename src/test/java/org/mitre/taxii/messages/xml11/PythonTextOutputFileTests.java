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
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.Unmarshaller;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

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
    
    @Parameterized.Parameter(0)
    public File file;
    
    private static File outDir;
    
    @BeforeClass
    public static void init() throws Exception {
        TaxiiXmlFactory txf = new TaxiiXmlFactory();
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
        MessageType m = (MessageType) unmarshaller.unmarshal(file);
        String s = PythonTextOutput.toText(m);
        String outName = file.getName().replaceFirst("[.][^.]+$", "");
        File outFile = new File(outDir,outName + ".txt");
        
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
        System.out.println(s);
        writer.write(s);
        writer.close();
    }
    
}
