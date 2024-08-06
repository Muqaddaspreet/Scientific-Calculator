package test.java.calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ArccosCalculatorTest {

    private static final double TOLERANCE = 1e-2;  // Tolerance for two decimal places

    @Test
    void testCalculateArccos_validInput() {
        assertEquals(Math.round(Math.PI / 2 * 100) / 100.0, Math.round(main.java.calculator.ArccosCalculator.calculateArccos(0) * 100) / 100.0, TOLERANCE);
        assertEquals(Math.round(0.00 * 100) / 100.0, Math.round(main.java.calculator.ArccosCalculator.calculateArccos(1) * 100) / 100.0, TOLERANCE);
        assertEquals(Math.round(Math.PI * 100) / 100.0, Math.round(main.java.calculator.ArccosCalculator.calculateArccos(-1) * 100) / 100.0, TOLERANCE);
    }

    @Test
    void testCalculateArccos_invalidInput() {
        assertThrows(IllegalArgumentException.class, () -> main.java.calculator.ArccosCalculator.calculateArccos(2));
        assertThrows(IllegalArgumentException.class, () -> main.java.calculator.ArccosCalculator.calculateArccos(-2));
    }

    @Test
    void testCalculateArcsin() {
        assertEquals(Math.round(0 * 100) / 100.0, Math.round(main.java.calculator.ArccosCalculator.calculateArcsin(0) * 100) / 100.0, TOLERANCE);
        assertEquals(Math.round(Math.PI / 2 * 100) / 100.0, Math.round(main.java.calculator.ArccosCalculator.calculateArcsin(1) * 100) / 100.0, TOLERANCE);
        assertEquals(Math.round(-Math.PI / 2 * 100) / 100.0, Math.round(main.java.calculator.ArccosCalculator.calculateArcsin(-1) * 100) / 100.0, TOLERANCE);
    }

    @Test
    void testPower() {
        assertEquals(1, main.java.calculator.ArccosCalculator.power(5, 0), 1e-6);
        assertEquals(5, main.java.calculator.ArccosCalculator.power(5, 1), 1e-6);
        assertEquals(25, main.java.calculator.ArccosCalculator.power(5, 2), 1e-6);
    }
}
