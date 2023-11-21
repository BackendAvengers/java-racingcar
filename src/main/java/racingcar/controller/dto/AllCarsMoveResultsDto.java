package racingcar.controller.dto;

import java.util.List;

public class AllCarsMoveResultsDto {

    private final List<SingleMoveResultDto> carResults;

    public AllCarsMoveResultsDto(List<SingleMoveResultDto> carResults) {
        this.carResults = carResults;
    }

    public List<SingleMoveResultDto> getCarResults() {
        return carResults;
    }
}
