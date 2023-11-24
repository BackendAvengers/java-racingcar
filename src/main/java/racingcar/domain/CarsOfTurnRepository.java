package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class CarsOfTurnRepository {

	private static final Map<Integer, Cars> CARS_OF_TURN = new HashMap<Integer, Cars>();

	private CarsOfTurnRepository() {
	}

	public static void addCars(int turn, Cars cars) {
		CARS_OF_TURN.put(turn, cars);
	}

	public static Cars getCarsOfTurn(int turn) {
		return CARS_OF_TURN.get(turn);
	}
}