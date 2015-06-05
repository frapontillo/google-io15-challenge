package net.frakbot.google.challenge.test.whenitrainsitpours;

import net.frakbot.google.challenge.whenitrainsitpours.Answer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Francesco Pontillo
 */
public class AnswerTest {
    @Test
    public void testCaseNormal() {
        Assert.assertEquals(5, Answer.answer(new int[] {1, 4, 2, 5, 1, 2, 3}));
    }

    @Test
    public void testCaseFlow() {
        Assert.assertEquals(0, Answer.answer(new int[] {1, 2, 3, 2, 1}));
    }

    @Test
    public void testCaseBox() {
        Assert.assertEquals(2, Answer.answer(new int[] {3,1,3}));
    }

    @Test
    public void testCaseHuge1() {
        Assert.assertEquals(31, Answer.answer(new int[] {12, 2, 1, 2, 12, 16, 2, 1}));
    }

    @Test
    public void testCaseHuge2() {
        Assert.assertEquals(13, Answer.answer(new int[] {1, 4, 1, 4, 2, 4, 2, 4, 1, 2, 3, 4, 1}));
    }

    @Test
    public void testCaseNoop1() {
        Assert.assertEquals(0, Answer.answer(new int[] {1,1,1,1,1,1}));
    }

    @Test
    public void testCaseNoop2() {
        Assert.assertEquals(0, Answer.answer(new int[] {1,1,2,2,1,1}));
    }

    @Test
    public void testCaseNoop3() {
        Assert.assertEquals(0, Answer.answer(new int[] {1,2,2}));
    }

    @Test
    public void testCaseNoop4() {
        Assert.assertEquals(0, Answer.answer(new int[] {9000}));
    }
}
