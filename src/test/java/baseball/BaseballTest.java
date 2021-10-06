package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
class BaseballTest {
    private List<Integer> opponentNumbers;

    @DisplayName("유저가 입력한 숫자가 3스트라이크인지 확인")
    @Test
    void 유저가_입력한_값이_3스트라이크인지_확인() {
        List<Integer> userNumbers = new ArrayList<>(Arrays.asList(1, 8, 3));
        assertThat(userNumbers).isEqualTo(opponentNumbers);

        List<Integer> incorrectUserNumbers = new ArrayList<>(Arrays.asList(2, 8, 3));
        assertThat(incorrectUserNumbers).isNotEqualTo(opponentNumbers);
    }

    @DisplayName("유저가 입력한 숫자가 낫싱인지 확인")
    @Test
    void 유저가_입력한_값이_낫싱인지_확인() {
        List<Integer> userNumbers = new ArrayList<>(Arrays.asList(2, 5, 4));

        Set<Integer> numberSet = new HashSet<>();

        addNumbers(userNumbers, numberSet);

        addNumbers(opponentNumbers, numberSet);

        assertThat(numberSet.size()).isEqualTo(6);
    }

    private void addNumbers(List<Integer> userNumbers, Set<Integer> numberSet) {
        for (Integer userNumber : userNumbers) {
            numberSet.add(userNumber);
        }
    }

    @DisplayName("유저가 입력한 값의 스트라이크 갯수 확인")
    @Test
    void 유저가_입력한_값이_스트라이크가_있는지_확인() {
        int strike = 0;
        List<Integer> userNumbers = new ArrayList<>(Arrays.asList(1, 8, 4));

        for (int i=0; i<userNumbers.size(); i++) {
            if (userNumbers.get(i) == opponentNumbers.get(i)) {
                strike++;
            }
        }

        assertThat(strike).isEqualTo(2);
    }

    @DisplayName("유저가 입력한 값의 볼 갯수 확인")
    @Test
    void 유저가_입력한_값이_볼이_있는지_확인() {
        List<Integer> overlapNumbers = new ArrayList<>();
        List<Integer> userNumbers = new ArrayList<>(Arrays.asList(8, 3, 4));

        addNumbers(overlapNumbers, userNumbers);

        removeOverlapMumbers(overlapNumbers, userNumbers);

        userNumbers.retainAll(opponentNumbers);

        assertThat(userNumbers.size()).isEqualTo(2);
    }

    private void removeOverlapMumbers(List<Integer> overlapNumbers, List<Integer> userNumbers) {
        for (Integer overlapNumber : overlapNumbers) {
            userNumbers.remove(overlapNumber);
            opponentNumbers.remove(overlapNumber);
        }
    }

    private void addNumbers(List<Integer> overlapNumbers, List<Integer> userNumbers) {
        for (int i = 0; i< userNumbers.size(); i++) {
            if (userNumbers.get(i) == opponentNumbers.get(i)) {
                overlapNumbers.add(userNumbers.get(i));
            }
        }
    }

    @BeforeEach
    void init() {
        opponentNumbers = new ArrayList<>();

        opponentNumbers.add(1);
        opponentNumbers.add(8);
        opponentNumbers.add(3);
    }


}
