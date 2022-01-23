package Base;

import PagesLibrary.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestsBase {
    protected LoginPage loginPage;
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://cloudmicrotec.neat-url.com:8002/#/auth");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    /*@AfterMethod
    public void tearDown() {
        driver.quit();
    }*/
}
