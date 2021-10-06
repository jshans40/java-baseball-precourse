package baseball.model;

import nextstep.utils.Randoms;
import utils.BaseballValidateUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Opponent {
    public final List<Integer> opponentNumberList;
    public Opponent() {
        opponentNumberList = new ArrayList<>();
    }

    public List<Integer> createNumbers() {
        while (opponentNumberList.size() < 3) {
            addNumberList();
        }

        return opponentNumberList;
    }

    private void addNumberList() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!opponentNumberList.contains(randomNumber)) {
            opponentNumberList.add(randomNumber);
        }
    }



}
