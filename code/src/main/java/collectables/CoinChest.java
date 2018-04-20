package collectables;

public class CoinChest extends Treasure {
    private CoinType type;
    int quantity;

    public CoinChest(int quantity, CoinType type) {
        super(type.getPrettyName() + " Coins Chest", type.getValue() * quantity);
        this.type = type;
        this.quantity = quantity;


    }

    public CoinType getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }
}
