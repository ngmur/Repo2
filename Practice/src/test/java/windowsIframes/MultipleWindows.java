package windowsIframes;

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
import java.util.Set;

public class MultipleWindows {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }

    @Test
    public void amazonTest(){
        driver.get("https://www.amazon.com");
        String windowHandle = driver.getWindowHandle();
        System.out.println(windowHandle);
        //the unique id will change after you close the browser
        //CDwindow-07C53A1CCC37CD17D83BC683C4B4942A
        //CDwindow-E92375C35E71EAD6E4753A3C8D181A46
    }
    @After
    public void tearDown() {
        driver.quit();

    }
    @Test
    public void testMultipleWindows()  {
        driver.get("http://www.seleniumframework.com/demo-sites/");
        driver.findElement(By.xpath("//a[@href='http://automationpractice.com']")).click();
        String mainPageWindowHandle = driver.getWindowHandle();
        Set<String> allPagesWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allPagesWindowHandles) {
            if (!windowHandle.equals(mainPageWindowHandle))
                driver.switchTo().window(windowHandle);
        }
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='T-shirts']"))).click();
    WebElement tshirtText = driver.findElement(By.xpath("//h1/span[@class='cat-name']"));
        Assert.assertTrue("T-shirt text is not dicplayed.Switch to the new window",tshirtText.isDisplayed());
   driver.switchTo().window(mainPageWindowHandle);
WebElement logo = driver.findElement(By.xpath("//img[@alt='My Store']"));
Assert.assertTrue("Logo is not displayed.Test failed",logo.isDisplayed());
    }


}

