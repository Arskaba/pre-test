package com.priceminister.account;


import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.ExpectedException;

import com.priceminister.account.implementation.*;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * <p>
 * We want to see how you "think code", and how you organize and structure a simple application.
 * <p>
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 */
public class CustomerAccountTest {

    private Account customerAccount;
    private AccountRule rule;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount();
        rule = new CustomerAccountRule();
    }

    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        assertEquals(0, (double) customerAccount.getBalance(), 0.0);
    }

    /**
     * Adds money to the account and checks that the new balance is as expected.
     *
     * @throws NegativeAmountAdditionException
     */
    @Test
    public void testAddPositiveAmount() throws NegativeAmountAdditionException {
        customerAccount.add(10.0);
        assertEquals(10.0, customerAccount.getBalance(), 0.0);
    }

    /**
     * Verify the impossibility to add a negative amount to the account
     *
     * @throws NegativeAmountAdditionException
     */
    @Test(expected = NegativeAmountAdditionException.class)
    public void testAddNegativeAmount() throws NegativeAmountAdditionException {
        customerAccount.add(30.0);
        assertEquals(30.0, customerAccount.getBalance(), 0.0);
        customerAccount.add(-50.0);
    }

    /**
     * withdraw money from the account and give back the amount taken back
     *
     * @throws IllegalBalanceException
     * @throws NegativeAmountAdditionException
     */
    @Test
    public void testWithdrawAndReportBalance() throws IllegalBalanceException, NegativeAmountAdditionException {
        customerAccount.add(10.0);
        assertEquals(5.0, customerAccount.withdrawAndReportBalance(5.0, rule), 0.0);
        assertEquals(1.0, customerAccount.withdrawAndReportBalance(4.0, rule), 0.0);
        assertEquals(0.0, customerAccount.withdrawAndReportBalance(1.0, rule), 0.0);
    }

    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     *
     * @throws IllegalBalanceException
     * @throws NegativeAmountAdditionException
     */
    @Test(expected = IllegalBalanceException.class)
    public void testWithdrawAndReportBalanceIllegalBalance() throws IllegalBalanceException, NegativeAmountAdditionException {
        customerAccount.withdrawAndReportBalance(15.0, rule);
    }

}
