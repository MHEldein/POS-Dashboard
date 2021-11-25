package Tests;

import Base.TestsBase;
import PagesLibrary.HomePage;
import PagesLibrary.ProfilePage;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class HomePageTests extends TestsBase {
    private HomePage homePage;
    private ProfilePage profilePage;

    @Test
    public void verifyNavToProfile(){
        homePage = loginPage.Login("admin", "P@ssw0rd");
        profilePage = homePage.navToProfile();
        assertEquals(profilePage.getPageTittle(), "Profile");
    }
    @Test
    public void verifySuccessfullLogout(){
        homePage = loginPage.Login("admin", "P@ssw0rd");
        homePage.logout();
        assertTrue(loginPage.getLoginLogoStatus());
    }

    @Test
    public void verifyChangeLanguage(){
        homePage = loginPage.Login("admin", "P@ssw0rd");
        homePage.changeLanguage("ar");
        assertEquals(homePage.getHomePageTittle(), "نقاط البيع");
    }


}
