package org.mitre.taxii.messages.xml10;

import org.junit.Test;

/**
 * Generate a series of Message IDs.
 * 
 * @author jasenj1
 */

public class MessageIDTest {
    @Test
    public void idTest() {
        for (int x=0; 100 > x; x++) {
            System.out.println(MessageHelper.generateMessageId());
        }
    }    
}
