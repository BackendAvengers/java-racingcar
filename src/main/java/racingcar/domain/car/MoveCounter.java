package racingcar.domain.car;

public class MoveCounter implements Comparable<MoveCounter> {

    private int moveCount;

    public void incrementMoveCount() {
        moveCount += 1;
    }

    public boolean hasSameMoveCount(MoveCounter other) {
        return this.moveCount == other.moveCount;
    }

    @Override
    public int compareTo(MoveCounter other) {
        return other.moveCount - this.moveCount;
    }

    @Override
    public String toString() {
        return "MoveCounter{" +
                "moveCount=" + moveCount +
                '}';
    }
}
