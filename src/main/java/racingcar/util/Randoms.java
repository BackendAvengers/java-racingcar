package racingcar.util;

public class Randoms {

    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    private Randoms() {
    }

    public static int getNumber() {
        return camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
