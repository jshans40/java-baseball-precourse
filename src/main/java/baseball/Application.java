package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;
import utils.BaseballValidateUtils;

import java.util.Arrays;

public class Application {
    private static boolean isGameFinish = false;
    private static boolean isUserInputFinish = false;
    private static boolean isGameRestart = true;
    private static int[] opponentNumbers = null;
    public static void main(String[] args) {
        opponentNumbers = createOpponentNumber();

        while (!isGameFinish || isGameRestart) {
            isUserInputFinish = false;
            int[] userInput = userInputLoop();
            Baseball baseball = new Baseball(opponentNumbers, userInput);
            isGameFinish = baseball.isGameFinish();
            isGameRestart = isGameRestart(isGameFinish);
        }
    }

    private static boolean isGameRestart(boolean isGameFinish) {
        boolean isValidateGameRestartInput = false;

        String finishUserInput = null;
        while (!isValidateGameRestartInput && isGameFinish) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            finishUserInput = Console.readLine();
            isValidateGameRestartInput = BaseballValidateUtils.isValidateGameRestartInput(finishUserInput);
        }

        if (finishUserInput != null && Integer.parseInt(String.valueOf(finishUserInput.charAt(0))) == 2) {
            return false;
        }

        if (finishUserInput != null && Integer.parseInt(String.valueOf(finishUserInput.charAt(0))) == 1) {
            opponentNumbers = createOpponentNumber();
        }

        return true;
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

    private static int[] userInputLoop() {
        int[] userInput = null;

        while(!isUserInputFinish) {
            System.out.println("숫자를 입력해주세요 : ");
            userInput = getUserInput();
        }

        return userInput;
    }

    private static int[] getUserInput() {
        boolean isCorrectUserInput = false;
        String userInput = null;
        while (!isCorrectUserInput) {
            userInput = Console.readLine();
            isCorrectUserInput = BaseballValidateUtils.validateUserInput(userInput);
        }

        isUserInputFinish = true;
        return BaseballValidateUtils.stringToInt(userInput);
    }

}
