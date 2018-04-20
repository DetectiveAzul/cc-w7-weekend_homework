package character.player_character;

import character.Character;
import collectables.Treasure;
import dungeon.Room;

import java.util.ArrayList;
import java.util.Arrays;

public class Player extends Character {

    public Player(String name) {
        super(name);
    }

    public Player(String name, int maxhp, int maxStamina, Room currentRoom) {
        super(name, maxhp, maxStamina, currentRoom);
    }

    //Check input action
    public void checkAction(String choice) {
            if (choice.startsWith("takeall")) takeAll();
            else if (choice.startsWith("take")) takeObject(choice);
            else if (choice.startsWith("dropall")) dropAll();
            else if (choice.startsWith("drop")) dropObject(choice);
            else if (choice.startsWith("status")) displayStatus();
            else checkDirectionChoice(choice);
            }

    //Check a string and execute the correct movement
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

    public String displayTreasures() {
        //Get all the names and add them to a new ArrayList
        ArrayList<String> treasuresNames = new ArrayList<>();
        for (Treasure treasure:
                getTreasures()) {
            treasuresNames.add(treasure.getName());
        }

        //Joins the arraylist to display it on the runner
        String joinedString = String.join(", ", treasuresNames);
        if (treasuresNames.size() == 0) return "You do not have items on your bag";
        return "You have on your inventory: " + joinedString;
    }

    public void takeObject(String action) {
        //Split the string in two, and take the part without the web
        String[] actionArray = action.split(" ", 2);
        Treasure treasureToGet = null;

        //Loop over the words to check if any of the words in the name is included on the array with the words from the action
        firstLoop: for (Treasure treasure: getCurrentRoom().getTreasures()) {
            for (String treasureWord: treasure.getName().split(" ")) {
                if (Arrays.asList(actionArray[1].split(" ")).contains(treasureWord)) {
                    treasureToGet = treasure;
                    break firstLoop;
                }
            }
        }

        //Then if he found an object, this adds it to the player and removes from the room
        if (treasureToGet != null) {
            addTreasure(treasureToGet);
            getCurrentRoom().removeTreasure(treasureToGet);
        }
    }

    public void dropObject(String action) {
        //Split the string in two, and take the part without the web
        String[] actionArray = action.split(" ", 2);
        Treasure treasureToDrop = null;

        //Loop over the words to check if any of the words in the name is included on the array with the words from the action
        firstLoop: for (Treasure treasure: getTreasures()) {
            for (String treasureWord: treasure.getName().split(" ")) {
                if (Arrays.asList(actionArray[1].split(" ")).contains(treasureWord)) {
                    treasureToDrop = treasure;
                    break firstLoop;
                }
            }
        }
        //Then if he found an object, this adds it to the player and removes from the room
        if (treasureToDrop != null) {
            removeTreasure(treasureToDrop);
            getCurrentRoom().addTreasure(treasureToDrop);
        }
    }

    public void takeAll() {
        getTreasures().addAll(getCurrentRoom().getTreasures());
        getCurrentRoom().getTreasures().clear();
    }



    //Special actions


}
