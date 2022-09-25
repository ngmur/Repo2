package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

/*
Wha are waits ? ==>
                 Functions in Selenium to make WebDriver wait for a specific
                 time or for some condition to be true;
Why waits are needed? ==>
            1. Sometimes the automation script is faster than the browser
               loading time or objects render time on browser - no such element
2.Diff elem-s may load at different time interval
3.Se webdriver script and browser events may not be synchronous at all times

Useful when there is some gap in loading time of the web page and
web elements
An implicit wait makes WebDriver to poll the DOM for a certain amount
of time when trying to find an element or elements if they are not
immediately available
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
default setting is 0 (disabled)
Once set, the implicit wait is set for the entire life of the session
 */
public class Waits {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        //Implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("Hello World".toLowerCase(Locale.ROOT), Keys.ENTER);
//Explicit
        //alert is present
        //element exists
        //element is visible
        //title contains
        //title is
        //element staleness
        //visible text

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("hello world"))).click();
  //Fluent - similar to Explicit wait, i.e. wait for a certain duration until a condition is met
        //Differences:
        //Polling frequency - can change as per need
        //Ignore Exception - in case element is not found, can ignore any exception
        //like 'NoSuchElement' exception etc.
        // Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
        //.withTimeout(Duration.ofSeconds(10))
        //.pollingEvery(Duration.ofSeconds(1))
        //ignoring(NoSuchElementException.class);
        // fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath('')));


        driver.navigate().back();
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(10))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
fluentWait.until(ExpectedConditions.elementToBeSelected(By.xpath("//*[@id=\"rso\"]/div[3]/div/div/div[2]/div[2]/div[2]/div/video-voyager/div/div/div/a/div/div[2]/div[1]/div")));
   driver.quit();

    }
}
