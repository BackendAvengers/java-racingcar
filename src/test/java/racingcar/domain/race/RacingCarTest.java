package racingcar.domain.race;

import static fixture.Fixture.createRacingCar;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    void 움직일수_없다면_자동차가_멈춘다() {
        //given
        RacingCar racingCar = createRacingCar("car", false);
        //when
        racingCar.moveForwardOrStop();
        //then
        assertThat(racingCar.getRacingPosition()).isEqualTo(new RacingPosition(0));
    }

    @Test
    void 움직일수_있다면_자동차가_전진한다() {
        //given
        RacingCar racingCar = createRacingCar("car", true);
        //when
        racingCar.moveForwardOrStop();
        //then
        assertThat(racingCar.getRacingPosition()).isEqualTo(new RacingPosition(1));
    }

}