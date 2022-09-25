## HOOKS in BDD Framework
@Before - from cucumber
@After - cucumber annotation
In BDD you set up your hooks only once in its own separate class. 
Your Hooks class must be located inside stepdefinitions folder
In your EnvMan-ger don't set up default env - instead throw an exception if
  invalid env is specified in properties file. If you throw an exception the
  person (manual tester) who tries to run your tests will see it right away and
  will be able to fix the mistake in env property in configurations. If you set
  a default env in case of invalid entry in config file - your user won't be able to
  see that the tests are running against default env right away, they will see it
  afterwards and this will result in lost time.
  
  POM - Page Object Model
  Design Pattern in Selenium