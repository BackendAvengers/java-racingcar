package racingcar.domain.race;

import static fixture.Fixture.createRacingCarGame;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RacingCarGameTest {

    @Test
    void 한_라운드를_실행한다() {
        //given`
        RacingCarGame racingCarGame = createRacingCarGame(3, 5);
        //when
        racingCarGame.proceedRound();
        //then
        assertThat(racingCarGame.getCurrentRound()).isEqualTo(1);
    }

    @Test
    void 게임이_종료되었는지_확인한다() {
        //given`
        RacingCarGame racingCarGame = createRacingCarGame(3, 2);
        racingCarGame.proceedRound();
        racingCarGame.proceedRound();
        //when
        boolean result = racingCarGame.isFinished();
        //then
        assertThat(result).isTrue();
    }
}