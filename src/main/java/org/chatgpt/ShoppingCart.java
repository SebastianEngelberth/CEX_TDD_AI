package org.chatgpt;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Product> products;

    public ShoppingCart() {
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

    public Product getProduct(String productName) {
        if (!products.containsKey(productName)) {
            throw new IllegalArgumentException("Product not found in the cart: " + productName);
        }
        return products.get(productName);
    }

    public double getTotal() {
        return products.values().stream()
                .mapToDouble(product -> product.getPrice() * product.getQuantity())
                .sum();
    }

    public void removeProduct(String productName) {
        if (!products.containsKey(productName)) {
            throw new IllegalArgumentException("Product not found in the cart: " + productName);
        }
        products.remove(productName);
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void changeQuantityOfProduct(String productName, int quantity) {
        if (!products.containsKey(productName)) {
            throw new IllegalArgumentException("Product not found in the cart: " + productName);
        }
        Product product = products.get(productName);
        product.setQuantity(quantity);
        if (product.getQuantity() <= 0) {
            products.remove(productName);
        }
    }

    public void clear() {
        products.clear();
    }
}







