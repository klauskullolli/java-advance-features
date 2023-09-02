package com.sda.java.advance.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileExample {
    private static void workWithFile() {
        String filePath = "resources/file.txt";

        String filePath1 = "resources/file1.txt";

        Scanner input = new Scanner(System.in);

//        File is a class that take care of file, folders and shows if those exist or not
//        It may also create if a file does not exist
//        Shows metadata of specified file
        File file = new File(filePath);
        if (file.exists()) {
            System.out.printf("File %s exist.\n", file.getAbsolutePath());
        } else {
            System.out.printf("File %s not exist.\n", file.getAbsolutePath());
        }

        file = new File(filePath1);
        if (file.exists()) {
            System.out.printf("File %s exist.\n", file.getAbsolutePath());
        } else {
            System.out.printf("File %s not exist.\n", file.getAbsolutePath());
            System.out.print("Do you want to create this file(yes/no): ");
            String ans = input.next().toLowerCase();
            if (ans.equals("yes")) {
                try {
                    if (file.createNewFile()) {
                        System.out.println("File created successfully");
                    } else {
                        System.out.println("File not created successfully");
                    }
                } catch (IOException e) {
                    System.out.println("File not created successfully");
                }
            }
        }

    }

    private static void createFile(File file) {
        if (!file.exists()) {
            System.out.println("File does not exist");
            try {
                if (file.getPath().contains(".")) {
                    file.createNewFile();
                } else {
                    file.mkdir();
                }
                System.out.println("File/Dir created successfully");
            } catch (IOException e) {
                System.out.println("File/Dir not created successfully");
            }
        } else {
            System.out.printf("File/Dir: %s already exists.\n", file.getAbsolutePath());
        }
    }

    public static void workWithFileClass2() {
        String filePath = "resources/subResc";

        List<String> paths = new ArrayList<>(List.of("test.txt", "test2.txt", "res"));


        File file = new File(filePath);
        System.out.println("Abs path: " + file.getAbsolutePath());
        System.out.println("File is directory: " + file.isDirectory());

        createFile(file);

        for (int i = 0; i < paths.size(); i++) {
            paths.set(i, filePath + "/" + paths.get(i));
        }

        for (String path : paths) {
            File f = new File(path);
            createFile(f);
        }
    }


    private static void workWithFileReader() {
        String filePath = "resources/file.txt";
        File file2 = new File(filePath);
        try {
            FileReader reader = new FileReader(file2);
            int i;
            String str = "";
            while ((i = reader.read()) != -1) {
//                System.out.print((char) i);
                str += (char) i;
            }

            System.out.println(str);

            reader.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String readWithFileReader(String path) {
        String str = "";
        FileReader reader = null;
        try {
            reader = new FileReader(path);

            int i;
            while ((i = reader.read()) != -1) {
                str += (char) i;
            }

            return str;

        } catch (IOException e) {
            System.out.println("Error: " + e);
            return str;
        }
    }

    private static void workWithFileReaderAndWriter() {
        String path1 = "resources/file.txt";
        String path2 = "resources/fileCopy.txt";
        createFile(new File(path2));
        String content1 = readWithFileReader(path1);
        try {
            FileWriter out = new FileWriter(path2);
            out.write(content1);
//            out.write(content1.toCharArray());
//            while(char c :  content1.toCharArray()){
//                out.write(c);
//            }
            out.flush();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    private static void workWithFileWriter() {
        String filePath = "resources/file1.txt";
        try {
            FileWriter writer = new FileWriter(filePath);
            String str = "Hello Klaus\n";
//            If file has data write rewrite the data into file
            writer.write(str);

            str = "Hello Word";
            for (char c : str.toCharArray()) {
                writer.append(c);
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void workWithBufferReaderAndWriter() {
        String filePath = "resources/file1.txt";
        String path2 = "resources/fileCopy.txt";
        createFile(new File(path2));
        try {
            String str = "";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                str += line + "\n";
                line = reader.readLine();
            }
            str = str.substring(0, str.length() - 1);
            System.out.print(str);
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(path2));

            writer.write(str);
            writer.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void workWithFileInputOutputStream() {
        String filePath = "resources/file.txt";
        String filePath1 = "resources/file1.txt";
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            int i;
            String str = "";
//            Reading entirely using  bytes and convert to string
            str = new String(inputStream.readAllBytes());
            System.out.println(str);

//            Reading  char by char
//            while ((i = inputStream.read()) != -1) {
//                str += (char) i;
//            }
//
//            System.out.print(str);

            FileOutputStream fileOutputStream = new FileOutputStream(filePath1);

//            for (char c : str.toCharArray()) {
//                fileOutputStream.write((int) c);
//            }
            fileOutputStream.write(str.getBytes());

            fileOutputStream.flush();
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void workWithBufferInAndOut() {
        String filePath = "resources/file.txt";
        String filePath1 = "resources/file1.txt";

        try {
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(filePath));
//            if you want to reset the stream to the position where mark is set
            input.mark(1);

            String str = new String(input.readAllBytes());
            System.out.println(str);

            input.reset();
            str = new String(input.readAllBytes());
            System.out.println(str);

            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(filePath1));
            out.write(str.getBytes(StandardCharsets.UTF_8));
            out.flush();
            out.close();

            input.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
//        String filePath = "resources/file.txt";
//        String filePath1 = "resources/file1.txt";
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(filePath));
//            reader.readLine();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        workWithFileClass2();

//        workWithFileReader();
//        workWithFileReaderAndWriter();
//        workWithBufferReaderAndWriter();
        workWithFileInputOutputStream();
    }


}


//        File file = new File("resources/file.txt");
//        System.out.println(file.exists());
//
//        try {
//            FileReader input =  new FileReader(file);
//            int i;
//            while((i=input.read())!=-1 ){
//
//                System.out.print((char)i);
//
//            }
//
//            input.close();
//
//           input = new FileReader(file);
//           CharBuffer charBuffer = CharBuffer.allocate(1024);
//
//            while((i=input.read(charBuffer))!=-1 ){
//                charBuffer.flip();
//
//                while (charBuffer.hasRemaining()) {
//                    char c = charBuffer.get();
//                    System.out.print(c);
//                }
//
//                charBuffer.clear();
//
//            }
//
//
//
//        } catch (FileNotFoundException e) {
//            System.out.println(file.getAbsolutePath() + " does not exist");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//}

