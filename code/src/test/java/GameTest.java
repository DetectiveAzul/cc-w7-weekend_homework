import character.player_character.Player;
import collectables.Key;
import dungeon.EndRoom;
import engine.Game;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {
    private EndRoom end;
    private Player player;
    private Key key;

    @Before
    public void setup() {
        player = new Player("Gandalf");
        end = new EndRoom("End", "An End");
        key = new Key("Golden", end);
        player.addTreasure(key);
        player.setCurrenRoom(end);
    }


    @Test
    public void canPlayerUnlock() {
        player.use("Key");
        assertTrue(Game.checkWin(end));
    }
}
