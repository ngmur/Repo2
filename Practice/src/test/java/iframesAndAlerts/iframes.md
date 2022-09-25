## IFRAMES
--> inline frame - one HTML document nested inside of another

<iframe>
#document
<!DOCTYPE html>
<html>
head
body
</html>
full HTML document

</iframe>

Because Selenium can work with one HTML document at a time you won't be able to
work with nested HTML docs without performing couple extra steps
# <iframe> - regular webelement that can be loacted using any of the 8 locators
1. You have to locate an iframe and store it in the webelement*
2. You have to switch to the iframe before working with the elements located in
nested html
driver.switchTo0).frame() - as a parameter pass:
1.frame webelement
2.index of the frame
3.name or id
! After you are done working with elements inside of an iframe and you need to
work with elements located in the main HTML doc - you have to switch back to the
main HTML:
- driver.switchTo().defaultContent() - main HTML
- driver.switchTo() .parentFrame() - if there are multiple levels of nesting
## ALERTS/ POP-UPS
Never confuse Javascript Alerts (Alerts, Pop-up) with HTML Modal windows.
Modal windows are regulat html elements that you can inspect, locate and work
like with a normal webelement. You don't need to perform any switch, once modal
is on the screen you simply locate a button to close it or save - whatever
options it gives you.
  Alerts/Pop-ups - they are javascript based. If any of your actions trigger a
  javascript alert, you page and its webelements become unresponsive until you
  handle the alert. You are not able to inspect the alert. Alert IS NOT a
  webelement. You cannot inspect it, locate it or store it.
  There are 3 types of alerts:
  simple alert - its main purpose is to provide some extra info or qive a
  warning to a user. The only button it has is OK
  
  You can switch to alert: driver.switchTo().alert() --› there is only one alert
  possible to be displayed on a page at a specific moment. Alert is not
  webelement so it doesn't have name or id.
  You have 3 methods that you can use on an alert:
There are 3 types of alerts:
- simple alert - its main purpose is to provide some extra info or give a
  warning to a user. The only button it has is OK
- confirmation alert - it asks you to either confirm your action or cancel
  it. It qives you two options - either click Ok, or click Cancel
- prompt alert- it asks you to provide more information. You have to type
  some info and accept it or you can simply dismiss it

  You can switch to alert: driver.switchTo().alert() -> there is only one alert
  possible to be displayed on a page at a specific moment. Alert is not a
  webelement so it doesn't have name or id.
  
  Alert alert = driver. switchTo().alert();
  You have 3 methods that you can use on an alert:
  alert.accept () - it clicks OK on the alert
  alert.dismiss() - it clicks Cancel on the alert
  alert.sendKeys() - it will type into alert
  alert.getText () - it will return you a string - text displayed on the actual
  alert.
  After vou hit ok or cancel on the alert - the alert is gone and vou can continue
  working with your webpage,
  no need to switch back to it