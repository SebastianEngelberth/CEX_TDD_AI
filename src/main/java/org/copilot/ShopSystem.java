// src/main/java/org/example/ShopSystem.java
package org.copilot;

import org.example.Catalog;
import org.example.PaymentService;
import org.example.ShippingAddress;
import org.example.ShoppingCart;

public class ShopSystem {
    private org.example.Catalog catalog;
    private org.example.PaymentService paymentService;
    private org.example.ShoppingCart shoppingCart;
    private PaymentMethod paymentMethod;
    private org.example.ShippingAddress shippingAddress;

    public ShopSystem(org.example.Catalog catalog, org.example.PaymentService paymentService, org.example.ShoppingCart shoppingCart) {
        this.catalog = catalog;
        this.paymentService = paymentService;
        this.shoppingCart = shoppingCart;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setShippingAddress(org.example.ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void addProductToCatalog(Product product) {
        if (product.getName().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        catalog.addProduct(product);
    }

    public boolean isProductAvailable(String productName, int quantity) {
        return catalog.isProductAvailable(productName, quantity);
    }

    public void addProductToCart(String productName, int quantity){
        if (!catalog.containsProduct(productName)){
            throw new ProductNotInStock(productName);
        }
        if (quantity == 0){
            return;
        }

        double catPrice = catalog.getProduct(productName).getPrice();

        if (shoppingCart.containsProduct(productName)){
            int cartQuantity = shoppingCart.getProduct(productName).getQuantity();
            if (catalog.isProductAvailable(productName, quantity + cartQuantity)){
                shoppingCart.changeQuantityOfProduct(productName, quantity + cartQuantity);
            }
            else {
                throw new ProductNotInStock(productName);
            }
        }
        else {
            if (catalog.isProductAvailable(productName, quantity)){
                shoppingCart.addProduct(new Product(productName, catPrice, quantity));
            }
            else {
                throw new ProductNotInStock(productName);
            }
        }
    }

    public boolean cartContains(String productName, int quantity) {
        return shoppingCart.containsProduct(productName, quantity);
    }

    public void removeProductFromCart(String productName) {
        if (!shoppingCart.containsProduct(productName)) {
            throw new IllegalArgumentException("Product not found in cart: " + productName);
        }
        shoppingCart.removeProduct(productName);
    }

    public void changeQuantityInCart(String productName, int quantity) {
        if (shoppingCart.containsProduct(productName)) {
            if (quantity == 0) {
                shoppingCart.removeProduct(productName);
            } else if (isProductAvailable(productName, quantity)) {
                shoppingCart.changeQuantityOfProduct(productName, quantity);
            } else {
                throw new ProductNotInStock(productName);
            }
        } else {
            throw new IllegalArgumentException("Product not found in cart: " + productName);
        }
    }

    public boolean doCheckout() {
        if (paymentMethod == null || !paymentMethod.isValid() || shippingAddress == null || !shippingAddress.isValid()) {
            return false;
        }
        if (shoppingCart.isEmpty()) {
            return false;
        }
        // Process payment and shipping logic here
        if (paymentService.processPayment(shippingAddress, paymentMethod, shoppingCart.getTotal())) {
            shoppingCart.clear();
            return true;
        }
        return false;
    }
}

// 33:07 min