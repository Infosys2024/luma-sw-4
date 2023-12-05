package com.softwaretestinboard.magento.pages;

import com.softwaretestinboard.magento.utilities.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {
    By womenTab = By.xpath("//span[normalize-space()='Women']");
    By topsInWomenDropdown = By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]");
    By jacketsInTops = By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]");
    By mensTabs = By.xpath("//a[@id='ui-id-5']");
    By bottomsInMensDropdown = By.xpath("//a[@id='ui-id-18']");
    By pantsInBottoms = By.xpath("//a[@id='ui-id-23']");
    By gearTab = By.xpath("//span[normalize-space()='Gear']");
    By bagsInGear = By.xpath("//span[normalize-space()='Bags']");

    public void mouseHoverOnWomenTab(){
        waitUntilVisibilityOfElementLocated(womenTab,10);
        mouseHoverToElement(womenTab);
    }
    public void mouseHoverOnTopsInWomenTab(){
        waitUntilVisibilityOfElementLocated(topsInWomenDropdown,10);
        mouseHoverToElement(topsInWomenDropdown);
    }
    public void mouseHoverAndClickOnJacketsInWomen(){
        waitUntilVisibilityOfElementLocated(jacketsInTops,10);
        mouseHoverToElementAndClick(jacketsInTops);
    }
    public void mouseHoverOnMensTab(){
        waitUntilVisibilityOfElementLocated(womenTab,10);
        mouseHoverToElement(mensTabs);
    }
    public void mouseHoverOnBottomsInMensTab(){
        waitUntilVisibilityOfElementLocated(bottomsInMensDropdown,10);
        mouseHoverToElement(bottomsInMensDropdown);
    }
    public void mouseHoverAndClickOnPantsInBottoms(){
        waitUntilVisibilityOfElementLocated(pantsInBottoms,10);
        mouseHoverToElementAndClick(pantsInBottoms);
    }
    public void mouseHoverOnGearTab(){
        waitUntilVisibilityOfElementLocated(gearTab,10);
        mouseHoverToElement(gearTab);
    }
    public void mouseHoverAndClickOnBagsInGear(){
        waitUntilVisibilityOfElementLocated(bagsInGear,10);
        mouseHoverToElementAndClick(bagsInGear);
    }

}
