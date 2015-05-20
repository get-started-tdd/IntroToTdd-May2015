package ca.jbrains.pos;

public class Price {
    private int centsValue;

    public Price(int centsValue) {
        this.centsValue = centsValue;
    }

    public static Price cents(int centsValue) {
        return new Price(centsValue);
    }

    @Override
    public String toString() {
        return String.format("%.2f EUR", centsValue / 100.0d);
    }
}
