package Base;

import PagesLibrary.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestsBase {
    private WebDriver driver;
    protected LoginPage loginPage;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver.get("http://cloudmicrotec.neat-url.com:8002/#/auth");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }
    //@AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
