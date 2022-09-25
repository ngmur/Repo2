import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class PracticeNavigation {
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
    public void practiceNavigation(){
        driver.navigate().to("https://www.tesla.com");
        driver.findElement(By.xpath("//a[@data-button-text-desktop='Custom Order']")).click();
        driver.findElement(By.id("purchase_price")).click();
    }
}
