package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

public class Browser {
    public static void main(String[] args) throws InterruptedException, IOException {
        //WebDriverManager
        WebDriverManager.firefoxdriver().setup();
        // System.setProperty("webdriver.gecko.driver","/Users/nurgulyamuratbekova/Desktop/UIautomation/drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
     //BROWSER ACTIONS
       driver.get("https://google.com");
        /*
        String originalWindow = driver.getWindowHandle();
        //how to open a web page
        driver.navigate().to("https://automationstepbystep.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(17));
       //get current URL
        String url = driver.getCurrentUrl();
        System.out.println(url);
        //get Title
        System.out.println(driver.getTitle());
        //Forward/Back/Refresh
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        driver.navigate().refresh();
        //Switching windows
        driver.switchTo().window(originalWindow);
        //open new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        //open new Tab
         driver.switchTo().newWindow(WindowType.TAB);
         //Frames
        driver.navigate().to("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
        driver.switchTo().frame("packageFrame");
        driver.findElement(By.linkText("Alert")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        //get & set Window size
       int width =  driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        Dimension size = driver.manage().window().getSize();
        System.out.println(size.getWidth());
        System.out.println(size.getHeight());
        driver.manage().window().setSize(new Dimension(500,700));
        //get & set Window Position
        driver.manage().window().getPosition().getX();
        driver.manage().window().getPosition().getY();
        Point position = driver.manage().window().getPosition();
        System.out.println(position.getX());
        System.out.println(position.getY());
        driver.manage().window().setPosition(new Point(600,600));
        //maximize/minimize/fullscreen
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.manage().window().minimize();
        Thread.sleep(2000);
        driver.manage().window().fullscreen();

        //screenshots
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File("./image.png"));
        WebElement element = driver.findElement(By.className("lnXdpd"));
        File logoSrc =element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(logoSrc,new File("./image1.png"));
        */

         //JavaScript
        //Creating the JavascriptExecutor interface object by Type casting
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //Get return value from script
        WebElement button = driver.findElement(By.id("gbqfbb"));
        js.executeScript("arguments[0].click();",button);
      //  String text = (String) js.executeScript("arguments[0].innerText;",button);
        //JavaScript to click element
     //   js.executeScript("arguments[0].click();",button);
        //Execute JS directly
        js.executeScript("console.log('hello world')");


       // System.out.println(text);
        Thread.sleep(2000);
        //close browser
       // driver.close();
       // driver.quit();//closes entire browser session
    }
}
