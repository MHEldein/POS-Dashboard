package PagesLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class LoginPage {
    private final WebDriver driver;
    private final By url = By.partialLinkText("www.facebook.com");
    private final By microtecLogo = By.xpath("//body/app-root[1]/app-authentication[1]/app-login[1]/div[1]/div[1]/div[2]/img[1]");
    private final By username = By.xpath("/html[1]/body[1]/app-root[1]/app-authentication[1]/app-login[1]/div[1]/div[1]/form[1]/div[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]/input[1]");
    private final By password = By.cssSelector("#mat-input-1");
    private final By loginButton = By.xpath("//body/app-root[1]/app-authentication[1]/app-login[1]/div[1]/div[1]/form[1]/div[2]/div[1]/button[1]");
    private final By userMenu = By.xpath("//app-header/nav[1]/div[1]/ul[1]/button[1]");
    private final By viewPW = By.xpath("//mat-icon[contains(text(),'visibility')]");
    private final By rememberMe = By.xpath("//body/app-root[1]/app-authentication[1]/app-login[1]/div[1]/div[1]/form[1]/div[1]/div[1]/mat-checkbox[1]/label[1]/span[1]");
    private final By newTab = By.tagName("body");
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage login(String user, String pass) {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        this.setUsername(user);
        this.setPassword(pass);
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

    public boolean getLoginLogoStatus() {
        return driver.findElement(microtecLogo).isDisplayed();
    }

    public void clickViewPassword() {
        driver.findElement(viewPW).click();
    }

    public String getPWType() {
        String result = driver.findElement(password).getAttribute("type");
        return result;
    }

    public void clickRememberMe() {
        driver.findElement(rememberMe).click();
    }

    public String getUsername() {
        wait = new WebDriverWait(driver, 10);
        String rememberedUsername = driver.findElement(username).getText();
        return rememberedUsername;
    }

    public void setUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public String getPassword() {
        wait = new WebDriverWait(driver, 5);
        clickViewPassword();
        String rememberedPW = driver.findElement(password).getText();
        return rememberedPW;
    }

    public void setPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void openInNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("http://cloudmicrotec.neat-url.com:8002/#/auth");
    }
}
