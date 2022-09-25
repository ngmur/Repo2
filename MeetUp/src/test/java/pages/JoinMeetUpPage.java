package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class JoinMeetUpPage {
    public JoinMeetUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

//@FindBy - it takes a single locator and it returns you a web element
    //or a list of matching web elements
//@FindBys - takes couple locators and it will find an element
    //or a list that match all of the provided locators
//@FindAll - takes couple locators but it will return an element
    //that is matching any of the provided FindBy

    public WebElement =

    public WebElement =

    public WebElement =
    @FindBys({
            @FindBy()
            @FindBy()

    })
    public WebElement =

    @FindAll({
           @FindBy()
           @FindBy()
    })




}
