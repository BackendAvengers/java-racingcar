package racingcar.domain.game;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.race.RacingCar;
import racingcar.domain.race.RacingPosition;
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

    public List<Car> findFinalWinner() {
        RacingPosition farthestPosition = findFarthestPosition();
        return racingCars.stream()
                .filter(racingCar -> racingCar.getRacingPosition().equals(farthestPosition))
                .map(RacingCar::getCar)
                .toList();
    }

    private RacingPosition findFarthestPosition() {
        Integer farthestPosition = racingCars.stream()
                .map(racingCar -> racingCar.getRacingPosition().getValue())
                .max(Comparator.comparingInt(o -> o))
                .orElse(0);
        return new RacingPosition(farthestPosition);
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
