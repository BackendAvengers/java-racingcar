package racingcar;

import racingcar.config.RaceCarControllerConfig;
import racingcar.controller.RaceCarController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceCarControllerConfig controllerConfig = new RaceCarControllerConfig();
        RaceCarController raceCarController = controllerConfig.getRaceCarController();

        raceCarController.run();
    }
}
