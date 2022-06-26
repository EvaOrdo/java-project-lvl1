package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static String[] getGameData() {
        String[] gameData;
        gameData = new String[2];
        final int minRangeNum = 1;
        final int maxRangeNum = 100;
        int randomNumber = Utils.getRandomNumber(minRangeNum, maxRangeNum);
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
            gameDataSet[i] = getGameData();
        }
        return gameDataSet;
    }
    public static void startEven() {
        String rule = "Answer 'yes' if number is even otherwise answer 'no'.";
        String[][] gameData = getGameDataSet(Engine.ROUNDS_COUNT);

        Engine.runEngine(rule, gameData);
    }
}
