package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;
import utils.BaseBallValidateUtils;

public class Application {
    private static boolean isGameFinish = false;
    private static boolean isUserInputFinish = false;

    public static void main(String[] args) {
        createOpponentNumber();
        while (!isGameFinish) {
            isUserInputFinish = false;
            userInputLoop();
        }

    }

    private static void createOpponentNumber() {

        Randoms.pickNumberInRange(1, 9);
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
            isCorrectUserInput = BaseBallValidateUtils.validateUserInput(userInput);
        }

        isUserInputFinish = true;
        return userInput;
    }


}
