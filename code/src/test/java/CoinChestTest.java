import collectables.CoinChest;
import collectables.CoinType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CoinChestTest {
    private CoinChest chest;
    @Before
    public void setup() {
        chest = new CoinChest(100, CoinType.GOLD);
    }

    @Test
    public void hasName() {
        assertEquals("Gold Coins Chest", chest.getName());
    }

    @Test
    public void hasValue() {
        assertEquals(100, chest.getValue(), 0);
    }

    @Test
    public void hasType() {
        assertEquals(CoinType.GOLD,chest.getType());
    }

    @Test
    public void hasQuantity() {
        assertEquals(100, chest.getQuantity());
    }
}
