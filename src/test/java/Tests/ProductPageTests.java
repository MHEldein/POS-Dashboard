package Tests;

import Base.TestsBase;
import PagesLibrary.AddProductPage;
import PagesLibrary.HomePage;
import PagesLibrary.ProductsPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ProductPageTests extends TestsBase {
    private HomePage homePage;
    private ProductsPage productsPage;
    private AddProductPage addProductPage;
    @Test
    public void verifySuccessNavToAddProduct(){
        homePage = loginPage.login("admin", "P@ssw0rd");
        productsPage = homePage.navToProducts();
        addProductPage = productsPage.navToAddProduct();
        assertEquals(addProductPage.getPageTitle(), "إضافة منتج");
    }
}
