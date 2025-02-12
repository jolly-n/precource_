package vendingmachine.domain;

public class Item {

    private static final int UNIT_PRICE = 10;
    private static final int MIN_PRICE = 100;
    private static final String PRICE_EXCEPTION = "상품의 가격은 최소 %d원 이상이며, %d원으로 나누어 떨어져야 합니다.";

    private final String name;
    private final int price;

    private int quantity;

    public Item(String name, int price, int quantity) {
        validate(price);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static Item from(String[] itemInfo) {
        String name = itemInfo[0];
        int price = Integer.parseInt(itemInfo[1]);
        int quantity = Integer.parseInt(itemInfo[2]);
        return new Item(name, price, quantity);
    }

    private void validate(int price) {
        if (price < MIN_PRICE || price % UNIT_PRICE != 0) {
            throw new IllegalArgumentException(String.format(PRICE_EXCEPTION, MIN_PRICE, UNIT_PRICE));
        }
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public void reduceQuantity() {
        quantity--;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
