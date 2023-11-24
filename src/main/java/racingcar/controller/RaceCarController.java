package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.util.RaceCarsFactory;
import racingcar.util.Randoms;
import racingcar.view.input.ConsoleRaceGameInput;
import racingcar.view.output.RaceGameOutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RaceCarController {

    private final ConsoleRaceGameInput inputView;
    private final RaceGameOutputView outputView;

    public RaceCarController(ConsoleRaceGameInput inputView, RaceGameOutputView outputView) {
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

    private List<Car.SingleMoveResultDto> getSingleCarsMoveResult(final Cars cars) {
        cars.instructAllCarsToMove(getMoveValues(cars));

        return cars.getCars().stream()
                .map(Car.SingleMoveResultDto::from)
                .toList();
    }

    private List<Integer> getMoveValues(Cars cars) {
        return cars.getCars().stream()
                .map(car -> Randoms.getNumber())
                .collect(Collectors.toList());
    }

    private void displayWinningCars(Cars cars) {
        List<Car.WinningCarNameDto> winningCarsName = getWinningCarsName(cars);
        outputView.displayWinningCars(winningCarsName);
    }

    private List<Car.WinningCarNameDto> getWinningCarsName(final Cars cars) {
        final List<Car> winningCars = cars.getWinningCars();

        return winningCars.stream()
                .map(Car.WinningCarNameDto::from)
                .toList();
    }

}
