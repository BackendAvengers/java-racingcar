package racingcar;

import racingcar.config.RacingCarConfig;

public class Application {
	public static void main(String[] args) {
		RacingCar racingCar = new RacingCarConfig().racingCar();

		racingCar.run();
	}
}