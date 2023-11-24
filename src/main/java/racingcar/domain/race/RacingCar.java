package racingcar.domain.race;

import racingcar.domain.car.Car;
import racingcar.domain.move.MoveStrategy;

public class RacingCar {
    private final Car car;
    private final RacingPosition racingPosition;
    private final MoveStrategy moveStrategy;

    public RacingCar(Car car, RacingPosition racingPosition, MoveStrategy moveStrategy) {
        this.car = car;
        this.racingPosition = racingPosition;
        this.moveStrategy = moveStrategy;
    }

    public void moveForwardOrStop() {
        if (moveStrategy.isMoveable()) {
            racingPosition.moveForward();
        }
    }

    public Car getCar() {
        return car;
    }

    public String getName() {
        return car.getName();
    }

    public RacingPosition getRacingPosition() {
        return racingPosition;
    }
}
