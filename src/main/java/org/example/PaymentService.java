package org.example;

/*
    * This class is responsible for processing the payment.
    * It checks if the shipping address is valid and if the payment method is not empty.
*/
public class PaymentService {

    public boolean processPayment(ShippingAddress shippingAddress, PaymentMethod paymentMethod, double total){
        // Missing actual api calls...
        return shippingAddress.isValid() && paymentMethod.isValid();
    }
}

// 1:04 min
