// src/main/java/org/example/ShoppingCart.java
package org.copilot;

import org.example.Product;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Product> products;

    public ShoppingCart() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        String productName = product.getName();
        if (product.getQuantity() <= 0) {
            return;
        }
        if (products.containsKey(productName)) {
            Product existingProduct = products.get(productName);
            existingProduct.setQuantity(existingProduct.getQuantity() + product.getQuantity());
        } else {
            products.put(productName, product);
        }
    }

    public void removeProduct(String productName) {
        products.remove(productName);
    }

    public void changeQuantityOfProduct(String productName, int newQuantity) {
        if (!products.containsKey(productName)) {
            throw new IllegalArgumentException("Product not found in cart: " + productName);
        }
        Product product = products.get(productName);
        if (newQuantity <= 0) {
            products.remove(productName);
        } else {
            product.setQuantity(newQuantity);
        }
    }

    public boolean containsProduct(String productName) {
        return products.containsKey(productName);
    }

    public boolean containsProduct(String productName, int quantity) {
        return products.containsKey(productName) && products.get(productName).getQuantity() >= quantity;
    }

    public Product getProduct(String productName) {
        if (!products.containsKey(productName)) {
            throw new IllegalArgumentException("Product not found in cart: " + productName);
        }
        return products.get(productName);
    }

    public double getTotal() {
        double total = 0.0;
        for (Product product : products.values()) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void clear() {
        products.clear();
    }

}

// 6:40 min