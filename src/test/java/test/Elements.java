package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.io.File;
import java.io.IOException;
import java.util.List;
/*Elements Selector Strategies :
       ID -> using ID property of the element
       Name -> using Name property of the element
       Link text -> using visible text value of an anchor element
       Partial Link text ->using the  partial value visible text of an anchor element
       Class name -> using Class name property of the element
       Tag Name -> using Tag name property of the element
       CSS Selector -> using a CSS selectors with available properties
       XPath -> using XPath expression with available properties
        */
//How to locate WebElements in selenium
public class Elements {
    //What are Web elements?
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
       // driver.get("https://google.com");
        //locating single element using any of its unique property
      // WebElement searchBox =  driver.findElement(By.name("q"));
      // searchBox.sendKeys("Australia",Keys.ENTER);
        //Locate multiple elements
      //  driver.navigate().to("https://trytestingthis.netlify.app/");
      //  List<WebElement> options = driver.findElements(By.name("Optionwithcheck[]"));
      //  for(WebElement element : options){
       //     System.out.println(element.getText());
       // }
        driver.navigate().to("https://www.apple.com");
       WebElement unicefLogo =  driver.findElement(By.cssSelector(".logo-image logo-image-unicef-relief-fund-unicef-logo-dark"));
        File srcFile = unicefLogo.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File("./image3.png"));
      //  WebElement appleLogo = driver.findElement(By.cssSelector("#ac-gn-firstfocus"));
    //   WebElement applLogo = driver.findElement(By.id("ac-gn-firstfocus"));
    //  driver.findElement(RelativeLocator.with(By.tagName("Store")).toRightOf(applLogo)).click();

        // Thread.sleep(2000);
        //driver.close();
        driver.quit();
    }
}
//The findElement method accepts a new method with(By) which returns a
//RelativeLocator
//above
//below
//toLeftOf
//toRightOf
//near
//driver.findElement(RelativeLocator.with(By.id("....*)).above(element));