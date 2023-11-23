package racingcar.service;

import static fixture.Fixture.createCars;
import static fixture.Fixture.createRound;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;
import racingcar.domain.race.RacingCarGame;
import racingcar.domain.round.Round;

class RacingCarGameServiceTest {
    private final RacingCarGameService racingCarGameService = new RacingCarGameService();

    @Test
    void 경주할_자동차들과_라운드를_기반으로_새로운_자동차경주게임을_만든다() {
        //given
        int carSize = 3;
        int totalRound = 5;
        Cars cars = createCars(carSize);
        Round round = createRound(totalRound);
        //when
        RacingCarGame racingCarGame = racingCarGameService.createGame(cars, round);
        //then
        assertThat(racingCarGame.getRacingCars()).hasSize(carSize);
        assertThat(racingCarGame.getTotalRound()).isEqualTo(totalRound);
    }
}