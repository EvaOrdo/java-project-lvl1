package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    static final int MIN_RANGE_NUM = 1;
    static final int MAX_RANGE_NUM = 100;
    static final String[] OPERANDS = {"+", "-", "*"};

    public static String[] getGameData() {
        String[] gameData = new String[2];
        int operandsLength = OPERANDS.length;
        int firstNumber = Utils.getRandomNumber(MIN_RANGE_NUM, MAX_RANGE_NUM);
        int secondNumber = Utils.getRandomNumber(MIN_RANGE_NUM, MAX_RANGE_NUM);
        int randomOperandsIndex = Utils.getRandomNumber(0, operandsLength);
        String question = firstNumber + " " + OPERANDS[randomOperandsIndex] + " " + secondNumber;
        gameData[0] = question;
        int answer = switch (OPERANDS[randomOperandsIndex]) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            default -> 0;
        };
        String correctAnswer = "" + answer;
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
    public static void startCalc() {
        String rule = "What is the result of the expression?";
        String[][] gameData = getGameDataSet(Engine.ROUNDS_COUNT);

        Engine.runEngine(rule, gameData);
    }
}
