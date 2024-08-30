package org.copilot;

import org.example.PaymentMethod;
import org.example.ShippingAddress;

public class PaymentService {
    public boolean processPayment(ShippingAddress shippingAddress, PaymentMethod paymentMethod, double amount) {
        if (shippingAddress == null || !shippingAddress.isValid() || paymentMethod == null || !paymentMethod.isValid()) {
            return false;
        }
        // Process payment logic here
        return true;
    }
}

// 0:30 min