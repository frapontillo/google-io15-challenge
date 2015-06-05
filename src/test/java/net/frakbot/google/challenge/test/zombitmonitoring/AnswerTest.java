package net.frakbot.google.challenge.test.zombitmonitoring;

import net.frakbot.google.challenge.zombitmonitoring.Answer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Francesco Pontillo
 */
public class AnswerTest {
    @Test
    public void testDuplicateRanges() {
        Assert.assertEquals(16, Answer.answer(new int[][]{
                new int[]{10, 14}, new int[]{4, 18}, new int[]{19, 20}, new int[]{19, 20}, new int[]{13, 20}
        }));
    }

    @Test
    public void testContinuousRanges() {
        Assert.assertEquals(5, Answer.answer(new int[][]{
                new int[]{1, 3}, new int[]{3, 6}
        }));
    }

    @Test
    public void testNonContinuousRanges() {
        Assert.assertEquals(4, Answer.answer(new int[][]{
                new int[]{1, 3}, new int[]{4, 6}
        }));
    }

    @Test
    public void testSeparateRanges() {
        Assert.assertEquals(5, Answer.answer(new int[][]{
                new int[]{2, 3}, new int[]{6, 10}
        }));
    }

    @Test
    public void testDifferentKindOfRanges() {
        Assert.assertEquals(10, Answer.answer(new int[][]{
                new int[]{1, 2}, new int[]{5, 6}, new int[]{6, 8}, new int[]{10, 12}, new int[]{12, 14}, new int[]{15, 17}
        }));
    }
}
