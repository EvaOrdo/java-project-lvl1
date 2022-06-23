package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    public static String[] getGameData() {
        String[] gameData = new String[2];
        final int minRangeNumber = 1;
        final int maxRangeNumber = 100;
        String[] operands = {"+", "-", "*"};
        int operandsLength = operands.length;
        int firstNumber = Utils.getRandomNumber(minRangeNumber, maxRangeNumber);
        int secondNumber = Utils.getRandomNumber(minRangeNumber, maxRangeNumber);
        int randomOperandsIndex = Utils.getRandomNumber(0, operandsLength);
        String question = firstNumber + " " + operands[randomOperandsIndex] + " " + secondNumber;
        gameData[0] = question;
        int answer = switch (operands[randomOperandsIndex]) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            default -> 0;
        };
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
    public static void calc() {
        String rule = "What is the result of the expression?";
        String[][] gameData = getGameDataSet(ROUNDS_COUNT);

        Engine.runEngine(rule, gameData);
    }
}
