package racingcar.domain.round;

public class RoundConstraints {
    private static final int MIN_TOTAL_ROUND = 1;
    private static final int MAX_TOTAL_ROUND = 10000;

    private RoundConstraints() {
    }

    public static boolean isValidTotalRound(int totalRound) {
        return MIN_TOTAL_ROUND <= totalRound && totalRound <= MAX_TOTAL_ROUND;
    }
}
