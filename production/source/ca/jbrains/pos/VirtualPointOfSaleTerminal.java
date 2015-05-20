package ca.jbrains.pos;

import java.util.HashMap;

public class VirtualPointOfSaleTerminal {
    public static void main(String[] args) {
        final SellOneItemController sellOneItemController = new SellOneItemController(
                new InMemoryCatalog(new HashMap<String, Price>() {{
                    put("12345", Price.cents(795));
                    put("23456", Price.cents(1250));
                }}),
                new Display() {
                    @Override
                    public void displayPrice(Price price) {
                        System.out.println(price.toString());
                    }

                    @Override
                    public void displayProductNotFoundMessage(String barcodeNotFound) {
                        System.out.println("Product not found for " + barcodeNotFound);
                    }

                    @Override
                    public void displayScannedEmptyBarcodeMessage() {
                        System.out.println("Scanning error: empty barcode");
                    }
                }
        );
        sellOneItemController.onBarcode("12345");
        sellOneItemController.onBarcode("23456");
        sellOneItemController.onBarcode("99999");
        sellOneItemController.onBarcode("");
    }
}
