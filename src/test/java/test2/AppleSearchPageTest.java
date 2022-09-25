package test2;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.AppleSearchPages;

public class AppleSearchPageTest {

  static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.firefoxdriver().setup();
    appleSearchTest();
    }

    public static void appleSearchTest() throws InterruptedException {

        driver = new FirefoxDriver();
        AppleSearchPages obj = new AppleSearchPages(driver);
        driver.get("https://apple.com");
        obj.clickSearchButton();
        obj.setTextInSearchBox("Macbook Pro");
        Thread.sleep(3000);
        driver.quit();
    }
}
