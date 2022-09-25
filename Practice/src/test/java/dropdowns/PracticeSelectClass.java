package dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class PracticeSelectClass {
    WebDriver driver;

    @Before
    public void setUp() {
    driver= Driver.getDriver();

    }

    @After
    public void tearDown() {
    Driver.closeDriver();
    }

    @Test
    public void practiceEnrollmentForm() {
        driver.get("https://www.amazon.com");
        WebElement selectElement = driver.findElement(By.cssSelector("#searchDropdownBox"));
        Select dropdown = new Select(selectElement);

        List<WebElement> options = dropdown.getOptions();
        Assert.assertEquals(59, options.size());
        for (WebElement availableOptions : options) {
            System.out.println(availableOptions.getText());
        }
        List<WebElement> selectedOptions = dropdown.getAllSelectedOptions();
        Assert.assertTrue(selectedOptions.size() == 1 &&
                selectedOptions.get(0).getText().equals("All Departments"));
        dropdown.selectByVisibleText("Baby");
        selectedOptions = dropdown.getAllSelectedOptions();
        Assert.assertTrue(selectedOptions.size() == 1 && selectedOptions.get(0).getText()
                .equals("Baby"));

    }

    @Test
    public void practiceMultiSelect() {
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");


        WebElement select = driver.findElement(By.id("option-droup-demo"));
        Select dropdown = new Select(select);
        Assert.assertTrue(dropdown.isMultiple());
        List<WebElement> selectedOptions = dropdown.getAllSelectedOptions();
        System.out.println("Currently options tha are selected: ");
        for (WebElement selected : selectedOptions) {
            System.out.println(selected.getText());
        }
        dropdown.deselectAll();
        dropdown.selectByValue("jQuery");
        dropdown.selectByIndex(5);
        dropdown.selectByVisibleText(" MySQL");
        dropdown.selectByIndex(9);
        selectedOptions = dropdown.getAllSelectedOptions();
        System.out.println("**********/n New selected options: ");
        for (WebElement selected : selectedOptions) {
            System.out.println(selected.getText());
            Assert.assertEquals(4, selectedOptions.size());
        }
    }
    @Test
    public void ExpediaselectCruises(){
    driver.get("https://www.expedia.com");

    driver.findElement(By.xpath("//a[@href='?pwaLob=wizard-cruise-pwa']")).click();

    WebElement cruiseSelections = driver.findElement(By.xpath("//select[@aria-label='Going to']"));

    Select dropdown = new Select(cruiseSelections);

    dropdown.selectByValue("alaska");
    Assert.assertTrue(dropdown.getAllSelectedOptions().get(0).getText().equals("Alaska"));

    dropdown.selectByVisibleText("Africa");
    Assert.assertTrue(dropdown.getFirstSelectedOption().getText().equals("Africa"));

    dropdown.selectByIndex(3);
    Assert.assertTrue(dropdown.getFirstSelectedOption().getText().equals("Mexico"));


for(WebElement allDestinatons: dropdown.getOptions())
        System.out.println(allDestinatons.getText());
    }
}

