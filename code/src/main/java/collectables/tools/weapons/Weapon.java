package collectables.tools.weapons;

import behaviours.IWieldable;
import character.Character;
import collectables.Treasure;

public class Weapon extends Treasure implements IWieldable {
    public Weapon(String name, int value) {
        super(name, value);
    }

    public void use(Character character) {
        //Will add the actual wielding tool to the inventory if there is one
        if (character.getPrimaryTool() != null) character.addTreasure((Treasure) character.getPrimaryTool());
        //Change the tool
        character.setPrimaryTool(this);
        //Remove it from the inventory
        character.removeTreasure(this);
    }

}
