import collectables.CoinType;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CoinTypeTest {
    @Test
    public void hasPrettyName() {
        assertEquals("Copper", CoinType.COPPER.getPrettyName());
    }

    @Test
    public void hasValue() {
        assertEquals(1.0, CoinType.GOLD.getValue());
    }
}
