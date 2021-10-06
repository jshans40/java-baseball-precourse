package baseball.model;

import baseball.PrintView;

import java.util.*;

public class Baseball {
    private int ball;
    private int strike;
    private List<Integer> opponentNumberList;
    private List<Integer> userNumberList;
    private List<Integer> removeNumberList;

    public Baseball(List<Integer> opponentNumberList, List<Integer> userNumberList) {
        this.opponentNumberList = opponentNumberList;
        this.userNumberList = userNumberList;
        this.removeNumberList = new ArrayList<>();
    }

    public Boolean calculateGameFinish(Set<Integer> numbers) {
        if (opponentNumberList.equals(userNumberList)) {
            PrintView.threeStrikeGameEnd();
            return true;
        }

        if (numbers.size() == 6) {
            PrintView.threeBall();
            return false;
        }
        return null;
    }

    public void calculateStrikeAndBall() {
        calculateStrike();
        calculateBall();
    }
    public void calculateStrike() {
        for (int i=0; i<opponentNumberList.size(); i++) {
            discriminationStrike(i);
        }
    }

    public void calculateBall() {
        int ball = 0;
        for (int i=0; i<userNumberList.size(); i++) {
            ball += addBallCount(i);
        }

        this.ball = ball;
    }

    private int addBallCount(int index) {
        if (!opponentNumberList.contains(userNumberList.get(index))) {
            return 0;
        }

        if (opponentNumberList.indexOf(userNumberList.get(index)) != index) {
            return 1;
        }

        return 0;
    }

    public Set<Integer> addNumbersToHashSet() {
        Set<Integer> numbers = new HashSet<>();
        for (int opponentNumber : opponentNumberList) {
            numbers.add(opponentNumber);
        }

        for (int userNumber : userNumberList) {
            numbers.add(userNumber);
        }
        return numbers;
    }

    public void discriminationStrike(int index) {
        if (opponentNumberList.get(index) == userNumberList.get(index)) {
            strike++;
            removeNumberList.add(opponentNumberList.get(index));
        }
    }

    public void printStrikeBall() {
        PrintView.strikeBall(strike, ball);
    }

    public boolean compareUserNumbersAndOpponentNumbers(List<Integer> userNumberList, List<Integer> opponentNumberList) {
        Set<Integer> numbers = addNumbersToHashSet();
        Boolean gameFinish = calculateGameFinish(numbers);
        if (gameFinish != null) {
            return gameFinish;
        }

        calculateStrikeAndBall();
        printStrikeBall();
        return false;
    }
}
