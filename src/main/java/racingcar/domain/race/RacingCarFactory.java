package racingcar.domain.race;

import racingcar.domain.car.Car;
import racingcar.domain.move.MoveStrategy;

public class RacingCarFactory {
    private static final int INITIAL_RACING_POSITION = 0;
    private final MoveStrategy moveStrategy;

    public RacingCarFactory(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public RacingCar createRacingCar(Car car) {
        return new RacingCar(car, new RacingPosition(INITIAL_RACING_POSITION), moveStrategy);
    }
}
