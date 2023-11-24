package racingcar.service;

import java.util.Arrays;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CreateCarsService {

	public Cars createCars(String[] carNames) {
		return new Cars(Arrays.stream(carNames)
				.map(Car::new)
				.toList());
	}
}