package BankManager;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BankManagerTests extends BaseTests {
    @Test
    void testAddCustomer(){
        var bm = homePage.clickBankManagerLogin();
        String firstname = "Sharaf";
        String lastname = "Ibrahim";
        String postcode = "123123" ;
        bm.addCustomer(firstname,lastname,postcode);
        String actualAlert = bm.getTextAlert();
        String expectedAlert = "Customer added successfully";
        assertTrue(actualAlert.contains(expectedAlert),"Customer isn't created");
        bm.acceptAlert();

    }


    @Test
    void testSearchCustomer(){
        var bm = homePage.clickBankManagerLogin();

        String first_name = "Sharaf1";
        String last_name = "Ibrahim1";
        String post_code = "12312345" ;
        bm.addCustomer(first_name,last_name,post_code);
        bm.acceptAlert();
        assertTrue(bm.searchCustomer(first_name),"Customer not found");

    }


    @Test
    void testOpenAccount(){
        var bm = homePage.clickBankManagerLogin();

        String first_name = "Sharaf2";
        String last_name = "Ibrahim2";
        String post_code = "123123456" ;
        String customerID = bm.addCustomer(first_name,last_name,post_code);
        bm.acceptAlert();
        String currency = "Dollar";
        bm.openAccount(customerID,currency);
        String actualAlert = bm.getTextAlert();
        String expectedAlert = "Account created successfully";
        assertTrue(actualAlert.contains(expectedAlert),"Account isn't created");
        bm.acceptAlert();
    }





}
