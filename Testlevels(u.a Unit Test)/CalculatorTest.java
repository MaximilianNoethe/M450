package main.test;

import main.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("Addition: Sollte zwei Zahlen korrekt addieren")
    void testAdd() {
        assertEquals(5.0, calculator.add(2.0, 3.0));
        assertEquals(-1.0, calculator.add(2.0, -3.0), "Addition mit negativen Zahlen");
        assertEquals(0.3, calculator.add(0.1, 0.2), 0.0001);
    }

    @Test
    @DisplayName("Subtraktion: Sollte die Differenz bilden")
    void testSubtract() {
        assertEquals(1.0, calculator.subtract(3.0, 2.0));
        assertEquals(-5.0, calculator.subtract(-2.0, 3.0));
    }

    @Test
    @DisplayName("Multiplikation: Sollte das Produkt berechnen")
    void testMultiply() {
        assertEquals(6.0, calculator.multiply(2.0, 3.0));
        assertEquals(-6.0, calculator.multiply(2.0, -3.0));
        assertEquals(0.0, calculator.multiply(5.0, 0.0));
    }

    @Test
    @DisplayName("Division: Sollte den Quotienten berechnen")
    void testDivide() {
        assertEquals(2.5, calculator.divide(5.0, 2.0));
        assertEquals(-2.0, calculator.divide(-6.0, 3.0));
    }

    @Test
    @DisplayName("Division durch Null: Sollte Fehler werfen")
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(5.0, 0.0);
        }, "Teilen durch Null sollte verboten sein");
    }
}
