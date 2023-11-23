package racingcar.domain.race;

public class RacingPosition {
    private int value;

    public RacingPosition(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void moveForward() {
        ++value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RacingPosition that = (RacingPosition) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
