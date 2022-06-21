package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static void runEngine(String rule, String[] gameData) {
        String userName = Cli.greeting();

        System.out.println(rule);

        final int ROUNDS_COUNT = 3;

        var counter = 0;
        while (counter < ROUNDS_COUNT) {
            System.out.println("Question: " + gameData[0]);
            System.out.print("Your answer: ");

            Scanner getUserAnswer = new Scanner(System.in);
            String userAnswer = getUserAnswer.nextLine();

            if (userAnswer.equals(gameData[1])) {
                System.out.println("Correct!");
                counter++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + gameData[1] + "'");
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }

        if (counter == ROUNDS_COUNT) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
