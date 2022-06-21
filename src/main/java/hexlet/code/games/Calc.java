package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    public static String[] getGameData() {
        String[] gameData = new String[2];
        int[] numbersRange = {1, 100};
        int min = numbersRange[0];
        int max = numbersRange[1];
        String[] operands = {"+", "-", "*"};
        int operandsLength = operands.length;
        int randomFirst = (int) (Math.random() * max + min);
        int randomSecond = (int) (Math.random() * max + min);
        int randomOperandsIndex = (int) (Math.random() * operandsLength);
        String question = randomFirst + operands[randomOperandsIndex] + randomSecond;
        gameData[0] = question;
        int answer = switch (operands[randomOperandsIndex]) {
            case "+" -> randomFirst + randomSecond;
            case "-" -> randomFirst - randomSecond;
            case "*" -> randomFirst * randomSecond;
            default -> 0;
        };
        String correctAnswer = "" + answer;
        gameData[1] = correctAnswer;
        return gameData;
    }
    public static void calc() {
        String rule = "What is the result of the expression?";

        Engine.runEngine(rule, getGameData());
    }
}
