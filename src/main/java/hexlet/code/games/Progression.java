package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    static final int MIN_PROGRESSION_FIRST_NUM = 1;
    static final int MAX_PROGRESSION_FIRST_NUM = 100;
    static final int MIN_PROGRESSION_STEP = 1;
    static final int MAX_PROGRESSION_STEP = 10;
    static final String RULE = "What number is missing in the progression?";

    public static int[] buildProgression(int initNum, int step, int progressionLength) {
        int[] progression = new int[progressionLength];
        for (var i = 0; i < progressionLength; i++) {
            progression[i] = initNum + step * (i - 1);
        }
        return progression;
    }
    public static String[] getGameRoundData() {
        String[] gameData;
        gameData = new String[2];
        int progressionInitNumber = Utils.getRandomNumber(MIN_PROGRESSION_FIRST_NUM, MAX_PROGRESSION_FIRST_NUM);
        int progressionStep = Utils.getRandomNumber(MIN_PROGRESSION_STEP, MAX_PROGRESSION_STEP);
        final int minLength = 10;
        final int maxLength = 20;
        int progressionLength = Utils.getRandomNumber(minLength, maxLength);
        int missingNumberIndex = Utils.getRandomNumber(1, progressionLength - 1);

        int[] progression = buildProgression(progressionInitNumber, progressionStep, progressionLength);
        int missingNum = progression[missingNumberIndex];
        StringBuilder question = new StringBuilder();
        String answer = "" + missingNum;
        for (var item: progression) {
            if (item == missingNum) {
                question.append(" ..");
            } else {
                question.append(" ").append(item);
            }
        }

        gameData[0] = question.toString().trim();
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
