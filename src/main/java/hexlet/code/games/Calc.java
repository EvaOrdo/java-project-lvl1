package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    static final int MIN_RANGE_NUM = 1;
    static final int MAX_RANGE_NUM = 100;
    static final String[] OPERANDS = {"+", "-", "*"};
    static final String RULE = "What is the result of the expression?";

    public static int calculate(int num1, int num2, String operand) {
        int result = switch (operand) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> throw new RuntimeException("Unknown operand: " + operand);
        };
        return result;
    }

    public static String[] getGameRoundData() {
        String[] gameData = new String[2];
        int operandsLength = OPERANDS.length;
        int firstNumber = Utils.getRandomNumber(MIN_RANGE_NUM, MAX_RANGE_NUM);
        int secondNumber = Utils.getRandomNumber(MIN_RANGE_NUM, MAX_RANGE_NUM);
        int randomOperandsIndex = Utils.getRandomNumber(0, operandsLength);
        String question = firstNumber + " " + OPERANDS[randomOperandsIndex] + " " + secondNumber;
        gameData[0] = question;
        int answer = calculate(firstNumber, secondNumber, OPERANDS[randomOperandsIndex]);
        String correctAnswer = "" + answer;
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
    public static void startCalc() {
        String[][] gameData = getGameDataSet(Engine.ROUNDS_COUNT);

        Engine.runEngine(RULE, gameData);
    }
}
