package org.example;

/*
    *The class product implements any product with its features.
    * - name: the name of the product (unique)
    * - price: the price of the product
    * - id: the id of the product
    * - description: the description of the product
    * - size: the size of the product
    * - quantity: the quantity of the product
*/
public class Product {
    private String name;
    private double price;
    private int id;
    private String description;
    private int size;
    private int quantity;

    public Product(String name, double price, int quantity) {
        if (name.isEmpty()){
            throw new IllegalArgumentException("org.example.Product name must not be empty");
        }
        if (quantity < 0){
            throw new IllegalArgumentException("Quantity must not be negative");
        }
        if (price <= 0){
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0){
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        this.price = price;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("org.example.Product quanity must not be negative!");
        }
        this.quantity = quantity;
    }
}