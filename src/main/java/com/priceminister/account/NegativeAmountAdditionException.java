package com.priceminister.account;


public class NegativeAmountAdditionException extends Exception {

    private static final long serialVersionUID = -9204191749972551939L;

	private Double amount;

    public NegativeAmountAdditionException(Double illegalAmount) {
        amount = illegalAmount;
    }
    
    public String toString() {
        return "Illegal amount tried to be adde to the account: " + amount;
    }
}
