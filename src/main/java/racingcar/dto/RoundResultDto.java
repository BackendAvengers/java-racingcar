package racingcar.dto;

import java.util.Collections;
import java.util.List;
import racingcar.domain.RacingCarStatus;

public record RoundResultDto(List<RacingCarStatus> racingCarStatuses) {
    public RoundResultDto(List<RacingCarStatus> racingCarStatuses) {
        this.racingCarStatuses = Collections.unmodifiableList(racingCarStatuses);
    }
}
