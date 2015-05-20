package ca.jbrains.pos.test;

import org.junit.Assert;
import org.junit.Test;

public abstract class CatalogContract {
    @Test
    public void productFound() throws Exception {
        final Price price = Price.cents(795);
        final Catalog catalog = catalogWith("12345", price);
        Assert.assertEquals(price, catalog.findPrice("12345"));
    }

    protected abstract Catalog catalogWith(String barcode, Price price);

    @Test
    public void productNotFound() throws Exception {
        final Catalog catalog = catalogWithout("12345");
        Assert.assertEquals(null, catalog.findPrice("12345"));
    }

    protected abstract Catalog catalogWithout(String barcodeToAvoid);
}
