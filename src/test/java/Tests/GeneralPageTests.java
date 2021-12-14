package Tests;

import Base.TestsBase;
import PagesLibrary.GeneralSettings;
import PagesLibrary.HomePage;
import org.testng.annotations.Test;

public class GeneralPageTests extends TestsBase {
    private GeneralSettings generalSettings;
    private HomePage homePage;
    @Test
    public void verifySuccessfulUploadImage(){
        homePage = loginPage.Login("admin", "P@ssw0rd");
        generalSettings = homePage.NavToGeneralSettings();
        generalSettings.upload("C:\\Users\\Omar\\Desktop\\dd.jpg");
    }
}
