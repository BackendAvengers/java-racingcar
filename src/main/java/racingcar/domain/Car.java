package racingcar.domain;

public class Car implements Comparable<Car> {

    private final Name name;
    private final MoveCounter moveCounter;

    public Car(String name) {
        this.name = new Name(name);
        this.moveCounter = new MoveCounter();
    }

    public void moveForwardOrHalt(int controlValue) {
        if (MoveSupport.isMoveAllowed(controlValue)) {
            moveCounter.incrementMoveCount();
        }
    }

    public boolean hasSameCar(Car other) {
        return moveCounter.hasSameMoveCount(other.moveCounter);
    }

    @Override
    public int compareTo(Car other) {
        return moveCounter.compareTo(other.moveCounter);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", moveCounter=" + moveCounter +
                '}';
    }
}
