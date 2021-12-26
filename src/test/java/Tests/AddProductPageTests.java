package Tests;

import Base.TestsBase;
import PagesLibrary.AddProductPage;
import PagesLibrary.HomePage;
import PagesLibrary.ProductsPage;
import org.testng.annotations.Test;

public class AddProductPageTests extends TestsBase {
    private HomePage homePage;
    private ProductsPage productsPage;
    private AddProductPage addProductPage;
    @Test
    public void verifySeccessfulUpload(){
        homePage = loginPage.login("admin", "P@ssw0rd");
        productsPage = homePage.navToProducts();
        addProductPage = productsPage.navToAddProduct();
        addProductPage.upload("C:\\Users\\Omar\\Desktop\\dd.jpg");
    }
}
