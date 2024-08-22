package org.chatgpt;

// Time 0:54
public class PaymentMethod {
    private String methodType;

    public PaymentMethod(String methodType) {
        this.methodType = methodType;
    }

    public String getMethodType() {
        return methodType;
    }

    public boolean isValid() {
        return !methodType.isEmpty();
    }
}

