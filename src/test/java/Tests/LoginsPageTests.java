package Tests;
import static org.testng.Assert.*;
import Base.TestsBase;
import PagesLibrary.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginsPageTests extends TestsBase {

    private HomePage homePage;
    @Test
    public void verifySuccessfulLogin(){
        homePage = loginPage.Login("admin", "P@ssw0rd");
        assertTrue(homePage.getMenuContainerStatus());
    }
    @Test
    public void verifyNoLoginWithInvalidCredentials(){
        homePage = loginPage.Login("admin15", "123456789");
        assertTrue(loginPage.getLoginLogoStatus());
    }
}
