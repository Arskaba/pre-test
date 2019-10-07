package com.priceminister.account;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.priceminister.account.implementation.CustomerAccountRule;


public class CustomerAccountRuleTest {

    private AccountRule rule;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        rule = new CustomerAccountRule();
    }

    /**
     * Verification that the correct boolean is returned for the withdrawPermitted function.
     */
    @Test
    public void testWithdrawPermitted(){
        Assert.assertTrue("the withdraw is permitted",rule.withdrawPermitted(5.0));
        Assert.assertTrue("the withdraw is permitted",rule.withdrawPermitted(0.0));
        Assert.assertFalse("the withdraw isn't permitted",rule.withdrawPermitted(-5.0));
    }
}
