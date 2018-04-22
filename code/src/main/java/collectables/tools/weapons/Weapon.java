package collectables.tools.weapons;

import behaviours.IWieldable;
import character.Character;
import collectables.Treasure;

public class Weapon extends Treasure implements IWieldable {
    private int damage;

    public Weapon(String name, int value, int damage) {
        super(name, value);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void use(Character character) {
        //Will add the actual wielding tool to the inventory if there is one
        if (character.getPrimaryTool() != null) character.addTreasure((Treasure) character.getPrimaryTool());
        //Change the tool
        character.setPrimaryTool(this);
        //Remove it from the inventory
        character.removeTreasure(this);
    }

    public void unWield(Character character) {
        character.setPrimaryTool(null);
        character.addTreasure(this);
    }

}
