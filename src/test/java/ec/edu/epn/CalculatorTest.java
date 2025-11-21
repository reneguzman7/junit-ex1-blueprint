package ec.edu.epn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    // Metodo casos_resultados_esperados

    @Test
    void add_TwoPositiveNumbers_ReturnsCorrectSum() {
        // Arrange
        int a = 2;
        int b = 4;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(6, result);
    }

    @Test
    void subtract_TwoNumbers_ReturnsCorrectDifference() {
        // Arrange
        int a = 10;
        int b = 4;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(6, result);
    }

    @Test
    void multiply_TwoNumbers_ReturnsCorrectProduct() {
        // Arrange
        int a = 6;
        int b = 7;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(42, result);
    }

    @Test
    void divide_TwoNumbers_ReturnsCorrectQuotient() {
        // Arrange
        int a = 7;
        int b = 2;

        // Act
        double result = calculator.divide(a, b);

        // Assert
        // Uso esperado de double
        assertEquals(3.5, result);
    }

    @Test
    void divide_DivideByZero_ThrowsIllegalArgumentException() {
        // Arrange
        int a = 5;
        int b = 0;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(a, b);
        });
    }

    @Test
    void isEven_EvenNumber_ReturnsTrue() {
        // Arrange
        int number = 8;

        // Act
        boolean result = calculator.isEven(number);

        // Assert
        assertTrue(result);
    }

    @Test
    void isEven_OddNumber_ReturnsFalse() {
        // Arrange
        int number = 9;

        // Act
        boolean result = calculator.isEven(number);

        // Assert
        assertFalse(result);
    }
}