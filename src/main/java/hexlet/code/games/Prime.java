package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    static final int MIN_RANGE_NUMBER = 3;
    static final int MAX_RANGE_NUMBER = 100;
    static final String RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static Boolean isPrime(int number) {
        for (var i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        } return true;
    }

    public static String[] getGameData() {
        int randomNum = Utils.getRandomNumber(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
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

    public static void startPrime() {
        String[][] gameData = getGameDataSet(Engine.ROUNDS_COUNT);

        Engine.runEngine(RULE, gameData);
    }
}
