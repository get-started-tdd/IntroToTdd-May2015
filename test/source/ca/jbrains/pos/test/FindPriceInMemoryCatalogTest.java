package ca.jbrains.pos.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;

public class FindPriceInMemoryCatalogTest {
    @Test
    public void productFound() throws Exception {
        final SellOneItemControllerTest.Price price = SellOneItemControllerTest.Price.cents(795);

        final InMemoryCatalog inMemoryCatalog = new InMemoryCatalog(
                Collections.singletonMap("12345", price));

        Assert.assertEquals(
                price,
                inMemoryCatalog.findPrice("12345"));
    }

    public static class InMemoryCatalog {
        private Map<String, SellOneItemControllerTest.Price> pricesByBarcode;

        public InMemoryCatalog(Map<String, SellOneItemControllerTest.Price> pricesByBarcode) {
            this.pricesByBarcode = pricesByBarcode;
        }

        public SellOneItemControllerTest.Price findPrice(String barcode) {
            return pricesByBarcode.get(barcode);
        }
    }
}
