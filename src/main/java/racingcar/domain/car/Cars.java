package racingcar.domain.car;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static racingcar.domain.car.exception.ErrorMessage.DUPLICATE_CAR_NAME_ERROR;
import static racingcar.domain.car.exception.ErrorMessage.MOVE_VALUE_ERROR;
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

    // random 테스트를 컨트롤러만 해주기 위해서 자동차 개수만큼 random값을 받아서 전달합니다. (ㅜㅜ 의견 주세요)
    public void instructAllCarsToMove(List<Integer> moveValues) {
        if (cars.size() != moveValues.size()) {
            throw new IllegalStateException(MOVE_VALUE_ERROR.getMessage());
        }

        IntStream.range(0, cars.size())
                .forEach(i -> cars.get(i).moveForwardOrHalt(moveValues.get(i)));
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
