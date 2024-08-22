package org.example;/*
    * Custom exception for when a product is not in stock
    * Contains the name of the product that is not in stock
    * -customer: the name of the customer
    * -country: the country of the customer
    * -postalCode: the postal code of the customer
    * -city: the city of the customer
    * -street: the street of the customer
*/

public class ShippingAddress {
    private final String customer;
    private final String country;
    private final String postalCode;
    private final String city;
    private final String street;

    public ShippingAddress(String customer, String country, String postalCode, String city, String street){
        this.customer = customer;
        this.country = country;
        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
    }

    public String getCustomer() {
        return customer;
    }

    public String getCountry(){
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public boolean isValid(){
        return !customer.isEmpty() && !country.isEmpty() && !postalCode.isEmpty() && !city.isEmpty() && !street.isEmpty();
    }
}

// 3:55 min
