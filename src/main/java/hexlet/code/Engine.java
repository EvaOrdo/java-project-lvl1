package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int ROUNDS_COUNT = 3;

    public static void runEngine(String rule, String[][] gameData) {
        Scanner getUserName = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String userName = getUserName.nextLine();
        System.out.println("Hello, " + userName + "!");

        System.out.println(rule);

        for (var i = 0; i < ROUNDS_COUNT; i++) {
            System.out.println("Question: " + gameData[i][0]);
            System.out.print("Your answer: ");

            Scanner getUserAnswer = new Scanner(System.in);
            String userAnswer = getUserAnswer.nextLine();

            if (userAnswer.equals(gameData[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + gameData[i][1] + "'");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}
