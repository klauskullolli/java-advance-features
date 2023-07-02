package com.sda.java.advance.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;

public class FileExample {
    public static void main(String[] args) {
        File file = new File("resources/file.txt");
        System.out.println(file.exists());

        try {
            FileReader input =  new FileReader(file);
            int i;
            while((i=input.read())!=-1 ){

                System.out.print((char)i);

            }

            input.close();

           input = new FileReader(file);
           CharBuffer charBuffer = CharBuffer.allocate(1024);

            while((i=input.read(charBuffer))!=-1 ){
                charBuffer.flip();

                while (charBuffer.hasRemaining()) {
                    char c = charBuffer.get();
                    System.out.print(c);
                }

                charBuffer.clear();

            }



        } catch (FileNotFoundException e) {
            System.out.println(file.getAbsolutePath() + " does not exist");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
