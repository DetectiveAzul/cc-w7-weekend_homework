import dungeon.RoomType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTypeTest {
    @Test
    public void hasPrettyName() {
        assertEquals("Treasure Room", RoomType.TREASURE_ROOM.getPrettyName());
    }
}
