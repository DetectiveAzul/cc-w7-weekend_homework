package collectables;

import behaviours.IFoundable;
import behaviours.IUsable;
import character.Character;

public abstract class Treasure implements IFoundable, IUsable {
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

    public void use(Character character) {
        System.out.println("You don't know how to use " + getName());
    }
}
