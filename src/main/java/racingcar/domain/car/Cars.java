package racingcar.domain.car;

import java.util.List;

import static racingcar.domain.car.exception.ErrorMessage.NOT_FOUND_CAR_ERROR;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void instructAllCarsToMove(int movesToPerform) {
        for (int initialCount = 0; initialCount < movesToPerform; initialCount++){
            cars.forEach(Car::moveForwardOrHalt);
        }
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
