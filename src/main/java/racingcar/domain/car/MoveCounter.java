package racingcar.domain.car;

import java.util.Objects;

public class MoveCounter implements Comparable<MoveCounter> {

    private int moveCount;

    public void incrementMoveCount() {
        moveCount += 1;
    }

    public boolean hasSameMoveCount(MoveCounter other) {
        return this.equals(other);
    }

    @Override
    public int compareTo(MoveCounter other) {
        return other.moveCount - this.moveCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoveCounter that = (MoveCounter) o;
        return moveCount == that.moveCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(moveCount);
    }

}
