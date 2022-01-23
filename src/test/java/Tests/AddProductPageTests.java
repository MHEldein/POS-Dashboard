package Tests;

import Base.TestsBase;
import PagesLibrary.AddProductPage;
import PagesLibrary.HomePage;
import PagesLibrary.ProductsPage;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


public class AddProductPageTests extends TestsBase {
    private HomePage homePage;
    private ProductsPage productsPage;
    private AddProductPage addProductPage;

    @Test
    public void verifySeccessfulUpload() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        productsPage = homePage.navToProducts();
        addProductPage = productsPage.navToAddProduct();
        addProductPage.upload("C:\\Users\\Omar\\Desktop\\dd.jpg");
    }

    @Test
    public void verifyAddLatinName(){
        homePage = loginPage.login("admin", "P@ssw0rd");
        productsPage = homePage.navToProducts();
        addProductPage = productsPage.navToAddProduct();
        addProductPage.setProductLatinName("nnew product");
    }

    @Test
    public void verifyAddArabicName() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        productsPage = homePage.navToProducts();
        addProductPage = productsPage.navToAddProduct();
        addProductPage.setProductArabicNameName("منتج جدجديد");
    }

    @Test
    public void chooseCategory(){
        homePage = loginPage.login("admin", "P@ssw0rd");
        productsPage = homePage.navToProducts();
        addProductPage = productsPage.navToAddProduct();
        addProductPage.selectCategory("قائمة اللحوم");
        assertEquals(addProductPage.getSelectedCategory(), "قائمة اللحوم");
    }
}
