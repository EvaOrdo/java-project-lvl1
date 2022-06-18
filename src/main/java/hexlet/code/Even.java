package hexlet.code;

import java.util.Scanner;

public class Even {
    public static void isEven() {
        String userName = Cli.greeting();

        System.out.println("Answer 'yes' if number is even otherwise answer 'no'.");

        int roundsCount = 3;
        int maxRandomNumber = 100;

        var counter = 0;
        while (counter < roundsCount) {
            int number = (int) (Math.random() * maxRandomNumber);

            System.out.println("Question: " + number);
            System.out.print("Your answer: ");

            Scanner getAnswer = new Scanner(System.in);
            String answer = getAnswer.nextLine();

            String correctAnswer = number % 2 == 0 ? "yes" : "no";

            if (answer.equals(correctAnswer)) {
                System.out.println("Correct!");
                counter++;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'");
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }

        if (counter == roundsCount) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
