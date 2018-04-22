package character.player_character;

import behaviours.IFoundable;
import character.Character;
import character.non_player_character.NonPlayerCharacter;
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
            else if (choice.startsWith("use")) use(choice);
            else if (choice.startsWith("kill")) kill(choice);
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
    public void kill(String foeString) {
        NonPlayerCharacter foe = (NonPlayerCharacter) findByName(foeString, getCurrentRoom().getFoes());
        foe.die();
    }

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
        Treasure object = (Treasure) findByName(action, getCurrentRoom().getTreasures());
        if (object != null) {
            addTreasure(object);
            getCurrentRoom().removeTreasure(object);
        }
    }

    public void dropObject(String action) {
        Treasure object = (Treasure) findByName(action, getTreasures());
        if ( object != null) {
            removeTreasure(object);
            getCurrentRoom().addTreasure(object);
        }
    }


    //Special actions
    public boolean use(String objectName) {
        Treasure treasureToUse = (Treasure) findByName(objectName, getTreasures());
        if (treasureToUse != null)
        {
            use(treasureToUse);
            return true;
        }
        return false;
    }

    //This method is for looking for an object on an array by passing a string containing a verb and a name
    private IFoundable findByName(String stringToLook, ArrayList<? extends IFoundable> arrayToLook) {
        //Split the string to look in individual words
        String[] stringArray = stringToLook.split(" ");
        IFoundable foundObject = null;

        //Loop over the words to check if any of the words in the name is included on the array with the words from the action
        firstLoop: for (IFoundable foundable: arrayToLook) {
            for (String foundableWord: foundable.getName().split(" ")) {
                if (Arrays.asList(stringArray).contains(foundableWord)) {
                    foundObject = foundable;
                    break firstLoop;
                }
            }
        }
        return foundObject;
    }


}
