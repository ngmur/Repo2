package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class PageLoadingDemo {
    public static void main(String[] args) {
        //NORMAL EAGER NONE

        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://www.youtube.com");

// Page Loading Strategies - NORMAL
//waits for the entire page to be loaded
//Se webdriver waits until the load event fire is returned
//ChromeOptions chromeOptions = new ChromeOptions();
//chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//By default normal is set to browser if none is provided

//Page Loading Strategies - EAGER
//waits until the initial HTML document has been completely loaded and
//parsed
//discards loading of stylesheets, images and subframes
//Se webdriver waits until the DOMContentLoaded event fire is returned
//ChromeOptions chromeOptions = new ChromeOptions();
//chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

        //Page Loading Strategies - NONE
        //When set to none Selenium WebDriver only waits until the initial page
        //is downloaded
        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        //AutomationStepByStep.com

    }
}
