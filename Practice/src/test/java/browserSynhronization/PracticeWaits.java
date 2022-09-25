package browserSynhronization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PracticeWaits {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void testEtsy(){
        driver.get("https://www.etsy.com");
        driver.findElement(By.xpath("//button[contains(@class,'select-signin')]")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        WebElement registerButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'select-register')]")));
        registerButton.click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//p[starts-with(text(),'Registration')]")));
        WebElement registrationForm = driver.findElement(By.xpath("//p[starts-with(text(),'Registration')]"));
        Assert.assertTrue("The registration form is not displayed",registrationForm.isDisplayed());

    }
    @Test
    public void test1(){
        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement visibilityButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='visibleAfter]")));
        Assert.assertTrue(visibilityButton.isDisplayed());


    }
    @Test
    public void test2(){
        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(By.cssSelector("#colorchange"),"class","text-danger"));
        WebElement colorChangeButton = driver.findElement(By.id("colorChange"));
        Assert.assertTrue(colorChangeButton.getAttribute("class").contains("text-danger"));
    }
    @Test
    public void testFileUpload() throws InterruptedException {
        driver.get("https://demoqa.com/upload-download");
     WebElement chooseFileInput = driver.findElement(By.xpath("//input[@id='uploadFile']"));
        chooseFileInput.sendKeys("/Users/nurgulyamuratbekova/Downloads/images.jpeg");
      Thread.sleep(2000);
       // driver.findElement(By.id("//input[@id='uploadFile']/../../following-sibling::p"));
        WebElement text = chooseFileInput.findElement(By.xpath("./../../following-sibling::p"));
        System.out.println(text.getText());
        Assert.assertTrue(text.getText().contains("images.jpeg"));
        //Robot Framework , AutoIt -> research

    }
    @Test
    public void googleImageUpload() throws InterruptedException {
        driver.get("https://images.google.com");
        driver.findElement(By.xpath("//div[@aria-label='Search by image']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Upload an image']")).click();
    driver.findElement(By.cssSelector("#awyMjb")).sendKeys("/Users/nurgulyamuratbekova/Downloads/images.jpeg");
    Thread.sleep(2000);
    WebElement result = driver.findElement(By.xpath("//input[@class='gsfi']"));
    Assert.assertTrue(result.getText().contains("vogue logo"));
    }
}
