package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RaceCarsFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("모든 자동차를 입력받은 값에 따라서 움직일 수 있다.")
    public void instructAllCarsToMove() {
        // given
        Cars cars = RaceCarsFactory.createCars(List.of("hw", "kk"));
        List<Integer> values = List.of(4, 4);
        // when
        cars.instructAllCarsToMove(values);
        // then
        List<Car> moveCar = cars.getCars();
        Assertions.assertThat(moveCar)
                .extracting("name", "moveCounter")
                .contains(
                        Tuple.tuple("hw", 1),
                        Tuple.tuple("kk", 1)
                );
    }

    @Test
    @DisplayName("모든 자동차를 입력받은 값에 따라서 멈출 수 있다.")
    public void instructAllCarsToStop() {
        // given
        Cars cars = RaceCarsFactory.createCars(List.of("hw", "kk"));
        List<Integer> values = List.of(3, 3);
        // when
        cars.instructAllCarsToMove(values);
        // then
        List<Car> moveCar = cars.getCars();
        Assertions.assertThat(moveCar)
                .extracting("name", "moveCounter")
                .contains(
                        Tuple.tuple("hw", 0),
                        Tuple.tuple("kk", 0)
                );
    }

    @Test
    @DisplayName("우승한 자동차를 얻어올 수 있다.")
    public void getWinningCar() {
        // given
        Cars cars = RaceCarsFactory.createCars(List.of("hw", "kk"));
        cars.instructAllCarsToMove(List.of(3, 5));
        // when
        List<Car> winningCars = cars.getWinningCars();
        // then
        Assertions.assertThat(winningCars).hasSize(1)
                .extracting("name", "moveCounter")
                .contains(
                        Tuple.tuple("kk", 1)
                );
    }

    @Test
    @DisplayName("우승한 자동차들을 얻어올 수 있다.")
    public void getWinningCars() {
        // given
        Cars cars = RaceCarsFactory.createCars(List.of("hw", "kk"));
        cars.instructAllCarsToMove(List.of(4, 4));
        // when
        List<Car> winningCars = cars.getWinningCars();
        // then
        Assertions.assertThat(winningCars).hasSize(2)
                .extracting("name", "moveCounter")
                .contains(
                        Tuple.tuple("hw", 1),
                        Tuple.tuple("kk", 1)
                );
    }

}