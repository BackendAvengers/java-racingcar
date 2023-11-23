package racingcar.controller;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.race.RacingCarGame;
import racingcar.domain.round.Round;
import racingcar.service.RacingCarGameService;
import racingcar.util.Parser;
import racingcar.view.RacingCarView;

public class RacingCarGameController {
    private final RacingCarView racingCarView;
    private final RacingCarGameService racingCarGameService;

    public RacingCarGameController(RacingCarView racingCarView, RacingCarGameService racingCarGameService) {
        this.racingCarView = racingCarView;
        this.racingCarGameService = racingCarGameService;
    }

    public void run() {
        Cars cars = getCars();
        Round totalRound = getTotalRound();
        RacingCarGame racingCarGame = racingCarGameService.createGame(cars, totalRound);


    }

    private Round getTotalRound() {
        String totalRoundInput = racingCarView.inputTotalRound();
        int totalRound = Parser.parseTotalRound(totalRoundInput);
        return new Round(totalRound, 0);
    }

    private Cars getCars() {
        String racingCarNamesInput = racingCarView.inputRacingCarNames();
        List<String> racingCarNames = Parser.parseRacingCarNames(racingCarNamesInput);
        List<Car> carList = racingCarNames.stream()
                .map(Car::new)
                .toList();
        return new Cars(carList);
    }
}
