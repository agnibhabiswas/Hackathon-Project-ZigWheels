NOTE: This program uses WebDriverManager is a library which allows to automate the management of the drivers required by selenium WebDriver.

WEBSITE: https://www.zigwheels.com

PRE-REQUISITES-------------------->
1) Stable Internet Connection.
2) Registered Google ID on zigwheels.com.

STEPS TO EXECUTE-------------------->
1) Run TestNG.xml file
2) By default the selected browser is chrome. If the user want to change the preferred browser, then the user need to edit the number on line 66 of ZigWheels.java before running the TESTNG.xml file as follows :
		1----> Mozilla Firefox
		2----> Google Chrome
		3----> Microsoft Edge
3) The Zigwheels homepage will be loaded and the user will be redirected to a new Google Login Window.
4) User will be logged into the website using the registed email-id and password. (Provided by us but can be changed in Zigwheels.xlsx file present inside the DataFiles Folder within the root project directory)
5) User will be redirected to the Upcoming Bikes page on Zigwheels.com wherein, Honda will be selected as the Manufacturer according the Hackathon case requirement.
6) All Honda Bikes will be loaded and details of the bikes having price less than 4 Lakh INR will be stored in sheet number 1 in ExcelDetails.xlsx file present inside the ExcelOutput folder within the root project directory.
7) Next, Used Cars in Chennai page will be loaded. Rs. 5-10 Lakh filter will be applied and the names of the cars (sorted brand wise) will be stored in sheet number 2  in the ExcelDetails.xlsx file.
8) After the successful completion of step 7, Rs. 10-15 Lakh filter will be applied on the same page and the names of the cars (sorted brand wise) will be stored in sheet number 3 in the ExcelDetails.xlsx file.
9) Extent report will be logged throughout the entirity of the test cases. Screenshots are also taken during the entire code for future reference,
10) Finally, when all the test cases have been Passed, the browser will be closed. All the aforementioned details will also be printed in the ECLIPSE console window for the user's reference.

NOTE: *Extent Report can be accessed via log.html file present in the ExtentReport folder in the root directory of the project folder. 
              *Screenshots can be accessed via the screenshots folder present in the root directory of the project folder.
