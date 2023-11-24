package racingcar.domain.car;

public enum MoveSupport {

    MOVE_THRESHOLD(4);

    private final int threshold;

    MoveSupport(int threshold) {
        this.threshold = threshold;
    }

    public static boolean isMoveAllowed(int moveValue) {
        return moveValue >= MOVE_THRESHOLD.threshold;
    }
}
