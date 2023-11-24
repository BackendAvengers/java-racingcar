package racingcar.domain.car;

import static racingcar.domain.race.RacingCarConstraints.isValidCarNameLength;
import static racingcar.exception.ErrorMessage.INVALID_CAR_NAME_LENGTH;

import java.util.Objects;

public class Car {
    private final String name;

    public Car(String name) {
        validateNameLength(name);

        this.name = name;
    }

    private void validateNameLength(String name) {
        if (!isValidCarNameLength(name)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.getValue(name.length()));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;

        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        if (name != null) {
            return name.hashCode();
        }
        return 0;
    }

    public String getName() {
        return name;
    }
}
