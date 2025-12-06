package ec.edu.epn;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void add_TwoPositiveNumbers_ReturnsCorrectSum() {
        int a = 2;
        int b = 4;
        int result = calculator.add(a, b);
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

    @Test
    void subtract_TwoNumbers_ReturnsCorrectDifference() {
        int a = 10;
        int b = 4;
        int result = calculator.subtract(a, b);
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

    @Test
    void multiply_TwoNumbers_ReturnsCorrectProduct() {
        int a = 6;
        int b = 7;
        int result = calculator.multiply(a, b);
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

    @Test
    void divide_TwoNumbers_ReturnsCorrectQuotient() {
        int a = 7;
        int b = 2;
        double result = calculator.divide(a, b);
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
        int a = 5;
        int b = 0;
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

    @Test
    void isEven_EvenNumber_ReturnsTrue() {
        int number = 8;
        boolean result = calculator.isEven(number);
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(ints = { 2, 4, 6, 8, 10, 0, -2, -4, -100, 1000 })
    void isEven_MultipleEvenNumbers_ReturnsTrue(int number) {
        assertTrue(calculator.isEven(number));
    }

    @Test
    void isEven_OddNumber_ReturnsFalse() {
        int number = 9;
        boolean result = calculator.isEven(number);
        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 5, 7, 9, -1, -3, -5, -99, 1001 })
    void isEven_MultipleOddNumbers_ReturnsFalse(int number) {
        assertFalse(calculator.isEven(number));
    }

    @Test
    void testDivisionConAssertAll() {
        Calculator calculator = new Calculator();
        double result = calculator.divide(20, 4);

        assertAll("Validaciones para la división",
                () -> assertEquals(5, result),
                () -> assertTrue(result > 0),
                () -> assertNotNull(result)
        );
    }
}