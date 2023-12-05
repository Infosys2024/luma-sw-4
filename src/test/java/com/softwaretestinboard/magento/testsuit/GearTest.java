package com.softwaretestinboard.magento.testsuit;

import com.softwaretestinboard.magento.pages.HomePage;
import com.softwaretestinboard.magento.pages.ProductPage;
import com.softwaretestinboard.magento.pages.ShoppingCart;
import com.softwaretestinboard.magento.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GearTest extends BaseTest {
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    ShoppingCart shoppingCart = new ShoppingCart();

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        // Mouse Hover on Gear Menu
        Thread.sleep(2000);
        homePage.mouseHoverOnGearTab();
        Thread.sleep(1000);
        // Click on Bags
        homePage.mouseHoverAndClickOnBagsInGear();
        Thread.sleep(1000);
        // Click on Product Name ‘Overnight Duffle’
        productPage.clickOnProductOvernightDuffle();
        // Verify the text ‘Overnight Duffle’
        Assert.assertEquals(productPage.verifyOvernightDuffleText(),"Overnight Duffle");
        // Change Qty 3
        productPage.changeQty("3");
        // Click on ‘Add to Cart’ Button.
        productPage.clickOnAddToCartButton();
        Thread.sleep(1000);
        // Verify the text ‘You added Overnight Duffle to your shopping cart.’
        Assert.assertEquals(productPage.verifyProductAddedToCartMessage(),"You added Overnight Duffle to your shopping cart.");
        // Click on ‘shopping cart’ Link into message
        productPage.clickOnShoppingCartLink();
        // Verify the product name ‘Overnight Duffle’
        Assert.assertEquals(shoppingCart.verifyProductNameOvernightDuffle(),"Overnight Duffle");
        //Verify the Qty is ‘3’
        Assert.assertEquals(shoppingCart.verifyProductOvernightDuffleQtyText("value"),"3");
        Thread.sleep(2000);
        // Verify the product price ‘$135.00’
        Assert.assertEquals(shoppingCart.verifyProductOvernightDufflePriceText(),"$135.00");
        // Change Qty to ‘5’
        shoppingCart.changeFieldInCart("5");
        Thread.sleep(2000);
        // Click on ‘Update Shopping Cart’ button
        shoppingCart.updateShoppingCart();
        // Verify the product price ‘$225.00’
        Thread.sleep(2000);
        Assert.assertEquals(shoppingCart.verifyProductPrice(),"$225.00");

    }
}




