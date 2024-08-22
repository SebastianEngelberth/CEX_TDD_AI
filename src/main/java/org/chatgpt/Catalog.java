package org.chatgpt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Time 7:10
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
        if (quantity < 0) {
            return false;
        }
        Product product = products.get(productName);
        return product != null && product.getQuantity() >= quantity;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public void changeQuantity(String productName, int quantity) {
        if (!products.containsKey(productName)) {
            throw new IllegalArgumentException("Product not found in the catalog: " + productName);
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        Product product = products.get(productName);
        product.setQuantity(quantity);
    }
}



