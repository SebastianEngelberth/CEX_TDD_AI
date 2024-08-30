// src/main/java/org/example/PayPalPaymentMethod.java
package org.copilot;

import org.example.PaymentMethod;

public class PayPalPaymentMethod extends PaymentMethod {
    private String email;
    private String authToken;

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
        return super.isValid() && email != null && !email.isEmpty() && authToken != null && !authToken.isEmpty();
    }
}

// ~0:20 min