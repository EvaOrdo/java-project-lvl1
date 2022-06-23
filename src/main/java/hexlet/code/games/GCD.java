package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
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

    public static String[] getGameData() {
        String[] gameData = new String[2];
        final int MIN_RANGE_NUMBER = 1;
        final int MAX_RANGE_NUMBER = 100;
        int firstNumber = Utils.getRandomNumber(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
        int secondNumber = Utils.getRandomNumber(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
        String question = firstNumber + " " + secondNumber;
        gameData[0] = question;
        int answer = getGCD(firstNumber, secondNumber);
        String correctAnswer = "" + answer;
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

    public static void gcd() {
        String rule = "Find the greatest common divisor of given numbers";
        String[][] gameData = getGameDataSet(ROUNDS_COUNT);

        Engine.runEngine(rule, gameData);
    }
}
