package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.Arrays;
import java.util.List;

public class RacingController {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final int RANDOM_NUMBER_START = 0;
    private static final int RANDOM_NUMBER_END = 9;
    private static final int MIN_NUMBER = 4;

    private final Output output = new Output();
    private final Input input = new Input();

    public void run() {
        output.showCarNamesInputMessage();
        String carNames = input.readCarNames();

        List<Car> cars = makeCars(carNames);

        output.showCountInputMessage();
        int count = Integer.parseInt(input.readCount());

        output.showResultMessage();
        for (int i = 0; i < count; i++) {
            for (Car car : cars) {
                if (canMove()) {
                    car.move();
                }
            }
            output.showResult(cars);
        }

        List<Car> winners = findWinners(cars);
    }

    private List<Car> makeCars(String carNames) {
        return Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .map(Car::new)
                .toList();
    }

    private boolean canMove() {
        return MIN_NUMBER <= makeRandomNumber();
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END);
    }

    private List<Car> findWinners(List<Car> cars) {
        int maxMove = cars.stream()
                .map(Car::getMoveCount)
                .mapToInt(num -> num)
                .max()
                .orElseThrow();

        return cars.stream()
                .filter(car -> car.isMaxMove(maxMove))
                .toList();
    }
}
