package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.EnumMap;
import java.util.Map;

public class CoinMaker {

    private final Map<Coin, Integer> coins = new EnumMap<>(Coin.class);

    public CoinMaker() {
        for (Coin coin : Coin.values()) {
            coins.put(coin, 0);
        }
    }

    public Map<Coin, Integer> make(int amount) {
        while (amount > 0) {
            int randomAmount = getRandomAmount(amount);
            Coin coin = Coin.from(randomAmount);
            coins.put(coin, coins.getOrDefault(coin, 0) + 1);
            amount -= randomAmount;
        }
        return coins;
    }

    private int getRandomAmount(int amount) {
        int randomAmount = Integer.MAX_VALUE;
        while (randomAmount > amount) {
            randomAmount = Randoms.pickNumberInList(Coin.findAmountLessThen(amount));
        }
        return randomAmount;
    }
}
