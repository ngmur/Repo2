package advancedLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PracticeAdvancedLocators {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }

    @Test
    public void test1() {
        driver.get("https://devxschool.com");
        WebElement link1 = driver.findElement(By.tagName("a"));
        System.out.println("First link is: " + link1.getAttribute("href"));
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement element : links) {
            System.out.println(element.getText());
            System.out.println(element.getAttribute("href"));
        }
    }

    //tag[attribute='value']
    @Test
    public void printIphone() {
        driver.get("https:/www.amazon.com");
        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
        searchInput.sendKeys("Iphone",Keys.ENTER);
      //List<WebElement> brand = driver.findElements(By.cssSelector("ul[aria-labelledby='p_89-title']"));
        List<WebElement> brand = driver.findElements(By.cssSelector("li[id^='p_89/']"));
        for(WebElement elements : brand){
        System.out.println(elements.getText());
}
    }
    // /.. -> 1 step up parent in xpath


    @After
    public void tearDown() {
        driver.quit();

    }
}