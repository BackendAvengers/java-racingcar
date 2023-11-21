package racingcar.controller;

import racingcar.controller.dto.SingleMoveResultDto;
import racingcar.controller.dto.WinningCarNameDto;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.util.RaceCarsFactory;
import racingcar.view.input.ConsoleRaceGameInput;
import racingcar.view.output.RaceGameOutputView;

import java.util.List;

public class RaceCarGameController {

    private final ConsoleRaceGameInput inputView;
    private final RaceGameOutputView outputView;

    public RaceCarGameController(ConsoleRaceGameInput inputView, RaceGameOutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = getCars();
        int moveAttempts = getMoveAttempts();
        displayResultMessage();
        displayCarsMoveResult(cars, moveAttempts);
        displayWinningCars(cars);
    }

    private Cars getCars() {
        List<String> carNames = inputView.requestCarNames();
        return RaceCarsFactory.createCars(carNames);
    }

    private int getMoveAttempts() {
        return inputView.requestMoveAttempts();
    }

    private void displayResultMessage() {
        outputView.displayResultMessage();
    }

    private void displayCarsMoveResult(Cars cars, int moveAttempts) {
        for (int iteration = 0; iteration < moveAttempts; iteration++) {
            outputView.displayCarsMoveResult(getSingleCarsMoveResult(cars));
        }
    }

    private List<SingleMoveResultDto> getSingleCarsMoveResult(final Cars cars) {
        cars.instructAllCarsToMove();

        return cars.getCars().stream()
                .map(SingleMoveResultDto::from)
                .toList();
    }

    private void displayWinningCars(Cars cars) {
        List<WinningCarNameDto> winningCarsName = getWinningCarsName(cars);
        outputView.displayWinningCars(winningCarsName);
    }

    private List<WinningCarNameDto> getWinningCarsName(final Cars cars) {
        List<Car> winningCars = cars.getWinningCars();

        return winningCars.stream()
                .map(WinningCarNameDto::from)
                .toList();
    }

}
