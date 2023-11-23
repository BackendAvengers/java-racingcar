package stub;

import org.mockito.Mock;
import racingcar.domain.move.MoveStrategy;

public class StubMoveStrategy implements MoveStrategy {
    private boolean isMoveable;

    @Override
    public boolean isMoveable() {
        return isMoveable;
    }

    public void setMoveable(boolean isMoveable) {
        this.isMoveable = isMoveable;
    }
}
