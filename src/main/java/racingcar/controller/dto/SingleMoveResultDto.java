package racingcar.controller.dto;

import racingcar.domain.car.Car;

public class SingleMoveResultDto {
    private final String carName;
    private final int moveCount;

    private SingleMoveResultDto(String carName, int moveCount) {
        this.carName = carName;
        this.moveCount = moveCount;
    }

    public static SingleMoveResultDto from(Car car) {
        return new SingleMoveResultDto(car.getName(), car.getMoveCounter());
    }

    public String getCarName() {
        return carName;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
