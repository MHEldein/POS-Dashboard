package Tests;

import Base.TestsBase;
import PagesLibrary.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginsPageTests extends TestsBase {

    private HomePage homePage;

    @Test(priority = 1)
    public void verifySuccessfulLogin() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        assertTrue(homePage.getMenuContainerStatus());
    }

    @Test(priority = 2)
    public void verifyNoLoginWithInvalidCredentials() {
        homePage = loginPage.login("admin15", "123456789");
        assertTrue(loginPage.getLoginLogoStatus());
    }

    @Test(priority = 3)
    public void verifyTogglePasswordVisibilty() {
        loginPage.setPassword("12345678");
        loginPage.clickViewPassword();
        assertEquals(loginPage.getPWType(), "text");
    }

    @Test(priority = 4)
    public void verifyRememberMe() {
        loginPage.clickRememberMe();
        homePage = loginPage.login("admin", "P@ssw0rd");
        loginPage.openInNewTab();
        assertEquals(homePage.getHomePageUrl(), "http://cloudmicrotec.neat-url.com:8002/#/pages");
    }
}
