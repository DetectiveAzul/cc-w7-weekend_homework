package collectables;

import behaviours.IFoundable;

public abstract class Treasure implements IFoundable {
    String name;
    double value;

    public Treasure(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public void use() { }
}
