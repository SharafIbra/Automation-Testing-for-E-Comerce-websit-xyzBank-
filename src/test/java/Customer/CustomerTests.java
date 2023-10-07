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


    @Test(description = "Customer need to withdraw amount equal or less than the balance")
    void testWithdrawMoney() {
        var cust = homePage.clickCustomerLogin();
        cust.customerlogin("Hermoine Granger");
        cust.withdrawMoney("1000", "1001");
        assertTrue(cust.withdrawStatus(), "Transaction Failed. You can not withdraw amount more than the balance.");
    }

    @Test(description = "Customer need to withdraw amount more than the balance")
    void testWithdrawMoney_invalid() {
        var cust = homePage.clickCustomerLogin();
        cust.customerlogin("Ron Weasly");
        /*    error->   money exceed the balance    */
        cust.withdrawMoney("1000000", "1007");
        assertFalse(cust.withdrawStatus(), "Transaction Failed. You can not withdraw amount more than the balance.");
    }



    @Test(description = "Customer need to deposit amount of money")
    void test_deposit_withdraw(){
        var cust = homePage.clickCustomerLogin();
        cust.customerlogin("Neville Longbottom");

        cust.depositMoney("10000", "1013");
    }




}
