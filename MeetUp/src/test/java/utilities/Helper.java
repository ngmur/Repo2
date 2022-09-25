package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {
    //this class will store reusable methods
    //actions click - mouse click
    public static void mouseClick(WebElement element) {
        //I would first check if my element is clickable and visible,enable
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(7))
                .until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(Driver.getDriver());
        actions.click(element).perform();
    }

    public static void javascriptClick(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("argument[0].click()", element);
    }

    //in case you will need demoing ur framework
    public static void highlightElement(WebElement element) throws InterruptedException {
        String style = "border: 4px dashed red";
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('style',arguments[1]);"
                , element, style);
        Thread.sleep(2000);
    }

    public static void waitForElementToBeDisplayed(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    //I have a custom click method WeClick)
    public static void weClick(WebElement element) {
        waitForElementToBeDisplayed(element);
        waitForElementToBeClickable(element);
        element.click();
    }
}
