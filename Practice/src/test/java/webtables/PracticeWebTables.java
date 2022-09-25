package webtables;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

import java.util.List;

public class PracticeWebTables {
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
    public void test1()throws InterruptedException {
    //1 - we will treat it as a static table
    //and we can hardcode the row where Dan Brown is displayed
        driver.navigate().to("https://chandanachaitanya.github.io/selenium-practice-site/?languages=JavadenterText=");
        //bring the table into the view
        Actions actions = new Actions(driver);
        WebElement buttonToScrollTo = driver.findElement(By.id("win"));
        actions.moveToElement(buttonToScrollTo).perform();
        Thread.sleep(3000);
        //we will be working with dynamic table
        //1. we need to find out which column contains authors
        //2. We need to locate a row that stores Dan Brown books
        //we will print out the books
        WebElement table = driver. findElement (By.xpath("//table[@id='BooksAuthorsTable' ]")) ;
        List<WebElement> columnNames = table. findElements(By.xpath(".//th")); // Bookl, Book2...,Author
        int index0fAuthorColumn = 0;
        for (WebElement columnName: columnNames) {
            ++index0fAuthorColumn;
            if (columnName.getText().contains("Author")) break;

            List<WebElement> authors = table.findElements(By.xpath(".//tr/td[" + index0fAuthorColumn + "]"));
            int index0fDanBrownRow = 0;
            for (WebElement author : authors) {
                ++index0fDanBrownRow;
                if (author.getText().trim().equals("Dan Brown")) break;

            }
            int numOfColumns = columnNames.size() ;
            String booksXpath=".//tri"+index0fDanBrownRow+"]/td";
            for(int i = 1; i<=numOfColumns; i++) {
                if (i == index0fAuthorColumn) continue;
                WebElement book = table.findElement(By.xpath(booksXpath + "[" + i + "]"));
                System.out.println(book.getText());


            }
        }

        //WebElement table = driver.findElement(By.xpath("//table[@id='BooksAuthorsTable' ]"));
        //how to get the number of rows
        List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        int number0fRows = rows.size();
        System.out.println("The number of rows in the table: " + number0fRows);

        //how to get the number of columns
        List<WebElement> columns = table.findElements(By.xpath(".//tr/th"));
        int number0fColumns = columns.size();
        System.out.println("The number of columns is: " + number0fColumns);

        //print out all the books written by Dan Brown
        List<WebElement> DanBrownRow = table.findElements(By.xpath(".//tr[4]/td"));
        for (int i = 1; i < DanBrownRow.size(); i++) {
            System.out.println(DanBrownRow.get(i).getText());
        }

        }

    @Test
    public void test3() throws InterruptedException{
        //print all of the author names, but first find teh correct column
        driver.navigate().to( "https://chandanachaitanya.github.io/selenium-practice-site/?Languages=JavadenterText=");
        Actions actions = new Actions (driver);
        WebElement buttonToScrollTo = driver.findElement (By.id("win")) ;
        actions.moveToElement(buttonToScrollTo).perform();
        Thread. sleep( 3000);
        List<WebElement> columns = driver. findElements(By.xpath("//table[@id='BooksAuthorsTable']//th"));
        int authorsIndex = 0;
        for (WebElement column: columns) {
            authorsIndex++;
            if (column.getText().trim().equals("'Author")) break;
        }
           List<WebElement> authors = driver.findElements(By.xpath("//table[Gid='BooksAuthorsTable'1//tr/td("+authorsIndex+"]"));
            for(WebElement author: authors)
                System.out.println(author.getText());
    }
    @Test
    public void test4(){
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        int countryColumn = 3;
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
        int mexicoRow = 1;
        for(int i =2; i<rows.size();i++){
            mexicoRow++;
            WebElement countryCell = driver.findElement(By.xpath("//table[@id='customers']//tr["+i+"]/td[3]"));
            if(countryCell.getText().trim().equals("Mexico")) break;
        }
        int companyColumn =1;
        WebElement mexicoCompany = driver.findElement(By.xpath("//table[@id='customers']//tr["+mexicoRow+"]/td["+companyColumn+"]"));
        System.out.println(mexicoCompany.getText());
    }
}
