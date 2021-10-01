package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;
import utils.BaseballValidateUtils;

import java.util.Arrays;

public class Application {
    private static boolean isGameFinish = false;
    private static boolean isUserInputFinish = false;

    public static void main(String[] args) {
        int[] opponentNumbers = createOpponentNumber();
        while (!isGameFinish) {
            isUserInputFinish = false;
            userInputLoop();

        }

    }

    private static int[] createOpponentNumber() {
        boolean isCompletedOpponentNumbers = false;
        Opponent opponent = null;

        while (!isCompletedOpponentNumbers) {
            opponent = new Opponent(Randoms.pickNumberInRange(1, 9), Randoms.pickNumberInRange(1, 9), Randoms.pickNumberInRange(1, 9));
            isCompletedOpponentNumbers = opponent.isNotDuplicateNumber();
        }

        return opponent.getOpponentNumbersArray();
    }

    private static void userInputLoop() {
        while(!isUserInputFinish) {
            userInput();
        }
    }

    private static String userInput() {
        boolean isCorrectUserInput = false;
        String userInput = null;
        while (!isCorrectUserInput) {
            userInput = Console.readLine();
            isCorrectUserInput = BaseballValidateUtils.validateUserInput(userInput);
        }

        isUserInputFinish = true;
        return userInput;
    }


}
