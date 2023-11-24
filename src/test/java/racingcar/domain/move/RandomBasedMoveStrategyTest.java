package racingcar.domain.move;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import racingcar.util.Random;

class RandomBasedMoveStrategyTest {

    private static MockedStatic<Random> random;
    private final MoveStrategy moveStrategy = new RandomBasedMoveStrategy();

    @BeforeAll
    public static void beforeALl() {
        random = mockStatic(Random.class);
    }

    @AfterAll
    public static void afterAll() {
        random.close();
    }

    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    void 값이_3이하라면_움직일수_없다(int number){
        //given
        given(Random.pickNumberInRange(anyInt(), anyInt())).willReturn(number);
        //when
        boolean moveable = moveStrategy.isMoveable();
        //then
        assertThat(moveable).isFalse();
    }

    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    void 값이_4이상이라면_움직일수_있다(int number){
        //given
        given(Random.pickNumberInRange(anyInt(), anyInt())).willReturn(number);
        //when
        boolean moveable = moveStrategy.isMoveable();
        //then
        assertThat(moveable).isTrue();
    }
}