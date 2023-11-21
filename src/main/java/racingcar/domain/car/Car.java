package racingcar.domain.car;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final Name name;
    private final MoveCounter moveCounter;

    private Car(String name) {
        this.name = new Name(name);
        this.moveCounter = new MoveCounter();
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public void moveForwardOrHalt() {
        if (MoveSupport.isMoveAllowed()) {
            moveCounter.incrementMoveCount();
        }
    }

    public boolean hasSameMovementCar(Car other) {
        return moveCounter.hasSameMoveCount(other.moveCounter);
    }

    @Override
    public int compareTo(Car other) {
        return moveCounter.compareTo(other.moveCounter);
    }

    public String getName() {
        return name.getName();
    }

    public int getMoveCounter() {
        return moveCounter.getMoveCount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(moveCounter, car.moveCounter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, moveCounter);
    }

}
