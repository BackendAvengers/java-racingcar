package racingcar.view.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.OutputTestSupport;
import racingcar.view.input.message.RaceGameMessage;
import racingcar.view.input.validator.InputValidator;

import java.io.ByteArrayInputStream;
import java.util.List;


class RaceGameInputViewTest extends OutputTestSupport {

    private RaceGameInputView inputView = new RaceGameInputView(new InputValidator());

    @AfterEach
    void tearDown(){
        inputView.close();
    }
    
    @Test
    @DisplayName("사용자에게 자동차의 이름을 묻는 메시지를 출력할 수 있다.")
    public void requestCarNamesMessage() {
        // given
        String result = RaceGameMessage.CAR_NAME_MESSAGE.getMessage();
        System.setIn(new ByteArrayInputStream("hw,qw".getBytes()));
        // when
        inputView.requestCarNames();
        // then
        Assertions.assertThat(getOutput().trim()).isEqualTo(result);
    }

    @Test
    @DisplayName("사용자에게 자동차의 이름을 물어볼 수 있다.")
    public void requestCarNames() {
        // given
        String input = "hw,qw";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when
        List<String> carNames = inputView.requestCarNames();
        // then
        Assertions.assertThat(carNames)
                .contains("hw", "qw");
    }

    @Test
    @DisplayName("시도 횟수를 물어보는 메시지를 출력할 수 있다.")
    public void requestMoveAttemptsMessage() {
        // given
        String result = RaceGameMessage.MOVE_ATTEMPTS_MESSAGE.getMessage();
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        // when
        inputView.requestMoveAttempts();
        // then
        Assertions.assertThat(getOutput().trim()).isEqualTo(result);
    }

    @Test
    @DisplayName("시도 횟수를 물어볼 수 있다.")
    public void requestMoveAttempts() {
        // given
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        // when
        int result = inputView.requestMoveAttempts();
        // then
        Assertions.assertThat(result).isEqualTo(2);
    }
}