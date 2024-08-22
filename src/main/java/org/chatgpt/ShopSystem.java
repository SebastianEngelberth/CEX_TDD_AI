package org.chatgpt;

//Time 52:23
public class ShopSystem {
    private Catalog catalog;
    private PaymentService paymentService;
    private ShoppingCart shoppingCart;
    private PaymentMethod paymentMethod;
    private ShippingAddress shippingAddress;

    public ShopSystem(Catalog catalog, PaymentService paymentService, ShoppingCart shoppingCart) {
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

    public ShoppingCart getShoppingCart() {
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

    public void addProductToCatalog(Product product) {
        catalog.addProduct(product);
    }

    public boolean isProductAvailable(String productName, int quantity) {
        return catalog.isProductAvailable(productName, quantity);
    }

    public void addProductToCart(String productName, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative: " + quantity);
        }
        if (quantity == 0) {
            return;
        }
        if (!catalog.isProductAvailable(productName, quantity)) {
            throw new ProductNotInStock("Product not in stock: " + productName);
        }
        Product product = catalog.getProducts().stream()
                .filter(p -> p.getName().equals(productName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Product not found in catalog: " + productName));
        Product productToAdd = new Product(productName, product.getPrice(), quantity);
        shoppingCart.addProduct(productToAdd);
    }

    public void removeProductFromCart(String productName) {
        shoppingCart.removeProduct(productName);
    }

    public void changeQuantityInCart(String productName, int newQuantity) {
        if (newQuantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative: " + newQuantity);
        }

        Product productInCart = shoppingCart.getProduct(productName);

        if (!catalog.isProductAvailable(productName, newQuantity)) {
            throw new ProductNotInStock("Product not in stock: " + productName);
        }

        if (newQuantity == 0) {
            shoppingCart.removeProduct(productName);
        } else {
            productInCart.setQuantity(newQuantity);
        }
    }


    public boolean cartContains(String productName, int quantity) {
        try {
            Product product = shoppingCart.getProduct(productName);
            return product.getQuantity() == quantity;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean doCheckout() {
        if (shoppingCart.isEmpty()) {
            return false;
        }
        double totalAmount = shoppingCart.getTotal();
        boolean paymentSuccess = paymentService.processPayment(shippingAddress, paymentMethod, totalAmount);
        if (paymentSuccess) {
            shoppingCart.clear();
            return true;
        }
        return false;
    }
}








