package vendingmachine.controller;

import vendingmachine.domain.Coin;
import vendingmachine.domain.CoinMaker;
import vendingmachine.domain.Item;
import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.Input;
import vendingmachine.view.Output;

import java.util.List;
import java.util.Map;

public class VendingMachineController {

    private final Input input = new Input();
    private final Output output = new Output();
    private final CoinMaker coinMaker = new CoinMaker();

    public void run() {
        Map<Coin, Integer> coins = coinMaker.make(input.readAmount());
        output.showCoins(coins);
        List<Item> items = makeItems(input.readItemInfos());
        Money money = new Money(input.readMoney());

        VendingMachine vendingMachine = new VendingMachine(coins, items, money);

        while (vendingMachine.canPurchase()) {
            output.showMoney(money);
            String itemName = input.readPurchaseItemName();
            vendingMachine.buyItem(itemName);
        }
    }

    private List<Item> makeItems(List<String[]> itemInfos) {
        return itemInfos.stream()
                .map(Item::from)
                .toList();
    }
}
