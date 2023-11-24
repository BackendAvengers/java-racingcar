package racingcar.domain;

import racingcar.util.ErrorMessage;

public record CarName(String carName) {

	private static final int MIN_NAME_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 5;

	public CarName {
		validateOutOfNameLength(carName);
	}

	private void validateOutOfNameLength(String carName) {
		if (isOutOfNameLength(carName.length())) {
			throw new IllegalArgumentException(ErrorMessage.PREFIX.getMessage() + "자동차 이름의 길이는 1이상 5이하여야합니다.");
		}
	}

	private boolean isOutOfNameLength(int carNameLength) {
		return carNameLength > MAX_NAME_LENGTH || carNameLength < MIN_NAME_LENGTH;
	}
}