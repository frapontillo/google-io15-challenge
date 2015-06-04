package net.frakbot.google.challenge.test.originsandorder;

import net.frakbot.google.challenge.originsandorder.Answer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Francesco Pontillo
 */
public class AnswerTest {
    private final static String AMBIGUOUS = "Ambiguous";

    @Test
    public void testCase1() {
        String result = "01/01/01";
        Assert.assertEquals(result, Answer.answer(1,1,1));
    }

    @Test
    public void testCase2() {
        String result = AMBIGUOUS;
        Assert.assertEquals(result, Answer.answer(1,1,2));
    }

    @Test
    public void testCase3() {
        String result = AMBIGUOUS;
        Assert.assertEquals(result, Answer.answer(1,2,3));
    }

    @Test
    public void testCase4() {
        String result = "01/13/13";
        Assert.assertEquals(result, Answer.answer(1,13,13));
    }

    @Test
    public void testCase5() {
        String result = AMBIGUOUS;
        Assert.assertEquals(result, Answer.answer(1,13,14));
    }

    @Test
    public void testCase6() {
        String result = AMBIGUOUS;
        Assert.assertEquals(result, Answer.answer(13,13,14));
    }

    @Test
    public void testCase7() {
        String result = "12/31/31";
        Assert.assertEquals(result, Answer.answer(12,31,31));
    }

    @Test
    public void testCase8() {
        String result = "12/31/32";
        Assert.assertEquals(result, Answer.answer(12,31,32));
    }

    @Test
    public void testCase9() {
        String result = AMBIGUOUS;
        Assert.assertEquals(result, Answer.answer(12,30,31));
    }

    @Test
    public void testCase10() {
        String result = AMBIGUOUS;
        Assert.assertEquals(result, Answer.answer(2,30,32));
    }

    @Test
    public void testCase11() {
        String result = "03/19/19";
        Assert.assertEquals(result, Answer.answer(19,19,3));
    }

    @Test
    public void testCase12() {
        String result = AMBIGUOUS;
        Assert.assertEquals(result, Answer.answer(2,30,3));
    }

    @Test
    public void testCase13() {
        String result = "02/28/00";
        Assert.assertEquals(result, Answer.answer(2,28,0));
    }

    @Test
    public void testCase14() {
        String result = "12/12/00";
        Assert.assertEquals(result, Answer.answer(12,12,0));
    }

    @Test
    public void testCase15() {
        String result = AMBIGUOUS;
        Assert.assertEquals(result, Answer.answer(1,12,0));
    }

    @Test
    public void testCase16() {
        String result = "01/13/00";
        Assert.assertEquals(result, Answer.answer(1,13,0));
    }
}
