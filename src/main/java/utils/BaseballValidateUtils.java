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
        int[] numbers = stringToInt(userInput);

        if (!isNotDuplicatedNumber(numbers[0], numbers[1], numbers[2])) {
            return false;
        }

        if (numbers[0] <= 0 || numbers[0] > 9) {
            return false;
        }

        if (numbers[1] <= 0 || numbers[1] > 9) {
            return false;
        }

        if (numbers[2] <= 0 || numbers[2] > 9) {
            return false;
        }

        return true;
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
        if (userInput == null) {
            System.out.println("[ERROR]");
            return false;
        }

        if (userInput.length() != 1) {
            System.out.println("[ERROR]");
            return false;
        }

        if (!BaseballValidateUtils.isInteger(userInput.charAt(0))) {
            System.out.println("[ERROR]");
            return false;
        }

        if (Integer.parseInt(String.valueOf(userInput.charAt(0))) == 0 || Integer.parseInt(String.valueOf(userInput.charAt(0))) > 2) {
            System.out.println("[ERROR]");
            return false;
        }

        return true;
    }
}
