package PagesLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddProductPage {
    private WebDriverWait wait;
    private WebDriver driver;
    private By title = By.className("page-title");
    private By uploadImage = By.className("fileInputProfile");
    private By productLatinName = By.name("LatinName");
    private By productArabicName = By.name("ArabicName");
    private By category = By.xpath("//mat-tab-body/div[1]/app-product-definition[1]/form[1]/div[1]/div[2]/div[3]/app-genaric-select[1]/ng-select[1]/div[1]");

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

    public void setProductLatinName(String name){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productLatinName)).sendKeys(name);
    }

    public void setProductArabicNameName(String name) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productArabicName)).sendKeys(name);
    }

    public void selectCategory(String categoryName){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(category)).click();
        List<WebElement> elements = new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("ng-option"), 0));
        for (int i=0; i < elements.size(); i++){
            if (new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(elements.get(i))).getText().equals(categoryName)){
                elements.get(i).click();
            }
            //else if (elements.get(i).getText().toString() != categoryName)System.out.println("entered category does not exist");
        }
    }

    public String getSelectedCategory(){
        wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ng-option-selected"))).getText();
    }
}
