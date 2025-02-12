package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public int readAmount() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return convertAmount(read());
    }

    public List<String[]> readItemInfos() {
        System.out.println("\n상품명과 가격, 수량을 입력해 주세요.");
        return Arrays.stream(read().split(";"))
                .map(itemInfo ->
                        itemInfo.replaceAll("[\\[\\]]", "")
                                .split(","))
                .collect(Collectors.toList());
    }

    public int readMoney() {
        System.out.println("\n투입 금액을 입력해 주세요.");
        return convertAmount(read());
    }

    public String readPurchaseItemName() {
        System.out.println("구매할 상품명을 입력해 주세요.");
        return read();
    }

    private int convertAmount(String inputValue) {
        if (inputValue.replaceAll("[0-9]", "").length() > 0) {
            throw new IllegalArgumentException("금액은 0원 이상이어야 합니다.");
        }
        return Integer.parseInt(inputValue);
    }

    private String read() {
        return Console.readLine();
    }
}
