package baseball;

import utils.BaseballValidateUtils;

import java.util.*;

public class Baseball {
    private int ball;
    private int strike;
    private int[] opponentNumbers;
    private int[] userNumbers;
    private List<Integer> opponentNumberList;
    private List<Integer> userNumberList;
    private List<Integer> removeNumberList;

    public Baseball(int[] opponentNumbers, int[] userNumbers) {
        this.opponentNumbers = opponentNumbers;
        this.userNumbers = userNumbers;

        List<Integer> opponentNumberList = new ArrayList<>();
        List<Integer> userNumberList = new ArrayList<>();

        for (int opponentNumber : opponentNumbers) {
            opponentNumberList.add(opponentNumber);
        }

        for (int userNumber : userNumbers) {
            userNumberList.add(userNumber);
        }

        this.opponentNumberList = opponentNumberList;
        this.userNumberList = userNumberList;
        this.removeNumberList = new ArrayList<>();
    }

    public boolean isGameFinish() {
        return compareOppnonentNumbersWithUserNumbers();
    }

    private boolean compareOppnonentNumbersWithUserNumbers() {
        Set<Integer> numbers = new HashSet<>();
        for (int opponentNumber : opponentNumbers) {
            numbers.add(opponentNumber);
        }

        for (int userNumber : userNumbers) {
            numbers.add(userNumber);
        }

        if (Arrays.equals(opponentNumbers, userNumbers)) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
            return true;
        }

        if (numbers.size() == 6) {
            System.out.println("낫싱");
            return false;
        }

        for (int i=0; i<opponentNumbers.length; i++) {
            discriminationStrike(i);
        }

        for (Integer removeNumber : removeNumberList) {
            opponentNumberList.remove(removeNumber);
            userNumberList.remove(removeNumber);
        }

        userNumberList.retainAll(opponentNumberList);

        ball = userNumberList.size();

        printStrikeBall();
        return false;
    }

    public void discriminationStrike(int index) {
        if (opponentNumbers[index] == userNumbers[index]) {
            strike++;
            removeNumberList.add(opponentNumbers[index]);
        }
    }

    public void printStrikeBall() {
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
