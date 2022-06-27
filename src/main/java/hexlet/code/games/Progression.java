package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    static final int MIN_PROGRESSION_FIRST_NUM = 1;
    static final int MAX_PROGRESSION_FIRST_NUM = 100;
    static final int MIN_PROGRESSION_STEP = 1;
    static final int MAX_PROGRESSION_STEP = 10;
    static final int PROGRESSION_LENGTH = 10;
    static final String RULE = "What number is missing in the progression?";

    public static String[] getGameData() {
        String[] gameData;
        gameData = new String[2];

        int progressionStartNumber = Utils.getRandomNumber(MIN_PROGRESSION_FIRST_NUM, MAX_PROGRESSION_FIRST_NUM);
        int progressionStep = Utils.getRandomNumber(MIN_PROGRESSION_STEP, MAX_PROGRESSION_STEP);

        int missingNumberIndex = Utils.getRandomNumber(1, PROGRESSION_LENGTH - 1);

        int[] progression = new int[PROGRESSION_LENGTH];

        progression[0] = progressionStartNumber;
        String question = "" + progressionStartNumber;
        String answer = "";

        for (var i = 1; i < PROGRESSION_LENGTH; i++) {
            progression[i] = progression[i - 1] + progressionStep;
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

    public static String[][] getGameDataSet(int roundsCount) {
        String[][] gameDataSet;
        gameDataSet = new String[roundsCount][];
        for (var i = 0; i < roundsCount; i++) {
            gameDataSet[i] = getGameData();
        }
        return gameDataSet;
    }

    public static void startProgression() {
        String[][] gameData = getGameDataSet(Engine.ROUNDS_COUNT);

        Engine.runEngine(RULE, gameData);
    }
}
