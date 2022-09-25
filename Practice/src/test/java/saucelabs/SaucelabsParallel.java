package saucelabs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.Driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SaucelabsParallel {
  private static final String USERNAME = ConfigReader.getProperty("saucelabsUsername");
  private static final String ACCESS_KEY = ConfigReader.getProperty("saucelabsAccessKey");
  private static final String URL = "https://"+USERNAME+":"+ACCESS_KEY+"";

  private String browser;
  private String version;
  private String os;

    public SaucelabsParallel(String browser,String version,String os){
        this.browser = browser;
        this.version = version;
        this.os = os;
    }
//when we are trying to run tests in parallel we need to make sure we set up our driver to be thread local
//Thread - line of execution
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
   //when we are running in parallel we need to keep track of sessions
    private ThreadLocal<String> sessionId = new ThreadLocal<>();

private WebDriver createDriver(String browser,String version,String os)throws MalformedURLException{
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("browserName",browser);
    capabilities.setCapability("browserVersion",version);
    capabilities.setCapability("platformName",os);

    driver.set(new RemoteWebDriver(new URL(URL),capabilities));
    //I need to get session id and store in sessionID collection
    String id = ((RemoteWebDriver)driver.get()).getSessionId().toString();
    sessionId.set(id);
    return  driver.get();
    }
    //now we need to store all the configurations for the browser that we will be using
    @Parameterized.Parameters
    public static Collection saucelabsDataProvider(){
        return Arrays.asList(new Object[][]{
            {"chrome","latest","macOs 10.14"},
            {"firefox","latest","Windows 10"},
            {"edge","latest","Windows 10"}
        });
    }




    @Test
    public void test1() throws InterruptedException, MalformedURLException{
       WebDriver driver = createDriver(browser,version,os);

        driver.navigate().to("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("clicked a button"));
        alert.dismiss();

        driver.findElement(By.id("timerAlertButton")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void testPromptAlert() throws MalformedURLException {
        WebDriver driver = createDriver(browser, version, os);
        driver.navigate().to("https://demoqa.com/alerts");
        driver.findElement(By.id("promtButton")).click();
        Alert alert = driver.switchTo().alert();

        String name = "Kenna";
        alert.sendKeys(name);
        alert.accept();
        WebElement result = driver.findElement(By.id("promptResult"));
        Assert.assertTrue(result.getText().contains(name));

    }

    @After
    public void tearDown() {
       driver.get().close();
    }
}
