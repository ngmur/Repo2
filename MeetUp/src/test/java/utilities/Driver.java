package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

import static utilities.ConfigReader.getProperty;
//We normally run our tests in interactive mode - we can see our browser opening,
// performing some actions and then closing
//Second option - you can run your browser in headless mode - as a service
//your test will run but you will not see your browser opening and closing
//Your Driver class is an example of Singleton Design Pattern -->
//Singleton means that the class is set up in a way that only one object of a
//class can be created at a time
public class Driver {
//this will be the class that will totally control our browser and driver
    //it will make sure that there is only one driver instance running at a time

    //in order to prevent anyone from creating a driver instance from anywhere
    //we create private constructor

    //!!! We created this class using Singleton Design Pattern

    //it will not allow your driver = new Driver();
    private Driver() {
    }

    private static WebDriver driver;

    //this class will contain two methods:

    //1. for creating a driver
    public static WebDriver getDriver() {
        //before creating a driver we need to make sure there is no driver running
        // first of all, we have to check that our driver is null
        if (driver == null) {
            //here we will create a new fresh driver based on the browser property
            switch (getProperty("browser").toLowerCase()) {
                default:
                    driver= ChromeWebDriver.loadChromeDriver();
                    break;
                case "firefox":
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


                }
                }
                    return driver;
                }
                public static void closeDriver(){
                try{
                if(driver!=null){
                driver.close();
                driver.quit();
                driver=null;
                }
                }catch (Exception e){
                e.printStackTrace();
                }
    }

}
