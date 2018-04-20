import character.non_player_character.NonPlayerCharacter;
import collectables.CoinChest;
import collectables.CoinType;
import dungeon.MonsterRoom;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommonNPCPropertiesTest {
    private NonPlayerCharacter foe;
    private MonsterRoom monster;
    private CoinChest chest;

    @Before
    public void setup() {
        chest = new CoinChest(100, CoinType.GOLD);
        monster = new MonsterRoom("Boss Lair", "The house of a small green dragon");
        foe = new NonPlayerCharacter("Giant Spider", 100, 10, monster);
        foe.addTreasure(chest);
    }

    @Test
    public void canDie() {
        foe.die();
        assertEquals(0, monster.getFoes().size());
        assertEquals(1, monster.getTreasures().size());
    }
}
