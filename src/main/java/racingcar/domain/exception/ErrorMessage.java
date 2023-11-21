package racingcar.domain.exception;

public enum ErrorMessage {

    PREFIX("[ERROR] %s"),
    NAME_LENGTH_ERROR("이름은 5자 이하만 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(PREFIX.message, message);
    }
}
