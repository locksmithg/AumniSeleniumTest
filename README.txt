THIS PROJECT ASSUMES THE FOLLOWING
-That you have chrome installed
-The chromedriver I just included in the project, however if on mac or linux, you'll need to download that one and place it in:
\Aumni_Selenium_Test\src\test\resources\drivers
Download link: https://chromedriver.chromium.org/downloads
-Java is also assumed to be installed. This project is using jre 1.8.0_241 in particular.
-Maven is installed and configured in your enviornment variables (windows) or just properly installed in mac.
_______________________________________________________________________________________________________________________
Project specifications:
Nothing in src
Only things in test
Has 4 tests showcasing different selenium features testing 4 types of features:
testHomePage_Title_ShouldBeCorrect
testHomePage_NavLogo_Load
testHomePage_DemoButton_NavigatesToDemoPage
testHomePage_ScrollDownHidesBruce_ScrollUpBringsBackBanner
_______________________________________________________________________________________________________________________
***Note***
There is a Dockerfile, didn't quite work on the first or second try, but I think it might be a configuration issue on my end.
_______________________________________________________________________________________________________________________
INSTRUCTIONS TO RUN TESTS
-Open a console or powershell or whatever you use
-clone or download the git repo wherever
-navigate to that repo where the pom.xml file is
-(given maven is installed) run "mvn test"
-Watch tests pass and be impressed by the cool things Gabe did with selenium? Job worthy? 
  Who's to say... David is. Hope it's to your liking.