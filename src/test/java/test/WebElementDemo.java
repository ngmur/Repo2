package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebElementDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();


       /* driver.get("https://www.youtube.com");
       driver.findElement(By.className("ytd-searchbox-spt"))
               .sendKeys( "Madison Beer Dangerous"+ Keys.ENTER);
        // get attribute of current active element
       String title = driver.switchTo().activeElement().getAttribute("title");
        System.out.println(title);



        */

        /*get tagname,text,css etc
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        System.out.println(searchBox.getTagName());
        System.out.println(searchBox.getText());
        System.out.println(searchBox.getCssValue("font"));
*/
        driver.get("http://the-internet.herokuapp.com/checkboxes");
       WebElement checkbox =  driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        System.out.println(checkbox.isEnabled());
        System.out.println(checkbox.isSelected());
        Thread.sleep(2000);
           driver.quit();
    }
}
