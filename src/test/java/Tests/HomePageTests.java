package Tests;

import Base.TestsBase;
import PagesLibrary.GeneralSettings;
import PagesLibrary.HomePage;
import PagesLibrary.ProfilePage;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class HomePageTests extends TestsBase {
    private HomePage homePage;
    private GeneralSettings generalSettings;
    private ProfilePage profilePage;

    @Test(priority = 4)
    public void verifyNavToProfile(){
        homePage = loginPage.Login("admin", "P@ssw0rd");
        profilePage = homePage.navToProfile();
        assertEquals(profilePage.getPageTittle(), "Profile");
    }
    @Test(priority = 1)
    public void verifySuccessfullLogout(){
        homePage = loginPage.Login("admin", "P@ssw0rd");
        homePage.logout();
        assertTrue(loginPage.getLoginLogoStatus());
    }

    @Test(priority = 2)
    public void verifyChangeLanguage(){
        homePage = loginPage.Login("admin", "P@ssw0rd");
        homePage.changeLanguage("en");
        assertEquals(homePage.getHomePageTittle(), "نقاط البيع");
    }

    @Test(priority = 3)
    public void verifySuccessfulNavToGeneralSettings(){
        homePage = loginPage.Login("admin", "P@ssw0rd");
        generalSettings = homePage.NavToGeneralSettings();
        assertEquals(generalSettings.getPageTittle(), "General Setting");
    }

}
