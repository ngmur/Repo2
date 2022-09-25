package test2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.GoogleSearchPage;

public class GoogleSearchTest {

      private static WebDriver driver = null;


    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        googleSearch();
    }
    public static void googleSearch(){
        driver = new FirefoxDriver();
        driver.get("https://google.com");
        GoogleSearchPage.texBoxSearch(driver).sendKeys("What will be my next trip?");
        GoogleSearchPage.buttonSearch(driver).click();
        driver.quit();
    }
}
