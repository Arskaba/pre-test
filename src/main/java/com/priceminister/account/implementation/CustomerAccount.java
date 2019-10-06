package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {

    private Double balance;

    private void setBalance(double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        if (balance == null) {
            setBalance(0.0);
        }
        return balance;
    }

    public void add(Double addedAmount) throws NegativeAmountAdditionException {
        if (addedAmount == null || addedAmount <= 0) {
            throw new NegativeAmountAdditionException(addedAmount);
        }
        double totalAmount = getBalance() + addedAmount;
        setBalance(totalAmount);
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule)
            throws IllegalBalanceException {
        if(withdrawnAmount == null || rule == null){
            return 0.0;
        }
        double amountAfterWithdraw = getBalance() - withdrawnAmount;
        if (!rule.withdrawPermitted(amountAfterWithdraw)) {
            throw new IllegalBalanceException(amountAfterWithdraw);
        }
        setBalance(amountAfterWithdraw);
        return amountAfterWithdraw;
    }

}
