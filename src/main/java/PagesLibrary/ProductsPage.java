package PagesLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductsPage {
    private WebDriverWait wait;
    private WebDriver driver;
    private WebElement element;
    private By title = By.className("page-title");
    private By addProduct = By.className("list-add-btn");
    private By filter = By.className("btn-filter");
    private By codeFilter = By.name("Code");
    private By nameFilter = By.name("Name");
    private By applyFilter = By.className("btn-apply");
    private By groupFilter = By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='main-content']/div[1]/div[1]/app-product-list[1]/mat-drawer-container[1]/mat-drawer[1]/div[1]/app-product-filter[1]/div[1]/div[3]/div[1]/app-genaric-select[1]/mat-form-field[1]/div[1]/div[1]/div[3]");
    private By groupChoice = By.className("mat-option-multiple");
    private By kanban = By.xpath("//mat-icon[contains(text(),'view_module')]");
    private By kanbanCard = By.className("grid-card");
    private By list = By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='main-content']/div[1]/div[1]/app-product-list[1]/mat-drawer-container[1]/mat-drawer-content[1]/app-list-view[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]/mat-icon[1]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }

    public AddProductPage navToAddProduct() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(addProduct)).click();
        return new AddProductPage(driver);
    }

    public FilterResultPage filterByCode(String code) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(filter)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(codeFilter)).sendKeys(code);
        element = driver.findElement(applyFilter);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.visibilityOfElementLocated(applyFilter)).click();
        return new FilterResultPage(driver);
    }

    public FilterResultPage filterByName(String name) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(filter)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameFilter)).sendKeys(name);
        element = driver.findElement(applyFilter);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.visibilityOfElementLocated(applyFilter)).click();
        return new FilterResultPage(driver);
    }

    public FilterResultPage filterBygroup(String groupName) {
        String text = null;
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(filter)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(groupFilter)).click();
        List<WebElement> elements = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(groupChoice, 0));
        for (int i = 0; i < elements.size(); i++) {
            text = elements.get(i).getText();
            if (text.equals(groupName)) {
                elements.get(i).click();
            }
        }
        element = driver.findElement(applyFilter);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementsByClassName('btn-apply')[0].focus();");
        wait.until(ExpectedConditions.elementToBeClickable(applyFilter)).click();
        return new FilterResultPage(driver);
    }

    public void changeToKanbanView(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(kanban)).click();
    }

    public boolean checkKanbanView(){
        return driver.findElement(kanbanCard).isDisplayed();
    }

    public void changeToListView(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(list)).click();
    }

}
