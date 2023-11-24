package racingcar.domain.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveCounterTest {

    @Test
    @DisplayName("움직임을 세는 객체를 만들 수 있다.")
    public void moveCounterTest() {
        // when
        MoveCounter moveCounter = new MoveCounter();
        // then
        Assertions.assertEquals(moveCounter.getMoveCount(), 0);
    }

    @Test
    @DisplayName("움직임을 하나 증가시킬 수 있다.")
    public void moveCountTest() {
        // given
        MoveCounter moveCounter = new MoveCounter();
        // when
        moveCounter.incrementMoveCount();
        // then
        Assertions.assertEquals(moveCounter.getMoveCount(), 1);
    }

}