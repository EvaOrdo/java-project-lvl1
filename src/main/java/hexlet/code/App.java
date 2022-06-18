package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String menu = "1 - Greet\n2 - Even\n0 - Exit";
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(menu);
        System.out.print("Your choice: ");
        Scanner getGameNumber = new Scanner(System.in);
        String gameNumber = getGameNumber.nextLine();
        switch (gameNumber) {
            case "1" -> Cli.greeting();
            case "2" -> Even.isEven();
            case "0" -> System.out.println("Bye!");
            default -> System.out.println("There is no such game!");
        }
    }
}
