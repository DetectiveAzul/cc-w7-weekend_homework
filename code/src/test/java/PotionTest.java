import character.player_character.Player;
import collectables.tools.consumables.Potion;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PotionTest {
    private Potion hpotion;
    private Potion evilPotion;
    private Player player;

    @Before
    public void setup() {
        hpotion = new Potion("Red", false, 5);
        evilPotion = new Potion("Green", true, 5);
        player = new Player("Gandalf");
    }

    @Test
    public void isPoisonous() {
        assertTrue(evilPotion.isPoisonous());
        assertFalse(hpotion.isPoisonous());
    }

    @Test
    public void hasPower() {
        assertEquals(5, evilPotion.getPower());
    }

    @Test
    public void canDamage() {
        evilPotion.use(player);
        assertEquals(5, player.getHp());
    }

    @Test
    public void canHeal() {
        evilPotion.use(player);
        hpotion.use(player);
        assertEquals(10, player.getHp());
    }
}
