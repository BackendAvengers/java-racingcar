package racingcar.domain.race;

import racingcar.domain.move.MoveStrategy;

public class RacingCarFactory {
    private static final int INITIAL_RACING_POSITION = 0;
    private final MoveStrategy moveStrategy;

    public RacingCarFactory(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public RacingCar createRacingCar(String name) {
        return new RacingCar(name, new RacingPosition(INITIAL_RACING_POSITION), moveStrategy);
    }
}
