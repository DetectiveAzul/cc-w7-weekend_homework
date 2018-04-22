package collectables.tools.consumables;

import character.Character;
import collectables.Treasure;

public class Potion extends Treasure {
    private int power;
    private boolean poisonous;

    public Potion(String name, boolean poisonous, int power) {
        super(name + " Potion", 25);
        this.poisonous = poisonous;
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public boolean isPoisonous() {
        return poisonous;
    }

    public void use(Character character) {
        if (poisonous) {
            character.takeDamage(power);
        } else {
            character.takeHealing(power);
        }
        character.removeTreasure(this);
    }


}
