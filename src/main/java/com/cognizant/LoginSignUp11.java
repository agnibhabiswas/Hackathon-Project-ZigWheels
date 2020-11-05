package com.cognizant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LoginSignUp11 extends Zigwheels {
	String[] pr510 = new String[25];
	String[] bname = new String[50];
	String[] bprice = new String[50];
	String[] bdate = new String[50];

	static WebElement bikeName, bikePrice, bikeDate;

	String homePageWindow;

	public void takeScreenshots(String filename) throws IOException {
		File source_file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source_file,
				new File((System.getProperty("user.dir") + "\\screenshot\\screenshot_") + filename + ".png"));
		System.out.println("The screenshot is taken");
	}

	
	public void selectLogin() {
		driver.navigate().to("https://www.zigwheels.com");
		homePageWindow = driver.getWindowHandle();
		webelements.loginElement().click();

		System.out.println("Login Functionality");
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Logging In");
		logger.log(Status.INFO, "Log-in Functionality");
		logger.log(Status.PASS, "Successfully accessed the Login Drive");
		extent.flush();
		try {
			takeScreenshots("select_login");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	
	public void selectContinueWithGoogle() throws InterruptedException {
		Set<String> windows = driver.getWindowHandles();
		for (String newwindow : windows) {
			driver.switchTo().window(newwindow);
			Thread.sleep(3000);
		}
		webelements.continue_with_google().click();
		System.out.println("Continuing with Google Sign-in");

		extent.attachReporter(reporter);

		ExtentTest logger = extent.createTest("Signing into Google");
		logger.log(Status.INFO, "Sign-in Functionality");
		logger.log(Status.PASS, "Successfully Signed in through Google Account");
		extent.flush();
		try {
			takeScreenshots("select_continue_with_google");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void setInvalidEmail() throws InterruptedException {
		Set<String> windows = driver.getWindowHandles();
		for (String newwindow : windows) {
			driver.switchTo().window(newwindow);
			Thread.sleep(3000);
		}
		String e_mail = (String) (data.get(3)[0]);
		webelements.email().sendKeys(e_mail);
		webelements.email_next().click();
		Thread.sleep(3000);

		try {
			takeScreenshots("invalid_email");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

	public void setValidEmailInvalidPassword() throws InterruptedException {
		Set<String> windows = driver.getWindowHandles();
		for (String newwindow : windows) {
			driver.switchTo().window(newwindow);
			Thread.sleep(3000);
		}
		String e_mail = (String) (data.get(2)[0]);
		webelements.email().sendKeys(e_mail);
		webelements.email_next().click();
		Set<String> windows1 = driver.getWindowHandles();
		for (String newwindow : windows1) {
			driver.switchTo().window(newwindow);
			Thread.sleep(3000);
		}
		String pass = (String) (data.get(2)[1]);
		webelements.password().sendKeys(pass);
		webelements.password_next().click();
		Thread.sleep(3000);
		System.out.println("Valid Email invalid Password");

		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Invalid Test Case");
		logger.log(Status.INFO, "Sign-in Functionality");
		logger.log(Status.FAIL, "Failed to Sign in through Google Account");
		extent.flush();

		try {
			takeScreenshots("valid_email_invalid_password");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		driver.close();
	}

	
	public void setEmail() throws InterruptedException {
		Set<String> windows = driver.getWindowHandles();
		for (String newwindow : windows) {
			driver.switchTo().window(newwindow);
			Thread.sleep(3000);
		}
		String e_mail = (String) (data.get(1)[0]);
		webelements.email().sendKeys(e_mail);
		System.out.println("Set the Email-id properly");

		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Email-id");
		logger.log(Status.INFO, "Correct Email to be entered");
		logger.log(Status.PASS, "Successfully entered the email-id");
		extent.flush();
		try {
			takeScreenshots("set_email");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	
	public void selectNext1() {
		webelements.email_next().click();
		System.out.println("Going to the next page for password entry");

		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Navigate to next window");
		logger.log(Status.INFO, "Entery of password window should open");
		logger.log(Status.PASS, "Successfully accessed the 'Enter password' window");
		extent.flush();
		try {
			takeScreenshots("select_next1");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	
	public void setPassword() throws InterruptedException {
		Set<String> windows = driver.getWindowHandles();
		for (String newwindow : windows) {
			driver.switchTo().window(newwindow);
			Thread.sleep(3000);
		}
		String pass = (String) (data.get(1)[1]);
		webelements.password().sendKeys(pass);
		extent.attachReporter(reporter);

		System.out.println("Enter the correct password");
		ExtentTest logger = extent.createTest("Enter Password");
		logger.log(Status.INFO, "Password should be entered properly");
		logger.log(Status.PASS, "Successfully entered the password");
		extent.flush();

		try {
			takeScreenshots("set_password");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	
	public void selectNext2() throws InterruptedException {
		
		webelements.password_next().click();

		extent.attachReporter(reporter);
		System.out.println("Navigate back to the parent window");
		ExtentTest logger = extent.createTest("Back to Main Websiite");
		logger.log(Status.INFO, "Control should come back to the original window");
		logger.log(Status.PASS, "Successfully accessed the original window");
		extent.flush();
		try {
			takeScreenshots("select_next2");
			logger.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\screenshot\\screenshot_select_next2");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		driver.switchTo().window(homePageWindow);
	}
}
