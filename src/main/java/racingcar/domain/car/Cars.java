package racingcar.domain.car;

import static racingcar.domain.race.RacingCarConstraints.isValidCarsSize;
import static racingcar.exception.ErrorMessage.DUPLICATED_CAR_NAME;
import static racingcar.exception.ErrorMessage.INVALID_CARS_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateSize(cars);
        validateUnique(cars);

        this.cars = cars;
    }

    private void validateSize(List<Car> racingCars) {
        if (!isValidCarsSize(racingCars)) {
            throw new IllegalArgumentException(INVALID_CARS_SIZE.getValue(racingCars.size()));
        }
    }

    private void validateUnique(List<Car> racingCars) {
        Set<Car> uniqueCars = new HashSet<>(racingCars);
        if (uniqueCars.size() != racingCars.size()) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAME.getValue());
        }
    }

    public List<Car> getRacingCars() {
        return cars;
    }
}
