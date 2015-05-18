package ca.jbrains.math.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class AddFractionsTest {
    @Test
    public void verySimplestHappyPath() throws Exception {
        Fraction sum = new Fraction(0).plus(new Fraction(0));
        Assert.assertEquals(0, sum.intValue());
    }

    @Test
    public void addendNotZero() throws Exception {
        Fraction sum = new Fraction(1).plus(new Fraction(0));
        Assert.assertEquals(1, sum.intValue());
    }

    public static class Fraction {
        private int integerValue;

        public Fraction(int integerValue) {
            this.integerValue = integerValue;
        }

        public Fraction plus(Fraction augend) {
            return this;
        }

        public int intValue() {
            return integerValue;
        }
    }
}
