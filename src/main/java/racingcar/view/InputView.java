package racingcar.view;

import racingcar.io.ViewPrinter;
import racingcar.io.ViewReader;

public class InputView {

	private static final String DELIMETER = ",";
	private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_TRY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

	private final ViewReader reader;
	private final ViewPrinter printer;
	private final InputValidator validator;

	public InputView(ViewReader reader, ViewPrinter printer, InputValidator validator) {
		this.reader = reader;
		this.printer = printer;
		this.validator = validator;
	}

	public String[] inputCarNames() {
		printer.printLine(INPUT_CAR_NAME_MESSAGE);
		String carNames = reader.readLine();

		validateInputCarNames(carNames);

		return carNames.split(DELIMETER);
	}

	public int inputTryNumber() {
		printer.printLine(INPUT_TRY_NUMBER_MESSAGE);
		String tryNumber = reader.readLine();

		validateInputTryNumber(tryNumber);

		return Integer.parseInt(tryNumber);
	}

	private void validateInputCarNames(String inputValue) {
		validator.validateIsEmpty(inputValue);
		validator.validateInputCarName(inputValue);
	}

	private void validateInputTryNumber(String inputValue) {
		validator.validateIsEmpty(inputValue);
		validator.validateTryNumber(inputValue);
	}
}