package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    public static String[] getGameData() {
        String[] gameData = new String[2];
        int[] numbersRange = {1, 100};
        int min = numbersRange[0];
        int max = numbersRange[1];
        int randomNumber = (int) (Math.random() * max + min);
        String question = "" + randomNumber;
        gameData[0] = question;
        String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";
        gameData[1] = correctAnswer;
        return gameData;
    }
    public static void isEven() {
        String rule = "Answer 'yes' if number is even otherwise answer 'no'.";

        Engine.runEngine(rule, getGameData());
    }
}
