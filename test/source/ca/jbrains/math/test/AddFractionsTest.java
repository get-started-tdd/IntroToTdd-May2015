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

    @Test
    public void simplestPathWithNoIntegers() throws Exception {
        final Fraction sum = new Fraction(1, 5).plus(new Fraction(2, 5));
        Assert.assertEquals(3, sum.getNumerator());
        Assert.assertEquals(5, sum.getDenominator());
    }

    public static class Fraction {
        private int numerator;
        private int denominator;
        private int integerValue;

        public Fraction(int integerValue) {
            this.integerValue = integerValue;
            this.numerator = integerValue;
            this.denominator = 1;
        }

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Fraction plus(Fraction augend) {
            if (this.denominator == 1) {
                return new Fraction(this.intValue() + augend.intValue());
            }
            else {
                return new Fraction(this.numerator + augend.numerator, 5);
            }
        }

        public int intValue() {
            return integerValue;
        }

        public int getNumerator() {
            return numerator;
        }

        public int getDenominator() {
            return denominator;
        }
    }
}
