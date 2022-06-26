package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.Progression;
import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n2 - Even\n3 - Calc\n4 - GCD\n5 - Progression\n6 - Prime\n0 - Exit");
        System.out.print("Your choice: ");
        Scanner getGameNumber = new Scanner(System.in);
        String gameNumber = getGameNumber.nextLine();
        switch (gameNumber) {
            case "1" -> Cli.greeting();
            case "2" -> Even.startEven();
            case "3" -> Calc.startCalc();
            case "4" -> GCD.startGCD();
            case "5" -> Progression.startProgression();
            case "6" -> Prime.startPrime();
            case "0" -> System.out.println("Bye!");
            default -> System.out.println("There is no such game!");
        }
    }
}
