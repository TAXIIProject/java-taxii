/*
Copyright (c) 2015, The MITRE Corporation
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
    * Neither the name of The MITRE Corporation nor the 
      names of its contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 */
package org.mitre.taxii.messages.xml11;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.Unmarshaller;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mitre.taxii.util.Validation;

/**
 * Perform XML Schema validation on instance documents. This helps ensure the 
 * schema enforces restrictions in the spec.
 * 
 * @author jasenj1
 */
@RunWith(Parameterized.class)
public class SchemaValidationTests {

    
    private static TaxiiXml taxiiXml;
    private static Unmarshaller unmarshaller;
    
    private static final String filePath = "src/test/resources/xsd/1.1";
    
    @Parameterized.Parameter(0)
    public File file;
    
    
    @BeforeClass
    public static void init() throws Exception {
        TaxiiXmlFactory txf = new TaxiiXmlFactory();
        taxiiXml = txf.createTaxiiXml();
        unmarshaller = taxiiXml.getJaxbContext().createUnmarshaller();
    }

    @Parameterized.Parameters(name="{index} - {0}")
    public static Iterable<File[]> data() throws IOException {
        final List<File[]> data = new ArrayList<>();
        Files.walkFileTree(
                Paths.get(filePath),
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
        final Validation val = taxiiXml.validateAll(m, true);
        if (file.getName().endsWith("-valid.xml")) {
            assertTrue("Expected " + file.getName() + " to be valid!", val.isSuccess());
        }
        else if (file.getName().endsWith("-invalid.xml")) {
            assertTrue("Expected " + file.getName() + " to be invalid!", val.isFailure());
        }
        else {
            fail("Test error: test file must end in -valid.xml or -invalid.xml: " + file.getPath());
        }
    }    
}
