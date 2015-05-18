package ca.jbrains.math.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class AddFractionsTest {
    @Test
    public void verySimplestHappyPath() throws Exception {
        Fraction sum = Fraction.withIntegerValue(0).plus(Fraction.withIntegerValue(0));
        Assert.assertEquals(0, sum.intValue());
    }

    @Test
    public void addendNotZero() throws Exception {
        Fraction sum = Fraction.withIntegerValue(1).plus(Fraction.withIntegerValue(0));
        Assert.assertEquals(1, sum.intValue());
    }

    @Test
    public void augendNotZero() throws Exception {
        Fraction sum = Fraction.withIntegerValue(0).plus(Fraction.withIntegerValue(3));
        Assert.assertEquals(3, sum.intValue());
    }

    @Test
    public void integersBothNotZero() throws Exception {
        Fraction sum = Fraction.withIntegerValue(4).plus(Fraction.withIntegerValue(5));
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

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public static Fraction withIntegerValue(int integerValue) {
            return new Fraction(integerValue, 1);
        }

        public Fraction plus(Fraction augend) {
            return new Fraction(this.numerator + augend.numerator, this.denominator);
        }
        

        public int intValue() {
            return numerator;
        }

        public int getNumerator() {
            return numerator;
        }

        public int getDenominator() {
            return denominator;
        }
    }
}
