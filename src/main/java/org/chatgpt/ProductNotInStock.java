package org.chatgpt;

public class ProductNotInStock extends RuntimeException {
    public ProductNotInStock(String message) {
        super(message);
    }
}

