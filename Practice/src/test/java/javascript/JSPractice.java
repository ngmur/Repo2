package javascript;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.HelperMethods;

import static utilities.HelperMethods.highlightElement;

public class JSPractice {
    WebDriver driver;

    @Before
    public void setUp(){
       driver = Driver.getDriver();
    }
    @After
    public void tearDown(){
        Driver.closeDriver();
    }
//javascriptExecutor - is an interface that allow us to execute javascript through the selenium web driver
//click , scroll and highlight methods are mostly use in real framework
 //we have a dependency to generate mock/fake data , i'm using a java faker
 //it is class,it has a lot of methods to generate mock data

        @Test
        public void EtsyTest()throws Exception{
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.location='https://www.etsy.com'");
        WebElement signInButton = driver.findElement(By.cssSelector(".select-signin"));
       // js.executeScript("arguments[0].setAttribute('style',arguments[1]);",signInButton,
       // "border: 2px solid green");
          ///  HelperMethods.highlightElement(signInButton);
            highlightElement(signInButton);
       //     Thread.sleep(3000);
        js.executeScript("arguments[0].click()",signInButton);
      //  js.executeScript("document.getElementById('join_neu_email_field').setAttribute('style',arguments[0]);",
      //            "border: 2px solid green");
            highlightElement("join_neu_email_field");
      //      Thread.sleep(3000);

        Faker faker = new Faker();
        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = faker.internet().password();

        js.executeScript("document.getElementById('join_neu_email_field').value=arguments[0];",fakeEmail);
    //    js.executeScript("document.getElementById('join_neu_password_field').setAttribute('style',arguments[0]);",
     //           "border: 2px solid green");
       highlightElement("join_neu_email_field");
      //  Thread.sleep(3000);
        js.executeScript("document.getElementById('join_neu_password_field').value=arguments[0];",fakePassword);
        WebElement submitButton = driver.findElement(By.xpath("//button[@name='submit_attempt']"));
      //  js.executeScript("arguments[0].setAttribute('style',arguments[1]);",submitButton,"border: 2px solid fuxia");
       highlightElement(submitButton);
     //   Thread.sleep(3000);
        js.executeScript("arguments[0].click();",submitButton);
       // Thread.sleep(4000);
    }
}
