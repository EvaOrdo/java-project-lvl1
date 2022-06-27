package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    static final int MIN_RANGE_NUM = 1;
    static final int MAX_RANGE_NUM = 100;
    static final String RULE = "Answer 'yes' if number is even otherwise answer 'no'.";


    public static String[] getGameRoundData() {
        String[] gameData;
        gameData = new String[2];
        int randomNumber = Utils.getRandomNumber(MIN_RANGE_NUM, MAX_RANGE_NUM);

        String question = "" + randomNumber;
        gameData[0] = question;
        String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";
        gameData[1] = correctAnswer;
        return gameData;
    }

    public static String[][] getGameDataSet(int roundsCount) {
        String[][] gameDataSet;
        gameDataSet = new String[roundsCount][];
        for (var i = 0; i < roundsCount; i++) {
            gameDataSet[i] = getGameRoundData();
        }
        return gameDataSet;
    }
    public static void startEven() {
        String[][] gameData = getGameDataSet(Engine.ROUNDS_COUNT);

        Engine.runEngine(RULE, gameData);
    }
}
