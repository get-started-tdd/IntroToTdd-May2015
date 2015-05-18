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

    @Test
    public void augendNotZero() throws Exception {
        Fraction sum = new Fraction(0).plus(new Fraction(3));
        Assert.assertEquals(3, sum.intValue());
    }

    @Test
    public void integersBothNotZero() throws Exception {
        Fraction sum = new Fraction(4).plus(new Fraction(5));
        Assert.assertEquals(9, sum.intValue());
    }

    public static class Fraction {
        private int integerValue;

        public Fraction(int integerValue) {
            this.integerValue = integerValue;
        }

        public Fraction plus(Fraction augend) {
            if (this.intValue() == 0) {
                return augend;
            } else if (augend.intValue() == 0){
                return this;
            } else {
                return new Fraction(this.intValue() + augend.intValue());
            }
        }

        public int intValue() {
            return integerValue;
        }
    }
}
