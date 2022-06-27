package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    static final int MIN_RANGE_NUMBER = 3;
    static final int MAX_RANGE_NUMBER = 100;
    static final String RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static Boolean isPrime(int number) {
        if (number < 0 || number == 1 || number == 2) {
            return true;
        }
        for (var i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        } return true;
    }

    public static String[] getGameRoundData() {
        int randomNum = Utils.getRandomNumber(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
        String question = "" + randomNum;
        String answer = isPrime(randomNum) ? "yes" : "no";
        String[] gameData = {question, answer};
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
