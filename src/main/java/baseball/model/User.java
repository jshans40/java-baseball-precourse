package baseball.model;

import baseball.service.BaseballService;
import utils.BaseballValidateUtils;
import utils.UserInput;

import java.util.*;

public class User {
    BaseballService baseballService = new BaseballService();

    public List<Integer> createUserNumbers() {
        boolean validateUserInput = false;

        String userInput = null;
        while (!validateUserInput) {
            userInput = UserInput.inputGameNumber();
            validateUserInput = baseballService.validateUserInput(userInput);
        }

        return userInputStringToList(userInput);
    }

    private List<Integer> userInputStringToList(String userInputString) {
        List<Integer> userInputNumberList = new ArrayList<>();

        int[] userInputArray = BaseballValidateUtils.stringToInt(userInputString);

        for (Integer userInput : userInputArray) {
            userInputNumberList.add(userInput);
        }

        return userInputNumberList;
    }
}
