package net.frakbot.google.challenge.breedinglikerabbits;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * @author Francesco Pontillo
 */
public class Answer {
    public static final String NONE = "None";
    public static final HashMap<BigInteger, BigInteger> partials = new HashMap<>();

    private final static BigInteger TWO = BigInteger.valueOf(2);
    private final static BigInteger THREE = BigInteger.valueOf(3);

    // seed values
    static {
        partials.put(BigInteger.ZERO, BigInteger.ONE);
        partials.put(BigInteger.ONE, BigInteger.ONE);
        partials.put(TWO, TWO);
    }

    public static String answer(String str_S) {
        BigInteger zombits;
        try {
            // parsing is achieved by BigInteger so we discard scientific notations even if numeric values are valid
            zombits = new BigInteger(str_S);
            // discard values out of the range in the specs
            if (zombits.compareTo(BigInteger.TEN.pow(25)) > 0 || zombits.compareTo(BigInteger.ZERO) <= 0) {
                return NONE;
            }
        } catch (Exception e) {
            return NONE;
        }

        // search for the result in both search spaces (odd and even) and take the maximum one
        BigInteger oddTime = getTimeExponential(zombits, false);
        BigInteger evenTime = getTimeExponential(zombits, true);
        BigInteger time = oddTime.max(evenTime);

        if (time.compareTo(BigInteger.ZERO) < 0) {
            return NONE;
        }
        return String.format("%s", time);
    }

    /**
     * Makes an iterative exponential search to split the search space (that is expensively generated).
     *
     * @param number The number to search in the space.
     * @param even   {@code true} if the number must be searched in the space generated by even indexes only,
     *               {@code false} if the number must be searched in the space generated by odd indexes only.
     * @return       A {@link BigInteger} representing the value x for which R(x) = number.
     */
    private static BigInteger getTimeExponential(BigInteger number, boolean even) {
        if (number.compareTo(THREE) < 0) {
            return number.equals(BigInteger.ZERO) ? BigInteger.ONE : BigInteger.valueOf(number.longValue());
        }
        BigInteger base = TWO;
        BigInteger min = even ? BigInteger.ZERO : BigInteger.ONE;
        int exp = 1;
        boolean changed = true;
        do {
            // calculate the starting index
            // the initial start is 2 + min so it's always compatible to even/odd
            // following restarts begin at 2 + min so the even/odd property is kept
            BigInteger index = base.pow(exp).add(min);
            // calculate the value at current index
            BigInteger value = R(index);
            // if the value at the beginning of the current index equals the one we're looking for, return the index
            if (value.equals(number)) {
                return index;
            }
            // if we passed the number we're searching for at the current index
            // reset the exponent and restart from a new value
            if (value.compareTo(number) > 0) {
                // the new min will use the previous exponent and will be increased by the current min
                // so we look for next items only
                min = base.pow(exp - 1).add(min);
                // if this is the first loop AGAIN, exit, since we're in a range that can't be simplified anymore
                if (exp == 1) {
                    changed = false;
                }
                exp = 1;
            } else {
                // increment the exponent so we search faster, better, harder, stronger
                // (cit. https://www.youtube.com/watch?v=gAjR4_CbPpQ)
                exp += 1;
            }
        } while (changed);

        // at this point the min value is the only candidate index whose R value can be equal to the number
        BigInteger value = R(min);
        if (number.equals(value)) {
            return min;
        }

        return BigInteger.valueOf(-1);
    }

    /**
     * Recursive method to generate the search space for a given value of time.
     * @param time  The value to generate the result of R(time) for.
     * @return      The result of R(time) according to the specs.
     */
    public static BigInteger R(BigInteger time) {
        if (partials.get(time) == null) {
            BigInteger value;
            // apply the proper formula
            if (isEven(time)) {
                value = R(time.divide(TWO))
                        .add(R(time.divide(TWO).add(BigInteger.ONE)))
                        .add(time.divide(TWO));
            } else {
                value = R(time.subtract(THREE).divide(TWO))
                        .add(R(time.subtract(BigInteger.ONE).divide(TWO)))
                        .add(BigInteger.ONE);
            }
            // cache the value for further uses
            partials.put(time, value);
        }
        return partials.get(time);
    }

    private static boolean isEven(BigInteger value) {
        return value.mod(TWO).equals(BigInteger.ZERO);
    }
}
