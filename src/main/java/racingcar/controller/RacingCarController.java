package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.CarMoveService;
import racingcar.service.CreateCarsService;

public class RacingCarController {

	private final CarMoveService carMoveService;
	private final CreateCarsService createCarsService;

	public RacingCarController(CarMoveService carMoveService, CreateCarsService createCarsService) {
		this.carMoveService = carMoveService;
		this.createCarsService = createCarsService;
	}

	public Cars createCars(String[] carNames) {
		return createCarsService.createCars(carNames);
	}

	public void moveCars(Cars cars, int tryNumber) {
		carMoveService.MoveCars(cars, tryNumber);
	}
}