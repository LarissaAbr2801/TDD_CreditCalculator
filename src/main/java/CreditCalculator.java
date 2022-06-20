import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CreditCalculator {

    private static final BigDecimal MONTHS = BigDecimal.valueOf(12);
    private static final BigDecimal ONE_HUNDRED_PERCENT = BigDecimal.valueOf(1);

    public BigDecimal calculateMonthlyPayment(BigDecimal yearsNumber, BigDecimal loanAmount,
                                              BigDecimal interestRate) {
        return calculateTotalDebt(yearsNumber, loanAmount, interestRate)
                .divide(yearsNumber.multiply(MONTHS), RoundingMode.HALF_EVEN);

    }

    public BigDecimal calculateTotalDebt(BigDecimal yearsNumber, BigDecimal loanAmount, BigDecimal interestRate) {
        return loanAmount.multiply(interestRate.multiply(yearsNumber).add(ONE_HUNDRED_PERCENT));
    }

    public BigDecimal calculateOverPaymentForEntirePeriod(BigDecimal yearsNumber, BigDecimal loanAmount,
                                                          BigDecimal interestRate) {
        return calculateTotalDebt(yearsNumber, loanAmount, interestRate).subtract(loanAmount);
    }

}
