package racingcar.domain;

public class Car implements Comparable<Car> {

	private static final int DEFAULT_MOVEMENT_DISTANCE = 1;
	private static final int START_LOCATION = 0;

	private final CarName carName;
	private final CarMoveCondition carMoveCondition;
	private int carLocation;

	public Car(String carName) {
		this.carName = new CarName(carName);
		this.carMoveCondition = new CarMoveCondition();
		this.carLocation = START_LOCATION;
	}

	public void move() {
		carMoveCondition.setCarMoveCondition();

		if (carMoveCondition.checkCarMoveCondition()) {
			carLocation += DEFAULT_MOVEMENT_DISTANCE;
		}
	}

	public boolean isSamePosition(Car other) {
		return other.carLocation == this.carLocation;
	}

	@Override
	public int compareTo(Car other) {
		return this.carLocation - other.carLocation;
	}

	public String getName() {
		return carName.carName();
	}

	public int getCarLocation() {
		return carLocation;
	}
}