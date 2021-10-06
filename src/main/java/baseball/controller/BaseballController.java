package baseball.controller;

import baseball.model.Baseball;
import baseball.model.Opponent;
import baseball.model.User;
import utils.BaseballValidateUtils;
import utils.UserInput;

import java.util.List;

public class BaseballController {
    private final User user;

    public BaseballController() {
        this.user = new User();
    }

    public void gameStart() {

        boolean isPlaying = true;
        while (isPlaying) {
            Opponent opponent = new Opponent();
            List<Integer> opponentNumberList = opponent.createNumbers();
            playUserTurn(opponentNumberList);
            isPlaying = !isEnd();
        }
    }

    public void playUserTurn(List<Integer> opponentNumberList) {
        boolean isWin = false;
        while (!isWin) {
            List<Integer> userNumberList = user.createUserNumbers();
            Baseball baseball = new Baseball(opponentNumberList, userNumberList);
            isWin = baseball.compareUserNumbersAndOpponentNumbers(userNumberList, opponentNumberList);
        }
    }

    public boolean isEnd() {
        String endUserInput = "";
        boolean isValidateGameRestartInput = false;
        while (!isValidateGameRestartInput) {
            endUserInput = UserInput.inputGameRestartNumber();
            isValidateGameRestartInput = BaseballValidateUtils.isValidateGameRestartInput(endUserInput);
        }

        return !isRestart(endUserInput);
    }

    public boolean isRestart(String restartUserInput) {
        if (restartUserInput.equals("1")) {
            return true;
        }
        return false;
    }
}
