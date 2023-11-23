package racingcar.domain.race;

import java.util.List;

public class RacingCarConstraints {
    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int CARS_MIN_SIZE = 2;
    private static final int CARS_MAX_SIZE = 100;

    private RacingCarConstraints() {
    }

    public static boolean isValidCarNameLength(String name) {
        int length = name.length();
        return CAR_NAME_MIN_LENGTH <= length && length <= CAR_NAME_MAX_LENGTH;
    }

    public static <T> boolean isValidCarsSize(List<T> cars) {
        int size = cars.size();
        return CARS_MIN_SIZE <= size && size <= CARS_MAX_SIZE;
    }
}
