package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    static final int MIN_RANGE_NUM = 1;
    static final int MAX_RANGE_NUM = 100;
    static final String RULE = "Find the greatest common divisor of given numbers";

    public static int getGCD(int num1, int num2) {
        var a = num1;
        var b = num2;
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public static String[] getGameRoundData() {
        String[] gameData = new String[2];
        int firstNumber = Utils.getRandomNumber(MIN_RANGE_NUM, MAX_RANGE_NUM);
        int secondNumber = Utils.getRandomNumber(MIN_RANGE_NUM, MAX_RANGE_NUM);
        String question = firstNumber + " " + secondNumber;
        gameData[0] = question;
        int answer = getGCD(firstNumber, secondNumber);
        String correctAnswer = "" + answer;
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
