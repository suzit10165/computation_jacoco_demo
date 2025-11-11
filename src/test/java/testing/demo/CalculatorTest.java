package testing.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calc = new Calculator();

    @Test
    void testAdd() {
        assertEquals(4, calc.add(2, 2));
    }

    @Test
    void testSubstract() {
        assertEquals(0, calc.substract(2, 2));
    }

    @Test
    void testMultiple() {
        assertEquals(4, calc.multiple(2, 2));
    }

    @Test
    void testDivide() {
        assertEquals(1, calc.divide(2, 2));
    }
}
