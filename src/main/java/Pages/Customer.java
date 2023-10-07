package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertEquals;


public class Customer extends basePage{

    public Customer(WebDriver driver) {
    this.driver=driver;
    }

    private By customerlogin = new By.ByXPath("/html/body/div/div/div[2]/div/div[1]/div[1]/button");

    private By selectcustomerDropDown = new By.ById("userSelect");
    private By loginbutton = new By.ByXPath("/html/body/div/div/div[2]/div/form/button");

    private By selectacountDropDown = new By.ById("accountSelect");
    private By welcomemsg = new By.ByXPath("/html/body/div/div/div[2]/div/div[1]/strong/text()[1]");
  /**
   * deposit elements
   * */
    private By deposit = new By.ByXPath("/html/body/div/div/div[2]/div/div[3]/button[2]");
    private By amounttodeposittextfield = new By.ByXPath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By depositbutton = new By.ByXPath("/html/body/div/div/div[2]/div/div[4]/div/form/button");
    private By depositstatus = new By.ByXPath("/html/body/div/div/div[2]/div/div[4]/div/span");

  /**
   * withdraw elements*/
    private By withdraw = new By.ByXPath("/html/body/div/div/div[2]/div/div[3]/button[3]");
    private By amounttowithdrawtextfield = new By.ByXPath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By withdrawbutton = new By.ByXPath("/html/body/div/div/div[2]/div/div[4]/div/form/button");
    private By withdrawstatus = new By.ByXPath("/html/body/div/div/div[2]/div/div[4]/div/span");

    /**
     Transaction elements*/
    private By transactions = new By.ByXPath("/html/body/div[1]/div/div[2]/div/div[3]/button[1]");
    private By starttime = new By.ById("start");
    private By endtime = new By.ById("end");

    public void customerlogin(String customerName){


        driver.findElement(customerlogin).click();

        Select selectCustomer = new Select(driver.findElement(selectcustomerDropDown));
        selectCustomer.selectByVisibleText(customerName);

        driver.findElement(loginbutton).click();
        System.out.println();

    }

    /*public void testCustomerLoginSuccessfully(){
        String expectedURL = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account";
        String actualURL = getCurrentURL();
        assertEquals(actualURL,expectedURL,"user not logged");
    }*/



    private void selectAccount(String accountNumber){
        Select selectAccount = new Select(driver.findElement(selectacountDropDown));
        selectAccount.selectByVisibleText(accountNumber);
    }

    public void depositMoney(String amount,String accountNumber){
        selectAccount(accountNumber);
        click(deposit);

        sendKeys(amounttodeposittextfield,amount);
        click(depositbutton);
    }

    public void withdrawMoney(String amount,String accountNumber){
        selectAccount(accountNumber);
        click(withdraw);
        sendKeys(amounttowithdrawtextfield,amount);
        click(withdrawbutton);
    }

    public void showTransactions(){
        driver.findElement(transactions).click();
        driver.findElement(starttime).sendKeys();


    }


    public Boolean depositStatus() {
       return  (driver.findElement(depositstatus).getText()).equals("Deposit Successful");
    }

    public Boolean withdrawStatus() {
        return  (driver.findElement(withdrawstatus).getText()).equals("Transaction successful");
    }



}
