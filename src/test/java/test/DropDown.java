package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        //create object by referring to the select element
        WebElement dropDownList = driver.findElement(By.id("dropdown"));
        Select selectObject = new Select(dropDownList);
        //select object will give you multiple commands to select
        // selectObject.selectByIndex(2);
        // selectObject.selectByVisibleText("Option 1");
        List<WebElement> allAvaileOptions = selectObject.getOptions();

        for (WebElement optins : allAvaileOptions) {
            System.out.println(optins.getText());
            if (optins.getText().equalsIgnoreCase("Option 2"))
                optins.click();


        }
        selectObject.deselectByVisibleText("Option 2");


        WebDriverManager.firefoxdriver().setup();
        WebDriver driver1 = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        List<WebElement> options = driver.findElements(By.id("checkboxes"));
        for (WebElement boxes : options) {
            System.out.println(boxes.getText());
            if (boxes.getText().equalsIgnoreCase(" checkbox 1"))
                boxes.click();
        }
        selectObject.deselectByVisibleText(" checkbox 1");
        Thread.sleep(2000);
        driver.quit();
    }

}