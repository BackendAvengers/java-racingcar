package racingcar.view.input;

import racingcar.view.input.message.RaceGameMessage;
import racingcar.view.input.validator.InputValidator;

import java.util.List;

public class RaceGameInputView extends ConsoleRaceGameInput {

    private final InputValidator validator;

    public RaceGameInputView(InputValidator validator) {
        this.validator = validator;
    }

    @Override
    public List<String> requestCarNames() {
        System.out.println(RaceGameMessage.CAR_NAME_MESSAGE.getMessage());
        List<String> carNames = getCarNames();
        validator.validateCarNames(carNames);
        return carNames;
    }

    private List<String> getCarNames() {
        return List.of(readLine().replaceAll(" ", "").split(","));
    }

    @Override
    public int requestMoveAttempts() {
        System.out.println(RaceGameMessage.MOVE_ATTEMPTS_MESSAGE.getMessage());
        int moveAttempts = validateNumber(readLine());
        close();
        newLine();
        return moveAttempts;
    }

    private int validateNumber(String requestMoveAttempts) {
        validator.validateNumber(requestMoveAttempts);
        int moveAttempts = Integer.parseInt(requestMoveAttempts);
        validator.validateNumber(moveAttempts);
        return moveAttempts;
    }

    private void newLine() {
        System.out.println();
    }

}
