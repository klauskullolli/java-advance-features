package com.sda.java.advance.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NioMain {


    private  static void workWithPathAndFiles() throws IOException {
        String filePath = "resources/file1.txt";

//        This path class is part of nio package
//        Very useful for path manipulations of file and folder
        Path path  = Paths.get(filePath);
        System.out.println("File name: "+ path.getFileName());
        System.out.println("Absolut path: "+ path.toAbsolutePath());
        if(!path.toFile().exists()){
            Files.createFile(path);
        }



//        This Files is also part of nio package
//        Very useful for reading and writing file operation
//        It supports static methods that modify, delete, add file and read and write files
        Files.write(path, "Hello where are you?\n".getBytes(StandardCharsets.UTF_8), StandardOpenOption.TRUNCATE_EXISTING);
        Files.write(path, "Hello, Hello...".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        Files.write(path, "Hello, Hello Hello Hello...".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        for(String line: Files.readAllLines(path)){
            System.out.println(line);
        }

//        Files.delete(path);
    }


    public static void main(String[] args) throws IOException {

        String filePath = "resources/file2.txt";

        Path path = Paths.get(filePath);
        if (!path.toFile().exists()) {
            Files.createFile(path);
        }

//        Use buffer to read from a channel
        ByteBuffer buffer = ByteBuffer.allocate(1024);

//     File channel is used for reading, writing, manipulation files
//      Object initialization is made like below using path and  StandardOpenOption
        FileChannel channel = FileChannel.open(path, StandardOpenOption.READ);

        int bites = channel.read(buffer);
        String fileStr = "";
        while (bites != -1) {
//            Flip function to prepare buffer for reading
            buffer.flip();
            while (buffer.hasRemaining()) {
                fileStr += (char) buffer.get();
            }
//           Cleaning buffer to fill again
            buffer.clear();
            bites = channel.read(buffer);
        }

        System.out.println(fileStr);

        channel = FileChannel.open(path, StandardOpenOption.APPEND);
        byte bytes[] = fileStr.getBytes();

        buffer = ByteBuffer.allocate(bytes.length);
        buffer.put(bytes);
        buffer.flip();
        channel.write(buffer);


//        workWithPathAndFiles();

    }
}
