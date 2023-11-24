package racingcar.view.output;

public enum OutputResultMessage {
    CAR_MOVE_RESULT_FORMAT("%s : %s\n"),
    WINNING_CAR_NAME_FORMAT("최종 우승자 : %s");

    private final String messageFormat;

    OutputResultMessage(String messageFormat) {
        this.messageFormat = messageFormat;
    }

    public String getMessageFormat() {
        return messageFormat;
    }
}
