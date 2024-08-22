package org.example;/*
    * Exception for when a product is not in stock
*/

public class ProductNotInStock extends RuntimeException {
    private final String productName;

    public ProductNotInStock(String productName) {
        super(String.format("org.example.Product %s is not in stock", productName));
        this.productName = productName;
    }

    public String getProductID() {
        return productName;
    }

}
