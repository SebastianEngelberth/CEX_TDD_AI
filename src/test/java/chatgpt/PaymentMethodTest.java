package chatgpt;

import org.chatgpt.PaymentMethod;
import org.testng.annotations.Test;

public class PaymentMethodTest {

    @Test
    public void testPaymentMethodCreation(){
        PaymentMethod paymentMethod = new PaymentMethod("PayPal");

        assert paymentMethod.getMethodType().equals("PayPal");
        assert paymentMethod.isValid();

    }
}
