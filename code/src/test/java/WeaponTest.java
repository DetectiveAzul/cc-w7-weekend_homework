import collectables.tools.weapons.Weapon;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class WeaponTest {
    private Weapon sword;
    private Weapon dagger;

    @Before
    public void setup() {
        sword = new Weapon("Long Sword", 5, 10);
        dagger = new Weapon("Dagger", 5, 5);
    }

    @Test
    public void hasDamage() {
        assertEquals(10, sword.getDamage());
    }

    @Test
    public void hasDamageDie() {
        assertEquals(5, dagger.getDamageDie().size() );
        assertEquals(10, sword.getDamageDie().size() );
    }

    @Test
    public void canRollDie() {
        int result = 6;
        assertTrue(result > dagger.rollDamageDie());
    }

}
