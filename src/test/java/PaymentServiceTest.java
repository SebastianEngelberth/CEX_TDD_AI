import org.example.*;
import org.testng.annotations.Test;

/*
 * This class tests the org.example.PaymentService class.
*/
public class PaymentServiceTest {

    @Test
    public void testProcessPayment(){
        ShippingAddress shippingAddress1 = new ShippingAddress("Max Mustermann", "GER", "50667", "Cologne", "Domkloster 4");
        PaymentMethod paymentMethod1 = new PaymentMethod("PayPal");
        PayPalPaymentMethod payPalPaymentMethod = new PayPalPaymentMethod("xyz@gmail.com", "123ABCxyz");
        CreditCardPaymentMethod creditCardPaymentMethod = new CreditCardPaymentMethod("123454321", "12/24", "Max Mustermann", "1234");
        PaymentService paymentService = new PaymentService();

        assert paymentService.processPayment(shippingAddress1, paymentMethod1, 19.99);
        assert paymentService.processPayment(shippingAddress1, payPalPaymentMethod, 19.99);
        assert paymentService.processPayment(shippingAddress1, creditCardPaymentMethod, 19.99);


        ShippingAddress shippingAddress2 = new ShippingAddress("", "GER", "50667", "Cologne", "Domkloster 4");

        assert !paymentService.processPayment(shippingAddress2, paymentMethod1, 19.99);


        PaymentMethod paymentMethod2 = new PaymentMethod("");

        assert !paymentService.processPayment(shippingAddress1, paymentMethod2, 19.99);

    }
}
