package com.softwaretestinboard.magento.pages;

import com.softwaretestinboard.magento.utilities.Utility;
import org.openqa.selenium.By;

public class ProductPage extends Utility {
     By jacketElementList = By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]");
     By sortByField = By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[3]/label[1]");
     By jacketsPriceElementList = By.xpath("//span[@class='price-container price-final_price tax weee']");
     By productCronusYogaPant = By.xpath("//a[normalize-space()='Cronus Yoga Pant']");
     By productCronusYogaPantSize = By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']");
     By productCronusYogaPantColour = By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']");
     By addToCart = By.xpath("//main[@id='maincontent']/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div/div[1]/form/button/span");
     By productAddedToCartMessage = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
     By shoppingCartLink = By.xpath("//a[normalize-space()='shopping cart']");
     By productOvernightDuffle = By.xpath("//a[contains(text(),'Overnight Duffle')]");
     By productOverNightDuffleText = By.xpath("//span[@class='base']");
     By changeField = By.xpath("//input[@id='qty']");
     By addToCartButton = By.xpath("//button[@id='product-addtocart-button']");

     public void verifySortingOfProductsInAscendingOrder(String option){
          waitUntilVisibilityOfElementLocated(jacketElementList,10);
          waitUntilVisibilityOfElementLocated(sortByField,10);
          verifyElementsInAscendingOrder(jacketElementList,sortByField, option);
     }
     public void verifySortingOfPriceInAscendingOrder(String option){
          waitUntilVisibilityOfElementLocated(jacketsPriceElementList,10);
          waitUntilVisibilityOfElementLocated(sortByField,10);
          verifyElementsOfDoubleInAscendingOrder(jacketsPriceElementList,sortByField,option);
     }
     public void mouseHoverOnProductCronusYogaPant(){
          waitUntilVisibilityOfElementLocated(productCronusYogaPant,10);
          mouseHoverToElement(productCronusYogaPant);
     }

     public void mouseHoverAndClickOnSizeOfCronusYogaPant(){
          mouseHoverToElementAndClick(productCronusYogaPantSize);
     }

     public void mouseHoverAndClickOnCronusYogaPantColour(){
          waitUntilVisibilityOfElementLocated(productCronusYogaPantColour,5);
          mouseHoverToElementAndClick(productCronusYogaPantColour);
     }

     public void mouseHoverAndClickOnAddToCart(){
          waitUntilVisibilityOfElementLocated(addToCart,5);
          mouseHoverToElementAndClick(addToCart);
     }

     public String verifyProductAddedToCartMessage(){
          return getTextFromElement(productAddedToCartMessage);
     }

     public void clickOnShoppingCartLink(){
          clickOnElement(shoppingCartLink);
     }

     public void clickOnProductOvernightDuffle(){
          waitUntilVisibilityOfElementLocated(productOvernightDuffle,5);
          clickOnElement(productOvernightDuffle);
     }

     public String verifyOvernightDuffleText(){
          return getTextFromElement(productOverNightDuffleText);
     }

     public void changeQty(String qty){
          clearField(changeField);
          waitUntilVisibilityOfElementLocated(changeField,5);
          sendTextToElement(changeField, qty);
     }

     public void clickOnAddToCartButton(){
          clickOnElement(addToCartButton);
     }
}
