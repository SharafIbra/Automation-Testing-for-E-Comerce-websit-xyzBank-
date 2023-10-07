package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class basePage {

    WebDriver driver;

    protected void sendKeys(By byObject, String data) {
        driver.findElement(byObject).sendKeys(data);
    }

    protected void click(By byObject) {
        driver.findElement(byObject).click();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    protected String getText(By byObject) {
        return driver.findElement(byObject).getText();
    }

    protected void clear(By byObject) {
        driver.findElement(byObject).clear();
    }

}
