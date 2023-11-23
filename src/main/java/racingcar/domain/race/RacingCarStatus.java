package racingcar.domain.race;

public class RacingCarStatus {
    private final String name;
    private final int position;

    public RacingCarStatus(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
