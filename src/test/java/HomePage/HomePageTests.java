package HomePage;

import base.BaseTests;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTests {


    @Test
    void testCustomerLogin(){
        homePage.clickCustomerLogin();

    }
    @Test
    void testManagerLogin(){
        homePage.clickBankManagerLogin();
    }
}
