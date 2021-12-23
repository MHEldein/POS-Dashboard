package PagesLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralSettings {
    private final By pageTittle = By.className("mt-2");
    private final By uploadImage = By.className("fileInputProfile");
    private final By companyArabicName = By.id("mat-input-2");
    private final By companyLatinName = By.id("mat-input-3");
    private final By alert = By.className("ng-nts-c21-258");
    private final By save = By.className("btn-submitted");
    private final By VAT = By.id("mat-input-4");
    private final By country = By.xpath("//mat-tab-body/div[1]/app-basic-setting[1]/form[1]/div[1]/div[2]/div[1]/div[4]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]");
    private final By currency = By.xpath("//mat-tab-body/div[1]/app-basic-setting[1]/form[1]/div[1]/div[2]/div[1]/div[5]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]");
    private final By vatList = By.xpath("//mat-tab-body/div[1]/app-basic-setting[1]/form[1]/div[1]/div[2]/div[1]/div[6]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]");
    private final By timeList = By.xpath("//mat-tab-body/div[1]/app-basic-setting[1]/form[1]/div[1]/div[2]/div[1]/div[7]/div[1]/mat-form-field[1]/div[1]/div[1]");
    private final By inactiveText = By.xpath("//input[@id='mat-input-5']");
    private final By priceVat = By.xpath("//label[contains(text(),'السعر شامل الضريبه')]");
    private final WebDriver driver;
    private WebElement element;
    private WebDriverWait wait;

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
        element = driver.findElement(save);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
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
        element = wait.until(ExpectedConditions.presenceOfElementLocated(location));
        driver.findElement(location).clear();
        driver.findElement(location).sendKeys(txt);
        this.save();
    }

    public void changeCountry(String countryName) {
        wait = new WebDriverWait(driver, 10);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(country));
        driver.findElement(country).click();
        driver.findElement(By.xpath("//span[contains(text(),'" + countryName + "')]")).click();
    }

    public void changeCurrency(String currencyName) {
        wait = new WebDriverWait(driver, 10);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(currency));
        driver.findElement(currency).click();
        driver.findElement(By.xpath("//span[contains(text(),'" + currencyName + "')]")).click();
    }

    public void changeVAT(String vatName) {
        wait = new WebDriverWait(driver, 10);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(vatList));
        driver.findElement(vatList).click();
        driver.findElement(By.xpath("//span[contains(text(),'" + vatName + "')]")).click();
    }

    public void changeTimeZone(String timeZoneName) {
        wait = new WebDriverWait(driver, 10);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(timeList));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'" + timeZoneName + "')]"))).click();
        this.save();
    }

    public void changeInactive(String inactiveTime) {
        wait = new WebDriverWait(driver, 10);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(inactiveText));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        this.updateTextField(inactiveText, inactiveTime);
        this.save();
    }

    public void togglePriceIncludeVat(String choice) {
        wait = new WebDriverWait(driver, 10);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(priceVat));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        if (choice == "yes") {
            driver.findElement(By.xpath("//mat-radio-button[@id='mat-radio-3']")).click();
        } else if (choice == "no") {
            driver.findElement(By.xpath("//mat-radio-button[@id='mat-radio-2']")).click();
        }
        this.save();
    }

    public String getCompanyArName() {
        return driver.findElement(companyArabicName).getAttribute("value");
    }

    public String getCompanyLatinName() {
        return driver.findElement(companyLatinName).getAttribute("value");
    }

    public String getCompanyIdentityNo() {
        return driver.findElement(VAT).getAttribute("value");
    }

    public String getCountryName() {
        return driver.findElement(country).getText();
    }

    public String getCurrency() {
        return driver.findElement(currency).getText();
    }

    public String getVatType() {
        return driver.findElement(vatList).getText();
    }

    public String getTimeZone() {
        return driver.findElement(timeList).getText();
    }

    public String getInactiveTime() {
        return driver.findElement(inactiveText).getAttribute("value");
    }
}
