package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class AppleSearchPages {

    WebDriver driver = null;
     By searchButton = By.id("ac-gn-link-search");
     By searchForm = By.id("ac-gn-searchform-input");

     public AppleSearchPages(WebDriver driver){
         this.driver = driver;
     }

public void clickSearchButton(){
    driver.findElement(searchButton).click();
}
public void setTextInSearchBox(String text){
    driver.findElement(searchForm).sendKeys(text, Keys.ENTER);
}
}
