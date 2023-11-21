package racingcar.view.input.validator;

public enum ValidationErrorMessage {
    PREFIX("[ERROR] %s"),
    NOT_NUMERIC_ERROR("숫자가 아닙니다."),
    EMPTY_NAME_ERROR("이름은 공백이거나 비어있을 수 없습니다.");


    private final String message;

    ValidationErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(PREFIX.message, message);
    }
}
