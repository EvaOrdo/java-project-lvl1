package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static String[] getGameData() {
        String[] gameData;
        gameData = new String[2];
        final int MIN_RANGE_NUM = 1;
        final int MAX_RANGE_NUM = 100;
        int randomNumber = Utils.getRandomNumber(MIN_RANGE_NUM, MAX_RANGE_NUM);
        String question = "" + randomNumber;
        gameData[0] = question;
        String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";
        gameData[1] = correctAnswer;
        return gameData;
    }

    public static final int ROUNDS_COUNT = 3;

    public static String[][] getGameDataSet(int roundsCount) {
        String[][] gameDataSet;
        gameDataSet = new String[roundsCount][];
        for (var i = 0; i < roundsCount; i++) {
            gameDataSet[i] = getGameData();
        }
        return gameDataSet;
    }
    public static void isEven() {
        String rule = "Answer 'yes' if number is even otherwise answer 'no'.";
        String[][] gameData = getGameDataSet(ROUNDS_COUNT);

        Engine.runEngine(rule, gameData);
    }
}
