package saucelabs;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public class SaucelabsDriver {
    //this will be the class to create the driver that will be running on saucelabs
    //we need to connect our code to our saucelabs account
    //we need: username,access key,url

    private static final String USERNAME = ConfigReader.getProperty("saucelabsUsername");
    private static final String ACCESS_KEY = ConfigReader.getProperty("saucelabsAccessKey");
    private static final String URL = "https://"+USERNAME+":"+ACCESS_KEY+"";

    public static WebDriver loadSaucelabsDriver(){
        //we need to provide the info on the configuration to use to run our tests
        //DesiredCapabilities class

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.WIN10);
        // capabilities.setCapability("platformName","Windows 10");
        //capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
        capabilities.setCapability("browserName","firefox");
        capabilities.setCapability("browserVersion","latest");

    WebDriver driver = null;
    try{
        driver = new RemoteWebDriver(
                new URL(URL),capabilities
        );
    }catch (MalformedURLException e){
        e.printStackTrace();
    }
  return driver;
    }
}
