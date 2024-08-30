// src/main/java/org/example/ShippingAddress.java
package org.copilot;

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
        return customer != null && !customer.isEmpty() &&
                country != null && !country.isEmpty() &&
                postalCode != null && !postalCode.isEmpty() &&
                city != null && !city.isEmpty() &&
                street != null && !street.isEmpty();
    }
}

// 0:54 min