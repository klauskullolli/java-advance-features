package com.sda.java.advance.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationExample {
    public static void main(String[] args) {
        String filePath =  "resources/serialization.ser";
        try {
            ObjectOutputStream out =  new ObjectOutputStream(new FileOutputStream(filePath));

            Quiz quiz = new Quiz(1);
            Question question =  new Question(1, "Where Klaus live?");

            List<Alternative>alternatives = new ArrayList<>(List.of(
                    new Alternative(1, "Tiran"),
                    new Alternative(2, "Gramsh")
            ));


            question.setAlternatives(alternatives);
            question.setSolution(1);

            quiz.setQuestions(new ArrayList<>(List.of(question)));

            out.writeObject(quiz);

            out.close();

            ObjectInputStream in =  new ObjectInputStream(new FileInputStream(filePath));
            Quiz quiz1 =  (Quiz) in.readObject();
            System.out.println(quiz1);


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
