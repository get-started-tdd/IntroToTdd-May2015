package ca.jbrains.pos.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SellOneItemTest {
    @Test
    public void productFound() throws Exception {
        final Display display = new Display();
        final Sale sale = new Sale(display, new Sale.Catalog(new HashMap<String, String>() {{
            put("12345", "7,95 EUR");
            put("23456", "12,50 EUR");
        }}));

        sale.onBarcode("12345");

        Assert.assertEquals("7,95 EUR", display.getText());
    }

    @Test
    public void anotherProductFound() throws Exception {
        final Display display = new Display();
        final Sale sale = new Sale(display, new Sale.Catalog(new HashMap<String, String>() {{
            put("12345", "7,95 EUR");
            put("23456", "12,50 EUR");
        }}));

        sale.onBarcode("23456");

        Assert.assertEquals("12,50 EUR", display.getText());
    }

    @Test
    public void productNotFound() throws Exception {
        final Display display = new Display();
        final Sale sale = new Sale(display, new Sale.Catalog(new HashMap<String, String>() {{
            put("12345", "7,95 EUR");
            put("23456", "12,50 EUR");
        }}));

        sale.onBarcode("99999");

        Assert.assertEquals("Product not found for 99999", display.getText());
    }

    @Test
    public void emptyBarcode() throws Exception {
        final Display display = new Display();
        final Sale sale = new Sale(display, new Sale.Catalog(null));

        sale.onBarcode("");

        Assert.assertEquals("Scanning error: empty barcode", display.getText());
    }

    public static class Sale {
        private final Display display;
        private final Catalog catalog;

        public Sale(Display display, Catalog catalog) {
            this.display = display;
            this.catalog = catalog;
        }

        public void onBarcode(String barcode) {
            if ("".equals(barcode)) {
                display.displayScannedEmptyBarcodeMessage();
                return;
            }

            final String price = catalog.findPrice(barcode);
            if (price == null)
                display.displayProductNotFoundMessage(barcode);
            else
                display.displayPrice(price);
        }

        private static class Catalog {
            private final Map<String, String> pricesByBarcode;

            private Catalog(Map<String, String> pricesByBarcode) {
                this.pricesByBarcode = pricesByBarcode;
            }

            public String findPrice(String barcode) {
                return this.pricesByBarcode.get(barcode);
            }
        }
    }

    public static class Display {
        private String text;

        public String getText() {
            return text;
        }

        public void displayProductNotFoundMessage(String barcode) {
            this.text = "Product not found for " + barcode;
        }

        public void displayScannedEmptyBarcodeMessage() {
            this.text = "Scanning error: empty barcode";
        }

        public void displayPrice(String price) {
            this.text = price;
        }
    }
}
