package collectables;

public enum CoinType {
    COPPER("Copper", 0.01),
    SILVER("Silver", 0.1),
    ELECTRUM("Electrum", 0.5),
    IRON("Iron", 0.6),
    GOLD("Gold", 1),
    PLATINUM("Platinum", 5);

    private final String prettyName;
    private final double value;

    CoinType(String prettyName, double value ) {
        this.prettyName = prettyName;
        this.value = value;
    }

    public String getPrettyName() {
        return prettyName;
    }

    public double getValue() {
        return value;
    }
}


