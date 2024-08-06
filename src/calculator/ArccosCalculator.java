package calculator;

/**
 * This class provides methods to calculate the arccosine and arcsine of a number.
 */
public final class ArccosCalculator {

    /**
     * Private constructor to prevent instantiation.
     */
    private ArccosCalculator() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Calculates the arccosine of a number.
     *
     * @param input the input value, which must be in the range -1 to 1.
     * @return the arccosine of the input value.
     * @throws IllegalArgumentException
     * if the input value is not in the range -1 to 1.
     */
    public static double calculateArccos(final double input) {
        if (input < -1 || input > 1) {
            throw new IllegalArgumentException("Input value must be in the range -1 to 1.");
        }
        return Math.PI / 2 - calculateArcsin(input);
    }

    /**
     * @param input the input value.
     * @return the arcsine of the input value.
     */
    public static double calculateArcsin(final double input) {
        double term = 0;
        double termValue;
        int exponent;
        for (int n = 1; n < 30_000; n++) {
            exponent = 2 * n - 1;
            final double coefficient1 = calculateCoefficient1(exponent);
            termValue = power(input, exponent) / exponent;
            term += coefficient1 * termValue;
        }
        return term;
    }

    /**
     * Calculates the first part of the coefficient
     * used in the Taylor Series expansion.
     *
     * @param exponent the power of x.
     * @return the coefficient value.
     */
    public static double calculateCoefficient1(final int exponent) {
        double result = 1;
        for (int i = 1; i < exponent; i++) {
            if (i % 2 == 0) {
                result /= i;
            } else {
                result *= i;
            }
        }
        return result;
    }

    /**
     * Calculates the power of a number.
     *
     * @param input the base value.
     * @param exponent the exponent value.
     * @return the result of raising x to the power of exponent.
     */
    public static double power(final double input, final int exponent) {
        double pow = 1;
        for (int i = 1; i <= exponent; i++) {
            pow *= input;
        }
        return pow;
    }
}
