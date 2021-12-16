package PagesLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralSettings {
    private By pageTittle = By.xpath("//div[contains(text(),'General Setting')]");
    private By uploadImage = By.className("fileInputProfile");
    private By companyArabicName = By.id("mat-input-2");
    private By fieldName = By.className("label-form");
    private By form = By.xpath("//mat-tab-body/div[1]/app-basic-setting[1]/form[1]/div[1]/div[2]");
    private By companyLatinName = By.id("mat-input-3");
    private By alert = By.className("ng-nts-c21-258");
    private By save = By.className("btn-submitted");
    private By VAT = By.id("mat-input-4");
    private By country = By.xpath("//mat-tab-body/div[1]/app-basic-setting[1]/form[1]/div[1]/div[2]/div[1]/div[4]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]");
    private By currency = By.xpath("//mat-tab-body/div[1]/app-basic-setting[1]/form[1]/div[1]/div[2]/div[1]/div[5]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]");
    private By vatList = By.xpath("//mat-tab-body/div[1]/app-basic-setting[1]/form[1]/div[1]/div[2]/div[1]/div[6]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]");
    private WebDriver driver;

    private WebDriverWait wait;
    private Actions act;

    public GeneralSettings(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTittle() {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTittle));
        return driver.findElement(pageTittle).getText();
    }

    public void upload(String path) {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(uploadImage));
        driver.findElement(uploadImage).sendKeys(path);
        this.save();
    }

    public void save() {
        WebElement Element = driver.findElement(save);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", Element);
        wait.until(ExpectedConditions.elementToBeClickable(save)).click();
    }

    public void updateCompanyLatinName(String LatinName) {
        this.updateTextField(companyLatinName, LatinName);
    }

    public void updateCompanyArabicName(String ArabicName) {
        this.updateTextField(companyArabicName, ArabicName);
    }

    public String getALertMessage() {
        return driver.findElement(alert).getText();
    }

    public void updateVATNumber(String VATNumber) {
        this.updateTextField(VAT, VATNumber);
    }

    public void updateTextField(By location, String txt) {
        wait = new WebDriverWait(driver, 10);
        WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(location));
        driver.findElement(location).clear();
        driver.findElement(location).sendKeys(txt);
        this.save();
    }

    public void changeCountry(String countryName) {
        wait = new WebDriverWait(driver, 10);
        WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(country));
        driver.findElement(country).click();
        driver.findElement(By.xpath("//span[contains(text(),'" + countryName + "')]")).click();
    }

    public void changeCurrency(String currencyName) {
        wait = new WebDriverWait(driver, 10);
        WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(currency));
        driver.findElement(currency).click();
        driver.findElement(By.xpath("//span[contains(text(),'" + currencyName + "')]")).click();
    }

    public void changeVAT(String vatName){
        wait = new WebDriverWait(driver, 10);
        WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(vatList));
        driver.findElement(vatList).click();
        driver.findElement(By.xpath("//span[contains(text(),'"+vatName+"')]")).click();
    }
}
