package PagesLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    private final By container = By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='main-content']/app-menu[1]/nav[1]/ul[1]");
    private final By userMenu = By.xpath("//app-header/nav[1]/div[1]/ul[1]/button[1]");
    private final By profile = By.className("fa-user-circle");
    private final By logout = By.className("fa-sign-out-alt");
    private final By langMenu = By.xpath("//app-header/nav[1]/div[1]/div[1]/button[1]");
    private final By arabicLang = By.xpath("//body/div[2]/div[2]/div[1]/div[1]/div[1]/button[1]");
    private final By englishLang = By.xpath("//body/div[2]/div[2]/div[1]/div[1]/div[1]/button[2]");
    private final By homeTittle = By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='main-content']/app-menu[1]/div[1]");
    private final By management = By.cssSelector("body.sidebar-toggled:nth-child(2) div.d-flex.flex-column div.container-fluid:nth-child(2) nav.navbar.navbar-expand.navbar-light.bg-white.mainbar.mt-4.mb-4.static-top.shadow.rounded.d-none.d-md-block.d-lg-block:nth-child(1) ul.navbar-nav.justify-content-center div.d-inline-block.dropdown:nth-child(1) button.dropdown-toggle.btn.btn-test > span.d-none.d-lg-inline.text-gray-6000.small");
    private final By generalSettings = By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='main-content']/app-menu[1]/nav[1]/ul[1]/div[1]/div[1]/div[1]/a[1]");
    private final WebDriver driver;
    private By masterBranch = By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/div[1]/mat-option[2]/span[1]");
    private By nasrBranch = By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/div[1]/mat-option[3]/span[1]");
    private By allTime = By.xpath("//li[contains(text(),'جميع الاوقات')]");
    private By year = By.xpath("//li[contains(text(),'العام')]");
    private By month = By.xpath("//li[contains(text(),'الشهر')]");
    private By week = By.xpath("//li[contains(text(),'الاسبوع')]");
    private By today = By.xpath("//li[contains(text(),'اليوم')]");
    private By branch = By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='main-content']/div[1]/div[1]/app-main[1]/div[1]/div[1]/div[1]/div[2]/app-genaric-select[1]/mat-form-field[1]/div[1]/div[1]/div[3]");
    private By menu = By.id("menuMenu");
    private By products = By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='main-content']/app-menu[1]/nav[1]/ul[1]/div[5]/div[1]/a[2]");
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean getMenuContainerStatus() {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(container));
        return driver.findElement(container).isDisplayed();
    }

    public ProfilePage navToProfile() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userMenu)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(profile)).click();
        return new ProfilePage(driver);
    }

    public LoginPage logout() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userMenu)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logout)).click();
        return new LoginPage(driver);
    }

    public void changeLanguage(String lang) {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(langMenu));
        driver.findElement(langMenu).click();
        if (lang == "ar") {
            wait.until(ExpectedConditions.visibilityOfElementLocated(arabicLang)).click();
        } else if (lang == "en") {
            wait.until(ExpectedConditions.visibilityOfElementLocated(englishLang)).click();
        } else {
            System.out.println("wrong language choice");
        }
    }

    public String getHomePageTittle() {
        wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homeTittle)).getText();
    }

    public String getHomePageUrl() {
        return driver.getCurrentUrl();
    }

    public GeneralSettings NavToGeneralSettings() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(management));
        driver.findElement(management).click();
        driver.findElement(generalSettings).click();
        return new GeneralSettings(driver);
    }

    public void toggleStatisticalPeriod(String period) {
        wait = new WebDriverWait(driver, 10);
        switch (period) {
            case "all time":
                wait.until(ExpectedConditions.visibilityOfElementLocated(allTime)).click();
                break;
            case "year":
                wait.until(ExpectedConditions.visibilityOfElementLocated(year)).click();
                break;
            case "month":
                wait.until(ExpectedConditions.visibilityOfElementLocated(month)).click();
                break;
            case "week":
                wait.until(ExpectedConditions.visibilityOfElementLocated(week)).click();
                break;
            case "today":
                wait.until(ExpectedConditions.visibilityOfElementLocated(today)).click();
                break;
        }
    }

    public String getSelectedPeriod() {
        String selectedPeriod = "";
        List<WebElement> periods = new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("list-group-item"), 0));
        for (int i = 0; i < periods.size(); i++) {
            if (periods.get(i).getAttribute("class").contains("priod-active")) {
                selectedPeriod = periods.get(i).getText();
                break;
            }
        }
        return selectedPeriod;
    }

    public void chooseBranch(String branchName) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(branch)).click();
        if (branchName == "master branch") {
            wait.until(ExpectedConditions.visibilityOfElementLocated(masterBranch)).click();
        } else if (branchName == "nasr branch") {
            wait.until(ExpectedConditions.visibilityOfElementLocated(nasrBranch)).click();
        } else {
            System.out.println("that branch does not exist");
        }
    }

    public String getSelectedBranch() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(branch)).getText();
    }

    public ProductsPage navToProducts() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(menu)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(products)).click();
        return new ProductsPage(driver);
    }

}
