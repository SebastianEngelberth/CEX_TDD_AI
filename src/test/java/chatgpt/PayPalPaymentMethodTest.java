package chatgpt;

import org.chatgpt.PayPalPaymentMethod;
import org.testng.annotations.Test;

public class PayPalPaymentMethodTest {

    @Test
    public void testPayPalPaymentMethodCreation(){
        PayPalPaymentMethod payPalPaymentMethod = new PayPalPaymentMethod("xyz@gmail.com", "123ABCxyz");

        assert payPalPaymentMethod.getMethodType().equals("PayPal");
        assert payPalPaymentMethod.getPayPalEmail().equals("xyz@gmail.com");
        assert payPalPaymentMethod.getPayPalAuthToken().equals("123ABCxyz");
        assert payPalPaymentMethod.isValid();
    }

    @Test
    public void testPayPalPaymentMethodCreationEmptyValues(){
        PayPalPaymentMethod paymentMethod1 = new PayPalPaymentMethod("", "123ABCxyz");

        assert !paymentMethod1.isValid();

        PayPalPaymentMethod paymentMethod2 = new PayPalPaymentMethod("xyz@gmail.com", "");

        assert !paymentMethod2.isValid();
    }
}
