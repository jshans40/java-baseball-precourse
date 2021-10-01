package baseball;

import utils.BaseballValidateUtils;

public class Opponent {
    private int firstNumber;
    private int secondNumber;
    private int thirdNumber;

    public Opponent(int firstNumber, int secondNumber, int thirdNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.thirdNumber = thirdNumber;
    }

    /**
     * 중복 숫자 확인
     */
    public boolean isNotDuplicateNumber() {
        return BaseballValidateUtils.isNotDuplicatedNumber(firstNumber, secondNumber, thirdNumber);
    }

    /**
     *  3개의 숫자를 배열로 변환해서 전달 (야구게임에서는 무저건 3개의 번호만 나올 수 있음)
    **/
    public int[] getOpponentNumbersArray() {
        int[] opponentNumbersArray = new int[3];
        opponentNumbersArray[0] = firstNumber;
        opponentNumbersArray[1] = secondNumber;
        opponentNumbersArray[2] = thirdNumber;

        return opponentNumbersArray;
    }
}
