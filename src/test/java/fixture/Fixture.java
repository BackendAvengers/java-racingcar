package fixture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.race.RacingCar;
import racingcar.domain.race.RacingCarGame;
import racingcar.domain.race.RacingPosition;
import racingcar.domain.round.Round;
import stub.StubMoveStrategy;

public class Fixture {

    public static Car createCar(String name) {
        return new Car(name);
    }

    public static List<Car> createCarList(String... names) {
        return Arrays.stream(names)
                .map(Fixture::createCar)
                .toList();
    }

    public static List<Car> createCarList(int size) {
        List<Car> cars = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            cars.add(createCar(String.valueOf(i)));
        }
        return cars;
    }

    public static RacingCar createRacingCar(String name, boolean isMoveable) {
        StubMoveStrategy stubMoveStrategy = new StubMoveStrategy();
        stubMoveStrategy.setMoveable(isMoveable);
        return new RacingCar(createCar(name), new RacingPosition(0), stubMoveStrategy);
    }

    public static RacingCar createRacingCar(Car car) {
        StubMoveStrategy stubMoveStrategy = new StubMoveStrategy();
        return new RacingCar(car, new RacingPosition(0), stubMoveStrategy);
    }

    public static Cars createCars(int size) {
        return new Cars(createCarList(size));
    }

    public static Round createRound(int totalRound) {
        return new Round(totalRound, 0);
    }

    public static RacingCarGame createRacingCarGame(int carSize, int totalRound) {
        List<RacingCar> racingCars = createCarList(carSize).stream()
                .map(Fixture::createRacingCar)
                .toList();
        return new RacingCarGame(racingCars, createRound(totalRound));
    }
}
