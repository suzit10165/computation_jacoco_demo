package testing.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private final Calculator c = new Calculator();

    @Test void add_ok() { assertEquals(5, c.add(2, 3)); }
    @Test void sub_ok() { assertEquals(-1, c.sub(2, 3)); }
    @Test void mul_ok() { assertEquals(6, c.mul(2, 3)); }
    @Test void div_ok() { assertEquals(2, c.div(6, 3)); }

    // Cover the error branch in div (b == 0)
    @Test void div_by_zero_throws() {
        assertThrows(ArithmeticException.class, () -> c.div(1, 0));
    }

    // Extra edges to push coverage well above 95%
    @Test void more_edges() {
        assertEquals(0, c.add(0, 0));
        assertEquals(-6, c.mul(-2, 3));
        assertEquals(1, c.sub(2, 1));
    }
}
