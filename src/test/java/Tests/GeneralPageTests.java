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
        assertEquals(generalSettings.getALertMessage(), "تم التعديل بنجاح");
    }

    @Test
    public void verifyUpdateCompanyArabicName() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        generalSettings = homePage.NavToGeneralSettings();
        generalSettings.updateCompanyArabicName("شركة جديدة");
    }

    @Test
    public void verifyUpdateVATIdentityNumber() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        generalSettings = homePage.NavToGeneralSettings();
        generalSettings.updateVATNumber("W-9999999");
    }

    @Test
    public void verifyChangeCountryName() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        generalSettings = homePage.NavToGeneralSettings();
        generalSettings.changeCountry("Sierra Leone");
    }

    @Test
    public void verifyChangeCurrency() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        generalSettings = homePage.NavToGeneralSettings();
        generalSettings.changeCurrency("HTG");
    }

    @Test
    public void verifyChangeVatType(){
        homePage = loginPage.login("admin", "P@ssw0rd");
        generalSettings = homePage.NavToGeneralSettings();
        generalSettings.changeVAT("الضريبة على الهامش");
    }
}
