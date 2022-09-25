package pages;
//POM - Page Object Model
//Design Pattern in Selenium
/*For every single page in your app under test u should create a separate
page class where u will store all the web elements that  belong to a specific webpage
In java folder create pages package - it will store all the page
classes: Every class in pages package must end with word "Page"

POM allows for code re-usability. Elements will be found once and
 stored in the page class that belong to.When you need to use a
 specific web element u simply grab it from the page
 */

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MainPage {

    //
    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@data-event-label='Log in']")
    public WebElement loginButton;
    @FindBy(xpath = "//a[@data-event-label='Sign up]")
    public WebElement signupButton;
    @FindBy(xpath = "//a[text()='Join Meetup']")
    public WebElement joinMeetupButton;
    @FindBy(css = "#search-keyword-input")
    public WebElement searchInputField;
@FindBy(xpath = "//input[@data-element-name='searchBarButton']")
    public WebElement searchButton;
   @FindBy(xpath = "//a[@data-event-label='Location search']")
            WebElement locationInputField;
    public void clickJoinMeetup(){
        joinMeetupButton.click();
    }
    public void search(String searchCriteria,String location){
        searchInputField.sendKeys(searchCriteria);
        if(location!=null){
           // locationInputField.clear();
            locationInputField.sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
            locationInputField.sendKeys(location);

        }
        searchButton.click();
    }
}
