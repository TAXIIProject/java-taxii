package org.mitre.taxii.client;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HttpClientTest {

    HttpClient taxiiClient;
    StringBuilder cb;
    StringBuilder s;
    String oTag;
    String cTag;

    @Before
    public void setUp() throws Exception {
        taxiiClient = new HttpClient();
        oTag = "<taxii_11:Poll_Response collection_name='guest.Lehigh_edu'>";
        cTag = "</taxii_11:Poll_Response>";
        s = new StringBuilder();
        cb = new StringBuilder().append("<taxii_11:Content_Block>").append("<stix:Indicators>")
                .append("<stix:Indicator id='opensource:indicator-44ed11b0-ac22-4543-b8be-1bfa8d0dc987'>")
                .append("</stix:Indicator>").append("</stix:Indicators>").append("</taxii_11:Content_Block>");

        s.append(oTag);
        s.append(cb);
        s.append(cTag);
    }

    @After
    public void tearDown() throws Exception {
        // dumpContentBlocksTest7 clean up
        deleteDirectory(new File("/var/tmp/EOFException/"));
    }

    private static boolean deleteDirectory(File dir) {
        if (dir.isDirectory()) {
            File[] children = dir.listFiles();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDirectory(children[i]);
                if (!success) {
                    return false;
                }
            }
        }

        // either file or an empty directory
        System.out.println("removing file or directory : " + dir.getName());
        return dir.delete();
    }

    private String readFile(String path) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        StringBuilder out = new StringBuilder();

        String line = reader.readLine();
        while (line != null) {
            out.append(line);
            line = reader.readLine();
        }
        return out.toString();
    }

    @Test
    public void writeToFileTest() throws Exception {
        String feedId = "feed_" + UUID.randomUUID();
        String path = "/var/tmp/" + feedId;
        String data = cb.toString();

        // First write
        taxiiClient.writeToFile(path, oTag, data, cTag);

        String wBookmark = path + "/bookmark.write";
        // verify the bookmark was created
        assertTrue(new File(wBookmark).exists());

        // verify the block value is written
        String line = readFile(wBookmark);
        int writeBM = Integer.parseInt(line);
        assertEquals(writeBM, 1);

        // verify data file was written
        assertTrue(new File(path + "/block_" + 0 + ".xml").exists());

        // Second write
        taxiiClient.writeToFile(path, oTag, data, cTag);

        // verify the block value is written
        line = readFile(wBookmark);
        writeBM = Integer.parseInt(line);
        assertEquals(writeBM, 2);

        // verify data file was written
        writeBM--;
        assertTrue(new File(path + "/block_" + 1 + ".xml").exists());

        deleteDirectory(new File(path));
    }

    @Test
    // consuming single valid block
    public void dumpContentBlocksTest1() throws Exception {
        String input = s.toString();
        String feedId = "feed_" + UUID.randomUUID();
        String path = "/var/tmp/" + feedId;
        InputStream is = new ByteArrayInputStream(input.getBytes());
        taxiiClient.dumpContentBlocks(is, path, 400);

        String output = readFile(path + "/block_0.xml");
        assertEquals(input, output);

        deleteDirectory(new File(path));
    }

    @Test
    // consuming several valid blocks. both go into the same file. block limit not reached
    public void dumpContentBlocksTest2() throws Exception {
        String feedId = "feed_" + UUID.randomUUID();
        String path = "/var/tmp/" + feedId;

        StringBuilder in = new StringBuilder().append("<taxii_11:Poll_Response collection_name='guest.Lehigh_edu'>")
                .append(cb).append(cb).append("</taxii_11:Poll_Response>");
        String input = in.toString();

        InputStream is = new ByteArrayInputStream(input.getBytes());
        taxiiClient.dumpContentBlocks(is, path, 1000);

        String output = readFile(path + "/block_0.xml");
        assertEquals(input, output);

        deleteDirectory(new File(path));
    }

    @Test
    // consuming several valid blocks. each goes into it's own block.
    // validate that extra tags outside of Poll_Response and between Poll_Response
    // and Content_Block are removed
    public void dumpContentBlocksTest3() throws Exception {
        String feedId = "feed_" + UUID.randomUUID();
        String path = "/var/tmp/" + feedId;

        StringBuilder in = new StringBuilder().append("<some extra data we don't care about>")
                .append("<taxii_11:Poll_Response collection_name='guest.Lehigh_edu'>").append("<this should be skipped")
                .append(cb).append(cb).append("</taxii_11:Poll_Response>")
                .append("<some extra data we don't care about>");
        String input = in.toString();

        InputStream is = new ByteArrayInputStream(input.getBytes());
        taxiiClient.dumpContentBlocks(is, path, 100);

        String output = readFile(path + "/block_0.xml");
        assertEquals(s.toString(), output);

        output = readFile(path + "/block_1.xml");
        assertEquals(s.toString(), output);

        deleteDirectory(new File(path));
    }

    @Test(expected = IllegalArgumentException.class)
    // Test that stream that contains no Poll_Response is considered invalid
    public void dumpContentBlocksTest4() throws Exception {
        String feedId = "feed_" + UUID.randomUUID();
        String path = "/var/tmp/" + feedId;

        StringBuilder in = new StringBuilder().append(cb).append("</taxii_11:Poll_Response>");
        String input = in.toString();

        InputStream is = new ByteArrayInputStream(input.getBytes());
        taxiiClient.dumpContentBlocks(is, path, 1000);

        deleteDirectory(new File(path));
    }

    @Test(expected = EOFException.class)
    // Test that stream that contains incomplete content block throws EOFException
    public void dumpContentBlocksTest5() throws Exception {
        String feedId = "feed_" + UUID.randomUUID();
        String path = "/var/tmp/" + feedId;

        StringBuilder in = new StringBuilder().append("<taxii_11:Poll_Response collection_name='guest.Lehigh_edu'>")
                .append(cb).append("<taxii_11:Content_Block>").append("<stix:Indicators>")
                .append("<stix:Indicator id='opensource:indicator-44ed11b0-ac22-4543-b8be-1bfa8d0dc987'>")
                .append("</stix:Indicator>");

        String input = in.toString();
        InputStream is = new ByteArrayInputStream(input.getBytes());
        taxiiClient.dumpContentBlocks(is, path, 1000);

        deleteDirectory(new File(path));
    }

    @Test
    // Send poll_interval with no data. expect no dir created
    public void dumpContentBlocksTest6() throws Exception {
        String feedId = "feed_" + UUID.randomUUID();
        String path = "/var/tmp/" + feedId;

        StringBuilder in = new StringBuilder().append("<taxii_11:Poll_Response collection_name='guest.Lehigh_edu'>")
                .append("</taxii_11:Poll_Response>");

        String input = in.toString();
        InputStream is = new ByteArrayInputStream(input.getBytes());
        taxiiClient.dumpContentBlocks(is, path, 1000);

        File dir = new File(path);
        assertFalse(dir.exists());
    }

    @Test(expected = EOFException.class)
    // Test for missing closing poll_response tag
    public void dumpContentBlocksTest7() throws Exception {
        String path = "/var/tmp/EOFException/";

        StringBuilder in =
                new StringBuilder().append("<taxii_11:Poll_Response collection_name='guest.Lehigh_edu'>").append(cb);

        String input = in.toString();
        InputStream is = new ByteArrayInputStream(input.getBytes());
        taxiiClient.dumpContentBlocks(is, path, 1000);
    }

    @Test
    // Test case where stream is larger than than 8kb buffer.
    public void dumpContentBlocksTest8() throws Exception {
        String feedId = "feed_" + UUID.randomUUID();
        String path = "/var/tmp/" + feedId;

        StringBuilder in = new StringBuilder().append("<taxii_11:Poll_Response collection_name='guest.Lehigh_edu'>");

        while (in.length() < 90000)
            in.append(cb);
        in.append("</taxii_11:Poll_Response>");

        String input = in.toString();
        InputStream is = new ByteArrayInputStream(input.getBytes());
        taxiiClient.dumpContentBlocks(is, path, 256 * 1024);

        String output = readFile(path + "/block_0.xml");
        assertEquals(input, output);

        deleteDirectory(new File(path));
    }
}
