package net.frakbot.google.challenge.test.namethatrabbit;

import net.frakbot.google.challenge.namethatrabbit.Answer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Francesco Pontillo
 */
public class AnswerTest {
    @Test
    public void testCase1() {
        String[] names = new String[] {"annie", "bonnie", "liz"};
        String[] expected = new String[] {"bonnie", "liz", "annie"};
        Assert.assertArrayEquals(expected, Answer.answer(names));
    }

    @Test
    public void testCase2() {
        String[] names = new String[] {"abcdefg", "vi"};
        String[] expected = new String[] {"vi", "abcdefg"};
        Assert.assertArrayEquals(expected, Answer.answer(names));
    }

    @Test
    public void testCaseEqual() {
        String[] names = new String[] {"abcdefg", "abcdefg"};
        String[] expected = new String[] {"abcdefg", "abcdefg"};
        Assert.assertArrayEquals(expected, Answer.answer(names));
    }

    @Test
    public void testCaseEmpty() {
        String[] names = new String[] {};
        String[] expected = new String[] {};
        Assert.assertArrayEquals(expected, Answer.answer(names));
    }

    @Test
    public void testCaseSameValue() {
        String[] names = new String[] {"AL", "CJ"};
        String[] expected = new String[] {"CJ", "AL"};
        Assert.assertArrayEquals(expected, Answer.answer(names));
    }
}
