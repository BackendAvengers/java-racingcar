package racingcar.domain.move;

import racingcar.util.Random;

public class RandomBasedMoveStrategy implements MoveStrategy {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int STOP_THRESHOLD = 3;

    @Override
    public boolean isMoveable() {
        int number = Random.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        return number > STOP_THRESHOLD;
    }
}
