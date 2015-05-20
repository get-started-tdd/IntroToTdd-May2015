package ca.jbrains.pos.test;

import ca.jbrains.pos.Catalog;
import ca.jbrains.pos.Price;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FindPriceInMemoryCatalogTest extends CatalogContract {
    @Override
    protected Catalog catalogWith(String barcode, Price price) {
        return new InMemoryCatalog(
                Collections.singletonMap(barcode, price));
    }

    @Override
    protected Catalog catalogWithout(String barcodeToAvoid) {
        return new InMemoryCatalog(new HashMap<String, Price>() {{
            put("not " + barcodeToAvoid, Price.cents(0));
            put("certainly not " + barcodeToAvoid, Price.cents(7873));
            put("definitely not " + barcodeToAvoid, Price.cents(10000000));
        }});
    }

    public static class InMemoryCatalog implements Catalog {
        private Map<String, Price> pricesByBarcode;

        public InMemoryCatalog(Map<String, Price> pricesByBarcode) {
            this.pricesByBarcode = new HashMap<>(pricesByBarcode);
        }

        public Price findPrice(String barcode) {
            return pricesByBarcode.get(barcode);
        }
    }
}
