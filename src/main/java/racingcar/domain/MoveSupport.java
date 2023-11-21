package racingcar.domain;

public enum MoveSupport {

    MOVE_THRESHOLD(4);

    private final int threshold;

    MoveSupport(int threshold) {
        this.threshold = threshold;
    }

    public static boolean isMoveAllowed(int controlValue) {
        return controlValue >= MOVE_THRESHOLD.threshold;
    }
}
