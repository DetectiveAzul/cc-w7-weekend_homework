import org.junit.Test;
import runner.TextColor;

import static org.junit.Assert.assertEquals;

public class TextColorTest {
    @Test
    public void hasAnsiiCode() {
        assertEquals("\u001B[34m", TextColor.BLUE.getAnsiiCode());
    }
}
