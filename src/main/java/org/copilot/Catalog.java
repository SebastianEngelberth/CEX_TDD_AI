// src/main/java/org/example/Catalog.java
package org.copilot;

import org.example.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog {
    private Map<String, Product> products;

    public Catalog() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (products.containsKey(product.getName())) {
            Product existingProduct = products.get(product.getName());
            existingProduct.setQuantity(existingProduct.getQuantity() + product.getQuantity());
        } else {
            products.put(product.getName(), product);
        }
    }

    public boolean containsProduct(String productName) {
        return products.containsKey(productName);
    }

    public boolean isProductAvailable(String productName, int quantity) {
        if (!products.containsKey(productName) || quantity <= 0) {
            return false;
        }
        return products.get(productName).getQuantity() >= quantity;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public void changeQuantity(String productName, int newQuantity) {
        if (!products.containsKey(productName)) {
            throw new IllegalArgumentException("Product not found in catalog: " + productName);
        }
        if (newQuantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be less than zero: " + newQuantity);
        }
        Product product = products.get(productName);
        if (newQuantity == 0) {
            products.remove(productName);
        } else {
            product.setQuantity(newQuantity);
        }
    }

    public Product getProduct(String productName) {
        return products.get(productName);
    }
}

// 3:40min