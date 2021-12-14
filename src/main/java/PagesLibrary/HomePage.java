package PagesLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private By container = By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='main-content']/app-menu[1]/nav[1]/ul[1]");
    private By userMenu = By.xpath("//app-header/nav[1]/div[1]/ul[1]/button[1]");
    private By profile = By.xpath("//button[contains(text(),'Profile')]");
    private By logout = By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/div[1]/button[2]");
    private By langMenu = By.xpath("//app-header/nav[1]/div[1]/div[1]/button[1]");
    private By arabicLang = By.xpath("//span[contains(text(),'العربية')]");
    private By englishLang = By.xpath("//span[contains(text(),'English')]");
    private By homeTittle = By.cssSelector("body.sidebar-toggled:nth-child(2) div.d-flex.flex-column div.container-fluid:nth-child(2) xng-breadcrumb.path nav.xng-breadcrumb-root.path ol.xng-breadcrumb-list li.xng-breadcrumb-item.ng-star-inserted label.xng-breadcrumb-trail.ng-star-inserted > li.ng-star-inserted");
    private By management = By.cssSelector("body.sidebar-toggled:nth-child(2) div.d-flex.flex-column div.container-fluid:nth-child(2) nav.navbar.navbar-expand.navbar-light.bg-white.mainbar.mt-4.mb-4.static-top.shadow.rounded.d-none.d-md-block.d-lg-block:nth-child(1) ul.navbar-nav.justify-content-center div.d-inline-block.dropdown:nth-child(1) button.dropdown-toggle.btn.btn-test > span.d-none.d-lg-inline.text-gray-6000.small");
    private By generalSettings = By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='main-content']/app-menu[1]/nav[1]/ul[1]/div[1]/div[1]/div[1]/a[1]");
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public boolean getMenuContainerStatus(){
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(container));
        return driver.findElement(container).isDisplayed();
    }

    public ProfilePage navToProfile(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userMenu));
        driver.findElement(userMenu).click();
        driver.findElement(profile).click();
        return new ProfilePage(driver);
    }

    public LoginPage logout(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userMenu));
        driver.findElement(userMenu).click();
        wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
        return new LoginPage(driver);
    }
    public void changeLanguage(String lang){
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(langMenu));
        driver.findElement(langMenu).click();
        if (lang == "ar"){
            driver.findElement(arabicLang).click();
        }
        else if (lang == "en"){
            driver.findElement(englishLang).click();
        }
        else{
            System.out.println("wrong language choice");
        }
    }
    public String getHomePageTittle(){
        return driver.findElement(homeTittle).getText();
    }

    public String getHomePageUrl(){
        return driver.getCurrentUrl();
    }

    public GeneralSettings NavToGeneralSettings(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(management));
        driver.findElement(management).click();
        driver.findElement(generalSettings).click();
        return new GeneralSettings(driver);
    }


}
