package com.digiat14.writer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StringWriterTests {

    private  Writer writer;
    @BeforeEach
     void setup()
    {
        writer = new StringWriter();
    }

    //test cases to assert  equal  after remove duplicate and remove stupid , toUpper will be ignored after close() call
    @Test
    void tesStringWriterRemoveStupidAndDuplicate() {

        writer.write("This is really really stupid!!!");
        writer.removeStupid();
        writer.removeDuplicate();
        writer.close();
        writer.toUpper();
        assertEquals("This is really s*****!!!", writer.read());
    }

    //test cases to assert  equal  after remove duplicate and to upper, toLower will be ignored after close() calling

    @Test
    void tesStringWriterRemoveDuplicateAndToUpper() {
        writer.write("This is really really stupid!!!");
        writer.removeDuplicate();
        writer.toUpper();
        writer.close();
        writer.toLower();
        assertEquals("THIS IS REALLY STUPID!!!", writer.read());
    }

    //test cases to assert not equal after close is true
    @Test
    void tesStringWriterRemoveDuplicateAndToUpperAfterClose() {
        writer.write("This is really really stupid!!!");
        writer.removeDuplicate();
        writer.close();
        writer.toUpper();
        assertNotEquals("THIS IS REALLY STUPID!!!", writer.read());
    }
}
