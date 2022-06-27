package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    static final int MIN_RANGE_NUM = 1;
    static final int MAX_RANGE_NUM = 100;
    static final String RULE = "Answer 'yes' if number is even otherwise answer 'no'.";

    public static Boolean isEven(int number) {
        return number % 2 == 0;
    }
    public static String[] getGameRoundData() {
        String[] gameData;
        gameData = new String[2];
        int randomNumber = Utils.getRandomNumber(MIN_RANGE_NUM, MAX_RANGE_NUM);

        String question = "" + randomNumber;
        gameData[0] = question;
        String correctAnswer = isEven(randomNumber) ? "yes" : "no";
        gameData[1] = correctAnswer;
        return gameData;
    }

    public static void start() {
        String[][] gameDataSet = new String[Engine.ROUNDS_COUNT][];
        for (var i = 0; i < Engine.ROUNDS_COUNT; i++) {
            gameDataSet[i] = getGameRoundData();
        }
        Engine.runEngine(RULE, gameDataSet);
    }
}
