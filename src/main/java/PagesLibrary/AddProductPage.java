package PagesLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductPage {
    private WebDriverWait wait;
    private WebDriver driver;
    private By title = By.className("page-title");
    private By uploadImage = By.className("fileInputProfile");

    public AddProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }

    public void upload(String path) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(uploadImage)).sendKeys(path);
    }
}
