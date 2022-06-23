package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static void runEngine(String rule, String[][] gameData) {
        String userName = Cli.greeting();

        System.out.println(rule);

        final int roundsCount = 3;

        var i = 0;
        while (i < roundsCount) {
            System.out.println("Question: " + gameData[i][0]);
            System.out.print("Your answer: ");

            Scanner getUserAnswer = new Scanner(System.in);
            String userAnswer = getUserAnswer.nextLine();

            if (userAnswer.equals(gameData[i][1])) {
                System.out.println("Correct!");
                i++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + gameData[i][1] + "'");
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }

        if (i == roundsCount) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
