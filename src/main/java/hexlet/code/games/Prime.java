package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {

    public static Boolean isPrime(int number) {
        for (var i = 2; i <= Math.sqrt(number); i += 1) {
            if (number % i == 0) {
                return false;
            }
        } return true;
    }

    public static String[] getGameData() {
        final int minRangeNum = 3;
        final int maxRangeNum = 100;
        int randomNum = Utils.getRandomNumber(minRangeNum, maxRangeNum);
        String question = "" + randomNum;
        String answer = isPrime(randomNum) ? "yes" : "no";
        String[] gameData = {question, answer};
        return gameData;
    }

    public static String[][] getGameDataSet(int roundsCount) {
        String[][] gameDataSet = new String[roundsCount][];
        for (var i = 0; i < roundsCount; i++) {
            gameDataSet[i] = getGameData();
        }
        return gameDataSet;
    }

    public static final int ROUNDS_COUNT = 3;
    public static void prime() {
        String rule = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[][] gameData = getGameDataSet(ROUNDS_COUNT);

        Engine.runEngine(rule, gameData);
    }
}
