package racingcar.domain;

import java.util.Collections;
import java.util.List;

import racingcar.util.ErrorMessage;

public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void move() {
		cars.stream()
		.forEach(Car::move);
	}

	public List<String> findWinners() {
		final Car maxPositionCar = findMaxPositionCar();
		return findSamePositionCar(maxPositionCar);
	}

	private Car findMaxPositionCar() {
		Car maxPositionCar = cars.stream()
				.max(Car::compareTo)
				.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.PREFIX.getMessage() + "차량 리스트가 비었습니다."));

		return maxPositionCar;
	}

	private List<String> findSamePositionCar(Car maxPositionCar) {
		return cars.stream()
				.filter(maxPositionCar::isSamePosition)
				.map(Car::getName)
				.toList();
	}

	public List<Car> toList() {
		return Collections.unmodifiableList(cars);
	}
}