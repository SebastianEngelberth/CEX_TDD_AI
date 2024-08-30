// src/main/java/org/example/PaymentMethod.java
package org.copilot;

public class PaymentMethod {
    private String methodType;

    public PaymentMethod(String methodType) {
        this.methodType = methodType;
    }

    public String getMethodType() {
        return methodType;
    }

    public boolean isValid() {
        return methodType != null && !methodType.isEmpty();
    }
}

// 0:20 min