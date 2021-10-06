package baseball;

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

        addNumberArrayToList(opponentNumbers, opponentNumberList);

        addNumberArrayToList(userNumbers, userNumberList);

        this.opponentNumberList = opponentNumberList;
        this.userNumberList = userNumberList;
        this.removeNumberList = new ArrayList<>();
    }

    private void addNumberArrayToList(int[] opponentNumbers, List<Integer> opponentNumberList) {
        for (int opponentNumber : opponentNumbers) {
            opponentNumberList.add(opponentNumber);
        }
    }

    public boolean isGameFinish() {
        return compareOppnonentNumbersWithUserNumbers();
    }

    private boolean compareOppnonentNumbersWithUserNumbers() {
        Set<Integer> numbers = addNumbersToHashSet();
        Boolean gameFinish = calculateGameFinish(numbers);
        if (gameFinish != null) {
            return gameFinish;
        }

        calculateStrike();
        calculateBall();
        printStrikeBall();
        return false;
    }

    /**
     *  계산이 종료되기 전에는 3스트라이크, 낫싱이 있는데,
     *  스트라이크 볼을 계산하기 전 3스트라이크, 낫싱을 먼저 계산하여 효율을 높인다.
     */
    private Boolean calculateGameFinish(Set<Integer> numbers) {
        if (opponentNumberList.equals(userNumberList)) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 끝");
            return true;
        }

        if (numbers.size() == 6) {
            System.out.println("낫싱");
            return false;
        }
        return null;
    }

    private void calculateStrike() {
        for (int i=0; i<opponentNumberList.size(); i++) {
            discriminationStrike(i);
        }
    }

    private void calculateBall() {
        removeNumbers();

        userNumberList.retainAll(opponentNumberList);

        ball = userNumberList.size();
    }

    private void removeNumbers() {
        for (Integer removeNumber : removeNumberList) {
            opponentNumberList.remove(removeNumber);
            userNumberList.remove(removeNumber);
        }
    }

    private Set<Integer> addNumbersToHashSet() {
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
