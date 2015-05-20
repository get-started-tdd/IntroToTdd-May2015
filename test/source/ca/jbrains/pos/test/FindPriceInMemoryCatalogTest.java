package ca.jbrains.pos.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
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
        final Catalog catalog = new InMemoryCatalog(
                Collections.emptyMap());

        Assert.assertEquals(null, catalog.findPrice("12345"));
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
