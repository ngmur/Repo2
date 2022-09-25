package advancedMouseInteractions;

import com.beust.ah.A;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

import static utilities.HelperMethods.highlightElement;

public class PracticeActionsClass {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = Driver.getDriver();
    }

    @After
    public void tearDown() {
        Driver.closeDriver();

    }

    @Test
    public void test1() {
        driver.navigate().to("https://demoqa.com/buttons");
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double Click Me']"));
        WebElement rightClickButton = driver.findElement(By.xpath("//button[text()='Right Click Me']"));
        WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).contextClick(rightClickButton).perform();
        //actions.contextClick(rightClickButton).perform();
        actions.click(clickMeButton).perform();
        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        Assert.assertTrue(doubleClickMessage.isDisplayed());
        WebElement rightClickMessage = driver.findElement(By.xpath("//div//p[text()='You have done a right click']"));
        Assert.assertTrue(rightClickMessage.isDisplayed());
        WebElement clickMeMessage = driver.findElement(By.cssSelector("#rightClickMessage"));
        Assert.assertTrue(clickMeMessage.isDisplayed());
    }

    @Test
    public void test2() {
        driver.navigate().to("https://demoqa.com/tool-tips");
        WebElement toolTipButton = driver.findElement(By.id("toolTipButton"));
        Actions action = new Actions(driver);
        action.moveToElement(toolTipButton).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.attributeToBe(toolTipButton, "aria-describedby", "buttonToolTip"));
        Assert.assertTrue("Tool tip is not displayed", toolTipButton.getAttribute("aria-describedby").equals("buttonToolTip"));
    }

    @Test
    public void Test3() {
        driver.navigate().to("https://demoqa.com/slider");
        WebElement sliderCircle = driver.findElement(By.xpath("//input[@max='100']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(sliderCircle).moveByOffset(30, 0).release().perform();
//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
//wait.until(ExpectedConditions.attributeToBe(sliderCircle,"value","58"));
        int newSliderValue = Integer.parseInt(sliderCircle.getAttribute("value"));
        Assert.assertTrue(newSliderValue > 25);
        Assert.assertTrue(sliderCircle.getAttribute("value").equals("58"));


    }

    @Test
    public void Test4() {
        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.xpath("//div[text()='Drag me']"));
        WebElement target = driver.findElement(By.cssSelector("#droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
        WebElement droppedText = target.findElement(By.xpath("./p"));
        Assert.assertTrue(droppedText.getText().equals("Dropped!"));
    }

    @Test
    public void Test5() {
        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.xpath("//div[text()='Drag me']"));
        WebElement target = driver.findElement(By.cssSelector("#droppable"));
        Actions actions = new Actions(driver);
       // actions.clickAndHold(source).moveToElement(target).release().perform();
       actions.clickAndHold(source).moveByOffset(250,75).release().perform();
        WebElement droppedText = target.findElement(By.xpath("./p"));
        Assert.assertTrue(droppedText.getText().equals("Dropped!"));
    }

    @Test
    public void Test6(){
        driver.get("https://demoqa.com/progress-bar");
        WebElement startButton = driver.findElement(By.xpath("//button[@class='mt-3 btn btn-primary']"));
       WebElement progressBar = driver.findElement(By.xpath("//div[@role='progressbar']"));
        startButton.click();
         new WebDriverWait(driver,Duration.ofSeconds(15)).
        until(ExpectedConditions.attributeToBe(progressBar,"aria-valuenow","100"));
        WebElement resetButton = driver.findElement(By.id("resetButton"));
        Assert.assertTrue(resetButton.getAttribute("id").equals("resetButton"));
        resetButton.click();
        Assert.assertTrue(progressBar.getAttribute("aria-valuenow").equals("0"));

    }
    @Test
    public void Test7(){
        driver.get("https://demoqa.com/menu");
WebElement item2 = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
Actions actions = new Actions(driver);
actions.moveToElement(item2).perform();
WebElement subSubList = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
actions.moveToElement(subSubList).perform();
WebElement subSubItem1 = driver.findElement(By.linkText("Sub Sub Item 1"));
subSubItem1.click();
//Assert.assertTrue(subSubItem1.getText().contains("Sub Item 1"));
    }
    @Test
    public void test8()throws InterruptedException{
    driver.navigate().to("https://demoqa.com/automation-practice-form");
    WebElement firstNameInput = driver.findElement(By.id("firstName"));
    WebElement lastNameInput = driver.findElement(By.id("lastName"));
    highlightElement(firstNameInput);
        Faker faker = new Faker();
        firstNameInput.sendKeys(faker.gameOfThrones().character());
     Actions actions = new Actions(driver);
     actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
     actions.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).perform();
     highlightElement(lastNameInput);
     actions.sendKeys(Keys.TAB).perform();
     actions.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();
     Thread.sleep(3000);
    Assert.assertTrue(lastNameInput.getAttribute("value").equals(firstNameInput.getAttribute("value")));

    }


}
