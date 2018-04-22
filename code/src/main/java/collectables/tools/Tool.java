package collectables.tools;

import behaviours.IWieldable;
import character.Character;
import collectables.Treasure;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Tool extends Treasure implements IWieldable {
        private int damage;
        private ArrayList<Integer> damageDie;

        public Tool(String name, int value, int damage) {
            super(name, value);
            this.damage = damage;
            this.damageDie = new ArrayList<>();
            pickDie();
        }

        //Create an arraylist of integers between 1 and the damage value
        private void pickDie() {
             for (int i = 1; i <= damage ; i++) {
                    this.damageDie.add(i);
             }
        }

        public int getDamage() {
            return damage;
        }

    public ArrayList<Integer> getDamageDie() {
        return damageDie;
    }

    //"roll" a die and return the result in the index 0 (the value facing top on a dice)
        public int rollDamageDie() {
            Collections.shuffle(this.damageDie);
            return this.damageDie.get(0);
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


