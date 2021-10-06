package baseball.controller;

import baseball.service.BaseballService;
import baseball.model.Opponent;
import baseball.model.User;
import utils.BaseballValidateUtils;
import utils.UserInput;

import java.util.List;

public class BaseballController {
    private final User user;
    private BaseballService baseballService;

    public BaseballController() {
        this.user = new User();
        this.baseballService = new BaseballService();
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
            List<Integer> userNumberSet = user.createUserNumbers();
            isWin = baseballService.compareUserNumbersAndOpponentNumbers(userNumberSet, opponentNumberList);
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
