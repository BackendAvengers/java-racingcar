package racingcar.util;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;

public class RaceCarsFactory {

    public static Cars createCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::from)
                .toList();

        return new Cars(cars);
    }
}
