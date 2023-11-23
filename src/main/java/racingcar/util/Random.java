package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

    private Random() {
    }

    public static int pickNumberInRange(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
