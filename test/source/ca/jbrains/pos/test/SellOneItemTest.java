package ca.jbrains.pos.test;

import org.junit.Assert;
import org.junit.Test;

public class SellOneItemTest {
    @Test
    public void productFound() throws Exception {
        final Sale sale = new Sale();
        final Display display = new Display();

        sale.onBarcode("12345");

        Assert.assertEquals("7,95 EUR", display.getText());
    }

    public static class Sale {
        public void onBarcode(String barcode) {
        }
    }
    
    public static class Display {
        public String getText() {
            return "7,95 EUR";
        }
    }
}
