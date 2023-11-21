package racingcar.domain;

import racingcar.util.Randoms;

import java.util.ArrayList;
import java.util.List;

import static racingcar.domain.exception.ErrorMessage.NOT_FOUND_CAR_ERROR;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void instructAllCarsToMove() {
        cars.forEach(this::instructCarToMove);
    }

    private void instructCarToMove(Car car) {
        car.moveForwardOrHalt(Randoms.count());
    }

    public List<Car> getWinningCars() {
        final Car mostActiveCar = getMostActiveCar();

        return cars.stream()
                .filter(car -> car.hasSameCar(mostActiveCar))
                .toList();
    }

    private Car getMostActiveCar() {
        return cars.stream()
                .sorted()
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(NOT_FOUND_CAR_ERROR.getMessage()));
    }

}
