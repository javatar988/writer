package com.digiat14.writer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FileWriterTests {

    private  Writer writer;
    private String fileName;
    @BeforeEach
    void setup() throws IOException {
        fileName="myfile.dat";
        writer = new FileWriter(fileName);
    }

    //test cases to assert  equal  after remove duplicate and remove stupid , toUpper will be ignored
    @Test
    void tesStringWriterRemoveStupidAndDuplicate() {

        writer.write("This is really really stupid!!!");
        writer.removeStupid();
        writer.removeDuplicate();
        writer.close();
        writer.toUpper();
        assertEquals("This is really s*****!!!"+System.lineSeparator(), writer.read());
    }
    //test cases to assert  equal  after remove duplicate and to upper, toLower will be ignored
    @Test
    void tesStringWriterRemoveDuplicateAndToUpper() {
        writer.write("This is really really stupid!!!");
        writer.removeDuplicate();
        writer.toUpper();
        writer.close();
        writer.toLower();
        assertEquals("THIS IS REALLY STUPID!!!" +System.lineSeparator(), writer.read());
    }
    //test cases to assert not equal after close is true
    @Test
    void tesStringWriterRemoveDuplicateAndToUpperAfterClose() {
        writer.write("This is really really stupid!!!");
        writer.removeDuplicate();
        writer.close();
        writer.removeStupid();
        assertNotEquals("This is really s*****!!!", writer.read());
    }

}
