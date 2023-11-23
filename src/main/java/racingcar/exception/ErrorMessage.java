package racingcar.exception;

public enum ErrorMessage {
    INVALID_CHARACTER_IN_RACING_CAR_NAME("자동차 이름은 알파벳 대소문자와 숫자만 포함되어야 합니다."),
    INVALID_CAR_NAME_LENGTH("자동차 이름은 1자 이상 5자 이하입니다."),
    INVALID_CHARACTER_IN_TOTAL_ROUND("시도 횟수는 숫자여야 합니다."),
    INVALID_TOTAL_ROUND_RANGE("시도 횟수는 1 이상 10000 이하입니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getValue(int arg) {
        return value + ": " + arg;
    }
}
