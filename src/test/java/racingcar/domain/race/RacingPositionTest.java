package racingcar.domain.race;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RacingPositionTest {

    @Test
    void 전진하면_위치가_바뀐다(){
        //given
        RacingPosition racingPosition = new RacingPosition(0);
        //when
        racingPosition.moveForward();
        //then
        assertThat(racingPosition.getValue()).isEqualTo(1);
    }
}