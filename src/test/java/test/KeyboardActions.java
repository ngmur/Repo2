package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
//How to release pressed keys
public class KeyboardActions {

    public static void main(String[] args) throws InterruptedException {
        //keyDown

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://google.com");
      /*  driver.findElement(By.name("q")).sendKeys("selenium" + Keys.ENTER);
        Actions actionProvider = new Actions(driver);
        Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("a").build();
        keydown.perform();
*/
        //keyUp
        Actions actions = new Actions(driver);
        WebElement searchBox = driver.findElement(By.name("q"));
        actions.keyDown(Keys.SHIFT).sendKeys(searchBox,"selenium")
                        .keyUp(Keys.SHIFT).sendKeys("selenium").perform();

        Thread.sleep(2000);
        //clear()
        searchBox.clear();
        Thread.sleep(2000);
        driver.quit();
    }
}
