package Tests;

import Base.TestsBase;
import PagesLibrary.AddProductPage;
import PagesLibrary.FilterResultPage;
import PagesLibrary.HomePage;
import PagesLibrary.ProductsPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductPageTests extends TestsBase {
    private FilterResultPage filterResultPage;
    private HomePage homePage;
    private ProductsPage productsPage;
    private AddProductPage addProductPage;

    @Test
    public void verifySuccessNavToAddProduct() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        productsPage = homePage.navToProducts();
        addProductPage = productsPage.navToAddProduct();
        assertEquals(addProductPage.getPageTitle(), "إضافة منتج");
    }

    @Test
    public void verifyFilterByCode() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        productsPage = homePage.navToProducts();
        filterResultPage = productsPage.filterByCode("000001");
        assertTrue(filterResultPage.checkFilterResult("كومبو العائلي - مظبي"));
    }

    @Test
    public void verifyFilterByName() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        productsPage = homePage.navToProducts();
        filterResultPage = productsPage.filterByName("بصل");
        assertTrue(filterResultPage.checkFilterResult("بصل"));
    }

    @Test
    public void verifyFilterByGroup() {
        homePage = loginPage.login("admin", "P@ssw0rd");
        productsPage = homePage.navToProducts();
        productsPage.filterBygroup("جروبزيييي");
    }
}
