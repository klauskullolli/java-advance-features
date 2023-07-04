package com.sda.java.advance.collections;

import java.util.*;


/**
 * Program features:
 * - Add quiz
 * - Add questions to the quiz
 * - Delete questions
 * - Add alternatives to question
 * - Add solution
 * - Add question description
 * - Save question
 * - Solve question
 * - See quiz result
 **/
public class QuizExercise {

    /**
     * This is an enum with values used for navigation throw question
     * Used in quiz solving part
     **/
    private static enum QuestionAction {
        ADD_CHANGE,
        BACK,
        NEXT,
        SUBMIT;
    }

    /**
     * This is a class that provide changing of primitive data types like: int, double etc. when are passed throw functions
     * So make them mutable throw program
     **/
    private static class Mutable<T> {
        private T value;

        public Mutable() {
        }

        public Mutable(T value) {
            this.value = value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }


    /**
     * Creating an executable class that implement quiz methodology using maps
     * Each quiz has a list of question
     * Questions are maps that have  descriptions  and a list of alternatives and true answer
     **/
    private static final String DESCRIPTION = "description";
    private static final String ANSWER = "answer";

    /**
     * Function used for getting number inputs and return it
     **/
    private static int getNum(Scanner input) {
        int num;
        while (true) {
            try {
                System.out.print("Press a number: ");
                num = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Wrong input!");
                input.nextLine();
            }


        }
        return num;
    }

    /**
     * This is main function and from here are called other function that make program functional
     * According to number inputted are preformed action that are described throw program
     **/
    private static void quiz() {
        List<Map<String, String>> quiz = new ArrayList<>();

        Map<Integer, String> solution = new LinkedHashMap<>();

        Scanner input = new Scanner(System.in);

        int num;

        String str;

        boolean solvedQuiz = false;

        while (true) {
            System.out.println("1) Add  quiz.");
            System.out.println("2) Solve quiz.");
            System.out.println("3) See result");
            System.out.println("4) Exit.");


            num = getNum(input);

            while (num < 1 || num > 4) {
                System.out.println("You entered wrong number!");
                num = getNum(input);
            }

            if (num == 1) {

                addQuiz(quiz, input);

            } else if (num == 2) {

                if (solvedQuiz) {
                    System.out.println("Quiz is already solved!\n");
                }

                if (quiz.size() == 0) {
                    System.out.println("There is no quiz created!\n");
                } else {
                    solveQuiz(quiz, solution, input);
                    solvedQuiz = true;
                }

            } else if (num == 3) {
                checkResults(quiz, solution, input);
            } else {
                break;
            }

        }


    }

    /**
     * This is the function that creates quiz according to requirements throw program
     **/
    private static void addQuiz(List<Map<String, String>> quiz, Scanner input) {
        int num;

        String str;

        Mutable<Integer> questionNr = new Mutable<>(1);

        while (true) {
            System.out.println("1) Add  question");
            System.out.println("2) Delete question");
            System.out.println("3) See quiz");
            System.out.println("4) Exit.");

            num = getNum(input);

            while (num < 1 || num > 4) {
                System.out.println("You entered wrong number!");
                num = getNum(input);
            }

            if (num == 1) {

                addQuestion(quiz, input, questionNr);

            } else if (num == 3) {
                for (int i = 1; i <= quiz.size(); i++) {
                    printQuestion(quiz.get(i - 1), i);
                }

            } else if (num == 2) {


                System.out.println("Which question you want to delete?");
                num = getNum(input);
                if (num > 0 && num <= quiz.size()) {
                    System.out.println("Deleted successfully:");
                    printQuestion(quiz.get(num - 1), num);
                } else {
                    System.out.println("This question does not exist!\n");
                }
            } else {
                break;
            }

        }

    }

    /**
     * This function makes possible addition of question to the quiz
     **/
    private static void addQuestion(List<Map<String, String>> quiz, Scanner input, Mutable<Integer> questionNr) {

        int num;
        String str;
        Map<String, String> question = new LinkedHashMap<>();
        int letter = 'A';
        int nrAlternatives = 0;
        boolean hasDesc = false;
        boolean hasAns = false;
        boolean add = false;
        while (true) {

            System.out.println("1) Add question description.");
            System.out.println("2) Change question description.");
            System.out.println("3) Add alternative.");
            System.out.println("4) Change alternative.");
            System.out.println("5) Add/Replace answer.");
            System.out.println("6) See question.");
            System.out.println("7) Save and Exit.");

            num = getNum(input);

            while (num < 1 || num > 7) {
                System.out.println("You entered wrong number!");
                num = getNum(input);
            }
            boolean terminate = false;
            switch (num) {
                case 1:
                    //                                System.out.println(question.get(DESCRIPTION));
                    if (question.get(DESCRIPTION) != null || (question.get(DESCRIPTION) != null && !question.get(DESCRIPTION).isEmpty())) {
                        System.out.println("This question has already a description!\n");
                        break;
                    }
                    System.out.print("Description: ");
                    input.nextLine();
                    str = input.nextLine();
                    question.put(DESCRIPTION, str);
                    hasDesc = true;
                    break;
                case 2:
                    input.nextLine();
                    System.out.print("Description: ");
                    str = input.nextLine();
                    question.replace(DESCRIPTION, str);
                    break;
                case 3:
                    input.nextLine();
                    if (!hasDesc) {
                        System.out.println("Enter description first!\n");
                        break;
                    }
                    System.out.print("Alternative: ");
                    str = input.nextLine();
                    question.put((char) letter + "", str);
                    letter++;
                    nrAlternatives++;
                    break;
                case 4:
                    input.nextLine();
                    System.out.print("Which alternative you want to change: ");
                    str = input.next();
                    if (question.get(str) == null || question.get(str).isEmpty()) {
                        System.out.println("This alternative does not exist!\n");
                        break;
                    }
                    input.nextLine();
                    System.out.print("Alternative: ");
                    str = input.nextLine();
                    question.replace((char) letter + "", str);
                    break;
                case 5:
                    Set<String> alter = new HashSet<>(question.keySet());
                    alter.remove(DESCRIPTION);
                    if (alter.isEmpty()) {
                        System.out.println("There is no alternative added already\n");
                    }
                    input.nextLine();

                    while (true) {
                        System.out.print("Answer: ");
                        str = input.nextLine();

                        if (alter.contains(str.toUpperCase())) {
                            question.put(ANSWER, str.toUpperCase());
                            hasAns = true;
                            break;
                        } else {
                            System.out.println("Please a valid alternative");
                        }
                    }

                    break;
                case 6:
                    printQuestion(question, questionNr.value);
                    break;
                default:
                    System.out.print("Do you want to save question(yes/no): ");
                    str = input.next().toLowerCase();
                    if (str.equals("yes")) {
                        if (!hasDesc) {
                            System.out.println("You can not save question without description\n");
                            break;
                        }
                        if (!hasAns) {
                            System.out.println("You can not save question without answer\n");
                            break;
                        }
                        if (nrAlternatives < 2) {
                            System.out.println("Question should have at least 2 alternatives\n");
                            break;
                        }
                        add = true;
                    }

                    terminate = true;
                    break;
            }

            if (terminate) break;

        }
        if (add) {
            quiz.add(question);
        }
    }


    /**
     * This function prints currently created question but is used only in quiz creation part
     **/
    static void printQuestion(Map<String, String> question, int questionNr) {
        System.out.printf("Question %d:\n", questionNr);
        for (String k : question.keySet()) {
            if (k.equals(DESCRIPTION)) {
                System.out.printf("Description: %s\n", question.get(k));
            } else if (k.equals(ANSWER)) {
                System.out.printf("Answer: %s\n", question.get(k));
            } else {
                System.out.printf("%s) %s\n", k, question.get(k));
            }
        }
        System.out.println("\n");
    }

    /**
     * This function prints currently solving question and used only in quiz solving part
     **/
    static void printQuestionForSolving(Map<String, String> question, Map<Integer, String> solution, int questionNr) {
        System.out.printf("Question %d:\n", questionNr);
        for (String k : question.keySet()) {
            if (k.equals(DESCRIPTION)) {
                System.out.printf("Description: %s\n", question.get(k));
            } else if (k.equals(ANSWER)) {
                System.out.print("");
            } else {
                System.out.printf("%s) %s\n", k, question.get(k));
            }
        }
        System.out.println("\n-------------------------------------------------");
        String str = solution.get(questionNr - 1) != null ? solution.get(questionNr - 1) : "no answer yet";
        System.out.println("Answer: " + str);
        System.out.println("-------------------------------------------------\n");
    }


    /**
     * This is the function that takes into action quiz solving steps
     **/
    private static void solveQuiz(List<Map<String, String>> quiz, Map<Integer, String> solution, Scanner input) {
        int len = quiz.size();
        boolean submit = false;
        if (len == 0) {
            System.out.println("There is not any quiz!\n");
            return;
        }


        Mutable<Integer> questionNr = new Mutable<>(0);

        while (true) {
            submit = solveQuestion(quiz.get(questionNr.value), solution, input, questionNr, len);
            if (submit) {
                break;
            }
        }

    }

    /**
     * This is the function shows current question that should be solved
     * Users add answer and can navigate throw quiz questions
     **/
    private static boolean solveQuestion(Map<String, String> question, Map<Integer, String> solution, Scanner input, Mutable<Integer> questionNr, int lenQuiz) {

        int num;
        String str;
        QuestionAction action;

        boolean submit = false;

        while (true) {
            printQuestionForSolving(question, solution, questionNr.value + 1);

            if (questionNr.value == 0 && questionNr.value == (lenQuiz - 1)) {
                System.out.println("1) Add/change answer");
                System.out.println("2) Submit");
                num = getNum(input);

                while (num < 1 || num > 3) {
                    System.out.println("You entered wrong number!");
                    num = getNum(input);
                }

                if (num == 1) action = QuestionAction.ADD_CHANGE;
                else action = QuestionAction.SUBMIT;
            } else if (questionNr.value == 0) {
                System.out.println("1) Add/change answer");
                System.out.println("2) Next");
                num = getNum(input);

                while (num < 1 || num > 3) {
                    System.out.println("You entered wrong number!");
                    num = getNum(input);
                }
                if (num == 1) action = QuestionAction.ADD_CHANGE;
                else action = QuestionAction.NEXT;

            } else if (questionNr.value == (question.size() - 1)) {
                System.out.println("1) Add/change answer");
                System.out.println("2) Back");
                System.out.println("3) Submit");
                num = getNum(input);

                while (num < 1 || num > 4) {
                    System.out.println("You entered wrong number!");
                    num = getNum(input);
                }
                if (num == 1) action = QuestionAction.ADD_CHANGE;
                else if (num == 2) action = QuestionAction.BACK;
                else action = QuestionAction.SUBMIT;

            } else {
                System.out.println("1) Add/change answer");
                System.out.println("2) Back");
                System.out.println("3) Next");
                num = getNum(input);

                while (num < 1 || num > 4) {
                    System.out.println("You entered wrong number!");
                    num = getNum(input);
                }
                if (num == 1) action = QuestionAction.ADD_CHANGE;
                else if (num == 2) action = QuestionAction.BACK;
                else action = QuestionAction.NEXT;
            }

            if (action.equals(QuestionAction.ADD_CHANGE)) {
                Set<String> alter = new HashSet<>(question.keySet());
                alter.remove(DESCRIPTION);

                input.nextLine();

                while (true) {
                    System.out.print("Answer: ");
                    str = input.nextLine();

                    if (alter.contains(str.toUpperCase())) {
                        solution.put(questionNr.value, str);
                        break;
                    } else {
                        System.out.println("Please a valid alternative");
                    }
                }

            } else if (action.equals(QuestionAction.NEXT)) {
                break;
            } else if (action.equals(QuestionAction.SUBMIT)) {
                submit = true;
                break;
            } else {
                break;
            }
        }

        if (action.equals(QuestionAction.NEXT)) questionNr.setValue(questionNr.value + 1);
        if (action.equals(QuestionAction.BACK)) questionNr.setValue(questionNr.value - 1);

        return submit;
    }

    /**
     * After solving quiz this is the function that shows quiz results
     **/

    private static void checkResults(List<Map<String, String>> quiz, Map<Integer, String> solution, Scanner input) {
        if (quiz.size() == 0) {
            System.out.println("There is no quiz created yet\n");
            return;
        }

        if (solution.isEmpty()) {
            System.out.println("Quiz is not solved yet!\n");
            return;
        }
        int i = 0;
        int rightSolution = 0;

        for (Map<String, String> question : quiz) {
            printQuestion(question, i + 1);
            System.out.println("Your answer: " + solution.get(i));
            if (question.get(ANSWER).equals(solution.get(i))) {
                rightSolution++;
            }
            i++;
        }

        System.out.printf("\nYou have solved %d out of %d right.\n\n", rightSolution, quiz.size());

    }


    public static void main(String[] args) {

        quiz();

    }
}
