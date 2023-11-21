package racingcar.controller;

import racingcar.controller.dto.AllCarsMoveResultsDto;
import racingcar.controller.dto.SingleMoveResultDto;
import racingcar.domain.car.Cars;
import racingcar.util.RaceCarsFactory;
import racingcar.view.input.RaceGameInputView;
import racingcar.view.output.RaceGameOutputView;

import java.util.List;
import java.util.stream.IntStream;

public class RaceCarGameController {

    private final RaceGameInputView inputView;
    private final RaceGameOutputView outputView;

    public RaceCarGameController(RaceGameInputView inputView, RaceGameOutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = getCars();
        displayCarsMoveResult(cars, getMoveAttempts());
    }

    private Cars getCars() {
        List<String> carNames = inputView.requestCarNames();
        return RaceCarsFactory.createCars(carNames);
    }

    private int getMoveAttempts() {
        return inputView.requestMoveAttempts();
    }

    private void displayCarsMoveResult(Cars cars, int moveAttempts) {
        List<AllCarsMoveResultsDto> allMoveResult = getAllMoveResult(cars, moveAttempts);
        outputView.displayCarsMoveResult(allMoveResult);
    }

    private List<AllCarsMoveResultsDto> getAllMoveResult(final Cars cars, final int moveAttempts) {
        return IntStream.range(0, moveAttempts)
                .mapToObj(i -> new AllCarsMoveResultsDto(getSingleMoveResult(cars)))
                .toList();
    }

    private List<SingleMoveResultDto> getSingleMoveResult(final Cars cars) {
        cars.instructAllCarsToMove();

        return cars.getCars().stream()
                .map(SingleMoveResultDto::from)
                .toList();
    }

}
