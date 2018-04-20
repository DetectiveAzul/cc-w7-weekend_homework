package character;

import dungeon.Room;

public abstract class Character {
    private String name;
    private Room currentRoom;

    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrenRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
