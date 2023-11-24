package racingcar.view.output;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.OutputTestSupport;
import racingcar.domain.car.Car;

import java.util.List;

class RaceGameOutputViewTest extends OutputTestSupport {

    private RaceGameOutputView outputView = new RaceGameOutputView();

    @Test
    @DisplayName("실행 결과를 출력하는 시작 메시지를 출력할 수 있다.")
    public void displayResultMessage() {
        // given
        String result = "실행 결과";
        // when
        outputView.displayResultMessage();
        // then
        Assertions.assertEquals(result, getOutput().trim());
    }

    @Test
    @DisplayName("자동차 총 시도 횟수를 출력할 수 있다.")
    public void displayCarsMoveResult() {
        // given
        List<Car.SingleMoveResultDto> request = List.of(Car.SingleMoveResultDto.from(Car.from("hw")));
        String result = "hw :";
        // when
        outputView.displayCarsMoveResult(request);
        // then
        Assertions.assertEquals(result, getOutput().trim());
    }

    @Test
    @DisplayName("최종 우승한 자동차를 출력할 수 있다.")
    public void displayWinningCars() {
        // given
        List<Car.WinningCarNameDto> request = List.of(Car.WinningCarNameDto.from(Car.from("hw")));
        String result = String.format(OutputResultMessage.WINNING_CAR_NAME_FORMAT.getMessageFormat(), "hw");
        // when
        outputView.displayWinningCars(request);
        // then
        Assertions.assertEquals(result, getOutput().trim());
    }

}