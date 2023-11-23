package racingcar.domain.race;

import static racingcar.domain.race.RacingCarConstraints.isValidCarNameLength;
import static racingcar.exception.ErrorMessage.INVALID_CAR_NAME_LENGTH;

import racingcar.domain.move.MoveStrategy;

public class RacingCar {
    private final String name;
    private final RacingPosition racingPosition;
    private final MoveStrategy moveStrategy;

    public RacingCar(String name, RacingPosition racingPosition, MoveStrategy moveStrategy) {
        validateNameLength(name);

        this.name = name;
        this.racingPosition = racingPosition;
        this.moveStrategy = moveStrategy;
    }

    private void validateNameLength(String name) {
        if (!isValidCarNameLength(name)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.getValue(name.length()));
        }
    }

    public void moveForwardOrStop() {
        if (moveStrategy.isMoveable()) {
            racingPosition.moveForward();
        }
    }

    public String getName() {
        return name;
    }

    public RacingPosition getRacingPosition() {
        return racingPosition;
    }
}
