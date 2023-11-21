package racingcar;

import racingcar.config.RaceCarControllerConfig;
import racingcar.controller.RaceCarGameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceCarControllerConfig controllerConfig = new RaceCarControllerConfig();
        RaceCarGameController raceCarController = controllerConfig.getRaceCarController();

        raceCarController.run();
    }
}
