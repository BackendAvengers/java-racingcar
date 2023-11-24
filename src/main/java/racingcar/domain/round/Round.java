package racingcar.domain.round;

import static racingcar.domain.round.RoundConstraints.isValidTotalRound;
import static racingcar.exception.ErrorMessage.INVALID_TOTAL_ROUND_RANGE;

public class Round {
    private final int totalRound;
    private int currentRound;

    public Round(int totalRound, int currentRound) {
        validateTotalRoundRange(totalRound);

        this.totalRound = totalRound;
        this.currentRound = currentRound;
    }

    private void validateTotalRoundRange(int totalRound) {
        if (!isValidTotalRound(totalRound)) {
            throw new IllegalArgumentException(INVALID_TOTAL_ROUND_RANGE.getValue(totalRound));
        }
    }

    public boolean hasNext() {
        return currentRound < totalRound;
    }

    public void next() {
        if (!hasNext()) {
            throw new IllegalStateException("이미 마지막 라운드입니다.");
        }
        ++currentRound;
    }

    public int getTotalRound() {
        return totalRound;
    }

    public int getCurrentRound() {
        return currentRound;
    }
}
