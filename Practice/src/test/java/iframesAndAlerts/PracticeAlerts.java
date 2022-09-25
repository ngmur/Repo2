package iframesAndAlerts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class PracticeAlerts {
    WebDriver driver;
    @Before
    public void setUp(){
        driver = Driver.getDriver();

    }
    @After
    public void tearDown(){
        Driver.closeDriver();
    }
    @Test
    public void test1(){
        driver.navigate().to("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("clicked a button"));
        alert.dismiss();

        driver.findElement(By.id("timerAlertButton")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        alert.accept();



        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert();
        alert.dismiss();
        WebElement confirmResult = driver.findElement(By.id("confirmResult"));
        Assert.assertTrue(confirmResult.getText().contains("Cancel")) ;


        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert();
        alert.sendKeys("Nikki");
        alert.accept();
WebElement promptResult = driver.findElement(By.id("promptResult"));
Assert.assertTrue(promptResult.getText().contains("Nikki"));

    }

}
