package racingcar.view.input;

import racingcar.view.input.message.RaceGameMessage;
import racingcar.view.input.validator.InputValidator;

import java.util.List;

public class RaceGameInputView extends ConsoleInput {

    private final InputValidator validator;

    public RaceGameInputView(InputValidator validator) {
        this.validator = validator;
    }

    public List<String> requestCarNames() {
        System.out.println(RaceGameMessage.CAR_NAME_MESSAGE);
        List<String> carNames = getCarNames();
        validator.validateCarNames(carNames);
        return carNames;
    }

    private List<String> getCarNames() {
        return List.of(readLine().replaceAll(" ", "").split(","));
    }

    public int requestMoveAttempts() {
        System.out.println(RaceGameMessage.MOVE_ATTEMPTS_MESSAGE);
        String moveAttempts = readLine();
        validator.validateNumber(moveAttempts);
        return Integer.parseInt(moveAttempts);
    }

}
