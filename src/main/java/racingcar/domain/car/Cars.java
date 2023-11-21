package racingcar.domain.car;

import java.util.Collections;
import java.util.List;

import static racingcar.domain.car.exception.ErrorMessage.DUPLICATE_CAR_NAME_ERROR;
import static racingcar.domain.car.exception.ErrorMessage.NOT_FOUND_CAR_ERROR;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicateName(cars);
        this.cars = cars;
    }

    public void validateDuplicateName(List<Car> cars) {
        List<Car> uniqueCars = cars.stream()
                .distinct()
                .toList();

        if (cars.size() != uniqueCars.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_ERROR.getMessage());
        }
    }

    public void instructAllCarsToMove() {
        cars.forEach(Car::moveForwardOrHalt);
    }

    public List<Car> getWinningCars() {
        final Car mostActiveCar = getMostActiveCar();

        return cars.stream()
                .filter(car -> car.hasSameMovementCar(mostActiveCar))
                .toList();
    }

    private Car getMostActiveCar() {
        return cars.stream()
                .sorted()
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(NOT_FOUND_CAR_ERROR.getMessage()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
