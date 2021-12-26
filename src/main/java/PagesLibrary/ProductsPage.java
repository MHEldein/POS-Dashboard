package PagesLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
    private WebDriverWait wait;
    private WebDriver driver;
    private By title = By.className("page-title");
    private By addProduct = By.className("list-add-btn");
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle(){
        wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }

    public AddProductPage navToAddProduct(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(addProduct)).click();
        return new AddProductPage(driver);
    }
}
