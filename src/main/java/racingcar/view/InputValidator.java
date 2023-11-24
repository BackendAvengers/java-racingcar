package racingcar.view;

import java.util.regex.Pattern;

import racingcar.util.ErrorMessage;

public class InputValidator {

	private static final Pattern CAR_NAMES_FORMAT = Pattern.compile("^[A-Za-z]+" + "(,[A-Za-z]+)*$");
	private static final Pattern NUMBER_FORMAT = Pattern.compile("\\d+");

	public void validateInputCarName(String inputValue) {
		if (!CAR_NAMES_FORMAT.matcher(inputValue).matches()) {
			throw new IllegalArgumentException(ErrorMessage.PREFIX.getMessage() + "이름은 쉼표(,)로 구분하여 알파벳으로만 입력해주세요.");
		}
	}

	public void validateTryNumber(String inputValue) {
		if (!NUMBER_FORMAT.matcher(inputValue).matches()) {
			throw new IllegalArgumentException(ErrorMessage.PREFIX.getMessage() + "숫자형식이 아닙니다.");
		}
	}

	public void validateIsEmpty(String inputValue) {
		if (isEmpty(inputValue)) {
			throw new IllegalArgumentException(ErrorMessage.PREFIX.getMessage() + "값이 비어있습니다.");
		}
	}

	private boolean isEmpty(String inputValue) {
		return inputValue == null || inputValue.isBlank();
	}
}