package baseball.domain;

import java.util.List;

public class Judgement {
    /**
     * 플레이어 수와 컴퓨터의 수를 비교해 동일한 개수를 반환한다.
     */
    public int countSameNumbers(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int count = 0;

        for (Integer number : playerNumbers) {
            if (computerNumbers.contains(number)) {
                count++;
            }
        }

        return count;
    }
}
