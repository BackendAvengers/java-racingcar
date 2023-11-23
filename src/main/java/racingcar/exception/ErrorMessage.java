package racingcar.exception;

public enum ErrorMessage {
    INVALID_CHARACTER_IN_RACING_CAR_NAME("자동차 이름은 알파벳 대소문자와 숫자만 가능합니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
