package com.digiat14.writer;

import java.io.IOException;

public class StringWriter extends Writer {




    public void write(String str) {

            super.writer = str;

    }

    //read method to read string and return the value
    @Override
    public String read() {
        return super.writer;
    }

    //close method to  close manipulation on data
    @Override
    public void close() {
        super.isClosed = true;
    }

}
