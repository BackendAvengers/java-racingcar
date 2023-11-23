package fixture;

import racingcar.domain.race.RacingCar;
import racingcar.domain.race.RacingPosition;
import stub.StubMoveStrategy;

public class Fixture {

    public static RacingCar createRacingCar(String name, boolean isMoveable) {
        StubMoveStrategy stubMoveStrategy = new StubMoveStrategy();
        stubMoveStrategy.setMoveable(isMoveable);
        return new RacingCar(name, new RacingPosition(0), stubMoveStrategy);
    }
}
