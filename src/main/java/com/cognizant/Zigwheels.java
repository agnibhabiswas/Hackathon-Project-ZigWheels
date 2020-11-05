package com.cognizant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.HashMap;


public class Zigwheels {
	public static  WebDriver driver;
	// Object of the WebElements class
	public WebElements webelements=new WebElements();
	// Retrieving data from input excel sheet
	public HashMap<Integer,Object[]>data=ExcelUtils.readData(System.getProperty("user.dir")+"\\DataFiles\\ZigWheels.xlsx");
	// Browser name
    public String browserName;
    static int count,count1=0;
    static String inputData;



	 String[] pr510 = new String[25];
		String[] pr1015 = new String[25];
		
		String[] tata510 = new String[25];
		String[] tata1015 = new String[25];
		String[] nissan510 = new String[25];
		String[] nissan1015 = new String[25];
		String[] maruti510 = new String[25];
		String[] maruti1015 = new String[25];
		String[] mahindra510 = new String[25];
		String[] mahindra1015 = new String[25];
		String[] mercedes510 = new String[25];
		String[] mercedes1015 = new String[25];
		String[] honda510 = new String[25];
		String[] honda1015 = new String[25];
		String[] hyundai510 = new String[25];
		String[] hyundai1015 = new String[25];
		String[] toyota510 = new String[25];
		String[] toyota1015 = new String[25];
		String[] volks510 = new String[25];
		String[] volks1015 = new String[25];
		String[] bmw510 = new String[25];
		String[] bmw1015 = new String[25];
		String[] ford510 = new String[25];
		String[] ford1015 = new String[25];
		String[] audi510 = new String[25];
		String[] audi1015 = new String[25];
		String[] isuzu510 = new String[25];
		String[] isuzu1015 = new String[25];
		static ExtentHtmlReporter reporter;
		static ExtentReports extent;
		
		int maruti=0,mahindra=0,mercedes=0,honda=0,hyundai=0,toyota=0,ford=0,volks=0,bmw=0,tata=0,nissan=0,isuzu=0,audi=0;
		int maruti1=0,mahindra1=0,mercedes1=0,honda1=0,hyundai1=0,toyota1=0,ford1=0,volks1=0,bmw1=0,tata1=0,audi1=0,isuzu1=0,nissan1=0;
		
    @BeforeTest
    public WebDriver createDriver()
	{
		 driver = DriverSetup.getWebDriver(3);
		webelements.setDriver(driver);
		Capabilities r=((RemoteWebDriver) driver).getCapabilities();
		browserName=r.getBrowserName();
		//driver.get("https://www.zigwheels.com");
		
		System.out.println("Driver Loaded Successfully");
		reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReport\\ExtentReport.html");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("DriverTest");
		logger.log(Status.INFO,"DriverElement being called");
		logger.log(Status.PASS,"Successfully called the driver element.");
		
		
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Browsers", "Chrome/Firefox/Edge");
		extent.setSystemInfo("Test Cycle 1", "Firefox");
		extent.setSystemInfo("Test Cycle 2", "Chrome");
		extent.setSystemInfo("Test Cycle 3", "Edge");
		extent.setSystemInfo("UI", "ZigWheels");
        reporter.config().setDocumentTitle("Testing Report");
        extent.flush();
        
		return driver;
	}
}
