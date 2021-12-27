package PagesLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterResultPage {
    WebDriver driver;
    WebDriverWait wait;
    private By resultsDiv = By.className("col-lg-12");

    public FilterResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkFilterResult(String checkResult) {
        wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resultsDiv)).getText().contains(checkResult);
    }
}
