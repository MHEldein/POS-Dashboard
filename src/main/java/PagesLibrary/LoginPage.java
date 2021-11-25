package PagesLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private By microtecLogo = By.xpath("//body/app-root[1]/app-authentication[1]/app-login[1]/div[1]/div[1]/div[2]/img[1]");
    private By username = By.cssSelector("#mat-input-0");
    private By password = By.cssSelector("#mat-input-1");
    private By loginButton = By.xpath("//body/app-root[1]/app-authentication[1]/app-login[1]/div[1]/div[1]/form[1]/div[2]/div[1]/button[1]");
    private By userMenu = By.xpath("//app-header/nav[1]/div[1]/ul[1]/button[1]");
    WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void setUsername(String user){
        driver.findElement(username).sendKeys(user);
    }

    public void setPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }

    public HomePage Login(String user, String pass){
        this.setUsername(user);
        this.setPassword(pass);
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

    public boolean getLoginLogoStatus(){
        return driver.findElement(microtecLogo).isDisplayed();
    }

}
