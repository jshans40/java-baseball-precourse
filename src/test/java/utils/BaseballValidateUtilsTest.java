package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BaseballValidateUtilsTest {

    @Test
    @DisplayName("중복 숫자 확인")
    void 중복_숫자_확인() {
        int[] numbers = new int[3];
        numbers[0] = 1;
        numbers[1] = 1;
        numbers[2] = 2;

        Set<Integer> numberSets = new HashSet<>();
        for (int number : numbers) {
            numberSets.add(number);
        }

        assertThat(numbers.length).isNotEqualTo(numberSets.size());
    }

    @Test
    @DisplayName("숫자가 아닐때 에러 발생")
    void 숫자가_아닐때_에러_발생() {
        char value = "a".charAt(0);

        assertThatThrownBy(() -> {
            Integer.parseInt(String.valueOf(value));
        }).isInstanceOf(NumberFormatException.class);
    }
}
