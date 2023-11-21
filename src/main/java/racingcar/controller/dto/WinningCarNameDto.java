package racingcar.controller.dto;

import racingcar.domain.car.Car;

public class WinningCarNameDto {
    private final String name;

    private WinningCarNameDto(String name) {
        this.name = name;
    }

    public static WinningCarNameDto from(Car car) {
        return new WinningCarNameDto(car.getName());
    }

    public String getName() {
        return name;
    }
}
