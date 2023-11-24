package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCar {

	private final RacingCarController controller;
	private final InputView inputView;
	private final OutputView outputView;

	public RacingCar(RacingCarController controller, InputView inputView, OutputView outputView) {
		this.controller = controller;
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		String[] carNames = inputView.inputCarNames();
		Cars cars = controller.createCars(carNames);
		int tryNumber = inputView.inputTryNumber();

		controller.moveCars(cars, tryNumber);
		outputView.printExecutionResult(tryNumber);
		outputView.printWinner(cars);
	}
}