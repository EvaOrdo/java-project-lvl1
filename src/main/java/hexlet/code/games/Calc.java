package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    static final int MIN_RANGE_NUM = 1;
    static final int MAX_RANGE_NUM = 100;
    static final String[] OPERATORS = {"+", "-", "*"};
    static final String RULE = "What is the result of the expression?";

    public static int calculate(int num1, int num2, String operator) {
        int result = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> throw new RuntimeException("Unknown operand: " + operator);
        };
        return result;
    }

    public static String[] getGameRoundData() {
        String[] gameData = new String[2];
        int operatorsLength = OPERATORS.length;
        int firstNumber = Utils.getRandomNumber(MIN_RANGE_NUM, MAX_RANGE_NUM);
        int secondNumber = Utils.getRandomNumber(MIN_RANGE_NUM, MAX_RANGE_NUM);
        int randomOperandsIndex = Utils.getRandomNumber(0, operatorsLength);
        String question = firstNumber + " " + OPERATORS[randomOperandsIndex] + " " + secondNumber;
        gameData[0] = question;
        int answer = calculate(firstNumber, secondNumber, OPERATORS[randomOperandsIndex]);
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
