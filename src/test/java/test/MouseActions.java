package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
       // driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
        driver.get("https://selenium08.blogspot.com/2020/01/drag-drop.html");
        // WebElement a = driver.findElement(By.xpath("//li[text()= 'A']"));
       // WebElement b = driver.findElement(By.cssSelector(".ui-state-default"));
      //  WebElement l = driver.findElement(By.xpath("//li[text()= 'L']"));
        //move the mouse cursor to an element
        Actions action = new Actions(driver);
        action.dragAndDrop(driver.findElement(By.id("draggable"))
                ,driver.findElement(By.id("droppable"))); //drag and drop
      // action.moveToElement(a);
       // action.clickAndHold();  //click and hold
      //  action.moveToElement(l);
       // action.release().perform();
       // action.doubleClick(l); //double click
       // action.contextClick(a); //right click
        action.build().perform();
        Thread.sleep(2000);
        driver.quit();
    }
}
