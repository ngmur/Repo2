package test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//https://selenium08.blogspot.com/2020/01/drag-drop.html
//https://trytestingthis.netlify.app/
//http://the-internet.herokuapp.com/dropdown"
//https://automationstepbystep.com

import java.time.Duration;
//Go to Maven repo and download Selenium dependency as well as WebDriver dependency
//go to selenium.sev website for instructions if needed or automation step by step (youtube)
public class FirstTest {
    public static void main(String[] args) {

       WebDriverManager.firefoxdriver().setup();
        // System.setProperty("webdriver.gecko.driver","/Users/nurgulyamuratbekova/Desktop/UIautomation/drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://google.com");
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(1));
     driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(17));
     driver.close();
    }
}
