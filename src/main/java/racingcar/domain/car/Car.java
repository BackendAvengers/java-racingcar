package racingcar.domain.car;

public class Car {

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

}
