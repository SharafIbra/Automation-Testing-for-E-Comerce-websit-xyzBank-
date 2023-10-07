package base;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTests {
    WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
        public void setUpEdgeDriver() {
        driver = new ChromeDriver();
        goHome();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }




    public void goHome(){
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }


    @AfterMethod
    public void tearDown() {driver.quit();}


}
