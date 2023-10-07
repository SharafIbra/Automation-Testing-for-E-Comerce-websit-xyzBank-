package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BankManager {
    WebDriver driver;



    public BankManager(WebDriver driver) {
    this.driver=driver;
    }

    private By addcustomer = new By.ByXPath("/html/body/div/div/div[2]/div/div[1]/button[1]");
    private By openaccount = new By.ByXPath("/html/body/div/div/div[2]/div/div[1]/button[2]");
    private By customers = new By.ByXPath("/html/body/div/div/div[2]/div/div[1]/button[3]");

    /**
     * Add Customer Elements
     * */
    private By firstname = new By.ByXPath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input");
    private By lastname = new By.ByXPath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input");
    private By postcode = new By.ByXPath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input");

    private By addcustomer_submit = new By.ByXPath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");

    /**
     * Search Customer Elements*/
    private By searchCustomer = new By.ByXPath("/html/body/div[1]/div/div[2]/div/div[2]/div/form/div/div/input");
    private By searchCustomerName = new By.ByXPath("/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr");

    /**
     * Open Account Elements
     * */
    private By customerNameDropDown = new By.ByXPath("//*[@id=\"userSelect\"]");
    private By currencyDropDown = new By.ByXPath("//*[@id=\"currency\"]");
    private By process = new By.ByXPath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");


    public String addCustomer(String FirstName , String LastName , String PostCode){
        driver.findElement(addcustomer).click();
        setFirstname(FirstName);
        setLastname(LastName);
        setPostcode(PostCode);
        driver.findElement(addcustomer_submit).click();
        return getTextAlert().replaceAll("[^0-9]", "");
     }
    private void setFirstname(String firstName){
        driver.findElement(firstname).sendKeys(firstName);
    }
    private void setLastname(String lastName){
        driver.findElement(lastname).sendKeys(lastName);
    }
    private void setPostcode(String postCode){
        driver.findElement(postcode).sendKeys(postCode);
    }




    public void openAccount(String customerId ,String currency)
    {
        driver.findElement(openaccount).click();
        Select selectCustomer = new Select(driver.findElement(customerNameDropDown));
        selectCustomer.selectByValue(customerId);
        Select selectCurrency = new Select(driver.findElement(currencyDropDown));
        selectCurrency.selectByVisibleText(currency);
        driver.findElement(process).click();
    }
    public void showCustomers(){driver.findElement(customers).click();}

    public boolean searchCustomer(String customerName){
        driver.findElement(customers).click();
        driver.findElement(searchCustomer).sendKeys(customerName);
        String searchText = driver.findElement(searchCustomerName).getText();
        System.out.println(searchText);
        return searchText.contains(customerName);

    }
    public String getTextAlert() {
        return driver.switchTo().alert().getText();
    }
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }



}
