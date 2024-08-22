package org.chatgpt;


public class PayPalPaymentMethod extends PaymentMethod {
    private String payPalEmail;
    private String payPalAuthToken;

    public PayPalPaymentMethod(String payPalEmail, String payPalAuthToken) {
        super("PayPal");
        this.payPalEmail = payPalEmail;
        this.payPalAuthToken = payPalAuthToken;
    }

    public String getPayPalEmail() {
        return payPalEmail;
    }

    public String getPayPalAuthToken() {
        return payPalAuthToken;
    }

    @Override
    public boolean isValid() {
        return super.isValid() && !payPalEmail.isEmpty() && !payPalAuthToken.isEmpty();
    }
}


