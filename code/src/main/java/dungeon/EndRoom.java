package dungeon;

public class EndRoom extends Room {
    //EndRoom is locked by default, if you unlocked it, you win.
    private boolean roomIsUnlocked = false;
    public EndRoom(String name, String description) {
        super(RoomType.END_ROOM, name, description);
    }

    public boolean isRoomIsUnlocked() {
        return roomIsUnlocked;
    }

    public void unlockExit() {
        this.roomIsUnlocked = true;
    }
}
