package racingcar.util;

import static racingcar.exception.ErrorMessage.INVALID_CHARACTER_IN_RACING_CAR_NAME;
import static racingcar.exception.ErrorMessage.INVALID_CHARACTER_IN_TOTAL_ROUND;
import static racingcar.exception.ErrorMessage.INVALID_TOTAL_ROUND_RANGE;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Parser {
    private static final Pattern DELIMITER_PATTERN = Pattern.compile(",");
    private static final Pattern SPACE_PATTERN = Pattern.compile("\\s+");
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");
    private static final Pattern RACING_CAR_NAME_PATTERN = Pattern.compile("[A-Za-z0-9]+");

    private Parser() {
    }

    private static String removeSpace(String input){
        return SPACE_PATTERN.matcher(input).replaceAll( "");
    }

    public static List<String> parseRacingCarNames(String input) {
        String removedSpaceInput = removeSpace(input);
        String[] split = DELIMITER_PATTERN.split(removedSpaceInput);
        if (!isValidRacingCarNameInput(split)) {
            throw new IllegalArgumentException(INVALID_CHARACTER_IN_RACING_CAR_NAME.getValue());
        }
        return List.of(split);
    }

    private static boolean isValidRacingCarNameInput(String[] split) {
        return Arrays.stream(split)
                .allMatch(name -> RACING_CAR_NAME_PATTERN.matcher(name).matches());
    }

    public static int parseTotalRound(String input){
        if(!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_CHARACTER_IN_TOTAL_ROUND.getValue());
        }

        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(INVALID_TOTAL_ROUND_RANGE.getValue());
        }
    }
}
