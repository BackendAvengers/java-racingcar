package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;

public abstract class ConsoleInput implements Input {

    @Override
    public String readLine() {
        try {
            return Console.readLine();
        } finally {
            close();
        }
    }

    private void close() {
        Console.close();
    }

}
