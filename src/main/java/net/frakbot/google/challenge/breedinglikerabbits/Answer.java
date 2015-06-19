package net.frakbot.google.challenge.breedinglikerabbits;

import java.util.HashMap;

/**
 * @author Francesco Pontillo
 */
public class Answer {
    public static final String NONE = "None";
    public static final HashMap<Double, Double> partials = new HashMap<>();

    static {
        partials.put(0D, 1D);
        partials.put(1D, 1D);
        partials.put(2D, 2D);
    }

    public static Double R(Double time) {
        if (partials.get(time) == null) {
            Double value;
            if (time % 2 == 0) {
                value = R(time / 2) + R((time / 2) + 1) + (time / 2);
            } else {
                value = R((time - 3) / 2) + R((time - 1) / 2) + 1;
            }
            partials.put(time, value);
        }
        return partials.get(time);
    }

    public static String answer(String str_S) {
        Double zombits = Double.parseDouble(str_S);
        Double time = -1D;

        //time = getTime(zombits, 0D, zombits);
        time = getTime(zombits);

        if (time < 0) {
            return NONE;
        }
        return String.format("%s", time);
    }

    private static Double getTime(Double number) {
        for (double i = 1; i < number; i++) {
            Double value = R(Math.pow(i,i));
            if (value >= number) {
                System.out.println("yolo");
                return value;
            }
        }
        return -1D;
    }

    private static Double getTime(Double number, Double min, Double max) {
        Double medium = (max - min) / 2;
        Double mediumValue = R(medium);
        if (mediumValue.equals(number)) {
            return medium;
        }
        if (number < mediumValue) {
            return getTime(number, min, medium);
        }
        return getTime(number, medium, max);
    }

    /*

    private static final int MAX_POINTS = 100;

    long[] oddX = new long[MAX_POINTS];
    long[] evenX = new long[MAX_POINTS];
    double[] oddY = new double[MAX_POINTS];
    double[] evenY = new double[MAX_POINTS];

    // build the first n = MAX_POINTS*2 values (avoid 0, 1, 2 as they may bias the approximation)
    for (int i = 3; i < (MAX_POINTS * 2) + 3; i++) {
        if (i % 2 == 1) {
            oddX[(i-3)/2] = i;
            oddY[(i-3)/2] = getValue(i);
        } else {
            evenX[(i-4)/2] = i;
            evenY[(i-3)/2] = getValue(i);
        }
    }

    double[][] coefficients = getCoefficients(oddX, oddY, evenX, evenY);
    double[] oddDifferences = coefficients[0];
    double[] evenDifferences = coefficients[1];

    // use Neville's differences algorithm to find the polynomials coefficients
    // (see https://en.wikipedia.org/wiki/Neville%27s_algorithm)
    private static double[][] getCoefficients(long[] oddX, double[] oddY, long[] evenX, double[] evenY) {
        double[] oddDifferences = oddY.clone();
        double[] evenDifferences = evenY.clone();
        for (int col = 1; col < MAX_POINTS; col++) {
            // for each loop, calculate all the differences
            for (int row = MAX_POINTS - 1; row > 0; row--) {
                if(row >= col) {
                    oddDifferences[row] = (oddDifferences[row] - oddDifferences[row - 1]) / (oddX[row] - oddX[row - col]);
                    evenDifferences[row] = (evenDifferences[row] - evenDifferences[row - 1]) / (evenX[row] - evenX[row - col]);
                }
            }
        }
        return new double[][] {oddDifferences, evenDifferences};
    }

    public static Double getSolutionForTime(long time, long[] x, double[] coefficients) {
        double solution = 0D;
        for (int i = 0; i < MAX_POINTS; i++) {
            Double term = coefficients[i];
            for (int j = 0; j < i; j++) {
                if (term == 0) {
                    break;
                }
                term *= (time - x[j]);
            }
            solution += term;
        }
        return solution;
    }
    */

}
