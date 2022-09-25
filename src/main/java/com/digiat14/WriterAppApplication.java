package com.digiat14;

import com.digiat14.writer.StringWriter;
import com.digiat14.writer.Writer;

import java.util.Scanner;


public class WriterAppApplication {

    public static void main(String[] args) throws InterruptedException {

        try {
            System.out.println("Please Enter Text to Write: ");
            Scanner scanner = new Scanner(System.in);
            String text = scanner.nextLine();
            Writer writer = new StringWriter();
            writer.write(text);
            writer.removeStupid();
            writer.close();
            writer.toUpper();
            System.out.println(writer.read());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
