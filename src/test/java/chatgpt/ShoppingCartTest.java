package chatgpt;

import org.chatgpt.Product;
import org.chatgpt.ShoppingCart;
import org.testng.annotations.Test;

public class ShoppingCartTest {

    @Test
    public void testAddProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product prod = new Product("Apple", 0.60, 1);
        cart.addProduct(prod);
        assert cart.containsProduct("Apple");
        cart.addProduct(prod);
        // Verify that there are now two apples in the cart
        assert cart.getProduct("Apple").getQuantity() == 2;
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetProductNotInCart(){
        // Create a new shopping cart
        ShoppingCart cart = new ShoppingCart();
        // Get a random non-existent product
        cart.getProduct("TV");
    }

    @Test
    public void testGetTotal() {
        ShoppingCart cart = new ShoppingCart();
        Product prod = new Product("Apple", 0.60, 2);
        cart.addProduct(prod);
        assert cart.getTotal() == 1.20;
    }

    @Test
    public void testGetTotalWithMultipleProducts() {
        ShoppingCart cart = new ShoppingCart();
        Product prod1 = new Product("Apple", 0.60, 1);
        cart.addProduct(prod1);
        Product prod2 = new Product("Banana", 0.40, 1);
        cart.addProduct(prod2);
        assert cart.getTotal() == 1.0;
    }

    @Test
    public void testGetTotalWithNoProducts() {
        ShoppingCart cart = new ShoppingCart();
        assert cart.getTotal() == 0.0;
    }

    @Test
    public void testRemoveProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product prod = new Product("Apple", 0.60, 1);
        cart.addProduct(prod);
        cart.removeProduct("Apple");
        assert cart.isEmpty();
    }

    @Test
    public void testRemoveNotAllProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product prod1 = new Product("Apple", 0.60, 2);
        cart.addProduct(prod1);
        Product prod2 = new Product("Banana", 0.40, 5);
        cart.addProduct(prod2);
        // Remove the one apple from the cart
        cart.changeQuantityOfProduct("Apple", 1);
        // Verify that the cart contains one apple and five bananas
        assert cart.getProduct("Apple").getQuantity() == 1;
        assert cart.getProduct("Banana").getQuantity() == 5;
    }

    @Test
    public void testChangeQuantityToZero(){
        // Create a new shopping cart
        ShoppingCart cart = new ShoppingCart();
        // Create a new product
        Product prod1 = new Product("Apple", 0.60, 2);
        // Add the product to the cart
        cart.addProduct(prod1);
        // Set quantity to zero
        cart.changeQuantityOfProduct("Apple", 0);
        // Verify that the cart has no more apples
        assert !cart.containsProduct("Apple");
    }

    @Test
    public void testIsEmpty(){
        ShoppingCart cart = new ShoppingCart();
        assert cart.isEmpty();

        Product prod1 = new Product("Apple", 0.60, 2);
        cart.addProduct(prod1);
        assert !cart.isEmpty();

        cart.changeQuantityOfProduct("Apple", 0);
        assert cart.isEmpty();
    }
}
