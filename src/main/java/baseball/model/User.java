package baseball.model;

import utils.BaseballValidateUtils;
import utils.UserInput;

import java.util.*;

public class User {
    public List<Integer> createUserNumbers() {
        boolean validateUserInput = false;

        String userInput = null;
        while (!validateUserInput) {
            userInput = UserInput.inputGameNumber();
            validateUserInput = validateUserInput(userInput);
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

    private boolean validateUserInput(String userInput) {
        if (!BaseballValidateUtils.validateUserInput(userInput)) {
            return false;
        }

        return true;
    }
}
