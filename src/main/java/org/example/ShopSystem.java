package org.example;

/*
    * This class is the main class of the shop system. It contains the catalog, payment service,
    * shopping cart, payment method and shipping address.
*/
public class ShopSystem {

    private final PaymentService paymentService;
    private final Catalog catalog;
    private final ShoppingCart shoppingCart;
    private PaymentMethod paymentMethod;
    private ShippingAddress shippingAddress;

    public ShopSystem(Catalog catalog, PaymentService paymentService, ShoppingCart shoppingCart){
        this.catalog = catalog;
        this.paymentService = paymentService;
        this.shoppingCart = shoppingCart;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public ShoppingCart getShoppingCart(){
        return shoppingCart;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void addProductToCatalog(Product product){
        if (product.getName().isEmpty()){
            throw  new IllegalArgumentException("org.example.Product name may not be empty!");
        }
        catalog.addProduct(product);
    }

    public boolean isProductAvailable(String productName, int quantity){
        return catalog.isProductAvailable(productName, quantity);
    }

    public void addProductToCart(String productName, int quantity){
        if (!catalog.containsProduct(productName)){
            throw new ProductNotInStock(productName);
        }
        if (quantity == 0){
            return;
        }

        double catPrice = catalog.getProduct(productName).getPrice();

        if (shoppingCart.containsProduct(productName)){
            int cartQuantity = shoppingCart.getProduct(productName).getQuantity();
            if (catalog.isProductAvailable(productName, quantity + cartQuantity)){
                shoppingCart.changeQuantityOfProduct(productName, quantity + cartQuantity);
            }
            else {
                throw new ProductNotInStock(productName);
            }
        }
        else {
            if (catalog.isProductAvailable(productName, quantity)){
                shoppingCart.addProduct(new Product(productName, catPrice, quantity));
            }
            else {
                throw new ProductNotInStock(productName);
            }
        }
    }

    public boolean cartContains(String productName, int quantity){
        return shoppingCart.containsProduct(productName) && shoppingCart.getProduct(productName).getQuantity() >= quantity;
    }

    public void removeProductFromCart(String productName){
        shoppingCart.removeProduct(productName);
    }

    public void changeQuantityInCart(String productName, int quantity){
        if (shoppingCart.containsProduct(productName)){
            if (isProductAvailable(productName, quantity)){
                shoppingCart.changeQuantityOfProduct(productName, quantity);
            }
            else {
                throw new ProductNotInStock(productName);
            }
        }
    }

    public boolean doCheckout(){
        if (!shoppingCart.isEmpty() && paymentService.processPayment(shippingAddress, paymentMethod, shoppingCart.getTotal())){
            shoppingCart.clear();
            return true;
        }
        else {
            return false;
        }
    }
}
// ~ 28 min
// Added clear() to shopping cart after checkout
