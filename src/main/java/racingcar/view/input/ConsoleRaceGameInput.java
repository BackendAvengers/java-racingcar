package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public abstract class ConsoleRaceGameInput implements Input {

    @Override
    public String readLine() {
        return Console.readLine();
    }

    public void close() {
        Console.close();
    }

    public abstract List<String> requestCarNames();
    public abstract int requestMoveAttempts();

}
