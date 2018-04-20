package character.player_character;

import behaviours.ICollectionist;
import character.Character;
import collectables.Treasure;
import dungeon.Room;

import java.util.ArrayList;

public class Player extends Character implements ICollectionist {
    private ArrayList<Treasure> treasures;

    public Player(String name) {
        super(name);
        this.treasures = new ArrayList<>();
    }

    public Player(String name, int maxhp, int maxStamina, Room currentRoom) {
        super(name, maxhp, maxStamina, currentRoom);
        this.treasures = new ArrayList<>();

    }

    //Check a string and execute the appropiate movement
    public void checkDirectionChoice(String choice) {
        switch (choice) {
            case "north":
                goNorth();
                break;
            case "south":
                goSouth();
                break;
            case "east":
                goEast();
                break;
            case "west":
                goWest();
            default:
                System.out.println("You cannot go that way");
                break;
        }
    }

    //Combat actions

    //Collection of items

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

    public String displayTreasures() {
        ArrayList<String> treasuresNames = new ArrayList<>();
        for (Treasure treasure:
                treasures) {
            treasuresNames.add(treasure.getName());
        }
        String joinedString = String.join(", ", treasuresNames);
        if (treasuresNames.size() == 0) return "You do not have items on your bag";
        return "You have on your inventory: " + joinedString;
    }


    //Special actions


}
