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

    public static int[] buildProgression(int startNum, int step) {
        int[] progression = new int[PROGRESSION_LENGTH];
        progression[0] = startNum;
        for (var i = 1; i < PROGRESSION_LENGTH; i++) {
            progression[i] = progression[i - 1] + step;
        }
        return progression;
    }
    public static String[] getGameRoundData() {
        String[] gameData;
        gameData = new String[2];
        int progressionStartNumber = Utils.getRandomNumber(MIN_PROGRESSION_FIRST_NUM, MAX_PROGRESSION_FIRST_NUM);
        int progressionStep = Utils.getRandomNumber(MIN_PROGRESSION_STEP, MAX_PROGRESSION_STEP);
        int missingNumberIndex = Utils.getRandomNumber(1, PROGRESSION_LENGTH - 1);

        int[] progression = buildProgression(progressionStartNumber, progressionStep);
        int missingNum = progression[missingNumberIndex];
        String question = "";
        String answer = "" + missingNum;
        for (var item: progression) {
            if (item == missingNum) {
                question += " ..";
            } else {
                question += " " + item;
            }
        }

        gameData[0] = question;
        gameData[1] = answer;
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
