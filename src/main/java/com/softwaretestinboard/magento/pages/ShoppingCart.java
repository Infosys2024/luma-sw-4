package com.softwaretestinboard.magento.pages;

import com.softwaretestinboard.magento.utilities.Utility;
import org.openqa.selenium.By;

public class ShoppingCart extends Utility {
    By shoppingCartText = By.xpath("//span[@class='base']");
    By productCronusYogaPantName = By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']");
    By productYogaPantSizeText = By.xpath("//dd[contains(text(),'32')]");
    By productCronusYogaPantColourText = By.xpath("//dd[contains(text(),'Black')]");
    By productOvernightDuffleText = By.xpath("//td[@class='col item']/descendant::a[2]");
    By productOverNightDuffleQtyText = By.xpath("//td[@class='col qty']/child::div[1]/descendant::input");
    By productOvernightDufflePriceText = By.xpath("//td[@class='col subtotal']//descendant::span[contains(text(),'$135.00')]");
    By qtyFieldInCart = By.xpath("//td[@class='col qty']/child::div[1]/descendant::input");
    By updateShoppingCartButton = By.xpath("//div[@class='cart main actions']/descendant::button[2]");
    By productPrice = By.xpath("//td[@data-th='Subtotal']//span[@class='price']");

    public String verifyShoppingCartTitle(){
        return getTextFromElement(shoppingCartText);
    }

    public String verifyProductCronusYogaPantName(){
        return getTextFromElement(productCronusYogaPantName);
    }

    public String verifyProductCronusYogaPantSizeText(){
        return getTextFromElement(productYogaPantSizeText);
    }

    public String verifyProductCronusYogaPantColourText(){
        return getTextFromElement(productCronusYogaPantColourText);
    }

    public String verifyProductNameOvernightDuffle(){
        return getTextFromElement(productOvernightDuffleText);
    }

    public String verifyProductOvernightDuffleQtyText(String value){
        return getTheAttributeValue(productOverNightDuffleQtyText, value);
    }

    public String verifyProductOvernightDufflePriceText(){
        return getTextFromElement(productOvernightDufflePriceText);
    }

    public void changeFieldInCart(String qty){
        clearField(qtyFieldInCart);
        waitUntilVisibilityOfElementLocated(qtyFieldInCart,5);
        sendTextToElement(qtyFieldInCart,qty);
    }

    public void updateShoppingCart(){
        waitUntilVisibilityOfElementLocated(updateShoppingCartButton,5);
        clickOnElement(updateShoppingCartButton);
    }

    public String verifyProductPrice(){
        return getTextFromElement(productPrice);
    }
}
