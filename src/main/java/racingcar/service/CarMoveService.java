package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.CarsOfTurnRepository;

public class CarMoveService {

	public void MoveCars(Cars cars, int tryNumber) {
		for (int turn = 1; turn <= tryNumber; turn++) {
			cars.move();
			CarsOfTurnRepository.addCars(turn, cars);
		}
	}
}