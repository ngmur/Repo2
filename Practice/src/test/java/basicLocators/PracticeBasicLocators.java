package basicLocators;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//Xpath - u can write a locator for any element
//2 types of Xpath: absolute and relative
//* in place of a tag in xpath means any tag
//.. - one step up - to the parent
//*[@id="userNumber-label"]
///html/body/div/div/div/div[2]/div[2]/div[1]/form/div[4]/div[1]/label
//input(@title='Search']
///html/body/div[1]/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input
//ElementNotInteractableException: some explanation here - in some of the cases it
//means that element cannot accept the action that you are trying to perform
//DOM - stands for document obiect model - used interchangeable with HTML doc

public class PracticeBasicLocators {
    WebDriver driver;

    @Test
    public void testLinkLocator() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        gmailLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("maily"));
        driver.quit();
    }
@Test
    public void testClassLocators() {
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com");
        String text = driver.findElement(By.className("lnXdpd")).getText();
        System.out.println(text);
        Assert.assertTrue("Link text verification did not contain future leaders", text.contains("2007"));


    }
    @Test
    public void testPartialLink() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com");
   WebElement link =  driver.findElement(By.partialLinkText("How Search"));
           link.click();
        String expected = "Google Search - Discover How Google Search Works";
    Assert.assertTrue("Title verification failed. Expected: " + expected + "Actual: "+
            driver.getTitle(),driver.getTitle().contains(expected));

    }

    @After
    public void tearDown(){
        driver.quit();
    }

}