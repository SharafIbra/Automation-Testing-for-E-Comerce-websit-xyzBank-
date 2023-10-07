package BankManager;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BankManagerTests extends BaseTests {
    @Test (description = "Manager add a new customer")
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


    @Test (description = "Manager search for a specific customer")
    void testSearchCustomer(){
        var bm = homePage.clickBankManagerLogin();

        assertTrue(bm.searchCustomer("Harry"),"Customer not found");

    }


    @Test (description = "Manager opens a new account to a registered customer")
    void testOpenAccount(){
        var bm = homePage.clickBankManagerLogin();

        String first_name = "Sharaf2";
        String last_name = "Ibrahim2";
        String post_code = "123123456" ;
        bm.addCustomer(first_name,last_name,post_code);
        String customerID = bm.getCustomer_ID();
        bm.acceptAlert();
        String currency = "Dollar";
        bm.openAccount(customerID,currency);
        String actualAlert = bm.getTextAlert();
        String expectedAlert = "Account created successfully";
        assertTrue(actualAlert.contains(expectedAlert),"Account isn't created");
        bm.acceptAlert();
    }



    @Test (description = "Delete Customer")
    public void testDeleteCustomer(){

    }





}
