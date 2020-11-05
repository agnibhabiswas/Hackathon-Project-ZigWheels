package com.cognizant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// This class provides the functions which will generate web-elements for different operations.

public class WebElements {
	
	private WebDriver driver;
	private Properties prop;
	public WebElements() {
		loadProperties();
	}
	// Loading properties file
	public void loadProperties() {
		try {
			FileInputStream fis=new FileInputStream(new File(System.getProperty("user.dir")+"\\resources\\objectrepository.properties"));
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	// Setter for web-driver
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}	
	// Login/ Sign Up 
	public WebElement loginElement() {
		return driver.findElement(By.xpath(prop.getProperty("login_Xpath")));
	}
	// Continue with google
	public WebElement continue_with_google() {
		return driver.findElement(By.xpath(prop.getProperty("continue_with_google_Xpath")));
	}
	// Email
	public WebElement email() {
		return driver.findElement(By.xpath(prop.getProperty("email_Xpath")));
	}
	// Clicking next after entering email
	public WebElement email_next() {
		return driver.findElement(By.xpath(prop.getProperty("email_next_Xpath")));
	}
	// Password
	public WebElement password() {
		return driver.findElement(By.xpath(prop.getProperty("password_Xpath")));
	}
	// Clicking next after entering password
	public WebElement password_next() {
		return driver.findElement(By.xpath(prop.getProperty("password_next_Xpath")));
	}
	public WebElement close_tab() {
		return driver.findElement(By.xpath(prop.getProperty("close_Xpath")));
	}
	public WebElement skip_tab() {
		return driver.findElement(By.xpath(prop.getProperty("skip_phone_number_Xpath")));
	}
	public WebElement close_skip_tab() {
		return driver.findElement(By.xpath(prop.getProperty("close_skip_Xpath")));
	}
	public WebElement close_new_tab() {
		return driver.findElement(By.xpath(prop.getProperty("close_tab_Xpath")));
	}
	
}
