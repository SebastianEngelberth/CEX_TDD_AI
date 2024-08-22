package org.chatgpt;

// Time 0:55
public class PaymentService {

    public boolean processPayment(ShippingAddress shippingAddress, PaymentMethod paymentMethod, double amount) {
        if (!shippingAddress.isValid() || !paymentMethod.isValid()) {
            return false;
        }
        // Here we can add more complex logic for processing the payment
        return true;
    }
}

