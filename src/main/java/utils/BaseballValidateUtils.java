package utils;

import baseball.PrintView;

import java.util.HashSet;
import java.util.Set;

public class BaseballValidateUtils {
    public static boolean validateUserInput(String userInput) {
        if (!checkUserInputLength(userInput, 3)) {
            return false;
        }

        if (!validateUserInputString(userInput)) {
            PrintView.errorMessage("입력한 숫자를 확인해주세요. 1~9까지의 숫자중 3개의 숫자를 입력해야됩니다.");
            return false;
        }

        return true;
    }

    private static boolean checkUserInputLength(String userInput, int length) {
        if (userInput == null || userInput.length() != length) {
            PrintView.errorMessage("입력한 숫자를 확인해주세요. 1~9까지의 숫자중 3개의 숫자를 입력해야됩니다.");
            return false;
        }

        return true;
    }

    private static boolean validateUserInputString(String userInput) {
        if (!isInteger(userInput.charAt(0)) || !isInteger(userInput.charAt(1)) || !isInteger(userInput.charAt(2))) {
            return false;
        }

        if (!validateRangeWithDuplicate(userInput)) {
            return false;
        }

        return true;
    }

    private static boolean validateRangeWithDuplicate(String userInput) {
        int[] numbers = stringToInt(userInput);
        if (!isNotDuplicatedNumber(numbers[0], numbers[1], numbers[2])) {
            return false;
        }

        if (checkNumberRange(numbers)) {
            return false;
        }

        return true;
    }

    private static boolean checkNumberRange(int[] numbers) {
        return (numbers[0] <= 0 || numbers[0] > 9) || (numbers[1] <= 0 || numbers[1] > 9) || (numbers[2] <= 0 || numbers[2] > 9);
    }

    public static int[] stringToInt(String value) {
        int[] numbers = new int[3];
        numbers[0] = Integer.parseInt(String.valueOf(value.charAt(0)));
        numbers[1] = Integer.parseInt(String.valueOf(value.charAt(1)));
        numbers[2] = Integer.parseInt(String.valueOf(value.charAt(2)));

        return numbers;
    }

    public static boolean isNotDuplicatedNumber(int ...numbers) {
        Set<Integer> numberSets = new HashSet<>();
        for (int number : numbers) {
            numberSets.add(number);
        }

        if (numberSets.size() != numbers.length) {
            return false;
        }

        return true;
    }

    public static boolean isInteger(char charUserInput) {
        try {
            Integer.parseInt(String.valueOf(charUserInput));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidateGameRestartInput(String userInput) {
        if (!checkUserInputLength(userInput, 1)) {
            return false;
        }

        if (!BaseballValidateUtils.isInteger(userInput.charAt(0)) || !isValidateRestartInputRange(Integer.parseInt(String.valueOf(userInput.charAt(0))) )) {
            PrintView.errorMessage("숫자만 입력 가능합니다. 1~9까지의 숫자중 3개의 숫자를 입력해야됩니다.");
            return false;
        }

        return true;
    }

    private static boolean isValidateRestartInputRange(int userInput) {
        if (userInput == 0 || userInput > 2) {
            return false;
        }
        return true;
    }
}
