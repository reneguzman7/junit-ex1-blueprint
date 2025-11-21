package ec.edu.epn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TaxCalculatorTest {

    private TaxCalculator taxCalculator;

    static Stream<Arguments> taxCalculatorData() {
        return Stream.of(
                Arguments.of(100.0, 0.15, 115.0), // 100 + 15% = 115
                Arguments.of(200.0, 0.10, 220.0), // 200 + 10% = 220
                Arguments.of(50.0, 0.20, 60.0), // 50 + 20% = 60
                Arguments.of(1000.0, 0.12, 1120.0), // 1000 + 12% = 1120
                Arguments.of(75.0, 0.08, 81.0), // 75 + 8% = 81
                Arguments.of(0.0, 0.15, 0.0), // 0 + 15% = 0
                Arguments.of(100.0, 0.0, 100.0), // 100 + 0% = 100
                Arguments.of(250.5, 0.15, 288.075) // 250.5 + 15% = 288.075
        );
    }

    @BeforeEach
    void setUp() {
        taxCalculator = new TaxCalculator();
    }

    @ParameterizedTest
    @MethodSource("taxCalculatorData")
    void calculateTax_MultipleTaxScenarios_ReturnsCorrectValueWithTax(double value, double tax, double expected) {
        // Arrange - Act
        double result = taxCalculator.calculateTax(value, tax);

        // Assert
        assertEquals(expected, result, 0.001);
    }
}
