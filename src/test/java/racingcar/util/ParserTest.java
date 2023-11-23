package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ErrorMessage.INVALID_CHARACTER_IN_RACING_CAR_NAME;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

    @Nested
    class 경주할_자동차_이름_입력값을_파싱 {

        @Test
        void 정상적인_입력값이라면_파싱에_성공한다(){
            //given
            String input = "pobi,woni,jun";
            //when
            List<String> result = Parser.parseRacingCarNames(input);
            //then
            assertThat(result).hasSize(3)
                    .containsExactly("pobi", "woni", "jun");
        }

        @ValueSource(strings = {"이름1,이름2", "이름*,이름@@"})
        @ParameterizedTest
        void 유효하지않은_문자_포함된_입력값이라면_예외를_발생시킨다(String input){
            //given
            //when then
            assertThatThrownBy(() -> Parser.parseRacingCarNames(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_CHARACTER_IN_RACING_CAR_NAME.getValue());
        }
    }
}