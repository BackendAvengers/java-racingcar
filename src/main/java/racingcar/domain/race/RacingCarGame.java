package racingcar.domain.race;

import java.util.Collections;
import java.util.List;
import racingcar.domain.round.Round;

public class RacingCarGame {
    private final List<RacingCar> racingCars;
    private final Round round;

    public RacingCarGame(List<RacingCar> racingCars, Round round) {
        this.racingCars = racingCars;
        this.round = round;
    }

    public void proceedRound() {
        racingCars.forEach(RacingCar::moveForwardOrStop);
        round.next();
    }

    public boolean isFinished() {
        return !round.hasNext();
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }

    public int getTotalRound() {
        return round.getTotalRound();
    }

    public int getCurrentRound() {
        return round.getCurrentRound();
    }
}
