package character;

import behaviours.ICollectionist;
import behaviours.IFoundable;
import behaviours.IMovable;
import behaviours.ITargetable;
import collectables.Treasure;
import dungeon.Room;
import runner.TextColor;

import java.util.ArrayList;

public abstract class Character implements IMovable, ITargetable, ICollectionist, IFoundable {
    private String name;
    private int maxhp;
    private int hp;
    private int maxStamina;
    private int stamina;
    private Room currentRoom;
    private ArrayList<Treasure> treasures;


    public Character(String name) {
        this.name = name;
        this.maxhp = 10;
        this.hp = maxhp;
        this.maxStamina = 0;
        this.stamina = maxStamina;
        this.treasures = new ArrayList<>();

    }

    public Character(String name, int maxhp, int maxStamina, Room currentRoom) {
        this.name = name;
        this.maxhp = maxhp;
        this.maxStamina = maxStamina;
        this.hp = maxhp;
        this.stamina = maxStamina;
        this.currentRoom = currentRoom;
        this.treasures = new ArrayList<>();

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
        if (hp < 0) hp = 0;
    }

    public void takeHealing(int healing) {
        hp += healing;
        if (hp > maxhp) hp = maxhp;
    }

    //Displaying Character status
    public void displayStatus() {
        System.out.println();
        displayHP();
        displayStamina();
        System.out.println();
    }

    private void displayHP() {
        System.out.print("HP: ");
        System.out.println(
                TextColor.RED.getAnsiiCode() + getHp() +
                        TextColor.WHITE.getAnsiiCode() + "/" +
                        TextColor.RED.getAnsiiCode() + getMaxhp() + TextColor.RESET.getAnsiiCode()
        );
    }

    private void displayStamina() {
        System.out.print("ST: ");
        System.out.println(
                TextColor.GREEN.getAnsiiCode() + getStamina() +
                        TextColor.WHITE.getAnsiiCode() + "/" +
                        TextColor.GREEN.getAnsiiCode() + getMaxStamina() + TextColor.RESET.getAnsiiCode()
        );
    }

    //General Inventory Management

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(ArrayList<Treasure> treasure) {
        this.treasures = treasure;
    }

    public void addTreasure(Treasure treasure) {
        treasures.add(treasure);
    }

    public void removeTreasure(Treasure treasure) {
        treasures.remove(treasure);
    }

    public void dropAll() {
        if (treasures.size() >= 1) currentRoom.getTreasures().addAll(treasures);
        treasures.clear();
    }

}
