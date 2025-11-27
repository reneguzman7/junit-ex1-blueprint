package ec.edu.epn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class StringValidatorTest {

    private StringValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new StringValidator();
    }

    @Test
    public void testValidateNotEmpty_ValidString_NoException() {
        assertDoesNotThrow(() -> validator.validateNotEmpty("Valid String"));
        assertDoesNotThrow(() -> validator.validateNotEmpty("a"));
        assertDoesNotThrow(() -> validator.validateNotEmpty("  text  "));
    }

    @Test
    public void testValidateNotEmpty_NullString_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateNotEmpty(null);
        });
        assertEquals("Input cannot be null.", exception.getMessage());
    }

    @Test
    public void testValidateNotEmpty_EmptyString_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateNotEmpty("");
        });
        assertEquals("Input cannot be empty.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"   ", "\t", "\n", "  \t\n  "})
    public void testValidateNotEmpty_WhitespaceStrings_ThrowsException(String input) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateNotEmpty(input);
        });
        assertEquals("Input cannot be empty.", exception.getMessage());
    }

    @ParameterizedTest
    @NullSource
    public void testValidateNotEmpty_NullInput_ThrowsException(String input) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateNotEmpty(input);
        });
        assertEquals("Input cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello", "World", "Test123", "Valid Input", "a", "123"})
    public void testValidateNotEmpty_ValidInputs_NoException(String input) {
        assertDoesNotThrow(() -> validator.validateNotEmpty(input));
    }
}
