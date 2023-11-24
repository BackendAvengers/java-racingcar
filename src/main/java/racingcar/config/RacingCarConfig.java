package racingcar.config;

import racingcar.RacingCar;
import racingcar.controller.RacingCarController;
import racingcar.io.ViewPrinter;
import racingcar.io.ViewReader;
import racingcar.service.CarMoveService;
import racingcar.service.CreateCarsService;
import racingcar.view.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarConfig {

	public RacingCar racingCar() {
		return new RacingCar(racingCarController(), inputView(), outputView());
	}

	private RacingCarController racingCarController() {
		return new RacingCarController(carMoveService(), createCarsService());
	}

	private CarMoveService carMoveService() {
		return new CarMoveService();
	}

	private CreateCarsService createCarsService() {
		return new CreateCarsService();
	}

	private InputView inputView() {
		return new InputView(reader(), printer(), inputValidator());
	}

	private OutputView outputView() {
		return new OutputView(printer());
	}

	private ViewReader reader() {
		return new ViewReader();
	}

	private ViewPrinter printer() {
		return new ViewPrinter();
	}

	private InputValidator inputValidator() {
		return new InputValidator();
	}
}