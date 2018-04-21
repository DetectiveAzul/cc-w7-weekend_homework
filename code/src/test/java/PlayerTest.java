import character.non_player_character.NonPlayerCharacter;
import character.player_character.Player;
import collectables.CoinChest;
import collectables.CoinType;
import dungeon.EndRoom;
import dungeon.EntryRoom;
import dungeon.RoomType;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class PlayerTest {
    private Player player;
    private Player player2;
    private EntryRoom entryRoom;
    private EndRoom endRoom;
    private CoinChest chest;
    private NonPlayerCharacter foe;


    @Before
    public void setup() {
        player = new Player("Gandalf");
        entryRoom = new EntryRoom("Entry", "An Entry");
        endRoom = new EndRoom("End", "An End");
        player2 = new Player("Frodo", 100, 50, entryRoom);
        entryRoom.setNorth(endRoom);
        chest = new CoinChest(100,CoinType.GOLD);
        foe = new NonPlayerCharacter("Giant Spider");

    }

    @Test
    public void hasName() {
        assertEquals("Gandalf", player.getName());
    }

    @Test
    public void hasRoom() {
        assertNull(player.getCurrentRoom());
    }

    @Test
    public void canSetRoom() {
        player.setCurrenRoom(entryRoom);
        assertEquals(RoomType.ENTRY, player.getCurrentRoom().getType());
    }

    @Test
    public void hasHP() {
        assertEquals(100, player2.getMaxhp());
        assertEquals(100, player2.getHp());
    }

    @Test
    public void hasStamina() {
        assertEquals(50, player2.getStamina());
        assertEquals(50, player2.getStamina());
    }

    @Test
    public void canTakeDamage() {
        player2.takeDamage(10);
        assertEquals(90, player2.getHp());
        assertEquals(100, player2.getMaxhp());
    }

    @Test
    public void canMove() {
        player.setCurrenRoom(entryRoom);
        player.goNorth();
        assertEquals(RoomType.END_ROOM, player.getCurrentRoom().getType());
    }

    @Test
    public void canMoveUsingString() {
        player.setCurrenRoom(endRoom);
        player.checkDirectionChoice("south");
        assertEquals(RoomType.ENTRY, player.getCurrentRoom().getType());
    }

    @Test
    public void hasTreasures() {
        assertEquals(0, player.getTreasures().size());
    }

    @Test
    public void canAddTreasure() {
        player.addTreasure(chest);
        assertEquals(1, player.getTreasures().size());
    }

    @Test
    public void canRemoveTreasure() {
        player.addTreasure(chest);
        player.removeTreasure(chest);
        assertEquals(0, player.getTreasures().size());
    }

    @Test
    public void canTakeTreasureFromRoom() {
        player.setCurrenRoom(entryRoom);
        entryRoom.addTreasure(chest);
        player.takeObject("take Chest");
        assertEquals(0, entryRoom.getTreasures().size());
        assertEquals(1, player.getTreasures().size());
    }

    @Test
    public void canKillMonster() {
        player.setCurrenRoom(entryRoom);
        entryRoom.addFoe(foe);
        foe.addTreasure(chest);
        assertEquals(1, entryRoom.getFoes().size());
        player.kill("kill Spider");
        assertEquals(0, entryRoom.getFoes().size());
        assertEquals(1, entryRoom.getTreasures().size());

    }

    @Test
    public void canUse() {
        player.addTreasure(chest);
        assertTrue(player.use("use Chest"));
        assertFalse(player.use("use key"));
    }

}
