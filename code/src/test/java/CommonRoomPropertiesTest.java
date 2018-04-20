import collectables.CoinChest;
import collectables.CoinType;
import dungeon.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CommonRoomPropertiesTest {
    //To test the common methods between all the rooms
    private TreasureRoom treasure;
    private TreasureRoom treasure2;
    private EntryRoom entry;
    private MonsterRoom monster;
    private EndRoom end;
    private CoinChest chest;

    @Before
    public void setup() {
        treasure = new TreasureRoom("Treasure Room", "A small treasure room");
        entry = new EntryRoom("Dungeon Entrance", "Where the dungeon begins");
        monster = new MonsterRoom("Boss Lair", "The house of a small green dragon");
        end = new EndRoom("The Exit", "If you have the key, you can escape");
        treasure2 = new TreasureRoom("Treasure Room 2", "Test Room");
        chest = new CoinChest(100, CoinType.GOLD);

    }

    @Test
    public void hasType() {
        assertEquals(RoomType.ENTRY, entry.getType());
    }

    @Test
    public void hasName() {
        assertEquals("Boss Lair", monster.getName());
    }

    @Test
    public void hasDescription() {
        assertEquals("Where the dungeon begins", entry.getDescription());
    }

    @Test
    public void hasExits() {
        assertNull(treasure.getNorth());
        assertNull(end.getSouth());
        assertNull(entry.getWest());
        assertNull(monster.getEast());
    }

    @Test
    public void canSetAndMirrorExits() {
        treasure.setNorth(monster);
        treasure.setSouth(entry);
        treasure.setEast(end);
        treasure.setWest(treasure2);

        //Testing one-way setting
        assertEquals(RoomType.END_ROOM, treasure.getEast().getType());
        assertEquals(RoomType.ENTRY, treasure.getSouth().getType());
        assertEquals(RoomType.MONSTER_ROOM, treasure.getNorth().getType());
        assertEquals(RoomType.TREASURE_ROOM, treasure.getWest().getType());

        //Testing if has been mirrored
        assertEquals(RoomType.TREASURE_ROOM, end.getWest().getType());
        assertEquals(RoomType.TREASURE_ROOM, entry.getNorth().getType());
        assertEquals(RoomType.TREASURE_ROOM, monster.getSouth().getType());
        assertEquals(RoomType.TREASURE_ROOM, treasure2.getEast().getType());

    }

    @Test
    public void hasTreasures() {
        assertEquals(0, treasure.getTreasures().size());
    }

    @Test
    public void canAddTreasure() {
        treasure.addTreasure(chest);
        assertEquals(1, treasure.getTreasures().size());
    }

    @Test
    public void canRemoveTreasure() {
        treasure.addTreasure(chest);
        treasure.removeTreasure(chest);
        assertEquals(0, treasure.getTreasures().size());
    }

}
