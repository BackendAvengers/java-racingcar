package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.exception.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;

class NameTest {

    @Test
    @DisplayName("이름을 저장할 수 있다.")
    public void nameLengthTest() {
        // given
        String name = "12345";
        // when
        Name result = new Name(name);
        // then
        assertThat(result.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("이름이 5글자를 넘어가면 예외가 발생한다.")
    public void nameLengthExceptionTest() {
        // given
        String name = "123456";
        // when // then
        Assertions.assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NAME_LENGTH_ERROR.getMessage());
    }

}