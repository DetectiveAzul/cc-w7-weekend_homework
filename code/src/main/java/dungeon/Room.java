package dungeon;

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

    public Room(RoomType type, String name, String description) {
        this.type = type;
        this.name = name;
        this.description = description;
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
        if (this.north != null) exits.add("North");
        if (this.east != null) exits.add("East");
        if (this.south != null) exits.add("South");
        if (this.west != null) exits.add("West");
        String exitsAvailable = String.join(", ", exits);
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
