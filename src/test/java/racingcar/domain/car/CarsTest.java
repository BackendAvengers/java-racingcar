package racingcar.domain.car;

import static fixture.Fixture.createCarList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ErrorMessage.DUPLICATED_CAR_NAME;
import static racingcar.exception.ErrorMessage.INVALID_CARS_SIZE;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

    @Nested
    class 생성_시 {

        @Test
        void 성공적으로_생성한다() {
            //given
            List<Car> racingCarList = createCarList("name1", "name2", "name3");
            //when
            Cars cars = new Cars(racingCarList);
            //then
            assertThat(cars.getRacingCars()).hasSize(3);
        }

        @Test
        void 중복된_이름이_있다면_예외를_발생시킨다() {
            //given
            List<Car> racingCarList = createCarList("name1", "name2", "name2");
            //when then
            assertThatThrownBy(() -> new Cars(racingCarList))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(DUPLICATED_CAR_NAME.getValue());
        }

        @ValueSource(ints = {1, 101})
        @ParameterizedTest
        void 크기가_2미만이거나_100초과라면_예외를_발생시킨다(int size) {
            //given
            List<Car> racingCarList = createCarList(size);
            //when then
            assertThatThrownBy(() -> new Cars(racingCarList))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_CARS_SIZE.getValue());
        }
    }
}