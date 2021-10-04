package baseball;

import utils.BaseballValidateUtils;

import java.util.*;

public class Baseball {
    private int ball;
    private int strike;
    private List<Integer> opponentNumberList;
    private List<Integer> userNumberList;
    private List<Integer> removeNumberList;

    public Baseball(int[] opponentNumbers, int[] userNumbers) {
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
        for (int opponentNumber : opponentNumberList) {
            numbers.add(opponentNumber);
        }

        for (int userNumber : userNumberList) {
            numbers.add(userNumber);
        }

        if (opponentNumberList.equals(userNumberList)) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
            return true;
        }

        if (numbers.size() == 6) {
            System.out.println("낫싱");
            return false;
        }

        for (int i=0; i<opponentNumberList.size(); i++) {
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
        if (opponentNumberList.get(index) == userNumberList.get(index)) {
            strike++;
            removeNumberList.add(opponentNumberList.get(index));
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
