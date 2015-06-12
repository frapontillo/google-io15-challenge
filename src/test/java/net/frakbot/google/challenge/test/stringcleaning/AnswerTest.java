package net.frakbot.google.challenge.test.stringcleaning;

import net.frakbot.google.challenge.stringcleaning.Answer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Francesco Pontillo
 */
public class AnswerTest {
    @Test
    public void testCase1() {
        Assert.assertEquals("looo", Answer.answer("lololololo", "lol"));
    }

    @Test
    public void testCase2() {
        Assert.assertEquals("dogfood", Answer.answer("goodgooogoogfogoood", "goo"));
    }

    @Test
    public void testEmpty() {
        Assert.assertEquals("", Answer.answer("", "lols"));
    }

    @Test
    public void testNonMatch() {
        Assert.assertEquals("ahahahahlol", Answer.answer("ahahahahlol", "lols"));
    }
}
