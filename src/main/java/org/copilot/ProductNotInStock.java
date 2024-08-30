// src/main/java/org/example/ProductNotInStock.java
package org.copilot;

public class ProductNotInStock extends RuntimeException {
    public ProductNotInStock(String productName) {
        super("Product not available in the required quantity: " + productName);
    }
}
