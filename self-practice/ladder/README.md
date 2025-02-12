# 사다리 타기

### 기능 요구 사항

- 사다리 게임에 참여하는 사람에 이름을 최대 5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름은 쉼표(,)를 기준으로 구분한다.
- 사람이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
    - `|-----|-----|` 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 경정할 수 없다.
- 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.

<br>

### 실행 결과

- 위 요구사항에 따라 4명의 사람을 위한 5개 높이 사다리를 만들 경우, 프로그램을 실행한 결과는 다음과 같다.

```
참여할 사람 이름을 입력하세요. (이름을 쉼표(,)로 구분하세요)
pobi,honux,crong,jk

실행 결과를 입력하세요 (결과는 쉼표(,)로 구분하세요)
꽝,5000,꽝,3000

최대 사다리 높이는 몇 개인가요?
5

실행결과
pobi  honux crong  jk
   |-----|     |-----|
   |     |-----|     |
   |-----|     |     |
   |     |-----|     |
   |-----|     |-----|
꽝   5000   꽝   3000

결과를 보고 싶은 사람은?
pobi

실행 결과
꽝

결과를 보고 싶은 사람은?
all

실행 결과
pobi : 꽝
honux : 3000
crong : 꽝
jk : 5000
```

<br>

### 힌트

- 2차원 배열을 ArrayList, Generic을 적용해 구현하면 `ArrayList<ArrayList<Boolean>>`와 같이 이해하기 어려운 코드가 추가된다.
- 사다리 게임에서 한 라인의 좌표 값을 가지는 객체를 추가해 구현해 본다.

``` java
public class Line {
    private List<Boolean> points = new ArrayList<>();
    
    public Line (int personCount) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
    }
    
    [...]
}
```

- 위와 같이 Line 객체를 추가하면 List<List<Boolean>> 코드를 List<Line>과 같이 구현하는 것이 가능해 진다.

<br>

### 프로그램 요구 사항

- indent depth가 2를 넘지 않도록 구현한다. 1까지만 허용
- 3항 연산자를 쓰지 않는다.
- else 예약어를 쓰지 않는다.
    - switch/case 허용 x

<br>

### 추가된 요구 사항

- 함수 길이가 10라인을 넘어가지 않도록 구현한다.
- 배열 대신 컬렉션을 사용한다.
- Java Enum을 적용한다.
- 모든 원시 값과 문자열을 포장한다.
- 줄여 쓰지 않는다.
