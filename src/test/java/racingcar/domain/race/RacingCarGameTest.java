package racingcar.domain.race;

import static fixture.Fixture.createCar;
import static fixture.Fixture.createRacingCar;
import static fixture.Fixture.createRacingCarGame;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.game.RacingCarGame;
import racingcar.domain.round.Round;

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

    @Test
    void 최종우승자를_찾는다() {
        //given
        List<RacingCar> racingCarList = List.of(
                createRacingCar(createCar("name1"), 4),
                createRacingCar(createCar("name2"), 4),
                createRacingCar(createCar("name3"), 3));
        Round round = new Round(10, 10);
        RacingCarGame racingCarGame = new RacingCarGame(racingCarList, round);
        //when
        List<Car> finalWinner = racingCarGame.findFinalWinner();
        //then
        assertThat(finalWinner).hasSize(2)
                .extracting(Car::getName)
                .containsExactly("name1", "name2");
    }
}