package net.frakbot.google.challenge.originsandorder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Francesco Pontillo
 */
public class Answer {
    private final static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final static String AMBIGUOUS = "Ambiguous";

    public static String answer(int x, int y, int z) {
        List<Integer> list = Arrays.asList(x, y, z);
        Collections.sort(list);

        int month = list.get(0);
        int day = list.get(1);
        int year = list.get(2);

        // if the month is 0, shift everything
        if (month == 0) {
            int newMonth = day;
            day = year;
            year = month;
            month = newMonth;
        }

        int maxDay;
        try {
            maxDay = days[month - 1];
        } catch (ArrayIndexOutOfBoundsException exc) {
            return AMBIGUOUS;
        }

        // month must be valid
        // day must be gt 12 or equal to the month and lte the maximum day for the month
        // the year must be gte the day or gt the maximum day
        if ((month >= 1 && month <= 12 && (day == month || day > 12) && day <= maxDay && (year == day || year > maxDay || year == 0))) {
            return String.format("%02d", month) + "/" + String.format("%02d", day) + "/" + String.format("%02d", year);
        }

        return AMBIGUOUS;
    }
}
