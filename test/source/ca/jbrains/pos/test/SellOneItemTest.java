package ca.jbrains.pos.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SellOneItemTest {
    @Test
    public void productFound() throws Exception {
        final Display display = new Display();
        final Sale sale = new Sale(display);

        sale.onBarcode("12345");

        Assert.assertEquals("7,95 EUR", display.getText());
    }

    @Test
    public void anotherProductFound() throws Exception {
        final Display display = new Display();
        final Sale sale = new Sale(display);

        sale.onBarcode("23456");

        Assert.assertEquals("12,50 EUR", display.getText());
    }

    public static class Sale {
        private Display display;

        public Sale(Display display) {
            this.display = display;
        }

        public void onBarcode(String barcode) {
            final Map<String, String> pricesByBarcode = new HashMap<String, String>() {{
                put("12345", "7,95 EUR");
                put("23456", "12,50 EUR");
            }};

            if (pricesByBarcode.containsKey(barcode))
                display.setText(pricesByBarcode.get(barcode));
        }
    }

    public static class Display {
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}