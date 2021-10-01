package utils;

import java.util.HashSet;
import java.util.Set;

public class BaseballValidateUtils {
    public static boolean validateUserInput(String userInput) {
        if (userInput == null) {
            System.out.println("[ERROR]");
            return false;
        }

        if (userInput.length() != 3) {
            System.out.println("[ERROR]");
            return false;
        }

        if (!validateUserInputString(userInput)) {
            System.out.println("[ERROR]");
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
        int firstNumber = Integer.parseInt(String.valueOf(userInput.charAt(0)));
        int secondNumber = Integer.parseInt(String.valueOf(userInput.charAt(1)));
        int thirdNumber = Integer.parseInt(String.valueOf(userInput.charAt(2)));

        if (!isNotDuplicatedNumber(firstNumber, secondNumber, thirdNumber)) {
            return false;
        }

        if (firstNumber <= 0 || firstNumber > 9) {
            return false;
        }

        if (secondNumber <= 0 || secondNumber > 9) {
            return false;
        }

        if (thirdNumber <= 0 || thirdNumber > 9) {
            return false;
        }

        return true;
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

    private static boolean isInteger(char charUserInput) {
        try {
            Integer.parseInt(String.valueOf(charUserInput));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}