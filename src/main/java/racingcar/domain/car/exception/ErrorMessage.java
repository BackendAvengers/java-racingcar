package racingcar.domain.car.exception;

public enum ErrorMessage {

    PREFIX("[ERROR] %s"),
    NAME_LENGTH_ERROR("이름은 5자 이하만 가능합니다."),
    NOT_FOUND_CAR_ERROR("자동차가 존재하지 않습니다."),
    DUPLICATE_CAR_NAME_ERROR("중복된 자동차 이름이 있습니다."),
    MOVE_VALUE_ERROR("차량을 움직일 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(PREFIX.message, message);
    }
}
