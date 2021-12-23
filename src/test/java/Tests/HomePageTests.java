package Tests;

import Base.TestsBase;
import PagesLibrary.GeneralSettings;
import PagesLibrary.HomePage;
import PagesLibrary.ProfilePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTests extends TestsBase {
    private HomePage homePage;
    private GeneralSettings generalSettings;
    private ProfilePage profilePage;

    @Test(priority = 4)
    public void verifyNavToProfile() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        profilePage = homePage.navToProfile();
        assertEquals(profilePage.getPageTittle(), "الملف الشخصى");
    }

    @Test(priority = 1)
    public void verifySuccessfullLogout() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        homePage.logout();
        assertTrue(loginPage.getLoginLogoStatus());
    }

    @Test(priority = 2)
    public void verifyChangeLanguage() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        homePage.changeLanguage("en");
        assertEquals(homePage.getHomePageTittle(), "Point of sales");
    }

    @Test(priority = 3)
    public void verifySuccessfulNavToGeneralSettings() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        generalSettings = homePage.NavToGeneralSettings();
        assertEquals(generalSettings.getPageTittle(), "الإعدادات العامة");
    }

    @Test
    public void verifyChooseStatisticalPeriod() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        homePage.toggleStatisticalPeriod("year");
        assertEquals(homePage.getSelectedPeriod(), "العام");
    }

}
