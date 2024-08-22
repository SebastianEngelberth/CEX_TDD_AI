package chatgpt;

import org.chatgpt.*;
import org.testng.annotations.Test;

public class ShopSystemTest {

    @Test
    public void testShopCreation(){
        PaymentService paymentService = new PaymentService();
        Catalog catalog = new Catalog();
        ShoppingCart shoppingCart = new ShoppingCart();
        ShopSystem shopSystem = new ShopSystem(catalog, paymentService, shoppingCart);

        assert shopSystem.getCatalog() == catalog;
        assert shopSystem.getPaymentService() == paymentService;
        assert shopSystem.getShoppingCart() == shoppingCart;
    }

    @Test
    public void testSetPaymentMethod(){
        PaymentService paymentService = new PaymentService();
        Catalog catalog = new Catalog();
        ShoppingCart shoppingCart = new ShoppingCart();
        ShopSystem shopSystem = new ShopSystem(catalog, paymentService, shoppingCart);
        PaymentMethod paymentMethod = new PaymentMethod("PayPal");

        shopSystem.setPaymentMethod(paymentMethod);

        assert shopSystem.getPaymentMethod() == paymentMethod;
    }

    @Test
    public void testSetShippingAddress(){
        PaymentService paymentService = new PaymentService();
        Catalog catalog = new Catalog();
        ShoppingCart shoppingCart = new ShoppingCart();
        ShopSystem shopSystem = new ShopSystem(catalog, paymentService, shoppingCart);
        ShippingAddress shippingAddress = new ShippingAddress("Max Mustermann", "GER", "50667", "Cologne", "Domkloster 4");

        shopSystem.setShippingAddress(shippingAddress);

        assert shopSystem.getShippingAddress() == shippingAddress;
    }

    @Test
    public void testAddProductToCatalog(){
        PaymentService paymentService = new PaymentService();
        Catalog catalog = new Catalog();
        ShoppingCart shoppingCart = new ShoppingCart();
        ShopSystem shopSystem = new ShopSystem(catalog, paymentService, shoppingCart);
        Product product1 = new Product("Apple", 0.40, 5);

        shopSystem.addProductToCatalog(product1);

        assert shopSystem.isProductAvailable("Apple", 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddProductToCatalogEmptyName(){
        PaymentService paymentService = new PaymentService();
        Catalog catalog = new Catalog();
        ShoppingCart shoppingCart = new ShoppingCart();
        ShopSystem shopSystem = new ShopSystem(catalog, paymentService, shoppingCart);
        Product product1 = new Product("", 0.40, 5);

        shopSystem.addProductToCatalog(product1);
    }

    @Test
    public void testAddProductToCart(){
        PaymentService paymentService = new PaymentService();
        Catalog catalog = new Catalog();
        ShoppingCart shoppingCart = new ShoppingCart();
        ShopSystem shopSystem = new ShopSystem(catalog, paymentService, shoppingCart);
        Product product1 = new Product("Apple", 0.40, 5);
        Product product2 = new Product("Banana", 0.40, 5);

        shopSystem.addProductToCatalog(product1);
        shopSystem.addProductToCatalog(product2);
        shopSystem.addProductToCart("Apple", 3);

        assert shopSystem.cartContains("Apple", 3);

        shopSystem.addProductToCart("Banana", 0);

        assert !shopSystem.cartContains("Banana", 0);
    }

    @Test(expectedExceptions = ProductNotInStock.class)
    public void testAddProductToCartNotInStock(){
        PaymentService paymentService = new PaymentService();
        Catalog catalog = new Catalog();
        ShoppingCart shoppingCart = new ShoppingCart();
        ShopSystem shopSystem = new ShopSystem(catalog, paymentService, shoppingCart);

        shopSystem.addProductToCart("Apple", 3);
    }

    @Test
    public void testRemoveProductFromCart(){
        PaymentService paymentService = new PaymentService();
        Catalog catalog = new Catalog();
        ShoppingCart shoppingCart = new ShoppingCart();
        ShopSystem shopSystem = new ShopSystem(catalog, paymentService, shoppingCart);
        Product product1 = new Product("Apple", 0.40, 5);

        shopSystem.addProductToCatalog(product1);
        shopSystem.addProductToCart("Apple", 3);
        shopSystem.removeProductFromCart("Apple");

        assert !shopSystem.cartContains("Apple", 0);
    }

    @Test
    public void testChangeQuantity(){
        PaymentService paymentService = new PaymentService();
        Catalog catalog = new Catalog();
        ShoppingCart shoppingCart = new ShoppingCart();
        ShopSystem shopSystem = new ShopSystem(catalog, paymentService, shoppingCart);
        Product product1 = new Product("Apple", 0.40, 5);

        shopSystem.addProductToCatalog(product1);
        shopSystem.addProductToCart("Apple", 3);

        assert shopSystem.cartContains("Apple", 3);

        shopSystem.changeQuantityInCart("Apple", 5);

        assert shopSystem.cartContains("Apple", 5);
    }

    @Test(expectedExceptions = ProductNotInStock.class)
    public void testChangeQuantityTooHigh(){
        PaymentService paymentService = new PaymentService();
        Catalog catalog = new Catalog();
        ShoppingCart shoppingCart = new ShoppingCart();
        ShopSystem shopSystem = new ShopSystem(catalog, paymentService, shoppingCart);
        Product product1 = new Product("Apple", 0.40, 5);

        shopSystem.addProductToCatalog(product1);
        shopSystem.addProductToCart("Apple", 3);

        shopSystem.changeQuantityInCart("Apple", 6);
    }

    @Test
    public void testChangeQuantityToZero(){
        PaymentService paymentService = new PaymentService();
        Catalog catalog = new Catalog();
        ShoppingCart shoppingCart = new ShoppingCart();
        ShopSystem shopSystem = new ShopSystem(catalog, paymentService, shoppingCart);
        Product product1 = new Product("Apple", 0.40, 5);

        shopSystem.addProductToCatalog(product1);
        shopSystem.addProductToCart("Apple", 3);

        shopSystem.changeQuantityInCart("Apple", 0);

        assert !shopSystem.cartContains("Apple", 0);
    }

    @Test
    public void testCheckout(){
        PaymentService paymentService = new PaymentService();
        Catalog catalog = new Catalog();
        ShoppingCart shoppingCart = new ShoppingCart();
        ShopSystem shopSystem = new ShopSystem(catalog, paymentService, shoppingCart);
        ShippingAddress shippingAddress = new ShippingAddress("Max Mustermann", "GER", "50667", "Cologne", "Domkloster 4");
        PaymentMethod paymentMethod = new PaymentMethod("PayPal");
        shopSystem.setShippingAddress(shippingAddress);
        shopSystem.setPaymentMethod(paymentMethod);

        Product product1 = new Product("Apple", 0.40, 5);

        shopSystem.addProductToCatalog(product1);
        shopSystem.addProductToCart("Apple", 3);

        assert shopSystem.doCheckout();
        assert shopSystem.getShoppingCart().isEmpty();
    }

    @Test
    public void testCheckoutEmptyCart(){
        PaymentService paymentService = new PaymentService();
        Catalog catalog = new Catalog();
        ShoppingCart shoppingCart = new ShoppingCart();
        ShopSystem shopSystem = new ShopSystem(catalog, paymentService, shoppingCart);
        ShippingAddress shippingAddress = new ShippingAddress("Max Mustermann", "GER", "50667", "Cologne", "Domkloster 4");
        PaymentMethod paymentMethod = new PaymentMethod("PayPal");
        shopSystem.setShippingAddress(shippingAddress);
        shopSystem.setPaymentMethod(paymentMethod);

        assert !shopSystem.doCheckout();
    }

    @Test
    public void testCheckoutEmptyAddress(){
        PaymentService paymentService = new PaymentService();
        Catalog catalog = new Catalog();
        ShoppingCart shoppingCart = new ShoppingCart();
        ShopSystem shopSystem = new ShopSystem(catalog, paymentService, shoppingCart);
        ShippingAddress shippingAddress = new ShippingAddress("", "", "", "", "");
        PaymentMethod paymentMethod = new PaymentMethod("PayPal");
        shopSystem.setShippingAddress(shippingAddress);
        shopSystem.setPaymentMethod(paymentMethod);

        Product product1 = new Product("Apple", 0.40, 5);

        shopSystem.addProductToCatalog(product1);
        shopSystem.addProductToCart("Apple", 3);

        assert !shopSystem.doCheckout();
        assert !shopSystem.getShoppingCart().isEmpty();
    }
}
