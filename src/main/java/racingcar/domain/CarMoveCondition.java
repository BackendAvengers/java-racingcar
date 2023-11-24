package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMoveCondition {

	private static final int MIN_MOVE_CONDITION = 4;
	private static final int DEFAULT_MOVE_CONDITION = 0;
	private static final int MIN_RANGE_NUMBER = 0;
	private static final int MAX_RANGE_NUMBER = 9;

	private int carMoveCondition;

	public CarMoveCondition() {
		this.carMoveCondition = DEFAULT_MOVE_CONDITION;
	}

	public void setCarMoveCondition() {
		carMoveCondition = Randoms.pickNumberInRange(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
	}

	public boolean checkCarMoveCondition() {
		return carMoveCondition >= MIN_MOVE_CONDITION;
	}
}