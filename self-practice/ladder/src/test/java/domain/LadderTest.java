package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {
    @ParameterizedTest
    @CsvSource({"1, 1", "2, 2", "3, 3", "4, 4", "5, 5"})
    @DisplayName("높이에 맞는 사다리를 생성한다.")
    void makeLadderWithHeight(int height, int size) {
        Ladder ladder = new Ladder(3, height);
        assertThat(ladder.getLines()).hasSize(size);
    }
}
