# Shopping System Implementation with TDD

This project demonstrates the use of Test-Driven Development (TDD) inside-out Approach in implementing a shop system.

## Development Environment

- Language: Java
- Build tool: Maven
- IDE: IntelliJ IDEA
- Testing Framework: TestNG

## TDD Process
Created a `Product` and `ShoppingCart`  class in the `main` package and a `ShoppingCartTest` and `Product` class in the `test` package. 

In the `ProductTest` class, the following tests were created:
1. **testProductCreation**: Created a test for the product constructor. Refactored the `Product` class to include a constructor.
2. **testInvalidProductName**: Created a test to check for empty names. Refactored the `Product` class constructor to include a check and exception.
3. **testInvalidNegativePrice**: Created a test to check for negative prices. Refactored the `Product` class constructor to include a check and exception.
4. **testInvalidZeroPrice**: Created a test to check for prices set to zero. Refactored the `Product` class constructor to include a check and exception.
5. **testInvalidQuantity**: Created a test to check for negative quantities. Refactored the `Product` class constructor to include a check and exception.
6. **testSetID**: Created a test for setting and getting the ID of a product. Refactored the `Product` class to include a `setID()` and `getID()`method.
7. **testSetName**: Created a test for setting and getting the name of a product. Refactored the `Product` class to include a `setName()` and `getName()` method.
8. **testSetPrice**: Created a test for setting and getting the price of a product. Refactored the `Product` class to include a `setPrice()` and `getPrice()` method.
9. **testSetInvalidNegativePrice**: Created a test to check for negative prices in the `setPrice()`method. Refactored the `Product` class' `setPrice()` method to include a check and exception.
10. **testSetInvalidZeroPrice**: Created a test to check for prices set to zero in the `setPrice()`method. Refactored the `Product` class' `setPrice()` method to include a check and exception.
11. **testSetDescription**: Created a test for setting and getting the description of a product. Refactored the `Product` class to include a `setDescription()` and `getDescription()` method.
12. **testSetSize**: Created a test for setting and getting the size of a product. Refactored the `Product` class to include a `setSize()` and `getSize()` method.
13. **testSetQuantity**: Created a test for setting and getting the piece of a product. Refactored the `Product` class to include a `setQuantity()` and `getQuantity()` method.
14. **testSetInvalidQuantity**: Created a test to check for negative quantities in the `setQuantity()`method. Refactored the `Product` class' `setQuantity()` method to include a check and exception.


In the `ShoppingCartTest` class, the following tests were created:
1. **testAddProduct**: Created a test for adding a product to the cart and verifying that the cart contains the product with the correct quantity. Refactored the `ShoppingCart` class to include an `addProduct()`, `getProduct()` and `containsProduct()` method.
2. **testGetProductNotInCart**: Created a test to check if there is an exception when the searched product is not in the cart. Refactored the `ShoppingCart` class' `getProduct()` method to include a check and exception.
3. **testGetTotal**: Created a test for calculating the total price of the products in the cart. Refactored the `ShoppingCart` class to include a `getTotal()` method.
4. **testGetTotalWithMultipleProducts**: Created a test for calculating the total price of multiple products in the cart. No refactoring was needed for this test.
5. **testGetTotalWithNoProducts**: Created a test for calculating the total price when no products are in the cart. No refactoring was needed for this test.
6. **testRemoveProduct**: Created a test to remove a product from the cart and verifying that the cart is empty. Refactored the `ShoppingCart` class to include a `removeProduct()` and `isEmpty()` method.
7. **testRemoveNotAllProduct**: This test was designed to validate the functionality of partially removing a product from the cart and checking the product's quantity in the cart. 
   Upon implementing this test, it was necessary to create a `changeQuantityOfProduct()` method in the `ShoppingCart`, which includes an additional `quantity` parameter and calls the `removeProduct()` when the `quantity` is equal or below zero. 
   This modification enables the removal of a specific number of product instances from the cart. Simultaneously, the `addProduct()` method was refactored check if the product already exists in the cart and to add the product to the cart (/the existing product in the cart) based on its `quantity` attribute.
   Subsequent to these changes, all previous tests involving the `addProduct()` and `removeProduct()` methods were refactored to align with the updated methods.
8. **testChangeQuantityToZero()**: This test was created to check the functionality of the `changeQuantityOfProduct()` method in the `ShoppingCart`. No refactoring was needed as the method was implemented in the previous step.
9. **testIsEmpty**: Created a test to check if the shopping cart is empty in certain scenarios. Refactored the `ShoppingCart` class to include a `isEmpty()` method. No refactoring was needed as the method was implemented in a previous step.

In the `CatalogTest` class, the following tests were created:
1. **testAddProduct**: Created a test for adding a product to the catalog and verifying that the catalog contains the product. Refactored the `Catalog` class to include a constructor, `addProduct()` and `containsProduct()` method.
2. **testProductAvailable**: Created a test for verifying that a product is available in a given quantity. Refactored the `Catalog` class to include a `isProductAvailable()` method.
3. **testGetProducts**: Created a test for getting all products in the catalog. Refactored the `Catalog` class to include a `getProducts()` method.
4. **testChangeQuantity**: Created a test for changing the quantity of a product and verifying its availability. Refactored the `Catalog` class to include a `changeQuantity()` method.
5. **testChangeQuantityBelowZero**: Created a test to verify that an exception is thrown when a product's quantity is set below zero. Refactored the `Catalog` class' `changeQuantity()` method to include a check and exception.

As the `Catalog` class is similar to the `ShoppingCart` class, the tests are less detailed.


In the `PaymentMethodTest` class, the following tests were created:
1. **testPaymentMethodCreation**: Created a test for creating a `PaymentMethod` object, getting its method type and checking its validity. Refactored the `PaymentMethod` class to include a constructor, `getMethodType()` and `isValid()` method.

In the `PayPalPaymentMethodTest` class, the following tests were created:
1. **testPayPalPaymentMethodCreation**: Created a test for creating a `PayPalPaymentMethod` object, getting its method type, email and authToken, and checking its validity. Refactored the `PayPalPaymentMethod` class to include a constructor, `getMethodType()`, `isValid()`, `getPayPalEmail()` and `getPayPalAuthToken()` method.
2. **testPayPalPaymentMethodCreationEmptyValues**: Created a test for checking that the `isValid()` method returns false, if the email or authToken is empty. No refactoring was needed for this test.

In the `CreditCardPaymentMethodTest` class, the following tests were created:
1. **testCreditCardPaymentMethodCreation**: Created a test for creating a `CreditCardPaymentMethod` object, getting its method type, credit card number, expiry date, cardholder name and card validation code, and checking its validity. Refactored the `CreditCardPaymentMethod` class to include a constructor, `getMethodType()`, `isValid()`, `getCreditCardNumber()`, `getExpiryDate()`, `getCardHolderName()` and `getCardValidationCode()` method.
2. **testCreditCardPaymentMethodCreationEmptyValues**: Created a test for checking that the `isValid()` method returns false, if the credit card number, expiry date, cardholder name or card validation code is empty. No refactoring was needed for this test.

In the `ShippingAddressTest` class, the following tests were created:
1. **testShippingAddressCreation**: Created a test for creating a `ShippingAddress` object, getting its customer name, country, postal code, city and street. Refactored the `ShippingAddress` class to include a constructor.
2. **testIsValid**: Created a test for checking the validity of a `ShippingAddress`. Refactored the `ShippingAddress` class to include a `isValid()` method.

In the `PaymentServiceTest` class, the following tests were created:
1. **testProcessPayment**: Created a test for creating a `PaymentService` object and processing payments. Refactored the `PaymentService` class to include a constructor and a `processPayment()` method.

In the `ShopSystemTest` class, the following tests were created:
1. **testShopCreation**: Created a test for creating a `ShopSystem` using `PaymentService`, `Catalog` and `ShoppingCart`. Refactored the `ShopSystem` class to include a constructor, `getCatalog()`, `getPaymentService()` and `getShoppingCart()` method.
2. **testSetPaymentMethod**: Created a test for setting and getting a payment method for the `PaymentService` within the `ShopSystem`. Refactored the `ShopSystem` class to include a `setPaymentMethod()` and `getPaymentMethod()` method.
3. **testSetShippingAddress**: Created a test for setting and getting a shipping address for the `PaymentService` within the `ShopSystem`. Refactored the `ShopSystem` class to include a `setShippingAddress()` and `getShippingAddress()` method.
4. **testAddProductToCatalog**: Created a test for adding products to the `Catalog` using the `ShopSystem` and checking their availability. Refactored the `ShopSystem` class to include a `addProductToCatalog()` and `isProductAvailable()` method.
5. **testAddProductToCatalogEmptyName**: Created a test to check if an exception is thrown when a product's name is empty while adding. Refactored the `ShopSystem` class' `addProductToCatalog()` method to include a check and exception.
6. **testAddProductToCart**: Created a test for adding products to the `ShoppingCart` using the `ShopSystem` and checking if the cart contains a product in a given quantity. Refactored the `ShopSystem` class to include a `addProductToCart()` and `cartContains()` method.
7. **testAddProductToCartNotInStock**: Created a test to check if an exception is thrown when a product is added to the cart that is not available in the catalog. Refactored the `ShopSystem` class' `addProductToCart()` method to include a check and exception.
8. **testRemoveProductFromCart**: Created a test for completely removing a product from the `ShoppingCart`. Refactored the `ShopSystem` class to include a `removeProductFromCart()` method.
9. **testChangeQuantity**: Created a test for changing the quantity of a product in the `ShoppingCart`. Refactored the `ShopSystem` class to include a `changeQuantityInCart()` method.
10. **testChangeQuantityTooHigh**: Created a test to check if an exception is thrown when the quantity of a product in the `ShoppingCart` is changed to an amount above the available quantity in the `Catalog`. Refactored the `ShopSystem` class' `changeQuantityInCart()` method to include a check and exception.
11. **testChangeQuantityToZero**: Created a test to check that a product is removed from the `ShoppingCart` when its quantity is changed to zero. Refactored the `ShopSystem` class' `changeQuantityInCart()` method to include a check and removal of the product from the `ShoppingCart`.
12. **testCheckout**: Created a test for doing checkout (payment) while having products in the `ShoppingCart` and verifying its success and that the `ShoppingCart` is empty afterwards. Refactored the `ShopSystem` to include a `doCheckout()` method.
13. **testCheckoutEmptyCart**: Created a test to check that the checkout fails, if there are no items in the `ShoppingCart`. Refactored the `ShopSystem` class' `doCheckout()` method to include a check.
14. **testCheckoutEmptyAddress**: Created a test to check that the checkout fails, if the `ShippingAddress` is invalid and that the cart is not emptied. Refactored the `ShopSystem` class' `doCheckout()` method to include a check.


## Code Quality 

To evaluate the code quality of the implementation generated with the assistance of GitHub Copilot, especially in the context of the principles outlined by Robert Martin and Martin Fowler, we can examine the provided code excerpts and general practices against key software quality metrics. These metrics include meaningful names for classes, methods, and variables; structuring of functions; comments; consistent code formatting; and cyclomatic complexity.


### Meaningful Names for Classes, Methods, and Variables
- Both manual and AI-assisted approaches prioritize meaningful names for classes, methods, and variables, enhancing code readability and maintainability.
- The AI excelled in naming conventions, particularly with the `ProductNotInStockException`, which is more descriptive than the manually chosen `ProductNotInStock`, illustrating the importance of clear exception naming.

### Function Structure
- Both approaches ensure methods are well-structured, focusing on single responsibilities to reduce complexity and improve readability.
- However, the AI-generated code occasionally failed to align methods within the `ShopSystem` class with corresponding methods in the `Catalog` class, leading to mismatches and integration issues.

### Comments
- While the initial code lacks detailed commentary on comment usage, it's generally advised to make code self-explanatory, using comments for the "why" rather than the "what".
- Manual implementation included comments to clarify the role of each class, whereas AI-generated code inconsistently applied comments, notably adding them in the `ShoppingCart` class but omitting them elsewhere, affecting documentation clarity.

### Consistent Code Formatting
- Both manual and AI implementations adhere to consistent code formatting, showing no significant stylistic differences, which aids in maintaining code readability.

### Cyclomatic Complexity
- Both approaches favor methods with low cyclomatic complexity, indicating straightforward logic paths and simplifying testing and maintenance.
- Manual methods occasionally exhibited higher complexity compared to their AI-generated counterparts. For instance, the manually implemented `shopSystem.addProductToCart()` method demonstrated a higher complexity than the AI's simpler implementation.
- Conversely, the AI introduced methods in the `ShopSystem` class that lacked corresponding implementations in the `ShoppingCart` class, such as `shoppingCart.changeQuantity`, `shoppingCart.contains()`, `catalog.getProduct()`, and `shoppingCart.clear()`, leading to logical inaccuracies.

