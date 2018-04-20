package character.player_character;

import behaviours.IMovable;
import character.Character;
import dungeon.Room;

public class Player extends Character {
    private Room currentRoom;

    public Player(String name) {
        super(name);
    }

    public Player(String name, int maxhp, int maxStamina, Room currentRoom) {
        super(name, maxhp, maxStamina, currentRoom);
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

    //Special actions


}
