package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import saucelabs.SaucelabsDriver;

import java.time.Duration;


import static utilities.ConfigReader.getProperty;

public class Driver {

    //initialize a logger for every class separately and add the class you are working in
    //so that logger uses this class name when logging stuff from this class
    private static final Logger LOGGER = LogManager.getLogger(Driver.class);


    private Driver() {


    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        LOGGER.debug("Initializing a web driver for selenium version 4.4.0 ");
        if (driver == null) {
            LOGGER.info("Loading" + ConfigReader.getProperty("browser").toLowerCase()+"browser");
            switch (ConfigReader.getProperty("browser").toLowerCase()) {
                default:
                    driver= ChromeWebDriver.loadChromeDriver();
                    break;
                case "firefox":
                    LOGGER.info("Loading Chrome browser driver");
                    driver = FirefoxWebDriver.loadFirefoxDriver();
                    break;
                case "safari":

                    driver=new SafariDriver();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
                    driver.manage().window().maximize();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver=new InternetExplorerDriver();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
                    driver.manage().window().maximize();
                    break;
                case "saucelabs":
                    driver = SaucelabsDriver.loadSaucelabsDriver();
                    break;

                }
                }
                    return driver;
                }
                public static void closeDriver(){
                try{
                if(driver!=null){
                    LOGGER.info("Closing driver");
                driver.close();
                driver.quit();
                driver=null;
                }
                }catch (Exception e){
                    LOGGER.error(e.getMessage());
                e.printStackTrace();
                }
    }

}
