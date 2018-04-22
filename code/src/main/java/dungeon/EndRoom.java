package dungeon;

public class EndRoom extends Room {
    public EndRoom(String name, String description) {
        super(RoomType.END_ROOM, name, description);
    }

    public boolean unlockExit() {
        return true;
    }
}
