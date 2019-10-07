package com.priceminister.account;


public class NegativeAmountAdditionException extends Exception {

    private static final long serialVersionUID = -8782534707326023999L;

	private Double amount;

    public NegativeAmountAdditionException(Double illegalAmount) {
        amount = illegalAmount;
    }
    
    public String toString() {
        return "Illegal amount addition to the account: " + amount;
    }
}
