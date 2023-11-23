package racingcar.controller;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.move.MoveStrategy;
import racingcar.domain.move.RandomBasedMoveStrategy;
import racingcar.domain.race.RacingCar;
import racingcar.domain.race.RacingCarFactory;
import racingcar.domain.race.RacingCarGame;
import racingcar.domain.race.RacingCarStatus;
import racingcar.domain.round.Round;
import racingcar.dto.RoundResultDto;
import racingcar.util.Parser;
import racingcar.view.RacingCarView;

public class RacingCarGameController {
    private final RacingCarView racingCarView;
    private final MoveStrategy moveStrategy = new RandomBasedMoveStrategy();
    private final RacingCarFactory racingCarFactory = new RacingCarFactory(moveStrategy);

    public RacingCarGameController(RacingCarView racingCarView) {
        this.racingCarView = racingCarView;
    }

    public void run() {
        Cars cars = getCars();
        Round totalRound = getTotalRound();
        RacingCarGame racingCarGame = createGame(cars, totalRound);

        playGame(racingCarGame);
    }

    private Cars getCars() {
        String racingCarNamesInput = racingCarView.inputRacingCarNames();
        List<String> racingCarNames = Parser.parseRacingCarNames(racingCarNamesInput);
        List<Car> carList = racingCarNames.stream()
                .map(Car::new)
                .toList();
        return new Cars(carList);
    }

    private Round getTotalRound() {
        String totalRoundInput = racingCarView.inputTotalRound();
        int totalRound = Parser.parseTotalRound(totalRoundInput);
        return new Round(totalRound, 0);
    }

    public RacingCarGame createGame(Cars cars, Round round) {
        List<RacingCar> racingCars = cars.getRacingCars().stream()
                .map(racingCarFactory::createRacingCar)
                .toList();
        return new RacingCarGame(racingCars, round);
    }

    public void playGame(RacingCarGame racingCarGame) {
        racingCarView.outputGameResultHeader();

        while (!racingCarGame.isFinished()) {
            racingCarGame.proceedRound();
            List<RacingCar> racingCars = racingCarGame.getRacingCars();

            List<RacingCarStatus> racingCarStatuses = racingCars.stream()
                    .map(racingCar -> new RacingCarStatus(racingCar.getName(),
                            racingCar.getRacingPosition().getValue()))
                    .toList();
            racingCarView.outputRoundResult(new RoundResultDto(racingCarStatuses));
        }
    }
}
