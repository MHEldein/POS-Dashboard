package PagesLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralSettings{
    private By pageTittle = By.xpath("//div[contains(text(),'General Setting')]");
    private By uploadImage = By.className("fileInputProfile");
    private By save = By.xpath("//button[contains(text(),'حفظ')]");
    private WebDriver driver;
    private WebDriverWait wait;

    public GeneralSettings(WebDriver driver){
        this.driver = driver;
    }

    public String getPageTittle(){
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTittle));
        return driver.findElement(pageTittle).getText();
    }

    public void upload(String path){
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(uploadImage));
        driver.findElement(uploadImage).sendKeys(path);
        WebElement Element = driver.findElement(save);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
        wait.until(ExpectedConditions.elementToBeClickable(save)).click();
    }
}
