package org.chatgpt;


public class CreditCardPaymentMethod extends PaymentMethod {
    private String creditCardNumber;
    private String expiryDate;
    private String cardHolderName;
    private String cardValidationCode;

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
        return super.isValid() && !creditCardNumber.isEmpty() && !expiryDate.isEmpty() && !cardHolderName.isEmpty() && !cardValidationCode.isEmpty();
    }
}


