package baseball.service;

import baseball.model.Baseball;
import utils.BaseballValidateUtils;

import java.util.List;
import java.util.Set;

public class BaseballService {
    public boolean validateUserInput(String userInput) {
        if (!BaseballValidateUtils.validateUserInput(userInput)) {
            return false;
        }

        return true;
    }

    public boolean compareUserNumbersAndOpponentNumbers(List<Integer> userNumberList, List<Integer> opponentNumberList) {
        Baseball baseball = new Baseball(opponentNumberList, userNumberList);
        Set<Integer> numbers = baseball.addNumbersToHashSet();
        Boolean gameFinish = baseball.calculateGameFinish(numbers);
        if (gameFinish != null) {
            return gameFinish;
        }

        baseball.calculateStrikeAndBall();
        baseball.printStrikeBall();
        return false;
    }
}
