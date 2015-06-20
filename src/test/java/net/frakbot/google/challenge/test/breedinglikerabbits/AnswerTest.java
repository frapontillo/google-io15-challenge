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
    public void testHuuuuuuge() {
        // test and counter-test because we don't trust ourselves #ahahahahlol
        Assert.assertEquals("46562747725281304248321", Answer.answer("0.9E24"));
        Assert.assertEquals(Double.parseDouble("0.9E24"), Answer.R(new BigInteger("46562747725281304248321")), 0);
    }

    @Test
    public void testHuuuge() {
        // test and counter-test because we don't trust ourselves #ahahahahlol
        Assert.assertEquals("425065432836037312250041", Answer.answer("8.54857545878E24"));
        Assert.assertEquals(Double.parseDouble("8.54857545878E24"), Answer.R(new BigInteger("425065432836037312250041")), 0);
    }

    @Test
    public void testWat() {
        Assert.assertEquals(Answer.NONE, Answer.answer("-1"));
        Assert.assertEquals(Answer.NONE, Answer.answer("8."));
        Assert.assertEquals(Answer.NONE, Answer.answer("ciao"));
        Assert.assertEquals(Answer.NONE, Answer.answer("lol"));
        Assert.assertEquals(Answer.NONE, Answer.answer(""));
        Assert.assertEquals(Answer.NONE, Answer.answer(null));
    }

    @Test
    public void testAll() {
        final int MAX = 200000;
        Set<Double> handled = new HashSet<Double>();
        // generate the first MAX values
        for (int i = 0; i < MAX; i++) {
            Answer.R(BigInteger.valueOf(i));
        }
        // visit the array in reverse and generate the values
        for (int i = MAX - 1; i >= 0; i--) {
            String expected = Integer.toString(i);
            Double numberAnswer = Answer.partials.get(BigInteger.valueOf(i));
            String answer = Answer.answer(String.format("%.0f", numberAnswer));
            if (!expected.equals(answer) && numberAnswer <= MAX && !handled.contains(numberAnswer)) {
                System.err.println(String.format("%s does not match the calculated %s", expected, answer));
            }
            handled.add(numberAnswer);
        }
    }
}
