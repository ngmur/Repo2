## Advanced Mouse Interactions
click() - performs a single mouse click
sendKeys() - send a sequence of chars to the webelement
  
  Selenium offers us Actions class - we use to perform mouse actions on the
  web-elements
  There are 2 groups of actions:
  -mouse actions
  -keyboard actions
  Example: to press Control+Shift+N
  sendKeys (Keys. CONTROL+Keys. SHIFT+"N");--> this doesn't always work
  To use Actions class:
  Step 1: Create object of Actions class
  Actions actions = new Actions (driver):
  Step 2: perform your action
  actions.keyDown (Keys. CONTROL) .keyDown (Keys.SHIFT) . sendKeys ("N" ). keyUp(
  Keys.SHIFT)-keyUp(Keys. CONTROL) .perform() ;
  !! We always finish any action with .perform() method. Without it the action
  won't be executed.
  -> in older selenium code you may see this code: some
  action.build(). perform():
  Now we don't need to use .build() because .perform() contains .build()
  inside.

Mouse actions:
Actions action = new Actions (driver);
- click() - imitates regular single mouse click but we use it only if
  regular selenium click doesn't work: action.click(webelement) .perform();
- doubleClick() - imitates double click on the webelement:
  action.doubleClick(webelement).perform();
- contextClick() - performs a right click on the webelement:
  action.contextClick(webelement).perform();
- clickAndHold() - will click on a webelement and will hold the click until
  you release it. It is normally used with release() method and moveByOffset()
  or moveToElement () .
  actions.clickAndHold (webelement) .moveByOffset(x, y). release() . perform() ;
  release()- releasing a hold mouse left click at a location where mouse
  currently pointing on teh webpage
- moveBy0ffset (x,y)- X- horizontal axis, y - vertical axis and both values
  are to be specified in pixels (px).
- if you want to move element 20 px to the right moveByOffset(20,0);
- 20 px to the left (-20,0);
- 50 px up (0, -50) ;
- 50 px (0, 50) ;
- movetoElement (webelemnt)- moves the mouse to the specific webelement and
  brings that element into the viewport ( it will move the element so
  that it shows on the screen).
  !We also use this method to scroll to the buttom of the page
  - dragAndDrop(source web-element, target web-element)- it will take a source
  webelement move it to the location of target webelement and drop it at that
  location











Thread.sleep()- coming from Java, it is unconditional - whatever time you set in
sleep method - it will stop your code execution for exactly that time
  Conditional wait (implicit, explicit) - you set a timeout but if specific
  condition is reached before the expires it doesn't wait it moves on with the
  next line of the code
  We ALWAYS try to AVOID!!! Thread.sleep(); - because of regression suite.
  
  File upload and download - in general cannot handle
  with exceptions:
- download - if file gets downloaded to your machine after the click - selenium
  can do it as well by using regular click() :. After it is downloded, Selenium
  cannot open or interact with it because it is in your file system, not on the
  browser
- file upload - use sendKeys () to upload a file to a web application
  