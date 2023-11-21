package racingcar.domain.car;

import racingcar.util.Randoms;

public enum MoveSupport {

    MOVE_THRESHOLD(4);

    private final int threshold;

    MoveSupport(int threshold) {
        this.threshold = threshold;
    }

    public static boolean isMoveAllowed() {
        return Randoms.getNumber() >= MOVE_THRESHOLD.threshold;
    }
}
