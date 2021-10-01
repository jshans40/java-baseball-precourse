package baseball;

import nextstep.utils.Console;

public class Application {
    private static boolean isGameFinish = false;

    public static void main(String[] args) {
        loop();
    }

    private static void loop() {
        while(!isGameFinish) {
            userInput();
        }
    }

    private static void userInput() {
        boolean isCorrectUserInput = false;

        while (!isCorrectUserInput) {
            String userInput = Console.readLine();
            isCorrectUserInput = validateUserInput(userInput);
        }
    }

    private static boolean validateUserInput(String userInput) {
        if (userInput.length() != 3) {
            System.out.println("입력한 숫자를 다시 한번 확인해주세요.");
            return false;
        }

        if (!validateUserInputString(userInput)) {
            System.out.println("입력한 숫자를 다시 한번 확인해주세요.");
            return false;
        }
        return true;
    }

    private static boolean validateUserInputString(String userInput) {
        if (!isIntegerWithRange(userInput)) {
            return false;
        }

        return true;
    }

    private static boolean isIntegerWithRange(String userInput) {
        if (!isInteger(userInput.charAt(0)) || !isInteger(userInput.charAt(1)) || !isInteger(userInput.charAt(2))) {
            return false;
        }

        if (Integer.parseInt(String.valueOf(userInput.charAt(0))) <= 0 || Integer.parseInt(String.valueOf(userInput.charAt(0))) > 9) {
            return false;
        }

        if (Integer.parseInt(String.valueOf(userInput.charAt(1))) <= 0 || Integer.parseInt(String.valueOf(userInput.charAt(1))) > 9) {
            return false;
        }

        if (Integer.parseInt(String.valueOf(userInput.charAt(2))) <= 0 || Integer.parseInt(String.valueOf(userInput.charAt(2))) > 9) {
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
