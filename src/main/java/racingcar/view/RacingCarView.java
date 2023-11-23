package racingcar.view;

import racingcar.io.ConsoleReader;
import racingcar.io.ConsoleWriter;
import racingcar.view.constants.Message;

public class RacingCarView {
    private final ConsoleReader consoleReader;
    private final ConsoleWriter consoleWriter;

    public RacingCarView(ConsoleReader consoleReader, ConsoleWriter consoleWriter) {
        this.consoleReader = consoleReader;
        this.consoleWriter = consoleWriter;
    }

    private String input(String message){
        consoleWriter.println(message);
        return consoleReader.readLine();
    }

    public String inputRacingCarNames(){
        return input(Message.INPUT_RACING_CAR_NAMES.getValue());
    }
}
