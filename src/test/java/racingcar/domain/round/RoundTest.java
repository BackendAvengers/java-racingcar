package racingcar.domain.round;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ErrorMessage.INVALID_TOTAL_ROUND_RANGE;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @Nested
    class 생성_시 {

        @ValueSource(ints = {1, 10000})
        @ParameterizedTest
        void 성공적으로_생성한다(int totalRound) {
            //given
            //when
            Round round = new Round(totalRound, 0);
            //then
            assertThat(round.getTotalRound()).isEqualTo(totalRound);
        }

        @ValueSource(ints = {0, 10001})
        @ParameterizedTest
        void 시도횟수가_1미만이거나_10000초과라면_예외를_발생시킨다(int totalRound) {
            //given
            //when then
            assertThatThrownBy(() -> new Round(totalRound, 0))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_TOTAL_ROUND_RANGE.getValue());
        }
    }

    @Nested
    class 다음_라운드가_있는지_확인시 {

        @Test
        void 현재라운드가_마지막라운드라면_다음라운드는_없다() {
            //given
            int totalRound = 10;
            int currentRound = 10;
            Round round = new Round(totalRound, currentRound);
            //when
            boolean result = round.hasNext();
            //then
            assertThat(result).isFalse();
        }

        @Test
        void 현재라운드가_마지막라운드가_아니라면_다음라운드가_있다() {
            //given
            int totalRound = 10;
            int currentRound = 9;
            Round round = new Round(totalRound, currentRound);
            //when
            boolean result = round.hasNext();
            //then
            assertThat(result).isTrue();
        }
    }

    @Nested
    class 다음_라운드로_넘어갈_시 {

        @Test
        void 현재라운드가_마지막라운드가_아니라면_다음라운드로_넘어간다() {
            //given
            int totalRound = 10;
            int currentRound = 9;
            Round round = new Round(totalRound, currentRound);
            //when
            round.next();
            //then
            assertThat(round.getCurrentRound()).isEqualTo(10);
        }

        @Test
        void 현재라운드가_마지막라운드라면_예외를_발생시킨다() {
            //given
            int totalRound = 10;
            int currentRound = 10;
            Round round = new Round(totalRound, currentRound);
            //when then
            assertThatThrownBy(round::next)
                    .isInstanceOf(IllegalStateException.class);
        }
    }
}