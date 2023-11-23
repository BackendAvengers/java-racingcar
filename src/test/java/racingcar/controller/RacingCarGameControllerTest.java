package racingcar.controller;

import static fixture.Fixture.createCars;
import static fixture.Fixture.createRound;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;
import racingcar.domain.game.RacingCarGame;
import racingcar.domain.round.Round;

class RacingCarGameControllerTest {
    private final RacingCarGameController controller = new RacingCarGameController();

    @Test
    void 경주할_자동차들과_라운드를_기반으로_새로운_자동차경주게임을_만든다() {
        //given
        int carSize = 3;
        int totalRound = 5;
        Cars cars = createCars(carSize);
        Round round = createRound(totalRound);
        //when
        RacingCarGame racingCarGame = controller.createGame(cars, round);
        //then
        assertThat(racingCarGame.getRacingCars()).hasSize(carSize);
        assertThat(racingCarGame.getTotalRound()).isEqualTo(totalRound);
    }

    @Test
    void 자동차경주게임을_시도횟수만큼_수행한다() {
        //given
        int carSize = 3;
        int totalRound = 5;
        Cars cars = createCars(carSize);
        Round round = createRound(totalRound);
        RacingCarGame racingCarGame = controller.createGame(cars, round);
        //when
        controller.playGame(racingCarGame);
        //then
        assertThat(racingCarGame.getRacingCars()).hasSize(carSize);
        assertThat(racingCarGame.getCurrentRound()).isEqualTo(totalRound);
    }
}