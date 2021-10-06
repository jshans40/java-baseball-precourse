package baseball;

public class PrintView {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String USER_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String GAME_IS_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String THREE_BALL = "낫싱";
    private static final String THREE_STRIKE_GAME_END = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 끝";

    public static void threeBall() {
        System.out.println(THREE_BALL);
    }

    public static void gameIsRestart() {
        System.out.println(GAME_IS_RESTART);
    }

    public static void userInputNumber() {
        System.out.println(USER_INPUT_NUMBER);
    }

    public static void errorMessage(String errorMessage) {
        System.out.println(ERROR_MESSAGE + " : " + errorMessage);
    }

    public static void threeStrikeGameEnd() {
        System.out.println(THREE_STRIKE_GAME_END);
    }

    public static void strikeBall(int strike, int ball) {
        String print = "";
        if (strike != 0) {
            print = strike + "스트라이크";
        }

        if (ball != 0) {
            print += " " + ball + "볼";
        }
        System.out.println(print);
    }
}
