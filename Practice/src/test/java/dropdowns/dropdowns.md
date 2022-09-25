Dropdowns:
  Dropdowns in Selenium are represented with <select> tag.
  Whenever you see a dropdown on a webpage:
1. Inspect it and make sure it is <select> element
2. Locate your select webelement and store it in webelement object
3. Create object of Select class
   Select dropdown = new Select (Your select webelement from step 2)
4. Using your select object - select a value from a dropdow by:
  - select by index (indexes start with 0)
  - by value
  - by visible text
5. You can deselect a value from a dropdown - same three ways
6. deselectAll()- normally we use with multi dropdown - will deselect all selected
  values
7. getOptions ()- returns a list of all the options available to the user
8. getAl1SelectedOptions () - it will return 1 value, if multiselect- it will
  return all values that are selected