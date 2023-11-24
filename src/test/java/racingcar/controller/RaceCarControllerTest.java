package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.OutputTestSupport;
import racingcar.config.RaceCarControllerConfig;
import racingcar.util.Randoms;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class RaceCarControllerTest extends OutputTestSupport {

    private RaceCarController controller = new RaceCarControllerConfig().getRaceCarController();

    @Test
    @DisplayName("게임 진행을 Mock을 이용해서 테스트할 수 있다.")
    public void RaceCarControllerMoveTest() {
        // given
        String result = """
                경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
                시도할 회수는 몇회인가요?
                                
                실행 결과
                hw : -
                                
                hw : --
                                
                최종 우승자 : hw
                """;

        System.setIn(new ByteArrayInputStream("hw\n2".getBytes()));

        try (final MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            BDDMockito.given(Randoms.getNumber()).willReturn(4);
            //when
            controller.run();
        }
        //then
        assertThat(getOutput()).isEqualTo(result);
    }

    @Test
    @DisplayName("게임 진행을 Mock을 이용해서 테스트할 수 있다.")
    public void RaceCarControllerStopTest() {
        // given
        String result = """
                경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
                시도할 회수는 몇회인가요?
                                
                실행 결과
                hw :\s
                                
                hw :\s
                                
                최종 우승자 : hw
                """;
        System.setIn(new ByteArrayInputStream("hw\n2".getBytes()));

        try (final MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            BDDMockito.given(Randoms.getNumber()).willReturn(3);
            //when
            controller.run();
        }
        //then
        assertThat(getOutput()).isEqualTo(result);
    }

}