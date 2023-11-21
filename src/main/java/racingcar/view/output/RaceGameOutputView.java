package racingcar.view.output;

import racingcar.controller.dto.AllCarsMoveResultsDto;
import racingcar.controller.dto.SingleMoveResultDto;

import java.util.List;

public class RaceGameOutputView {

    private static final String CAR_MOVE_SYMBOL = "-";

    public void displayCarsMoveResult(List<AllCarsMoveResultsDto> allMoveResult) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < allMoveResult.size(); i++) {
            AllCarsMoveResultsDto allCarsMoveResultsDto = allMoveResult.get(i);
            List<SingleMoveResultDto> carResults = allCarsMoveResultsDto.getCarResults();

            for (int j = 0; j < carResults.size(); j++) {
                SingleMoveResultDto singleMoveResultDto = carResults.get(j);
                String carName = singleMoveResultDto.getCarName();
                int moveCount = singleMoveResultDto.getMoveCount();
                String s = generateDashString(moveCount);

            }
        }

    }

    private String generateDashString(int moveCount) {
        return CAR_MOVE_SYMBOL.repeat(moveCount);
    }


}
