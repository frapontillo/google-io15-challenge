package net.frakbot.google.challenge.zombitmonitoring;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Francesco Pontillo
 */
public class Answer {
    public static int answer(int[][] intervals) {
        List<Range> rangeList = new ArrayList<Range>();
        List<Range> compactRangeList;

        for (int[] interval : intervals) {
            rangeList.add(new Range(interval));
        }

        boolean doItAgain;

        do {
            compactRangeList = new ArrayList<Range>();
            for (Range range : rangeList) {
                compactRangeList = addOrMerge(compactRangeList, range);
            }
            // if the range list has been compacted, do it again
            doItAgain = (rangeList.size() > compactRangeList.size());
            rangeList = compactRangeList;
        } while (doItAgain);

        return getTime(compactRangeList);
    }

    private static List<Range> addOrMerge(List<Range> ranges, Range newRange) {
        // when the newRange has been handled, any other matching range in ranges must be removed
        boolean handled = false;
        for (int i = 0; i < ranges.size(); i++) {
            Range existingRange = ranges.get(i);
            // if the newRange is contained in the existing one
            if (newRange.start >= existingRange.start && newRange.end <= existingRange.end) {
                handled = true;
            } else {
                // if the new range begins before the existing one and ends after the existing one starts
                if (newRange.start < existingRange.start && newRange.end >= existingRange.start) {
                    existingRange.start = newRange.start;
                    handled = true;
                }
                // if the new range ends after the existing one and it starts before the existing one ends, merge them
                if (newRange.end > existingRange.end && newRange.start <= existingRange.end) {
                    existingRange.end = newRange.end;
                    handled = true;
                }
            }
        }
        if (!handled) {
            ranges.add(newRange);
        }
        return ranges;
    }

    private static int getTime(List<Range> ranges) {
        int time = 0;
        for (Range range : ranges) {
            time += range.getTime();
        }
        return time;
    }

    public static class Range {
        int start;
        int end;

        public Range(int[] interval) {
            start = interval[0];
            end = interval[1];
        }

        public int getTime() {
            return end - start;
        }
    }
}
