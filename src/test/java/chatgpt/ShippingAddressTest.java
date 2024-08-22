package chatgpt;

import org.chatgpt.ShippingAddress;
import org.testng.annotations.Test;

public class ShippingAddressTest {

    @Test
    public void testShippingAddressCreation(){
        ShippingAddress shippingAddress = new ShippingAddress("Max Mustermann", "GER", "50667", "Cologne", "Domkloster 4");

        assert shippingAddress.getCustomer().equals("Max Mustermann");
        assert shippingAddress.getCountry().equals("GER");
        assert shippingAddress.getPostalCode().equals("50667");
        assert shippingAddress.getCity().equals("Cologne");
        assert shippingAddress.getStreet().equals("Domkloster 4");
    }

    @Test
    public void testIsValid(){
        ShippingAddress shippingAddress1 = new ShippingAddress("Max Mustermann", "GER", "50667", "Cologne", "Domkloster 4");
        assert shippingAddress1.isValid();

        ShippingAddress shippingAddress2 = new ShippingAddress("", "GER", "50667", "Cologne", "Domkloster 4");
        assert !shippingAddress2.isValid();

        ShippingAddress shippingAddress3 = new ShippingAddress("Max Mustermann", "", "50667", "Cologne", "Domkloster 4");
        assert !shippingAddress3.isValid();

        ShippingAddress shippingAddress4 = new ShippingAddress("Max Mustermann", "GER", "", "Cologne", "Domkloster 4");
        assert !shippingAddress4.isValid();

        ShippingAddress shippingAddress5 = new ShippingAddress("Max Mustermann", "GER", "50667", "", "Domkloster 4");
        assert !shippingAddress5.isValid();

        ShippingAddress shippingAddress6 = new ShippingAddress("Max Mustermann", "GER", "50667", "Cologne", "");
        assert !shippingAddress6.isValid();
    }
}
