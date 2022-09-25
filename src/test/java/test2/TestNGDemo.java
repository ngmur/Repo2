package test2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo {
    static  private WebDriver driver = null;
@BeforeTest
    public void setUpTest(){
    WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

    }
    @Test
public void googleSearch(){
    driver.get("https://google.com");
    driver.findElement(By.name("q")).sendKeys("Best start-Ups 2022");
driver.findElement(By.name("btnk")).sendKeys(Keys.RETURN);

}

@AfterTest
    public void tearDownTest(){
        driver.quit();
        System.out.println("Test completed successfully");
    }
}
