package character;

import behaviours.IMovable;
import behaviours.ITargetable;
import dungeon.Room;

public abstract class Character implements IMovable, ITargetable {
    private String name;
    private int maxhp;
    private int hp;
    private int maxStamina;
    private int stamina;
    private Room currentRoom;

    public Character(String name) {
        this.name = name;
        this.maxhp = 10;
        this.hp = maxhp;
        this.maxStamina = 0;
        this.stamina = maxStamina;
    }

    public Character(String name, int maxhp, int maxStamina, Room currentRoom) {
        this.name = name;
        this.maxhp = maxhp;
        this.maxStamina = maxStamina;
        this.hp = maxhp;
        this.stamina = maxStamina;
        this.currentRoom = currentRoom;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getStamina() {
        return stamina;
    }

    public int getMaxhp() {
        return maxhp;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    //To get and set the room where the character is working on
    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrenRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    //To move between rooms
    public void goNorth() {
        if (getCurrentRoom().getNorth() != null)
            setCurrenRoom(getCurrentRoom().getNorth());
    }

    public void goSouth() {
        if (getCurrentRoom().getSouth() != null)
            setCurrenRoom(getCurrentRoom().getSouth());
    }

    public void goEast() {
        if (getCurrentRoom().getEast() != null)
            setCurrenRoom(getCurrentRoom().getEast());
    }

    public void goWest() {
        if (getCurrentRoom().getWest() != null)
            setCurrenRoom(getCurrentRoom().getWest());
    }

    //Targeteable actions
    public void takeDamage(int damage) {
        hp -= damage;
    }

    public void takeHealing(int healing) {
        hp += healing;
    }

}
