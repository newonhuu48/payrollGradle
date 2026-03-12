import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FirstTest {

    @Test
    void testTwoEqualsTwo() {
        // The first 2 is the expected value, the second 2 is the actual value
        assertEquals(2, 2, "Math should work!");
    }
}