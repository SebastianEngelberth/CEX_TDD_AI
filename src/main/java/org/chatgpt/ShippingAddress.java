package org.chatgpt;


public class ShippingAddress {
    private String customer;
    private String country;
    private String postalCode;
    private String city;
    private String street;

    public ShippingAddress(String customer, String country, String postalCode, String city, String street) {
        this.customer = customer;
        this.country = country;
        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
    }

    public String getCustomer() {
        return customer;
    }

    public String getCountry() {
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

    public boolean isValid() {
        return !customer.isEmpty() && !country.isEmpty() && !postalCode.isEmpty() && !city.isEmpty() && !street.isEmpty();
    }
}

