package character.non_player_character;

import character.Character;
import dungeon.Room;

public class NonPlayerCharacter extends Character {
    public NonPlayerCharacter (String name) {
        super(name);
    }
    public NonPlayerCharacter(String name, int maxhp, int maxStamina, Room currentRoom) {
        super(name, maxhp, maxStamina, currentRoom);
    }

        public void die() {
        dropAll();
        getCurrentRoom().removeFoe(this);
        setCurrenRoom(null);
        setDead(true);
    }
}
