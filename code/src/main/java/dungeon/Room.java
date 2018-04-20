package dungeon;

import collectables.Treasure;

import java.util.ArrayList;

public abstract class Room {
    //Room attributes
    private RoomType type;
    private String name;
    private String description;

    //Basic exits
    private Room north;
    private Room south;
    private Room east;
    private Room west;

    //Collectables
    private ArrayList<Treasure> treasures;

    public Room(RoomType type, String name, String description) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.treasures = new ArrayList<>();
    }

    //Basic getters

    public RoomType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    // Treasure setters

    //This is to add a whole array to the room, substituting anything already there
    public void setTreasures(ArrayList<Treasure> treasures) {
        this.treasures = treasures;
    }

    //To add and remove individual objects
    public void addTreasure(Treasure treasure) {
        treasures.add(treasure);
    }

    public void removeTreasure(Treasure treasure) {
        treasures.remove(treasure);
    }

    //Display treasures

    public String displayTreasures() {
        ArrayList<String> treasuresNames = new ArrayList<>();
        for (Treasure treasure:
             treasures) {
            treasuresNames.add(treasure.getName());
        }
        String joinedString = String.join(", ", treasuresNames);
        if (treasuresNames.size() == 0) return "There are no objects on this room";
        return "There are: " + joinedString;
    }

    //Getters for the exits

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    public String getExitsAvailable() {
        ArrayList<String> exits = new ArrayList<>();
        if (this.north != null) exits.add("north");
        if (this.east != null) exits.add("east");
        if (this.south != null) exits.add("south");
        if (this.west != null) exits.add("west");
        String exitsAvailable = String.join(", ", exits);
        if (exits.size() == 0) return "No exits available";
        return "Exits Available are: " + exitsAvailable;
    }

    //

    //Setters for the exits. This should add a room as a connected room, and add himself
    //to the correct exit for the other room, mirroring the entrances.
    public void setNorth(Room room) {
        this.north = room;
        if (room.south == null) room.south = this;
    }

    public void setSouth(Room room) {
        this.south = room;
        if (room.north == null) room.north = this;
    }

    public void setEast(Room room) {
        this.east = room;
        if (room.west == null) room.west = this;
    }

    public void  setWest(Room room) {
        this.west = room;
        if (room.east == null) room.east = this;
    }

}
