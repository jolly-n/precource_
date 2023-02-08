package racingcar.domain;

import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Cars {
    private static final int MIN_SIZE = 2;
    private static final String CAR_SIZE_ERROR = "경주를 진행하려면 %d대 이상의 자동차가 필요합니다.";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarSize(cars);
        this.cars = cars;
    }

    public int getSize() {
        return cars.size();
    }

    public Cars move(List<Integer> numbers) {
        for (int i = 0; i < getSize(); i++) {
            cars.get(i).move(numbers.get(i));
        }
        return this;
    }

    public List<Car> findWinner() {
        Map<Integer, List<Car>> map = cars.stream()
                .collect(groupingBy(Car::getPosition));

        Integer maxPosition = map.keySet().stream()
                .map(Integer::new)
                .max(Integer::compareTo)
                .get();

        return map.get(maxPosition);
    }

    private void validateCarSize(List<Car> cars) {
        if (cars.size() < MIN_SIZE) {
            throw new IllegalArgumentException(String.format(CAR_SIZE_ERROR, MIN_SIZE));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
