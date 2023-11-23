package racingcar.domain.race;

import static fixture.Fixture.createRacingCar;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ErrorMessage.INVALID_CAR_NAME_LENGTH;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.move.MoveStrategy;
import racingcar.domain.move.RandomBasedMoveStrategy;
import stub.StubMoveStrategy;

class RacingCarTest {

    @Nested
    class 생성_시 {

        @ValueSource(strings = {"1", "12345"})
        @ParameterizedTest
        void 성공적으로_생성한다(String name) {
            //given
            //when
            RacingCar racingCar = new RacingCar(name, new RacingPosition(0), new StubMoveStrategy());
            //then
            assertThat(racingCar.getName()).isEqualTo(name);
        }

        @ValueSource(strings = {"", "123456"})
        @ParameterizedTest
        void 이름이_비었거나_5글자초과라면_예외를_발생시킨다(String name) {
            //given
            RacingPosition racingPosition = new RacingPosition(0);
            MoveStrategy moveStrategy = new RandomBasedMoveStrategy();
            //when then
            assertThatThrownBy(() -> new RacingCar(name, racingPosition, moveStrategy))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_CAR_NAME_LENGTH.getValue());
        }
    }

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