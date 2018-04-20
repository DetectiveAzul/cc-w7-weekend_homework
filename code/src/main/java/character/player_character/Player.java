package character.player_character;

import behaviours.IMovable;
import character.Character;

public class Player extends Character implements IMovable {
    public Player(String name) {
        super(name);
    }

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


}
