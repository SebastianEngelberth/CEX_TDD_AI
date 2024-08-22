package org.example;/*
    * This class represents a shopping cart that contains a list of products.
    * It can add, remove, and change the quantity of products in the cart.
    * It can get the total price of the products in the cart and to check if the cart is empty.
*/
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public Product getProduct(String productName){
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        throw new IllegalArgumentException("org.example.Product not in Cart!");
    }

    public boolean containsProduct(String productName){
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void addProduct(Product product) {
        if (containsProduct(product.getName())) {
            changeQuantityOfProduct(product.getName(),getProduct(product.getName()).getQuantity() + product.getQuantity());
        }
        else {
            products.add(product);
        }
    }

    public void removeProduct(String productName) {
        try {
            Product product = getProduct(productName);
            products.remove(product);
        }
        catch (IllegalArgumentException ignored){}
    }

    public void changeQuantityOfProduct(String productName, int quantity){
        try {
            Product product = getProduct(productName);
            if(quantity > 0) {
                product.setQuantity(quantity);
            } else {
                products.remove(product);
            }
        }
        catch(IllegalArgumentException ignored) {}
    }

    public double getTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }

    public boolean isEmpty(){
        return products.isEmpty();
    }

    public void clear(){
        products.clear();
    }
}
