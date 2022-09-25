package com.digiat14.writer;

import java.io.IOException;

/*Abstract Writer class for writing String

The only methods that a subclass must implement are read, close
 */
public abstract class Writer {

    protected boolean isClosed;
    String writer;

    public void write(String str) {
        this.writer = str;
    }

    // utility method that convert text to Upper case
    public void toLower()  {
        if (!isClosed) {
            this.writer = this.writer.toLowerCase();

        }

    }

    // utility method that convert text to Upper case
    public void toUpper() {
        if (!isClosed) {
            this.writer = this.writer.toUpperCase();
        }
    }

    // utility method that replace stupid with s*****
    public void removeStupid() {

        this.writer = this.writer.replace("stupid", "s*****");


    }

    // utility method that remove duplicate words
    public void removeDuplicate() {

        this.writer = writer.replaceAll("(?i)\\b([a-z]+)\\b(?:\\s+\\1\\b)+", "$1");


    }

    //abstract method that must be implemented by subclass for reading String
    abstract public String read() ;


    //abstract method that must be implemented by subclass for closing manipulation on data
    abstract public void close() ;


}
