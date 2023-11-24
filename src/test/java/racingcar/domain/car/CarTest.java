package racingcar.domain.car;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    //getter 없이 test를 작성했을 때
    @ParameterizedTest
    @DisplayName("차량이 움직인다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void moveTestWithReflection(int moveValue) throws NoSuchFieldException, IllegalAccessException {
        // given
        Car car = Car.from("hw");
        // when
        car.moveForwardOrHalt(moveValue);
        // then
        Field fieldName = Car.class.getDeclaredField("name");
        fieldName.setAccessible(true);
        Name name = (Name) fieldName.get(car);

        Field fieldMoveCount = Car.class.getDeclaredField("moveCounter");
        fieldMoveCount.setAccessible(true);
        MoveCounter moveCounter = (MoveCounter) fieldMoveCount.get(car);

        MoveCounter moveCounterResult = new MoveCounter();
        moveCounterResult.incrementMoveCount();
        assertEquals(new Name("hw"), name);
        assertEquals(moveCounterResult, moveCounter);
    }

    //getter 없이 test를 작성했을 때 생각보다 괜찮을지도..?
    @ParameterizedTest
    @DisplayName("차량이 움직인다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void moveTestWithJunit(int moveValue) {
        // given
        Car car = Car.from("hw");
        List<Car> cars = List.of(car);
        // when
        car.moveForwardOrHalt(moveValue);
        // then
        assertThat(cars)
                .extracting("name", "moveCounter")
                .containsOnly(
                        Tuple.tuple("hw", 1)
                );
    }

    // 그냥 getter 씁시다.
    @ParameterizedTest
    @DisplayName("차량이 움직인다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void moveTestWithGetter(int moveValue) {
        // given
        String name = "hw";
        Car car = Car.from(name);
        // when
        car.moveForwardOrHalt(moveValue);
        // then
        assertEquals(car.getName(), name);
        assertEquals(car.getMoveCounter(), 1);
    }


    @ParameterizedTest
    @DisplayName("차량이 멈춘다.")
    @ValueSource(ints = {1, 2, 3})
    public void stop(int moveValue) {
        // given
        Car car = Car.from("hw");
        // when
        car.moveForwardOrHalt(moveValue);
        // then
        assertEquals(car.getName(), "hw");
        assertEquals(car.getMoveCounter(), 0);
    }

    @Test
    @DisplayName("자동차의 움직인 횟수가 같은 알 수 있다.")
    public void hasSameMovementCarTrue() {
        // given
        Car car1 = Car.from("hw");
        Car car2 = Car.from("hw");
        // when
        boolean result = car1.hasSameMovementCar(car2);
        // then
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("자동차의 움직인 횟수가 같은 알 수 있다.")
    public void hasSameMovementCarFalse() {
        // given
        Car car1 = Car.from("hw");
        Car car2 = Car.from("hw");
        car2.moveForwardOrHalt(4);
        // when
        boolean result = car1.hasSameMovementCar(car2);
        // then
        Assertions.assertFalse(result);
    }
}