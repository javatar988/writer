package com.digiat14.writer;

import java.io.*;

public class FileWriter extends Writer {



    java.io.FileWriter fileWriter;

    public FileWriter(String fileName) throws IOException {
        fileWriter = new java.io.FileWriter(fileName);

    }

    public void write(String str) {

            super.writer = str;


    }

    //read method to read from file and return the value as string
    public String read()  {
        StringBuilder content = new StringBuilder();
        String line;
        FileReader file = null;
        try {
            file = new FileReader(new File("myfile.dat"));
            BufferedReader br = new BufferedReader(file);
            while ((line = br.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return content.toString();
    }

    //close method to  close manipulation and fileWriter
    @Override
    public void close()  {
        try {
            fileWriter.write(super.writer);
            super.isClosed = true;
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
