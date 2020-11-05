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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

// This class provides unit test for simple App

public class AppTest extends Zigwheels{
    
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

	@Test(priority = 0)
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

	@Test(priority = 1)
	public void selectContinueWithGoogle() throws InterruptedException {
		Set<String> windows = driver.getWindowHandles();
		for (String newwindow : windows) {
			Thread.sleep(3000);
			driver.switchTo().window(newwindow);
			Thread.sleep(1000);
		}
		webelements.continue_with_google().click();
		System.out.println("Continuing with Google Sign-in");

		extent.attachReporter(reporter);

		ExtentTest logger = extent.createTest("Signing into Google");
		logger.log(Status.INFO, "Sign-in Functionality");
		logger.log(Status.PASS, "Successfully Signed in through Google Account");
		extent.flush();
		
	}

	public void setInvalidEmail() throws InterruptedException {
		Set<String> windows = driver.getWindowHandles();
		for (String newwindow : windows) {
			Thread.sleep(3000);
			driver.switchTo().window(newwindow);
			Thread.sleep(1000);
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
			Thread.sleep(3000);
			driver.switchTo().window(newwindow);
			Thread.sleep(1000);
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

	@Test(priority = 2)
	public void setEmail() throws InterruptedException {
		Set<String> windows = driver.getWindowHandles();
		for (String newwindow : windows) {
			Thread.sleep(3000);
			driver.switchTo().window(newwindow);
			Thread.sleep(1000);
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

	@Test(priority = 3)
	public void selectNext1() throws InterruptedException {
		Thread.sleep(3000);
		webelements.email_next().click();
		Thread.sleep(1000);
		System.out.println("Going to the next page for password entry");

		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Navigate to next window");
		logger.log(Status.INFO, "Entry of password window should open");
		logger.log(Status.PASS, "Successfully accessed the 'Enter password' window");
		extent.flush();
		try {
			takeScreenshots("select_next1");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void setPassword() throws InterruptedException {
		Set<String> windows = driver.getWindowHandles();
		for (String newwindow : windows) {
			Thread.sleep(3000);
			driver.switchTo().window(newwindow);
			Thread.sleep(1000);
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

	@Test(priority = 5)
	public void selectNext2() throws InterruptedException {
		// Set<String> windows = driver.getWindowHandles();
		Thread.sleep(3000);
		webelements.password_next().click();
		Thread.sleep(1000);

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
	@Test(priority = 6)
	public void newBikes() throws InterruptedException {
		Actions actions = new Actions(driver);
		
		Thread.sleep(8000);
		WebElement target = driver.findElement(By.xpath("//a[@data-track-component='navigation' and @href='/newbikes' ]"));
		actions.moveToElement(target).build().perform();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/div[2]/ul/li[3]/ul/li/div[1]/ul/li[3]/a")).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		extent.attachReporter(reporter);
		System.out.println("New Bikes Selection");
		ExtentTest logger = extent.createTest("New Bikes");
		logger.log(Status.INFO, "New Bikes Functionality");
		logger.log(Status.PASS, "Successfully accessed the New Bikes Section");
		extent.flush();

		try {
			takeScreenshots("new_bikes");
		} catch (IOException e1) {
			e1.printStackTrace();

		}
	}

	@Test(priority = 7)
	public void hondaBikes() {
		WebElement choose = driver.findElement(By.xpath("//*[@id=\"makeId\"]"));
		Select select = new Select(choose);
		select.selectByIndex(2);

		extent.attachReporter(reporter);
		System.out.println("Selection of a specific Brand");
		ExtentTest logger = extent.createTest("Specific Brand Selection");
		logger.log(Status.INFO, "Select 'Honda'");
		logger.log(Status.PASS, "Successfully accessed the 'Brand' Section");
		extent.flush();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)", "");
		try {

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//span[@class=\"zw-cmn-loadMore\"]")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			takeScreenshots("honda_bikes");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Test(priority = 8)
	public void selectDetails() throws Exception {

		List<WebElement> bikes = driver.findElements(By.xpath("//div[@class=\"clr-bl p-5\"]"));
		count = bikes.size();
		
		System.out.println("Selecting 'Honda'");

		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Honda");
		logger.log(Status.INFO, "Selecting 'Honda'");
		logger.log(Status.PASS, "Successfully accessed the Honda bikes");
		extent.flush();

		for (int i = 1; i <= count; i++) {

			bikeName = driver.findElement(By.xpath("//li[starts-with(@class, \"col\")][" + i + "]/descendant::strong"));
			bikePrice = driver.findElement(By.xpath(
					"//li[starts-with(@class, \"col\")][" + i + "]/descendant::div[starts-with(@class, \"clr-bl\")]"));
			bikeDate = driver.findElement(By.xpath(
					"//li[starts-with(@class, 'col')][" + i + "]/descendant::div[starts-with(@class, 'clr-try')]"));
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

			String price1 = bikePrice.getText();
			String price2 = price1.replace("Rs.", "");
			boolean isLakhs = price1.contains("Lakh");

			if (isLakhs) {
				String price3 = price2.replaceAll("[^0-9.0-9]", "");
				float price4 = Float.parseFloat(price3) * 100000;
				int price5 = (int) price4;

				
				if (price5 < 400000) {

					System.out.println(bikeName.getText());
					System.out.println(bikePrice.getText());
					System.out.println(bikeDate.getText());

					for (int j = count1; j < (count1 + 1); j++) {
						bname[j] = bikeName.getText();
						bprice[j] = bikePrice.getText();
						bdate[j] = bikeDate.getText();
					}
					
					count1++;
				}

				

			} else {
				System.out.println(bikeName.getText());
				System.out.println(bikePrice.getText());
				System.out.println(bikeDate.getText());

			}

		}

		outputFromExcel();
	}

	public void outputFromExcel() throws Exception {
		FileInputStream f = new FileInputStream(System.getProperty("user.dir") + "\\ExcelOutput\\ExcelDetails.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet sheet = wb.getSheetAt(0);
		for (int i = 0; i < 3; i++) {
			sheet.setColumnWidth(i, 8000);
		}
		sheet.createRow(0).createCell(0).setCellValue("Name of the Item");
		sheet.getRow(0).createCell(1).setCellValue("Price");
		sheet.getRow(0).createCell(2).setCellValue("Date");
		CellStyle cs1 = wb.createCellStyle();
		Font font = wb.createFont(); // Create font
		font.setBold(true); // Make font bold
		cs1.setFont(font);
		sheet.getRow(0).getCell(0).setCellStyle(cs1);
		sheet.getRow(0).getCell(1).setCellStyle(cs1);
		sheet.getRow(0).getCell(2).setCellStyle(cs1);

		System.out.println("ExcelOutput for New Bikes");

		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("ExcelOutput1");
		logger.log(Status.INFO, "Creating Excel Output for 'New Bikes' Section");
		logger.log(Status.PASS, "Successfully created the Excel Sheet containing 'New Bikes' details");
		extent.flush();

		for (int i = 1; i <= count1; i++) {
			sheet.createRow(i).createCell(0).setCellValue(bname[i - 1]);
			sheet.getRow(i).createCell(1).setCellValue(bprice[i - 1]);
			sheet.getRow(i).createCell(2).setCellValue(bdate[i - 1]);
		}

		FileOutputStream fout = new FileOutputStream(System.getProperty("user.dir") + "\\ExcelOutput\\ExcelDetails.xlsx");
		wb.write(fout);
		wb.close();
	}

	@Test(priority = 10)
	public void usedC() throws Exception {

		driver.navigate().to("https://www.zigwheels.com/");
		
		driver.findElement(By.xpath("//a[@data-track-label='used-cars']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[@data-track-label='used-cars-chennai']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 5-10 Lacs Popular Used Cars
		driver.findElement(
				By.xpath("/html/body/div[11]/div/div[2]/div[1]/div[1]/div[2]/ul/li[1]/div[2]/ul/li[3]/label")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
		try {
			takeScreenshots("Used_cars5-10");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,500)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,600)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,700)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// takess();

		js.executeScript("window.scrollBy(0,800)", "");
		try {

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		js.executeScript("window.scrollBy(0,900)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,1000)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,1100)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// takess();

		js.executeScript("window.scrollBy(0,1200)", "");
		try {

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,1300)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,1400)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,1500)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// takess();

		js.executeScript("window.scrollBy(0,1600)", "");
		try {

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,1700)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,1800)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,1900)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		js.executeScript("window.scrollBy(0,2000)", "");
		try {

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 1; i <= 24; i++) {
			pr510[i] = driver.findElement(By.xpath(
					"//div[starts-with (@class,'zw-sr')][" + i + "]/descendant::a[starts-with (@class ,'fnt-22')]"))
					.getText();
		}

		driver.navigate().to("https://www.zigwheels.com/used-car/Chennai");

		System.out.println("Accessing Used Cars section in Chennai");
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Accessing Used Cars in Chennai");
		logger.log(Status.INFO, "Accessing the 'Used C' section in 'Chennai'");
		logger.log(Status.PASS, "Successfully accessed the 'Used Cars' section in 'Chennai'");
		extent.flush();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		driver.findElement(
				By.xpath("/html/body/div[11]/div/div[2]/div[1]/div[1]/div[2]/ul/li[1]/div[2]/ul/li[4]/label")).click();

		js.executeScript("window.scrollBy(0,400)", "");
		try {
			takeScreenshots("Used_cars10-15");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,500)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,600)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,700)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		js.executeScript("window.scrollBy(0,800)", "");
		try {

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		js.executeScript("window.scrollBy(0,900)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,1000)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,1100)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		js.executeScript("window.scrollBy(0,1200)", "");
		try {

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,1300)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,1400)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,1500)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// takess();

		js.executeScript("window.scrollBy(0,1600)", "");
		try {

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,1700)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,1800)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,1900)", "");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// takess();

		js.executeScript("window.scrollBy(0,2000)", "");
		try {

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 1; i <= 24; i++) {
			pr1015[i] = driver.findElement(By.xpath(
					"//div[starts-with (@class,'zw-sr')][" + i + "]/descendant::a[starts-with (@class ,'fnt-22')]"))
					.getText();
		}

		try {
			takeScreenshots("used_cars");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Test(priority = 11)
	public void sortCar1() {
		System.out.println("\n \n Cars between 5-10 Lacs \n ******************************************** \n");
		System.out.println(" \n Maruti cars between 5-10 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr510[i].contains("Maruti")) {
				maruti510[maruti++] = pr510[i];
				System.out.println(pr510[i]);
			}
		}
	}

	@Test(priority = 12)
	public void sortCar2() {
		System.out.println(" \n Hyundai cars between 5-10 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr510[i].contains("Hyundai")) {
				hyundai510[hyundai++] = pr510[i];
				System.out.println(pr510[i]);
			}
		}
	}

	@Test(priority = 13)
	public void sortCar3() {
		System.out.println(" \n Honda cars between 5-10 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr510[i].contains("Honda")) {
				honda510[honda++] = pr510[i];
				System.out.println(pr510[i]);
			}
		}
	}

	@Test(priority = 14)
	public void sortCar4() {
		System.out.println(" \n Mercedes cars between 5-10 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr510[i].contains("Mercedes")) {
				mercedes510[mercedes++] = pr510[i];
				System.out.println(pr510[i]);
			}
		}
	}

	@Test(priority = 15)
	public void sortCar5() {
		System.out.println(" \n Toyota cars between 5-10 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr510[i].contains("Toyota")) {
				toyota510[toyota++] = pr510[i];
				System.out.println(pr510[i]);
			}
		}
	}

	@Test(priority = 16)
	public void sortCar6() {
		System.out.println(" \n BMW cars between 5-10 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr510[i].contains("BMW")) {
				bmw510[bmw++] = pr510[i];
				System.out.println(pr510[i]);
			}
		}
	}

	@Test(priority = 17)
	public void sortCar7() {
		System.out.println(" \n Ford cars between 5-10 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr510[i].contains("Ford")) {
				ford510[ford++] = pr510[i];
				System.out.println(pr510[i]);
			}
		}
	}

	@Test(priority = 18)
	public void sortCar8() {
		System.out.println(" \n Mahindra cars between 5-10 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr510[i].contains("Mahindra")) {
				mahindra510[mahindra++] = pr510[i];
				System.out.println(pr510[i]);
			}
		}
	}

	@Test(priority = 19)
	public void sortCar9() {
		System.out.println(" \n Tata cars between 5-10 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr510[i].contains("Tata")) {
				tata510[tata++] = pr510[i];
				System.out.println(pr510[i]);
			}
		}
	}

	@Test(priority = 20)
	public void sortCar10() {
		System.out.println(" \n Nissan cars between 5-10 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr510[i].contains("Nissan")) {
				nissan510[nissan++] = pr510[i];
				System.out.println(pr510[i]);
			}
		}
	}

	@Test(priority = 21)
	public void sortCar11() {
		System.out.println(" \n Isuzu cars between 5-10 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr510[i].contains("Isuzu")) {
				isuzu510[isuzu++] = pr510[i];
				System.out.println(pr510[i]);
			}
		}
	}

	@Test(priority = 22)
	public void sortCar12() {
		System.out.println(" \n Audi cars between 5-10 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr510[i].contains("Audi")) {
				audi510[audi++] = pr510[i];
				System.out.println(pr510[i]);
			}
		}
	}

	@Test(priority = 23)
	public void sortCar13() {
		System.out.println(" \n Volkswagen cars between 5-10 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr510[i].contains("Volkswagen")) {
				volks510[volks++] = pr510[i];
				System.out.println(pr510[i]);
			}
		}
		System.out.println("\n \n Cars between 10-15 Lacs \n ******************************************** \n");

	}

	@Test(priority = 24)
	public void sortCar14() {
		System.out.println(" \n Maruti cars between 10-15 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr1015[i].contains("Maruti")) {
				maruti1015[maruti1++] = pr1015[i];
				System.out.println(pr1015[i]);
			}
		}
	}

	@Test(priority = 25)
	public void sortCar15() {
		System.out.println(" \n Hyundai cars between 10-15 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr1015[i].contains("Hyundai")) {
				hyundai1015[hyundai1++] = pr1015[i];
				System.out.println(pr1015[i]);
			}
		}
	}

	@Test(priority = 26)
	public void sortCar16() {
		System.out.println(" \n Honda cars between 10-15 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr1015[i].contains("Honda")) {
				honda1015[honda1++] = pr1015[i];
				System.out.println(pr1015[i]);
			}
		}
	}

	@Test(priority = 27)
	public void sortCar17() {
		System.out.println(" \n Mercedes cars between 10-15 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr1015[i].contains("Mercedes")) {
				mercedes1015[mercedes1++] = pr1015[i];
				System.out.println(pr1015[i]);
			}
		}
	}

	@Test(priority = 28)
	public void sortCar18() {
		System.out.println(" \n Toyota cars between 10-15 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr1015[i].contains("Toyota")) {
				toyota1015[toyota1++] = pr1015[i];
				System.out.println(pr1015[i]);
			}
		}
	}

	@Test(priority = 29)
	public void sortCar19() {
		System.out.println(" \n BMW cars between 10-15 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr1015[i].contains("BMW")) {
				bmw1015[bmw1++] = pr1015[i];
				System.out.println(pr1015[i]);
			}
		}
	}

	@Test(priority = 30)
	public void sortCar20() {
		System.out.println(" \n Ford cars between 10-15 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr1015[i].contains("Ford")) {
				ford1015[ford1++] = pr1015[i];
				System.out.println(pr1015[i]);
			}
		}
	}

	@Test(priority = 31)
	public void sortCar21() {
		System.out.println(" \n Mahindra cars between 10-15 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr1015[i].contains("Mahindra")) {
				mahindra1015[mahindra1++] = pr1015[i];
				System.out.println(pr1015[i]);
			}
		}
	}

	@Test(priority = 32)
	public void sortCar22() {
		System.out.println(" \n Tata cars between 10-15 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr1015[i].contains("Tata")) {
				tata1015[tata1++] = pr1015[i];
				System.out.println(pr1015[i]);
			}
		}
	}

	@Test(priority = 33)
	public void sortCar23() {
		System.out.println(" \n Nissan cars between 10-15 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr1015[i].contains("Nissan")) {
				nissan1015[nissan1++] = pr1015[i];
				System.out.println(pr1015[i]);
			}
		}
	}

	@Test(priority = 34)
	public void sortCar24() {
		System.out.println(" \n Isuzu cars between 10-15 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr1015[i].contains("Isuzu")) {
				isuzu1015[isuzu1++] = pr1015[i];
				System.out.println(pr1015[i]);
			}
		}
	}

	@Test(priority = 35)
	public void sortCar25() {
		System.out.println(" \n Audi cars between 10-15 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr1015[i].contains("Audi")) {
				audi1015[audi1++] = pr1015[i];
				System.out.println(pr1015[i]);
			}
		}
	}

	@Test(priority = 36)
	public void sortCar26() {
		System.out.println(" \n Volkswagen cars between 10-15 lakhs \n");
		for (int i = 1; i <= 24; i++) {
			if (pr1015[i].contains("Volkswagen")) {
				volks1015[volks1] = pr1015[i];
				System.out.println(volks1015[volks1]);
				volks1++;

			}

		}

		System.out.println(" \n ******************************************** \n");
	}

	@Test(priority = 37)
	public void outputFromExcel1() throws Exception {

		FileInputStream f = new FileInputStream(System.getProperty("user.dir") + "\\ExcelOutput\\ExcelDetails.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet sheet = wb.getSheetAt(1);
		CellStyle cs1 = wb.createCellStyle();
		Font font = wb.createFont(); // Create font
		font.setBold(true); // Make font bold
		cs1.setFont(font);
		cs1.setWrapText(true);

		for (int i = 0; i < 13; i++)
			sheet.setColumnWidth(i, 12500);

		sheet.createRow(0).createCell(0).setCellValue("Maruti");
		sheet.getRow(0).getCell(0).setCellStyle(cs1);
		sheet.getRow(0).createCell(1).setCellValue("Mahindra");
		sheet.getRow(0).getCell(1).setCellStyle(cs1);
		sheet.getRow(0).createCell(2).setCellValue("Mercedes");
		sheet.getRow(0).getCell(2).setCellStyle(cs1);
		sheet.getRow(0).createCell(3).setCellValue("Honda");
		sheet.getRow(0).getCell(3).setCellStyle(cs1);
		sheet.getRow(0).createCell(4).setCellValue("Hyundai");
		sheet.getRow(0).getCell(4).setCellStyle(cs1);
		sheet.getRow(0).createCell(5).setCellValue("Toyota");
		sheet.getRow(0).getCell(5).setCellStyle(cs1);
		sheet.getRow(0).createCell(6).setCellValue("Volkswagen");
		sheet.getRow(0).getCell(6).setCellStyle(cs1);
		sheet.getRow(0).createCell(7).setCellValue("Ford");
		sheet.getRow(0).getCell(7).setCellStyle(cs1);
		sheet.getRow(0).createCell(8).setCellValue("BMW");
		sheet.getRow(0).getCell(8).setCellStyle(cs1);
		sheet.getRow(0).createCell(9).setCellValue("Tata");
		sheet.getRow(0).getCell(9).setCellStyle(cs1);
		sheet.getRow(0).createCell(10).setCellValue("Nissan");
		sheet.getRow(0).getCell(10).setCellStyle(cs1);
		sheet.getRow(0).createCell(11).setCellValue("Audi");
		sheet.getRow(0).getCell(11).setCellStyle(cs1);
		sheet.getRow(0).createCell(12).setCellValue("Isuzu");
		sheet.getRow(0).getCell(12).setCellStyle(cs1);

		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("ExcelOutput2");
		logger.log(Status.INFO, "Creating Excel Output for Used Cars in Chennai(Brand-wise) between 5-10 Lacs");
		logger.log(Status.PASS,
				"Successfully created the Excel Sheet containing 'Used cars' details in Chennai ranging between 5-10 Lacs");
		extent.flush();

		for (int i = 1; i <= 14; i++)
			sheet.createRow(i);

		for (int i = 1; i <= maruti; i++)
			sheet.getRow(i).createCell(0).setCellValue(maruti510[i - 1]);
		for (int i = 1; i <= mahindra; i++)
			sheet.getRow(i).createCell(1).setCellValue(mahindra510[i - 1]);
		for (int i = 1; i <= mercedes; i++)
			sheet.getRow(i).createCell(2).setCellValue(mercedes510[i - 1]);
		for (int i = 1; i <= honda; i++)
			sheet.getRow(i).createCell(3).setCellValue(honda510[i - 1]);
		for (int i = 1; i <= hyundai; i++)
			sheet.getRow(i).createCell(4).setCellValue(hyundai510[i - 1]);
		for (int i = 1; i <= toyota; i++)
			sheet.getRow(i).createCell(5).setCellValue(toyota510[i - 1]);
		for (int i = 1; i <= volks; i++)
			sheet.getRow(i).createCell(6).setCellValue(volks510[i - 1]);
		for (int i = 1; i <= ford; i++)
			sheet.getRow(i).createCell(7).setCellValue(ford510[i - 1]);
		for (int i = 1; i <= bmw; i++)
			sheet.getRow(i).createCell(8).setCellValue(bmw510[i - 1]);
		for (int i = 1; i <= tata; i++)
			sheet.getRow(i).createCell(9).setCellValue(tata510[i - 1]);
		for (int i = 1; i <= nissan; i++)
			sheet.getRow(i).createCell(10).setCellValue(nissan510[i - 1]);
		for (int i = 1; i <= audi; i++)
			sheet.getRow(i).createCell(11).setCellValue(audi510[i - 1]);
		for (int i = 1; i <= isuzu; i++)
			sheet.getRow(i).createCell(12).setCellValue(isuzu510[i - 1]);

		FileOutputStream fout = new FileOutputStream(System.getProperty("user.dir") + "\\ExcelOutput\\ExcelDetails.xlsx");
		wb.write(fout);
		wb.close();
	}

	@Test(priority = 38)
	public void outputFromExcel2() throws Exception {

		FileInputStream f1 = new FileInputStream(System.getProperty("user.dir") + "\\ExcelOutput\\ExcelDetails.xlsx");
		XSSFWorkbook wb1 = new XSSFWorkbook(f1);
		XSSFSheet sheet = wb1.getSheetAt(2);

		CellStyle cs2 = wb1.createCellStyle();
		Font font = wb1.createFont(); // Create font
		font.setBold(true); // Make font bold
		cs2.setFont(font);
		cs2.setWrapText(true);

		for (int i = 0; i < 13; i++)
			sheet.setColumnWidth(i, 12000);

		sheet.createRow(0).createCell(0).setCellValue("Maruti");
		sheet.getRow(0).getCell(0).setCellStyle(cs2);
		sheet.getRow(0).createCell(1).setCellValue("Mahindra");
		sheet.getRow(0).getCell(1).setCellStyle(cs2);
		sheet.getRow(0).createCell(2).setCellValue("Mercedes");
		sheet.getRow(0).getCell(2).setCellStyle(cs2);
		sheet.getRow(0).createCell(3).setCellValue("Hyundai");
		sheet.getRow(0).getCell(3).setCellStyle(cs2);
		sheet.getRow(0).createCell(4).setCellValue("Honda");
		sheet.getRow(0).getCell(4).setCellStyle(cs2);
		sheet.getRow(0).createCell(5).setCellValue("Toyota");
		sheet.getRow(0).getCell(5).setCellStyle(cs2);
		sheet.getRow(0).createCell(6).setCellValue("Volkswagen");
		sheet.getRow(0).getCell(6).setCellStyle(cs2);
		sheet.getRow(0).createCell(7).setCellValue("Ford");
		sheet.getRow(0).getCell(7).setCellStyle(cs2);
		sheet.getRow(0).createCell(8).setCellValue("BMW");
		sheet.getRow(0).getCell(8).setCellStyle(cs2);
		sheet.getRow(0).createCell(9).setCellValue("Tata");
		sheet.getRow(0).getCell(9).setCellStyle(cs2);
		sheet.getRow(0).createCell(10).setCellValue("Nissan");
		sheet.getRow(0).getCell(10).setCellStyle(cs2);
		sheet.getRow(0).createCell(11).setCellValue("Audi");
		sheet.getRow(0).getCell(11).setCellStyle(cs2);
		sheet.getRow(0).createCell(12).setCellValue("Isuzu");
		sheet.getRow(0).getCell(12).setCellStyle(cs2);

		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("ExcelOutput3");
		logger.log(Status.INFO, "Creating Excel Output for Used Cars in Chennai(Brand-wise) between 10-15 Lacs");
		logger.log(Status.PASS,
				"Successfully created the Excel Sheet containing 'Used cars' details in Chennai ranging between 10-15 Lacs.");
		System.out.println("Please refer to ExcelDetails.xlsx file in ExcelOutput folder for output results. Please refer to ExtentReport.html in the ExtentReport folder for the complete Extent Report.");
		extent.flush();

		for (int i = 1; i <= 14; i++)
			sheet.createRow(i);

		for (int i = 1; i <= maruti1; i++)
			sheet.getRow(i).createCell(0).setCellValue(maruti1015[i - 1]);
		for (int i = 1; i <= mahindra1; i++)
			sheet.getRow(i).createCell(1).setCellValue(mahindra1015[i - 1]);
		for (int i = 1; i <= mercedes1; i++)
			sheet.getRow(i).createCell(2).setCellValue(mercedes1015[i - 1]);
		for (int i = 1; i <= honda1; i++)
			sheet.getRow(i).createCell(3).setCellValue(hyundai1015[i - 1]);
		for (int i = 1; i <= hyundai1; i++)
			sheet.getRow(i).createCell(4).setCellValue(honda1015[i - 1]);
		for (int i = 1; i <= toyota1; i++)
			sheet.getRow(i).createCell(5).setCellValue(toyota1015[i - 1]);
		for (int i = 1; i <= volks1; i++)
			sheet.getRow(i).createCell(6).setCellValue(volks1015[i - 1]);
		for (int i = 1; i <= ford1; i++)
			sheet.getRow(i).createCell(7).setCellValue(ford1015[i - 1]);
		for (int i = 1; i <= bmw1; i++)
			sheet.getRow(i).createCell(8).setCellValue(bmw1015[i - 1]);
		for (int i = 1; i <= tata1; i++)
			sheet.getRow(i).createCell(9).setCellValue(tata1015[i - 1]);
		for (int i = 1; i <= nissan1; i++)
			sheet.getRow(i).createCell(10).setCellValue(nissan1015[i - 1]);
		for (int i = 1; i <= audi1; i++)
			sheet.getRow(i).createCell(11).setCellValue(audi1015[i - 1]);
		for (int i = 1; i <= isuzu1; i++)
			sheet.getRow(i).createCell(12).setCellValue(isuzu1015[i - 1]);

		FileOutputStream fout = new FileOutputStream(System.getProperty("user.dir") + "\\ExcelOutput\\ExcelDetails.xlsx");
		wb1.write(fout);
		wb1.close();
	}
	
	@AfterTest
	// closing the browser
	public void closeBrowser() {
		driver.quit();
	}
}