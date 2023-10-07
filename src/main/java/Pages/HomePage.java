package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){this.driver=driver;}

    By customerlogin = new By.ByXPath("/html/body/div/div/div[2]/div/div[1]/div[1]/button");

    By bankmanagerlogin = new By.ByXPath("/html/body/div/div/div[2]/div/div[1]/div[2]/button");


    public Customer clickCustomerLogin(){
        driver.findElement(customerlogin).click();
        return new Customer(driver);
    }
    public BankManager clickBankManagerLogin(){
        driver.findElement(bankmanagerlogin).click();
        return new BankManager(driver);
    }

}
