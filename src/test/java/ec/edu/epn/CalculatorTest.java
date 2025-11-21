package ec.edu.epn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }

    // ========== ADD TESTS ==========

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

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "5, 7, 12",
            "-1, 1, 0",
            "0, 0, 0",
            "-5, -3, -8",
            "100, 200, 300"
    })
    void add_MultipleValues_ReturnsCorrectSum(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    // ========== SUBTRACT TESTS ==========

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

    @ParameterizedTest
    @CsvSource({
            "10, 4, 6",
            "5, 5, 0",
            "0, 5, -5",
            "-5, -3, -2",
            "100, 50, 50",
            "-10, 5, -15"
    })
    void subtract_MultipleValues_ReturnsCorrectDifference(int a, int b, int expected) {
        assertEquals(expected, calculator.subtract(a, b));
    }

    // ========== MULTIPLY TESTS ==========

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

    @ParameterizedTest
    @CsvSource({
            "6, 7, 42",
            "5, 5, 25",
            "0, 10, 0",
            "-5, 3, -15",
            "-4, -5, 20",
            "10, 0, 0"
    })
    void multiply_MultipleValues_ReturnsCorrectProduct(int a, int b, int expected) {
        assertEquals(expected, calculator.multiply(a, b));
    }

    // ========== DIVIDE TESTS ==========

    @Test
    void divide_TwoNumbers_ReturnsCorrectQuotient() {
        // Arrange
        int a = 7;
        int b = 2;

        // Act
        double result = calculator.divide(a, b);

        // Assert
        assertEquals(3.5, result);
    }

    @ParameterizedTest
    @CsvSource({
            "7, 2, 3.5",
            "10, 2, 5.0",
            "9, 3, 3.0",
            "-10, 2, -5.0",
            "15, 4, 3.75",
            "0, 5, 0.0"
    })
    void divide_MultipleValues_ReturnsCorrectQuotient(int a, int b, double expected) {
        assertEquals(expected, calculator.divide(a, b));
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
    void divide_ByZero_AssertsExceptionMessage() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(5, 0);
        });
        assertEquals("The divisor cannot be zero.", illegalArgumentException.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 10, -5, 100, -50 })
    void divide_ByZero_ThrowsIllegalArgumentException(int dividend) {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(dividend, 0);
        });
    }

    // ========== IS EVEN TESTS ==========

    @Test
    void isEven_EvenNumber_ReturnsTrue() {
        // Arrange
        int number = 8;

        // Act
        boolean result = calculator.isEven(number);

        // Assert
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(ints = { 2, 4, 6, 8, 10, 0, -2, -4, -100, 1000 })
    void isEven_MultipleEvenNumbers_ReturnsTrue(int number) {
        assertTrue(calculator.isEven(number));
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

    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 5, 7, 9, -1, -3, -5, -99, 1001 })
    void isEven_MultipleOddNumbers_ReturnsFalse(int number) {
        assertFalse(calculator.isEven(number));
    }
}