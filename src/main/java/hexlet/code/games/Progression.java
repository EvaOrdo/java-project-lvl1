package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    public static String[] getGameData() {
        String[] gameData;
        gameData = new String[2];

        final int maxProgressionStartNum = 100;
        int progressionStartNumber = Utils.getRandomNumber(1, maxProgressionStartNum);

        final int minGapNum = 1;
        final int maxGapNum = 10;

        int progressionGapNum = Utils.getRandomNumber(minGapNum, maxGapNum);

        final int progressionLength = 10;

        int missingNumberIndex = Utils.getRandomNumber(1, progressionLength - 1);

        int[] progression = new int[progressionLength];

        progression[0] = progressionStartNumber;
        String question = "" + progressionStartNumber;
        String answer = "";

        for (var i = 1; i < progressionLength; i++) {
            progression[i] = progression[i - 1] + progressionGapNum;
            if (i == missingNumberIndex) {
                question += " ..";
                answer += progression[i];
            } else {
                question += " " + progression[i];
            }
        }

        gameData[0] = question;
        gameData[1] = answer;
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

    public static void progression() {
        String rule = "What number is missing in the progression?";
        String[][] gameData = getGameDataSet(ROUNDS_COUNT);

        Engine.runEngine(rule, gameData);
    }
}
