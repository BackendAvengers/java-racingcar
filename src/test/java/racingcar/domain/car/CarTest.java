package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ErrorMessage.INVALID_CAR_NAME_LENGTH;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @Nested
    class 생성_시 {

        @ValueSource(strings = {"1", "12345"})
        @ParameterizedTest
        void 성공적으로_생성한다(String name) {
            //given
            //when
            Car car = new Car(name);
            //then
            assertThat(car.getName()).isEqualTo(name);
        }

        @ValueSource(strings = {"", "123456"})
        @ParameterizedTest
        void 이름이_비었거나_5글자초과라면_예외를_발생시킨다(String name) {
            //given
            //when then
            assertThatThrownBy(() -> new Car(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_CAR_NAME_LENGTH.getValue());
        }
    }
}