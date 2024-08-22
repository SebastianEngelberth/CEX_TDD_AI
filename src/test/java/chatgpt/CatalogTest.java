package chatgpt;

import org.chatgpt.Catalog;
import org.chatgpt.Product;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CatalogTest {

    @Test
    public void testAddProduct(){
        Product product1 = new Product("Apple", 0.40, 5);
        Product product2 = new Product("Banana", 0.50, 2);
        Catalog catalog = new Catalog();

        catalog.addProduct(product1);
        catalog.addProduct(product2);

        assert catalog.containsProduct("Apple");
        assert catalog.containsProduct("Banana");
    }

    @Test
    public void testProductAvailable(){
        Product product1 = new Product("Apple", 0.40, 5);
        Product product2 = new Product("Apple", 0.40, 2);
        Catalog catalog = new Catalog();

        catalog.addProduct(product1);
        catalog.addProduct(product2);

        assert catalog.isProductAvailable("Apple", 3);
        assert catalog.isProductAvailable("Apple", 7);
        assert !catalog.isProductAvailable("Apple", 8);
        assert !catalog.isProductAvailable("Banana", -1);
    }

    @Test
    public void testGetProducts(){
        Product product1 = new Product("Apple", 0.40, 5);
        Product product2 = new Product("Banana", 0.50, 2);
        List<Product> products = new ArrayList<>();
        Catalog catalog = new Catalog();

        products.add(product1);
        products.add(product2);

        catalog.addProduct(product1);
        catalog.addProduct(product2);

        assert products.equals(catalog.getProducts());
    }

    @Test
    public void testChangeQuantity(){
        Product product1 = new Product("Apple", 0.40, 5);
        Catalog catalog = new Catalog();

        catalog.addProduct(product1);

        assert !catalog.isProductAvailable("Apple", 6);

        catalog.changeQuantity("Apple", 8);

        assert catalog.isProductAvailable("Apple", 8);

        catalog.changeQuantity("Apple", 1);

        assert !catalog.isProductAvailable("Apple", 2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testChangeQuantityBelowZero(){
        Product product1 = new Product("Apple", 0.40, 5);
        Catalog catalog = new Catalog();

        catalog.addProduct(product1);

        catalog.changeQuantity("Apple", -1);
    }
}
