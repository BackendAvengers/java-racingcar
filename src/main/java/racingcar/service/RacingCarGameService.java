package racingcar.service;

import java.util.List;
import racingcar.domain.car.Cars;
import racingcar.domain.move.MoveStrategy;
import racingcar.domain.move.RandomBasedMoveStrategy;
import racingcar.domain.race.RacingCar;
import racingcar.domain.race.RacingCarFactory;
import racingcar.domain.race.RacingCarGame;
import racingcar.domain.round.Round;

public class RacingCarGameService {
    private final MoveStrategy moveStrategy = new RandomBasedMoveStrategy();
    private final RacingCarFactory racingCarFactory = new RacingCarFactory(moveStrategy);

    public RacingCarGame createGame(Cars cars, Round round) {
        List<RacingCar> racingCars = cars.getRacingCars().stream()
                .map(racingCarFactory::createRacingCar)
                .toList();
        return new RacingCarGame(racingCars, round);
    }
}
