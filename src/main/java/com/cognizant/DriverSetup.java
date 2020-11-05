package com.cognizant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// This class is to get specified driver object of different drivers.

public class DriverSetup {
	private static WebDriver driver;
	// Getter for the web-driver
	public WebDriver getDriver() {
		return driver;
	}	
	public static WebDriver getWebDriver(int select) {
		// Using WebDriverManager library which allows to automate the management of the drivers
		if(select==1) {
			// Defining path for fire-fox driver
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(select==2) {
			// Defining path for chrome driver
			WebDriverManager.chromedriver().setup();
			ChromeOptions ops=new ChromeOptions();
			ops.addArguments("--disable-infobars");
			ops.addArguments("--disable-notifications");
			driver=new ChromeDriver(ops);
		}
		else if(select==3) {
			// Defining path for edge driver.
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}	
}