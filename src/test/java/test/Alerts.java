package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Alerts {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
       //JS Alert
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        if(driver.getPageSource().contains("You successfully clicked an alert"))
            System.out.println("SUCCESS");

    //JS Confirmation
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Alert confirmation = driver.switchTo().alert();
        System.out.println(confirmation.getText());
        alert.dismiss();
        if(driver.getPageSource().contains("You clicked: Cancel"))
            System.out.println("OOPS!");

        //JS Prompt
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert prompt = driver.switchTo().alert();
        System.out.println(prompt.getText());
        prompt.sendKeys("You look beautiful today");
        prompt.accept();
        if(driver.getPageSource().contains("You entered: You look beautiful today"))
            System.out.println("Yup");
    driver.quit();
    }
}
