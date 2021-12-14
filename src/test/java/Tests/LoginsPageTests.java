package Tests;
import static org.testng.Assert.*;
import Base.TestsBase;
import PagesLibrary.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginsPageTests extends TestsBase {

    private HomePage homePage;
    @Test(priority = 1)
    public void verifySuccessfulLogin(){
        homePage = loginPage.Login("admin", "P@ssw0rd");
        assertTrue(homePage.getMenuContainerStatus());
    }
    @Test(priority = 2)
    public void verifyNoLoginWithInvalidCredentials(){
        homePage = loginPage.Login("admin15", "123456789");
        assertTrue(loginPage.getLoginLogoStatus());
    }
    @Test(priority = 3)
    public void verifyTogglePasswordVisibilty(){
        loginPage.setPassword("12345678");
        loginPage.clickViewPassword();
        assertEquals(loginPage.getPWType(), "text");
    }

    @Test(priority = 4)
    public void verifyRememberMe(){
        loginPage.clickRememberMe();
        homePage = loginPage.Login("admin", "P@ssw0rd");
        loginPage.openInNewTab();
        assertEquals(homePage.getHomePageUrl(), "http://cloudmicrotec.neat-url.com:8002/#/pages");
    }
}
