package ca.jbrains.pos.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FindPriceInMemoryCatalogTest {
    @Test
    public void productFound() throws Exception {
        final Price price = Price.cents(795);
        final Catalog catalog = catalogWith("12345", price);
        Assert.assertEquals(price, catalog.findPrice("12345"));
    }

    private InMemoryCatalog catalogWith(String barcode, Price price) {
        return new InMemoryCatalog(
                Collections.singletonMap(barcode, price));
    }

    @Test
    public void productNotFound() throws Exception {
        final Catalog catalog = catalogWithout("12345");
        Assert.assertEquals(null, catalog.findPrice("12345"));
    }

    private InMemoryCatalog catalogWithout(String barcodeToAvoid) {
        return new InMemoryCatalog(new HashMap<String, Price>() {{
            put("not " + barcodeToAvoid, Price.cents(0));
            put("certainly not " + barcodeToAvoid, Price.cents(7873));
            put("definitely not " + barcodeToAvoid, Price.cents(10000000));
        }});
    }

    public static class InMemoryCatalog implements Catalog {
        private Map<String, Price> pricesByBarcode;

        public InMemoryCatalog(Map<String, Price> pricesByBarcode) {
            this.pricesByBarcode = pricesByBarcode;
        }

        public Price findPrice(String barcode) {
            return pricesByBarcode.get(barcode);
        }
    }
}
