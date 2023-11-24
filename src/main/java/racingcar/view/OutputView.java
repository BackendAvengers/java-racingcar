package racingcar.view;

import java.util.List;
import java.util.StringJoiner;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.CarsOfTurnRepository;
import racingcar.io.ViewPrinter;

public class OutputView {

	private static final String NEW_LINE = System.lineSeparator();
	private static final String MINUS_LETTER = "-";
	private static final String EXECUTION_RESULT_MESSAGE = "실행결과";
	private static final String NOTHING = "없음";
	private static final String WINNER_MESSAGE = "최종 우승자 : ";
	private static final String WINNER_MESSAGE_DELIMITER = ", ";

	private final ViewPrinter printer;

	public OutputView(ViewPrinter printer) {
		this.printer = printer;
		;
	}

	public void printExecutionResult(int tryNumber) {
		StringJoiner gameResultMessage = new StringJoiner(NEW_LINE);
		gameResultMessage.add(NEW_LINE + EXECUTION_RESULT_MESSAGE);

		if (tryNumber == 0) {
			gameResultMessage.add(NOTHING + NEW_LINE);
		}

		for (int turn = 1; turn <= tryNumber; turn++) {
			List<Car> cars = CarsOfTurnRepository.getCarsOfTurn(turn).toList();
			gameResultMessage.add(convertCarsToMessage(cars));
		}

		printer.printLine(gameResultMessage.toString());
	}

	private String convertCarsToMessage(List<Car> cars) {
		StringJoiner carsMessage = new StringJoiner(NEW_LINE);

		for (Car car : cars) {
			String carName = car.getName();
			String carLocationLetter = convertCarLocationToMinusLetter(car.getCarLocation());

			carsMessage.add(String.format("%s : %s", carName, carLocationLetter));
		}

		carsMessage.add("");

		return carsMessage.toString();
	}

	private String convertCarLocationToMinusLetter(int carLocation) {
		return MINUS_LETTER.repeat(carLocation);
	}

}