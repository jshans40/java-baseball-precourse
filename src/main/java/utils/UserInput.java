package utils;

import baseball.PrintView;
import nextstep.utils.Console;

public class UserInput {
    public static String inputGameNumber() {
        PrintView.userInputNumber();
        return Console.readLine();
    }

    public static String inputGameRestartNumber() {
        PrintView.gameIsRestart();
        return Console.readLine();
    }
}
