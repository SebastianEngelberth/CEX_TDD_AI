package org.example;

public class CreditCardPaymentMethod extends PaymentMethod{
    private final String creditCardNumber;
    private final String expiryDate;
    private final String cardHolderName;
    private final String cardValidationCode;

    public CreditCardPaymentMethod(String creditCardNumber, String expiryDate, String cardHolderName, String cardValidationCode) {
        super("Credit Card");
        this.creditCardNumber = creditCardNumber;
        this.expiryDate = expiryDate;
        this.cardHolderName = cardHolderName;
        this.cardValidationCode = cardValidationCode;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getCardValidationCode() {
        return cardValidationCode;
    }

    @Override
    public boolean isValid() {
        return !creditCardNumber.isEmpty() && !expiryDate.isEmpty() && !cardHolderName.isEmpty() && !cardValidationCode.isEmpty();
    }
}