package dungeon;

public enum RoomType {
    TREASURE_ROOM("Treasure Room"),
    MONSTER_ROOM("Monster Room"),
    ENTRY("Entrance"),
    END_ROOM("Exit");

    private final String prettyName;

    RoomType(String prettyName) {
        this.prettyName = prettyName;
    }

    public String getPrettyName() {
        return prettyName;
    }
}
