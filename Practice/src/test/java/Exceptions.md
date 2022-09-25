## Selenium exceptions
1. NoSuchElementException - syntax of our locator is correct but the element
   doesn't exist or you did a typo in an attribute that you used to locate the
   element
   //input [@id='myInputHere']
   How to handle: 
1 Check your locator - make sure the value of attribute used to
   locate the element is typed correctly
2 Add explicit wait where vou wait for the presence of element
 
2. InvalidSelectorException - you made a syntax mistake in locator
   //input [@id='myInputHere']
   How to handle: 1. Check your locator syntax and fix it

3. StaleElementException - element becomes stale (element is old or not attached
   to the HTML) when HTML or part of it was refreshed and you are trying to reuse
   webelement found before the refresh.
   How to handle: 1. relocate the webelement that you need to interact with
4. Refresh the page
   Locate your webelements right before using them
5. Figure out which lines qive you this exception most l
   ah 5 70: d
   Plain Text

6. Refresh the page
7. Locate your webelements right before using them
8. Figure out which lines give you this exception most
   often and then use try catch block and loop inside of
   the block to locate the needed element multiple times
   until it is found without throwing stale element


4.ElementClikInterceptedException: Element not clickable at a point (145, 54)
when element is in the html, but it is hidden behind another element. You may
also get this exception when your web element is not in the viewport.
How to handle: 
1. Handle the element that is overlapping your target
2. Make sure your webelement is in the viewport
3. Check your screen size options
  
5WebDriverTimeoutException
when our explicit wait condition fails to be met within the specified time
  How to handle: 
1.You need to make sure that the condition you are
  waiting for is actually happening
2.Increase the wait time
 
6.NoSuchFrameException, NoSuchWindowException, NoSuchAlertException
  
7NoSuchSessionException - whenever you are trying to perform any actions in
   your test but the browser is closed
How to handle: I have @Before and @After hooks to make sure that browser is
   created and set up correctly before teh test and closed and cleaned up after
   the test.
 