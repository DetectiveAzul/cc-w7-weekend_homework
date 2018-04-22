import character.player_character.Player;
import collectables.Key;
import dungeon.EndRoom;
import dungeon.RoomType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KeyTest {
    private Key key;
    private EndRoom end;
    private Player player;

    @Before
    public void setup() {
        end = new EndRoom("The Exit", "If you have the key, you can escape");
        key = new Key("Exit", end);
        player = new Player("Gandalf");
        player.setCurrenRoom(end);
        player.addTreasure(key);
    }

    @Test
    public void hasName() {
        assertEquals("Exit Key", key.getName());
    }

    @Test
    public void hasValue() {
        assertEquals(0, key.getValue(),0);
    }

    @Test
    public void hasRoom() {
        assertEquals(RoomType.END_ROOM, key.getRoomToOpen().getType());
    }

    @Test
    public void canUnlockRoom() {
        assertEquals(1, player.getTreasures().size());
        player.use("Key");
        assertEquals(0, player.getTreasures().size());

    }

}
