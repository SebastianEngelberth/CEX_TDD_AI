package org.example;

public class PayPalPaymentMethod extends PaymentMethod {
    private final String email;
    private final String authToken;

    public PayPalPaymentMethod(String email, String authToken) {
        super("PayPal");
        this.email = email;
        this.authToken = authToken;
    }

    public String getPayPalEmail() {
        return email;
    }

    public String getPayPalAuthToken() {
        return authToken;
    }

    @Override
    public boolean isValid() {
        return !email.isEmpty() && !authToken.isEmpty();
    }
}
