package ec.edu.epn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class EmailValidatorTest {

    private EmailValidator emailValidator;

    static Stream<Arguments> emailValidatorData() {
        Stream<Arguments> ret = Stream.of(
                Arguments.of("rene@example.com", true),
                Arguments.of("example@test.com", true),
                Arguments.of("correo.invalidado", false),
                Arguments.of("invalid@correo", false),
                Arguments.of(null, false));
        return ret;
    }

    @BeforeEach
    public void setUp() {
        emailValidator = new EmailValidator();
    }

    @ParameterizedTest
    @MethodSource("emailValidatorData")
    void isValid_MultipleEmails_ShouldReturnTrue(String email, boolean expected) {
        // Arrange - Act
        boolean result = emailValidator.isValid(email);
        // Assert
        assertEquals(expected, result);
    }

}
