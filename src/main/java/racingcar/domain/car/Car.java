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

    private String getName() {
        return name.getName();
    }

    private int getMoveCounter() {
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

    public static class SingleMoveResultDto {
        private final String carName;
        private final int moveCount;

        private SingleMoveResultDto(String carName, int moveCount) {
            this.carName = carName;
            this.moveCount = moveCount;
        }

        public static SingleMoveResultDto from(Car car) {
            return new SingleMoveResultDto(car.getName(), car.getMoveCounter());
        }

        public String getCarName() {
            return carName;
        }

        public int getMoveCount() {
            return moveCount;
        }
    }

    public static class WinningCarNameDto {
        private final String name;

        private WinningCarNameDto(String name) {
            this.name = name;
        }

        public static WinningCarNameDto from(Car car) {
            return new WinningCarNameDto(car.getName());
        }

        public String getName() {
            return name;
        }
    }

}
