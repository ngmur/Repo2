package iframesAndAlerts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class PracticeIframes {
     WebDriver driver;
    @Before
    public void setUp(){
       driver= Driver.getDriver();
    }
    @After
    public void tearDown(){
        Driver.closeDriver();
    }
    @Test
    public void test1(){
        driver.get("https://demoqa.com/frames");
        //before checking if text1 is displayed we need to switch to the iframe that contains it

        //Option 1 - switch iframe by web element
        WebElement iframe = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(iframe);
        WebElement text1 = driver.findElement(By.id("sampleHeading"));
        Assert.assertTrue(text1.isDisplayed());
        driver.switchTo().defaultContent();
        //Option 2 - switch to iframe by name or id
        driver.switchTo().frame("frame2");
        WebElement text2 = driver.findElement(By.id("sampleHeading"));
        Assert.assertTrue(text2.isDisplayed());
        driver.switchTo().defaultContent();
        //Option 3 - switch to iframe by index
        driver.switchTo().frame(2);
        WebElement text3 = driver.findElement(By.xpath("//iframe[@id='google_ads_iframe_/21849154601,22343295815/Ad.Plus-300x250-1_0']"));
        Assert.assertTrue(text3.getAttribute("title").contains("3rd party ad content"));



    }

    @Test
    public void test2()throws InterruptedException {
        driver.get("https://leetcode.com");
        Actions actions = new Actions(driver);
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='playground-iframe']"))).perform();
        WebElement iframe = driver.findElement(By.xpath("//iframe[@height='400']"));

        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@class='btn btn-success run-code-btn']")).click();
        WebElement runResultMessage = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='success result']")));
        String text = runResultMessage.getText();
        for (String word : text.split("")) {  //Finished in 4 ms -> String arr = {Finished, in , 4, ms}
            if (Character.isDigit(word.charAt(0))) {
                int ms = Integer.parseInt(word);
                Assert.assertTrue(ms < 5);
            }
        }
    }
       @Test
        public void nestedFrames(){
        driver.get("https://demoqa.com/nestedframes");
        WebElement childFrame = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        driver.switchTo().frame(childFrame);
        Assert.assertEquals("Child Iframe",childFrame.getText());
       }

}
