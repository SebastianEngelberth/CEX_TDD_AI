package org.example;

import java.util.ArrayList;
import java.util.List;
/*
    * This class represents the catalog of products.
    * The catalog contains all available products.
    * The catalog can be used to add products, change the quantity of products and check if a product is available.

*/
public class Catalog {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        if (containsProduct(product.getName())) {
            changeQuantity(product.getName(),getProduct(product.getName()).getQuantity() + product.getQuantity());
        }
        else {
            products.add(product);
        }
    }

    public boolean containsProduct(String productName){
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void changeQuantity(String productName, int quantity){
        try {
            Product product = this.getProduct(productName);
            if(quantity >= 0) {
                product.setQuantity(quantity);
            } else {
                throw new IllegalArgumentException("org.example.Product count may not be negative!");
            }
        }
        catch(ProductNotInStock ignored) {}
    }

    public Product getProduct(String productName){
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        throw new ProductNotInStock(productName);
    }

    public boolean isProductAvailable(String productName, int quantity){
        try {
            return getProduct(productName).getQuantity() >= quantity;
        }
        catch (ProductNotInStock ignored){
            return false;
        }
    }

    public List<Product> getProducts(){
        return products;
    }

}

// 6:36 min
