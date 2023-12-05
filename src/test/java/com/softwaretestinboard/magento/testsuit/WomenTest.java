package com.softwaretestinboard.magento.testsuit;

import com.softwaretestinboard.magento.pages.HomePage;
import com.softwaretestinboard.magento.pages.ProductPage;
import com.softwaretestinboard.magento.testbase.BaseTest;
import org.testng.annotations.Test;

public class WomenTest extends BaseTest {
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        Thread.sleep(2000);
        //Mouse Hover on Women Menu
        homePage.mouseHoverOnWomenTab();
        Thread.sleep(2000);
        //Mouse Hover on Tops
        homePage.mouseHoverOnTopsInWomenTab();
        //Click on Jackets
        homePage.mouseHoverAndClickOnJacketsInWomen();
        Thread.sleep(2000);
        //Select Sort By filter “Product Name”
        //Verify the products name display in alphabetical order
        productPage.verifySortingOfProductsInAscendingOrder("Product Name");

    }
    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        Thread.sleep(2000);
        //Mouse Hover on Women Menu
         homePage.mouseHoverOnWomenTab();
         Thread.sleep(2000);
        //Mouse Hover on Tops
        homePage.mouseHoverOnTopsInWomenTab();
        //Click on Jackets
        homePage.mouseHoverAndClickOnJacketsInWomen();
        Thread.sleep(2000);
        //Select Sort By filter “Price”
        //Verify the products price display in Low to High
        productPage.verifySortingOfPriceInAscendingOrder("Price");

    }
}
