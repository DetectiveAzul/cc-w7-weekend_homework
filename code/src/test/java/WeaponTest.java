import collectables.tools.weapons.Weapon;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

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
}
