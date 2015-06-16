package net.frakbot.google.challenge.breedinglikerabbits;

import java.util.HashMap;

/**
 * @author Francesco Pontillo
 */
public class Answer {
    public static final String NONE = "None";
    public static final HashMap<Long, Double> partials = new HashMap<Long, Double>();

    static {
        partials.put(0L, 1D);
        partials.put(1L, 1D);
        partials.put(2L, 2D);
    }

    public static String answer(String str_S) {
        Double number = Double.parseDouble(str_S);
        Long solution = -1L;

        int alwaysLower = 2;
        for (Long time = 0L; alwaysLower > 0; time++) {
            Double value = calcValue(time);
            if (value > number) {
                alwaysLower = alwaysLower + ((value > number) ? -1 : +1);
            }
            if (value.equals(number) && solution < time) {
                solution = time;
            }
        }
        if (solution < 0) {
            return NONE;
        }
        return String.format("%s", solution);
    }

    public static Double calcValue(Long time) {
        if (partials.get(time) == null) {
            Double value;
            // even
            if (time % 2 == 0) {
                value = partials.get(time / 2) + partials.get((time / 2) + 1) + (time / 2);
            } else {
                value = partials.get((time - 3) / 2) + partials.get((time - 1) / 2) + 1;
            }
            partials.put(time, value);
        }
        return partials.get(time);
    }
}
