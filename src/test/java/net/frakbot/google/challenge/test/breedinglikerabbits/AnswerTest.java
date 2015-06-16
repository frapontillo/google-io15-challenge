package net.frakbot.google.challenge.test.breedinglikerabbits;

import net.frakbot.google.challenge.breedinglikerabbits.Answer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Francesco Pontillo
 */
public class AnswerTest {
    @Test
    public void testBase1() {
        Assert.assertEquals("1", Answer.answer("1"));
    }

    @Test
    public void testBase2() {
        Assert.assertEquals("2", Answer.answer("2"));
    }

    @Test
    public void testOdd() {
        Assert.assertEquals("4", Answer.answer("7"));
    }

    @Test
    public void testNone() {
        Assert.assertEquals(Answer.NONE, Answer.answer("100"));
    }

    @Test
    public void testHuge() {
        Assert.assertEquals(Answer.NONE, Answer.answer("18"));
    }

    @Test
    public void testLols() {
        List<String> lols = new ArrayList<String>(101);
        for (Long time = 0L; time <= 100L; time++) {
            Double value = Answer.calcValue(time);
            lols.add(value.toString());
            /*
            if (time >= 2) {
                Double value = Answer.calcValue(time);
                lols.add(Double.toString(value - Answer.partials.get(time - 2)));
            } else {
                lols.add("0.0");
            }
            */
        }
        Map m = Answer.partials;
    }
}
