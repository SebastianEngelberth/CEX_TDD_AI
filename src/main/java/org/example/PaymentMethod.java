package org.example;/*
This class implements the payment method
*/

public class PaymentMethod {
    private final String methodType;

    public PaymentMethod(String methodType){
        this.methodType = methodType;
    }

    public String getMethodType() {
        return methodType;
    }

    public boolean isValid(){
        return !methodType.isEmpty();
    }
}

// 53 sec