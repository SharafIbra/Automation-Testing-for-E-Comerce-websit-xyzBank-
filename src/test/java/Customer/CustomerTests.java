package Customer;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CustomerTests extends BaseTests {


    @Test
    void testCustomerLogin() {
        var cust = homePage.clickCustomerLogin();
        cust.customerlogin("Hermoine Granger");
    }

    @Test
    void testDepositMoney() {
        var cust = homePage.clickCustomerLogin();
        cust.customerlogin("Hermoine Granger");
        cust.depositMoney("10000", "1001");
        assertTrue(cust.depositStatus(), "Deposit not ok");
    }

    /*@Test
    void testDepositMoney_invalid() {
        var cust = homePage.clickCustomerLogin();
        cust.customerlogin("Harry Potter");
        *//*        error-> invalid account number      *//*
        cust.depositMoney("10000", "10015");
        assertTrue(cust.depositStatus(), "Deposit not ok");
    }*/


    @Test
    void testWithdrawMoney() {
        var cust = homePage.clickCustomerLogin();
        cust.customerlogin("Harry Potter");
        cust.withdrawMoney("100", "1005");
        assertTrue(cust.withdrawStatus(), "Transaction Failed. You can not withdraw amount more than the balance.");
    }

    @Test
    void testWithdrawMoney_invalid() {
        var cust = homePage.clickCustomerLogin();
        cust.customerlogin("Ron Weasly");
        /*    error->   money exceed the balance    */
        cust.withdrawMoney("1000000", "1007");
        assertFalse(cust.withdrawStatus(), "Transaction Failed. You can not withdraw amount more than the balance.");
    }



    @Test
    void test_deposit_withdraw(){
        var cust = homePage.clickCustomerLogin();
        cust.customerlogin("Sharaf Ibrahim");

        cust.depositMoney("10000", "1016");
        cust.withdrawMoney("100", "1016");

    }


}
