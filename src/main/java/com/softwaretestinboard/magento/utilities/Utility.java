package com.softwaretestinboard.magento.utilities;

import com.google.common.base.Function;
import com.softwaretestinboard.magento.browserfactory.ManageBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by Jay Vaghani
 */
public class Utility extends ManageBrowser {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * This method will send text on element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

//************************* Alert Methods *****************************************************

    /**
     * This method will switch to alert
     */
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    /**
     * This method will accept alert
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * This method will dismiss alert
     */
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * This method will get text from alert
     */
    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    /**
     * This method will send text from alert
     */
    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }


//*************************** Select Class Methods ***************************************//

    /**
     * This method will select the option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    /**
     * This method will select the option by value
     */
    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);
    }

    /**
     * This method will select the option by index
     */
    public void selectByIndexFromDropDown(By by, int index) {
        new Select(driver.findElement(by)).selectByIndex(index);
    }

    /**
     * This method will select the option by contains text
     */
    public void selectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }

//*************************** Window Handle Methods ***************************************//

    /**
     * This method will close all windows
     */
    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }

    /**
     * This method will switch to parent window
     */
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    /**
     * This method will find that we switch to right window
     */
    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }
//*************************** Action Methods ***************************************//

    /**
     * This method will use to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    /**
     * This method will use to hover mouse on element and click
     */
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

    //************************** Waits Methods *********************************************//

    /**
     * This method will use to wait until  VisibilityOfElementLocated
     */
    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }

    //************************** ScreenShot Methods *********************************************//

    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    //****************************** verification *************************************************//

    /**
     * This method is to verify the text
     */
    public void verifyTex(String displayMessage, String expectedTex, String actualTex){
    }

    /**
     * This method is to verify that sorting is done in reverse order or not
     */
    public void verifySortedElementsInReverseOrder(By by, By by1, String sortName) {
        List<WebElement> elements = driver.findElements(by);
        ArrayList<String> originalElementList = new ArrayList<>();
        for (WebElement e : elements) {
            originalElementList.add(e.getText());
        }
        System.out.println(originalElementList);
        // Sort By Reverse order
        Collections.reverse(originalElementList);
        System.out.println(originalElementList);
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(by1, sortName);
        // After filter Z -A Get all the products name and stored into array list
        elements = driver.findElements(by);
        ArrayList<String> afterSortByReverseList = new ArrayList<>();
        for (WebElement e : elements) {
            afterSortByReverseList.add(e.getText());
        }
        System.out.println(afterSortByReverseList);
    }

    /**
     * This method is to verify elements are in ascending order or not
     */
    public void verifyElementsInAscendingOrder(By by, By by1, String text){
        List<WebElement> elements = driver.findElements(by);
        List<String> elementsBefore = new ArrayList<>();
        for(
                WebElement e :elements)

        {
            elementsBefore.add(e.getText());
        }
        System.out.println("Before Sorting: " + elementsBefore);

        // Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(by1, text);

        // After Sorting value
        elements =driver.findElements(by);
        List<String> elementsAfter = new ArrayList<>();
        for(
                WebElement value :elements)

        {
            elementsAfter.add(value.getText());
        }
        // Sort the before name list into Ascending Order
        elementsBefore.sort(String.CASE_INSENSITIVE_ORDER);// Ascending order
        System.out.println("After sorting:" + elementsAfter);
    }
    /**
     * This method is to verify elements are in ascending order or not of type double
     */
    public void verifyElementsOfDoubleInAscendingOrder(By by,By by1, String text){
        List<WebElement> elementList = driver.findElements(by);
        List<Double> elementsListBefore = new ArrayList<>();
        for (WebElement value : elementList) {
            //Converting price in to Double and Removing $ from price
            elementsListBefore.add(Double.valueOf(value.getText().replace("$", "")));
        }
        // Select Sort By filter “Price”
        selectByVisibleTextFromDropDown(by1,text);
        // After Sorting Products by Price
        elementList = driver.findElements(by);
        List<Double> elementsListAfter = new ArrayList<>();
        for (WebElement value : elementList) {
            //Converting price in to Double and Removing $ from price
            elementsListAfter.add(Double.valueOf(value.getText().replace("$", "")));
        }
        // Sort the jacketPriceListBefore to Ascending Order
        Collections.sort(elementsListBefore);
    }
    /**
     * This method is to clear the texField
     */

    public void clearField(By by){
        driver.findElement(by).clear();
    }

    public String getTheAttributeValue(By by, String value){
        String qty = driver.findElement(by).getAttribute(value);
        return qty;
    }

}