
import org.example.Product;
import org.testng.annotations.Test;

/*
 * This class tests the org.example.Product class.
*/
public class ProductTest {

    @Test
    public void testProductCreation() {
        Product prod = new Product("Apple", 0.60, 1);
        assert prod.getName().equals("Apple");
        assert prod.getPrice() == 0.60;
        assert prod.getQuantity() == 1;
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidProductName(){
        new Product("", 1, 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidNegativePrice(){
        new Product("Apple", -1, 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidZeroPrice(){
        new Product("Apple", 0, 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidQuantity(){
        new Product("Apple", 1, -1);
    }

    @Test
    public void testSetID() {
        Product prod = new Product("Apple", 0.60, 1);
        // Verify that the ID is 0 on creation
        assert prod.getID() == 0;
        prod.setID(1);
        assert prod.getID() == 1;
    }

    @Test
    public void testSetName() {
        Product prod = new Product("Apple", 0.60, 1);
        assert prod.getName().equals("Apple");
        prod.setName("Banana");
        assert prod.getName().equals("Banana");
    }

    @Test
    public void testSetPrice() {
        Product prod = new Product("Apple", 0.60, 1);
        // Verify that the price is correct
        assert prod.getPrice() == 0.60;
        prod.setPrice(0.40);
        assert prod.getPrice() == 0.40;
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetInvalidNegativePrice(){
        Product prod = new Product("Apple", 0.60, 1);
        // Set the price
        prod.setPrice(-0.40);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetInvalidZeroPrice(){
        Product prod = new Product("Apple", 0.60, 1);
        prod.setPrice(0);
    }

    @Test
    public void testSetDescription() {
        Product prod = new Product("Apple", 0.60, 1);
        prod.setDescription("This is " + prod.getName() + ".");
        assert prod.getDescription().equals("This is Apple.");
    }

    @Test
    public void testSetSize() {
        Product prod = new Product("Apple", 0.60, 1);
        prod.setSize(1);
        assert prod.getSize() == 1;
    }

    @Test
    public void testSetQuantity() {
        Product prod = new Product("Apple", 0.60, 1);
        // Verify that the quantity is correct
        assert prod.getQuantity() == 1;
        prod.setQuantity(2);
        // Verify that the quantity is correct
        assert prod.getQuantity() == 2;
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetInvalidQuantity(){
        Product prod = new Product("Apple", 0.60, 1);
        prod.setQuantity(-1);
    }

}
