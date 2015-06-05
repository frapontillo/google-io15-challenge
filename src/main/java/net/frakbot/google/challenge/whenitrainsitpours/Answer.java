package net.frakbot.google.challenge.whenitrainsitpours;

import java.util.Arrays;

/**
 * @author Francesco Pontillo
 */
public class Answer {
    public static int answer(int[] heights) {
        int water = 0;
        int h = 0;

        // loop on the heights (exclude the last two, since they can't make an empty box)
        while (h < heights.length - 2) {
            // if the right column is higher or equal than the current one, ignore the current one
            int rightH = h + 1;
            if (heights[h] <= heights[rightH]) {
                h += 1;
                continue;
            }
            // look for the highest element in the right part of the array
            int[] rightHeights = Arrays.copyOfRange(heights, rightH, heights.length);
            int nextHigherIndex = getNextHigherIndex(rightHeights, heights[h]) + h + 1;
            // if the found index is gt the current one and included in the array, we got business
            if (nextHigherIndex > h) {
                // get the lower bound of the box
                int lowestBound = Math.min(heights[h], heights[nextHigherIndex]);
                // for every element between h and nextHigherIndex
                for (int shift = rightH; shift < nextHigherIndex; shift++) {
                    // calc the difference and add to water
                    water += lowestBound - heights[shift];
                }
            }
            h = nextHigherIndex;
        }

        return water;
    }

    private static int getNextHigherIndex(int[] heights, int gt) {
        int maxIndex = 0;
        int maxValue = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] >= gt) {
                return i;
            }
            // if we haven't found anything higher than gt, record the local maximum
            if (heights[i] >= maxValue) {
                maxIndex = i;
                maxValue = heights[maxIndex];
            }
        }
        // no next higher index, return the local highest
        return maxIndex;
    }
}
