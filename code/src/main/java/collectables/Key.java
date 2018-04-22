package collectables;
import character.Character;
import dungeon.EndRoom;

public class Key extends Treasure {
    private EndRoom roomToOpen;

    public Key(String name, EndRoom roomToOpen) {
        super(name + " Key", 0);
        this.roomToOpen = roomToOpen;
    }

    public EndRoom getRoomToOpen() {
        return roomToOpen;
    }

    //Check is player is in the roomToOpen, and then unlocks it if it is true
    public void use(Character character) {
        if (character.getCurrentRoom() == getRoomToOpen()) {
            character.removeTreasure(this);
            roomToOpen.unlockExit();
        }
    }
}
