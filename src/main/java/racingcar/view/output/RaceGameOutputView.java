package racingcar.view.output;

import racingcar.controller.dto.SingleMoveResultDto;
import racingcar.controller.dto.WinningCarNameDto;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.view.output.OutputResultMessage.CAR_MOVE_RESULT_FORMAT;
import static racingcar.view.output.OutputResultMessage.WINNING_CAR_NAME_FORMAT;

public class RaceGameOutputView {

    private static final String CAR_MOVE_SYMBOL = "-";
    private static final String RESULT_MESSAGE = "실행 결과";

    public void displayResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void displayCarsMoveResult(List<SingleMoveResultDto> moveResults) {
        StringBuilder sb = new StringBuilder();

        moveResults.stream()
                .map(this::getResultMessage)
                .forEach(sb::append);

        System.out.println(sb);
    }

    private String getResultMessage(SingleMoveResultDto moveResult) {
        String carName = moveResult.getCarName();
        String moveSymbol = generateDashString(moveResult.getMoveCount());

        return String.format(CAR_MOVE_RESULT_FORMAT.getMessageFormat(), carName, moveSymbol);
    }

    private String generateDashString(int moveCount) {
        return CAR_MOVE_SYMBOL.repeat(moveCount);
    }

    public void displayWinningCars(List<WinningCarNameDto> winningCarNames) {
        System.out.println(getWinningCarNamesFormat(winningCarNames));
    }

    private String getWinningCarNamesFormat(List<WinningCarNameDto> winningCarsName) {
        String joinCarsName = winningCarsName.stream()
                .map(WinningCarNameDto::getName)
                .collect(Collectors.joining(", "));

        return String.format(WINNING_CAR_NAME_FORMAT.getMessageFormat(), joinCarsName);
    }


}
