package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.race.RacingCarStatus;
import racingcar.dto.FinalWinnerDto;
import racingcar.dto.RoundResultDto;
import racingcar.io.ConsoleReader;
import racingcar.io.ConsoleWriter;
import racingcar.view.constants.Message;

public class RacingCarView {
    private static final String LINE_SEPARATOR = System.lineSeparator();

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

    public String inputTotalRound(){
        return input(Message.INPUT_TOTAL_ROUND.getValue());
    }

    private String formatMessagesWithNewLine(String... messages){
        return String.join(LINE_SEPARATOR, messages);
    }

    public void outputGameResultHeader(){
        String message = formatMessagesWithNewLine("", Message.GAME_RESULT_HEADER.getValue());
        consoleWriter.println(message);
    }

    public void outputRoundResult(RoundResultDto roundResultDto){
        List<RacingCarStatus> racingCarStatuses = roundResultDto.racingCarStatuses();
        String roundResultMessage = getRoundResultMessage(racingCarStatuses);
        String message = formatMessagesWithNewLine("", roundResultMessage);
        consoleWriter.println(message);
    }

    private String getRoundResultMessage(List<RacingCarStatus> racingCarStatuses) {
        return racingCarStatuses.stream()
                .map(status -> String.format(Message.ROUND_RESULT_CONTENT_FORMAT.getValue(),
                        status.getName(),
                        Message.RACING_POSITION_CHARACTER.getValue().repeat(status.getPosition())))
                .collect(Collectors.joining(LINE_SEPARATOR));
    }

    public void outputFinalWinner(FinalWinnerDto finalWinnerDto){
        List<String> winnerNames = finalWinnerDto.winnerNames();
        String message = String.join(", ", winnerNames);
        consoleWriter.println(message);
    }
}
