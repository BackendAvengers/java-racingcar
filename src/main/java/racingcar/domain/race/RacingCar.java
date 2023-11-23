package racingcar.domain.race;

import racingcar.domain.move.MoveStrategy;

public class RacingCar {
    private final String name;
    private final RacingPosition racingPosition;
    private final MoveStrategy moveStrategy;

    public RacingCar(String name, RacingPosition racingPosition, MoveStrategy moveStrategy) {
        this.name = name;
        this.racingPosition = racingPosition;
        this.moveStrategy = moveStrategy;
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
