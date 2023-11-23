package racingcar.view.constants;

public enum Message {
    INPUT_RACING_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TOTAL_ROUND("시도할 회수는 몇회인가요?"),
    GAME_RESULT_HEADER("실행 결과"),
    ROUND_RESULT_CONTENT_FORMAT("%s : %s"),
    RACING_POSITION_CHARACTER("-");

    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
