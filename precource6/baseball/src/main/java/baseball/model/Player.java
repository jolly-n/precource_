package baseball.model;

import java.util.Arrays;
import java.util.List;

public class Player {

    private static final int NUMBERS_SIZE = 3;
    private static final String DELIMITER = "";
    private static final String NUMBER_SIZE_EXCEPTION = "%d자리 수만 가능합니다.";
    private static final String NUMBER_UNIQUE_EXCEPTION = "서로 다른 숫자만 가능합니다.";

    private final List<Integer> numbers;

    public Player(String number) {
        validateNumberSize(number);
        validateUniqueNumber(number);
        this.numbers = convert(number);
    }

    private void validateNumberSize(String number) {
        if (number.length() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(String.format(NUMBER_SIZE_EXCEPTION, NUMBERS_SIZE));
        }
    }

    private void validateUniqueNumber(String number) {
        long count = Arrays.stream(number.split(DELIMITER))
                .distinct()
                .count();

        if (number.length() != count) {
            throw new IllegalArgumentException(NUMBER_UNIQUE_EXCEPTION);
        }
    }

    private List<Integer> convert(String number) {
        return Arrays.stream(number.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    public int countSameNumber(Computer computer) {
        return (int) numbers.stream()
                .filter(computer::hasNumber)
                .count();
    }

    public int countSameIndex(Computer computer) {
        return (int) numbers.stream()
                .filter(number -> computer.isSameIndex(number, numbers.indexOf(number)))
                .count();
    }
}
