package racingcar.view.input.validator;

import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");

    public void validateNumber(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ValidationErrorMessage.NOT_NUMERIC_ERROR.getMessage());
        }
    }

    public void validateCarNames(List<String> carNames) {
        if (carNames.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException(ValidationErrorMessage.EMPTY_NAME_ERROR.getMessage());
        }
    }

}
