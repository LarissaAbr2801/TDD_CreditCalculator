import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class CreditCalculatorTests {

    CreditCalculator creditCalculator;

    @BeforeEach
    public void initEach() {
        System.out.println("Тест для метода класса CreditCalculator запущен");
    }

    @AfterEach
    public void finishEach() {
        System.out.println("Тест для метода класса CreditCalculator завершен");
    }

    @ParameterizedTest
    @MethodSource("sourceCalculateMonthlyPayment")
    void testCalculateMonthlyPayment(int yearsNumber, BigDecimal loanAmount, BigDecimal interestRate,
                                     BigDecimal expected) {
        creditCalculator = new CreditCalculator();

        BigDecimal result = creditCalculator.calculateMonthlyPayment(yearsNumber, loanAmount,
                interestRate);

        Assertions.assertEquals(result, expected);
    }

    private static Stream<Arguments> sourceCalculateMonthlyPayment() {
        return Stream.of(Arguments.of(), Arguments.of());
    }

    @ParameterizedTest
    @MethodSource("sourceCalculateTotalDebt")
    void testCalculateTotalDebt(int yearsNumber, BigDecimal loanAmount, BigDecimal interestRate,
                                BigDecimal expected) {
        creditCalculator = new CreditCalculator();

        BigDecimal result = creditCalculator.calculateTotalDebt(yearsNumber, loanAmount,
                interestRate);

        Assertions.assertEquals(result, expected);
    }

    private static Stream<Arguments> sourceCalculateTotalDebt() {
        return Stream.of(Arguments.of(), Arguments.of());
    }

    @ParameterizedTest
    @MethodSource("sourceCalculateOverPaymentForEntirePeriod")
    void testCalculateOverPaymentForEntirePeriod(int yearsNumber, BigDecimal loanAmount,
                                                 BigDecimal interestRate, BigDecimal expected) {
        creditCalculator = new CreditCalculator();

        BigDecimal result = creditCalculator.calculateOverPaymentForEntirePeriod(yearsNumber, loanAmount,
                interestRate);

        Assertions.assertEquals(result, expected);
    }

    private static Stream<Arguments> sourceCalculateOverPaymentForEntirePeriod() {
        return Stream.of(Arguments.of(), Arguments.of());
    }

}
