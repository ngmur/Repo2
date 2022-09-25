Javascript Executor
-> it us an interface in Selenium that allows to execute javascript code
through the webdriver.
Javascript is a native browser language. It adds action, animation to the web
application UI --> <script>
Javascript is very powerful and it canperform a lot of actions on the web app
when regular selenium methods don't work.
! Because javascript Executor can talk directly to the browser - it does not
imitate real user behavior. Using javascript executor more than you need and
instaed of selenium methods will make your tests pass but you will be getting
false positive results.
Syntax:
JavascriptExecutor js = (JavascriptExecutor)driver:
•executeScript();
•executeAsyncSrypt();
•executeScript(script, arguments) ;
•esecuteScript(script);

- to click on the webelement
  js. executeScript ("arguments[0].click();", webelement);
  js.executeScript("document.getElementById('your id' ).click();") ;
- to type text into an input field
  js.executeScript("arguments[0].click();", webelement);
  js. executeScript ("document.getElementById( 'your id' ).click();") ;
js.executeScript("document.getElementById('your"id•;.value="text!;"):
- -to check a checkbox
  js.executeScript ("arguments [0] .checked=true;", webelement);
  -to scroll the page
  js. executeScript ("window.scrollBy(x,y) ;") ;
  to scroll to the buttom of the page
1. You need to get a height of your page
   js.executeScript("window.outerHeight");
2. Use scroll by and height of the page
   js.executeScript ("window.scrollBy(x, y) ;") ;
   *****FOR DEMO PURPOSES**水水水水水水***
   Before performing an action we will highlight the webelement that we will be
   working with next
   js. executeScript ("arguments [0].setAttribute('style', arguments[1]) ;", webelement,
   "border: 2px solid yellow");

In the utilities package we will create Helper class
public class Helper
//this class will contain all the reusable methods
//these methods should be generic, they should not be specific to some
elements

//mouse click

//js click

//is highlight
public static void highlightElement (WebElement el) {
js.executeScript ("arguments [0].setAttribute('style', arguments [1]);",
el,"border: 2px solid yellow");