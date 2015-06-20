package net.frakbot.google.challenge.test.breedinglikerabbits;

import net.frakbot.google.challenge.breedinglikerabbits.Answer;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Francesco Pontillo
 */
public class AnswerTest {
    @Test
    public void testBases() {
        Assert.assertEquals("1", Answer.answer("1"));
        Assert.assertEquals("2", Answer.answer("2"));
        Assert.assertEquals("3", Answer.answer("3"));
    }

    @Test
    public void testEven() {
        Assert.assertEquals("4", Answer.answer("7"));
    }

    @Test
    public void testOdd() {
        Assert.assertEquals("13", Answer.answer("18"));
    }

    @Test
    public void testNone() {
        Assert.assertEquals(Answer.NONE, Answer.answer("100"));
    }

    @Test
    public void testWat() {
        Assert.assertEquals(Answer.NONE, Answer.answer("-1"));
        Assert.assertEquals(Answer.NONE, Answer.answer("8."));
        Assert.assertEquals(Answer.NONE, Answer.answer("ciao"));
        Assert.assertEquals(Answer.NONE, Answer.answer("lol"));
        Assert.assertEquals(Answer.NONE, Answer.answer(""));
        Assert.assertEquals(Answer.NONE, Answer.answer(null));
        Assert.assertEquals(Answer.NONE, Answer.answer("10000000000000000000000001"));
        Assert.assertEquals(Answer.NONE, Answer.answer("10E25"));
        Assert.assertEquals(Answer.NONE, Answer.answer("0"));
        Assert.assertEquals(Answer.NONE, Answer.answer("-"));
        Assert.assertEquals(Answer.NONE, Answer.answer("-10000"));
    }

    @Test
    public void testAll() {
        final BigInteger FROM = BigInteger.valueOf(0);
        final BigInteger MAX = BigInteger.valueOf(40000);
        Set<BigInteger> handled = new HashSet<>();
        // generate the first MAX values
        for (BigInteger i = FROM; i.compareTo(MAX) < 0; i = i.add(BigInteger.ONE)) {
            Answer.R(i);
        }
        // visit the array in reverse and get answers for results we already know
        for (BigInteger i = MAX.subtract(BigInteger.ONE); i.compareTo(FROM) >= 0; i = i.subtract(BigInteger.ONE)) {
            String expected = i.toString();
            BigInteger numberAnswer = Answer.partials.get(i);
            String answer = Answer.answer(String.format("%s", numberAnswer));
            if (!expected.equals(answer) && !handled.contains(numberAnswer) && numberAnswer.compareTo(MAX) <= 0) {
                System.err.println(String.format("R(%s) expected was %s. Got %s.", i, expected, answer));
            }
            if (numberAnswer.compareTo(MAX) <= 0 && !handled.contains(numberAnswer)) {
                Assert.assertEquals(expected, answer);
            }
            // add the answer to the set of answers so not to make any assertions on lower indexes
            handled.add(numberAnswer);
        }
    }

    /**
     * Huge method to test and counter test values.
     * NOTE: this is insanely expensive for higher indexes/values.
     */
    @Test
    public void counterTest() {
        final BigInteger FROM = BigInteger.valueOf(1);
        final BigInteger MAX = BigInteger.valueOf(100000);
        for (BigInteger i = FROM; i.compareTo(MAX) < 0; i = i.add(BigInteger.ONE)) {
            // get the x out of Rx
            String x = Answer.answer(i.toString());
            if (x.equals(Answer.NONE)) {
                continue;
            }
            // use x to get Rx
            BigInteger Rx = Answer.R(new BigInteger(x));
            if (!i.equals(Rx)) {
                System.err.println(String.format("R^(-1)(%s) = %s but R(%s) = %s.", i, x, x, Rx));
            }
        }
    }
}
