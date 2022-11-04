package baseball.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class GameController {
    private final Computer computer = new Computer();
    private final Player player = new Player();
    private final Judgement judgement = new Judgement();

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computerNumbers = computer.createComputerNumbers();

        String judgementResult = "";

        while (!judgementResult.equals("3스트라이크")) {
            System.out.println("숫자를 입력해주세요 : ");

            List<Integer> playerNumbers = player.createPlayerNumbers(readLine());
            judgementResult = judgement.getJudgementResult(computerNumbers, playerNumbers);

            System.out.println(judgementResult);
        }
    }
}
