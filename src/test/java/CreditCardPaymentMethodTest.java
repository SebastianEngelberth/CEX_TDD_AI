import org.example.CreditCardPaymentMethod;
import org.testng.annotations.Test;

public class CreditCardPaymentMethodTest{

    @Test
    public void testCreditCardPaymentMethodCreation(){
        CreditCardPaymentMethod creditCardPaymentMethod = new CreditCardPaymentMethod("123454321", "12/24", "Max Mustermann", "1234");

        assert creditCardPaymentMethod.getMethodType().equals("Credit Card");
        assert creditCardPaymentMethod.getCreditCardNumber().equals("123454321");
        assert creditCardPaymentMethod.getExpiryDate().equals("12/24");
        assert creditCardPaymentMethod.getCardHolderName().equals("Max Mustermann");
        assert creditCardPaymentMethod.getCardValidationCode().equals("1234");
        assert creditCardPaymentMethod.isValid();
    }

    @Test
    public void testCreditCardPaymentMethodCreationEmptyValues(){
        CreditCardPaymentMethod creditCardPaymentMethod1 = new CreditCardPaymentMethod("", "12/24", "Max Mustermann", "1234");

        assert !creditCardPaymentMethod1.isValid();

        CreditCardPaymentMethod creditCardPaymentMethod2 = new CreditCardPaymentMethod("123454321", "", "Max Mustermann", "1234");

        assert !creditCardPaymentMethod2.isValid();

        CreditCardPaymentMethod creditCardPaymentMethod3 = new CreditCardPaymentMethod("123454321", "12/24", "", "1234");

        assert !creditCardPaymentMethod3.isValid();

        CreditCardPaymentMethod creditCardPaymentMethod4 = new CreditCardPaymentMethod("123454321", "12/24", "Max Mustermann", "");

        assert !creditCardPaymentMethod4.isValid();
    }
}
