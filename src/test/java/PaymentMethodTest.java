import org.example.PaymentMethod;
import org.testng.annotations.Test;
/*
 * This class tests the org.example.PaymentMethod class.
*/
public class PaymentMethodTest {

    @Test
    public void testPaymentMethodCreation(){
        PaymentMethod paymentMethod = new PaymentMethod("PayPal");

        assert paymentMethod.getMethodType().equals("PayPal");
        assert paymentMethod.isValid();

    }
}
