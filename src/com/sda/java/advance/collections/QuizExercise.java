package com.sda.java.advance.collections;

import java.util.*;

public class QuizExercise {



//    creating an executable class that implement quiz methodology using maps
//     Each quiz has a list of question
//    Questions are maps that have  descriptions  and a list of alternatives and true answer

    private static  final String DESCRIPTION = "description";
    private static final String ANSWER = "answer";
    private static int getNum(Scanner input){
        int num;
        while (true) {
            try {
                System.out.print("Press a number: ");
                num = input.nextInt();
                break;
            }catch (Exception e){
                System.out.println("Wrong input!");
            }


        }
        return num;
    }


    public static void main(String[] args) {

        List<Map<String,String>> quiz =  new ArrayList<>();

        List<Map<String,String>> solution =  new ArrayList<>();

        Map<String,String> question = new LinkedHashMap<>();

        Scanner input =  new Scanner(System.in);

        int num;

        String str;

        while(true){
            System.out.println("1) Add  quiz.");
            System.out.println("2) Solve quiz.");
            System.out.println("3) Exit.");


            num =  getNum(input);

            while (num<1 || num >3){
                System.out.println("You entered wrong number!");
                num = getNum(input);
            }

            if (num ==1){
                while (true){
                    System.out.println("1) Add  question");
                    System.out.println("2) See quiz");
                    System.out.println("3) Exit.");

                    num = getNum(input);

                    while (num<1 || num >3){
                        System.out.println("You entered wrong number!");
                        num = getNum(input);
                    }

                    if(num==1){

                        while (true){
                            int letter = 'A';
                            System.out.println("1) Add question description.");
                            System.out.println("2) Change question description.");
                            System.out.println("3) Add alternative.");
                            System.out.println("4) Change alternative.");
                            System.out.println("5) Add/Replace answer.");
                            System.out.println("6) See question.");
                            System.out.println("7) Exit.");

                            num = getNum(input);

                            while (num<1 || num >7){
                                System.out.println("You entered wrong number!");
                                num = getNum(input);
                            }
                            boolean terminate = false;
                            switch (num){
                                case 1:
//                                System.out.println(question.get(DESCRIPTION));
                                    if(question.get(DESCRIPTION)!=null || (question.get(DESCRIPTION)!=null &&!question.get(DESCRIPTION).isEmpty())){
                                        System.out.println("This question has already a description!\n");
                                        break;
                                    }
                                    System.out.print("Description: ");
                                    input.nextLine();
                                    str = input.nextLine();
                                    question.put(DESCRIPTION, str);
                                    break;
                                case 2:
                                    System.out.print("Description: ");
                                    str = input.nextLine();
                                    question.replace(DESCRIPTION, str);
                                    break;
                                case 3:
                                    System.out.print("Alternative: ");
                                    str = input.nextLine();
                                    question.put((char)letter+"", str);
                                    letter++;
                                    break;
                                case 4:
                                    System.out.print("Which alternative you want to change: ");
                                    str = input.nextLine();
                                    if(question.get(str)==null || !question.get(str).isEmpty()){
                                        System.out.println("This alternative does not exist!\n");
                                        break;
                                    }
                                    System.out.print("Alternative: ");
                                    str = input.nextLine();
                                    question.replace((char)letter+"", str);
                                    break;
                                case 5:
                                    System.out.print("Answer: ");
                                    str = input.nextLine();
                                    question.put(ANSWER, str);
                                    break;
                                case 6:
                                    System.out.println(question);
                                    break;
                                default:
                                    terminate = true;
                                    break;

                            }
                            quiz.add(question);
                            if (terminate) break;

                        }

                    } else if (num==2) {
                        for (int i=1; i<= quiz.size(); i++){
                            System.out.printf("Question %d: %s\n", i, question.get(i-1));
                        }

                    }else {
                        break;
                    }

                }


            }else if (num ==2){
                if(quiz.size()==0){
                    System.out.println("There is no quiz created!\n");
                }
                else{
                    while (true){

                    }
                }

            }else{
                break;
            }

        }



    }
}
