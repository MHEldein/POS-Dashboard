package Tests;

import Base.TestsBase;
import PagesLibrary.GeneralSettings;
import PagesLibrary.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeneralPageTests extends TestsBase {
    private GeneralSettings generalSettings;
    private HomePage homePage;

    @Test
    public void verifySuccessfulUploadImage() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        generalSettings = homePage.NavToGeneralSettings();
        generalSettings.upload("C:\\Users\\Omar\\Desktop\\dd.jpg");
    }

    @Test
    public void verifyUpdateCompanyLatinName() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        generalSettings = homePage.NavToGeneralSettings();
        generalSettings.updateCompanyLatinName("New Company");
        assertEquals(generalSettings.getCompanyLatinName(), "New Company");
    }

    @Test
    public void verifyUpdateCompanyArabicName() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        generalSettings = homePage.NavToGeneralSettings();
        generalSettings.updateCompanyArabicName("شركة جديدة");
        assertEquals(generalSettings.getCompanyArName(), "شركة جديدة");
    }

    @Test
    public void verifyUpdateVATIdentityNumber() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        generalSettings = homePage.NavToGeneralSettings();
        generalSettings.updateVATNumber("W-9999999");
        assertEquals(generalSettings.getCompanyIdentityNo(), "W-9999999");
    }

    @Test
    public void verifyChangeCountryName() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        generalSettings = homePage.NavToGeneralSettings();
        generalSettings.changeCountry("Sierra Leone");
        assertEquals(generalSettings.getCountryName(), "Sierra Leone");
    }

    @Test
    public void verifyChangeCurrency() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        generalSettings = homePage.NavToGeneralSettings();
        generalSettings.changeCurrency("HTG");
        assertEquals(generalSettings.getCurrency(), "HTG");
    }

    @Test
    public void verifyChangeVatType() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        generalSettings = homePage.NavToGeneralSettings();
        generalSettings.changeVAT("الضريبة على الهامش");
        assertEquals(generalSettings.getVatType(), "الضريبة على الهامش");
    }

    @Test
    public void verifyChangeTimeZone() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        generalSettings = homePage.NavToGeneralSettings();
        generalSettings.changeTimeZone("(GMT+04:30) Kabul");
        assertEquals(generalSettings.getTimeZone(), "(GMT+04:30) Kabul");
    }

    @Test
    public void verifyChangeInactiveTime() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        generalSettings = homePage.NavToGeneralSettings();
        generalSettings.changeInactive("1900");
        assertEquals(generalSettings.getInactiveTime(), "1900");
    }

    @Test
    public void verifyTogglePriceIncludeVat() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        generalSettings = homePage.NavToGeneralSettings();
        generalSettings.togglePriceIncludeVat("yes");
    }
}
