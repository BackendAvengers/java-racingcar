package racingcar.config;

import racingcar.controller.RaceCarGameController;
import racingcar.view.input.RaceGameInputView;
import racingcar.view.input.validator.InputValidator;
import racingcar.view.output.RaceGameOutputView;

public class RaceCarControllerConfig {

    public RaceCarGameController getRaceCarController() {
        return new RaceCarGameController(getRaceGameInputView(), getRaceGameOutputView());
    }

    private RaceGameInputView getRaceGameInputView() {
        return new RaceGameInputView(getInputValidator());
    }

    private InputValidator getInputValidator() {
        return new InputValidator();
    }

    private RaceGameOutputView getRaceGameOutputView() {
        return new RaceGameOutputView();
    }
}
