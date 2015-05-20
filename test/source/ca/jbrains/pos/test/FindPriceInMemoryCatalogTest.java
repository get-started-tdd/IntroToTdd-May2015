package ca.jbrains.pos.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;

public class FindPriceInMemoryCatalogTest {
    @Test
    public void productFound() throws Exception {
        final Price price = Price.cents(795);

        final InMemoryCatalog inMemoryCatalog = new InMemoryCatalog(
                Collections.singletonMap("12345", price));

        Assert.assertEquals(
                price,
                inMemoryCatalog.findPrice("12345"));
    }

    @Test
    public void productNotFound() throws Exception {
        final InMemoryCatalog inMemoryCatalog = new InMemoryCatalog(
                Collections.emptyMap());

        Assert.assertEquals(
                null,
                inMemoryCatalog.findPrice("12345"));
    }

    public static class InMemoryCatalog {
        private Map<String, Price> pricesByBarcode;

        public InMemoryCatalog(Map<String, Price> pricesByBarcode) {
            this.pricesByBarcode = pricesByBarcode;
        }

        public Price findPrice(String barcode) {
            return pricesByBarcode.get(barcode);
        }
    }
}
